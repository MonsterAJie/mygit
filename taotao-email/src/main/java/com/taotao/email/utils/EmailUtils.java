package com.taotao.email.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * @ClassName:  EmailUtils   
 * @Description:TODO(邮件工具)   
 * @author: AJie
 * @date:   2018年11月24日 下午9:57:09   
 *     
 * @Copyright: 2018 https://github.com/MonsterAJie/mygit
 *
 */
public class EmailUtils {
	private static final String PROPERTIESNAME = "email.properties";//配置文件名
	private static final String PATTERN = "\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}";//邮箱地址正则表达式
	private static final String REGEX = "\\s*";//去空格
	private static EmailUtils instance = null;
	private static String rpath;//项目路径
	private static String filePath;//配置文件路径
	private static StringBuffer sbf;
	
	private BufferedReader in = null;//流
	private Properties pro;//读取配置文件
	private Session session;//邮件会话对象 
    private MimeMessage mimeMsg;//MIME邮件对象 
    private Multipart mp;//Multipart对象,邮件内容,标题,附件等内容均添加到其中后再生成MimeMessage对象 
    private String auth;//尝试使用AUTH命令认证用户
    private String protocol;//协议
	private String host;//服务器
	private String senderNick;//发件人名称
	private String username;//服务邮箱(from邮箱)
	private String password;//邮箱密码
	private String logoUrl;//logo
	
	static{
		rpath = getRealPath() + "resource\\";
		filePath = rpath+PROPERTIESNAME;
	}
	
	public EmailUtils(){
		pro = new Properties();
		try {
			if(!fileIsTrue(filePath)){
				System.out.println("配置文件不存在");
				return;
			}
			in = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));
			if(in == null) return;
			pro.load(in);//加载配置文件
			in.close();//关闭流
		} catch (FileNotFoundException e) {
			System.out.println("文件不存在："+e.toString());
		} catch (IOException e) {
			System.out.println("IO 流关闭异常："+e.toString());
		} finally {
			if(in != null){
				try {
					in.close();//关闭流
				} catch (IOException e) {
					System.out.println("IO 流关闭异常："+e.toString());
				}
			}
		}
		/*MailSSLSocketFactory msf = null;//SSL 加密
		try {
			msf = new MailSSLSocketFactory();
			msf.setTrustAllHosts(true);
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pro.put("mail.smtp.ssl.socketFactory",msf);*/
		//尝试使用AUTH命令认证用户
		auth = pro.getProperty("mail.smtp.auth").toString();
		//装载服务协议、服务器
		protocol = pro.getProperty("mail.transport.protocol").toString();
		host = pro.getProperty("mail.smtp.host").toString();
		//装载发件人昵称
		senderNick = pro.getProperty("senderNick").toString();
		//装载服务邮箱和密码
		username = pro.getProperty("username").toString();
		password = pro.getProperty("password").toString();
		//装载 logo 图标路径
		logoUrl = pro.getProperty("logoUrl").toString();
		//建立会话
        session = Session.getDefaultInstance(pro);
        session.setDebug(true);
	}
	
	
	/**
     * 
     * @Title: getInstance
     * @Description: TODO 单列
     * @return
     * @return: EmailUtils
     */
    public static EmailUtils getInstance() {
        if (instance == null) {
            instance = new EmailUtils();
        }
        return instance; 
    }
	
    /**
     * 
     * @Title: sendMail
     * @Description: TODO 邮件发送
     * @param to 收件人
     * @param copyto 抄送人[可为空数组或者null]
     * @param subject 主题
     * @param content 正文
     * @param logoarr html 邮件中的图片,名称需要和模板中的名称相同,
     * 			如模板中为 cid:top_logo,那么图片名称就应该是 top_logo.xxx
     * @param fileList 附件列表
     * @return
     * @return: boolean
     */
    private boolean sendMail(String[] to, String[] copyto, String subject, String content, String[] logoarr, String[] fileList) {
    	boolean success = true;
        try {
            mimeMsg = new MimeMessage(session);
            mp = new MimeMultipart();
            String nick = "";//自定义发件人昵称
            try {
                nick = MimeUtility.encodeText(senderNick);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            mimeMsg.setFrom(new InternetAddress(username, nick));//设置发件人
            //设置收件人
            if (to != null && to.length > 0) {
                String toListStr = getMailList(to);
                System.out.println("收件人："+toListStr);
                mimeMsg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toListStr));
            }
            //设置抄送人
            if (copyto != null && copyto.length > 0) {
                String ccListStr = getMailList(copyto);
                System.out.println("抄送人："+ccListStr);
                mimeMsg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(ccListStr)); 
            }
            mimeMsg.setSubject(subject);//设置主题
            MimeBodyPart bp = new MimeBodyPart();//设置正文
            String body = content;
            bp.setContent(body, "text/html;charset=utf-8");
            mp.addBodyPart(bp);
            
            for (int i = 0; i < logoarr.length; i++) {
            	String sUrl = rpath+File.separator+logoarr[i];
            	String str = logoarr[i].substring(0, logoarr[i].lastIndexOf("."));
            	boolean flag = fileIsTrue(sUrl);
            	if(flag){
                    //正文的图片部分
                    MimeBodyPart jpgBody = new MimeBodyPart();
                    FileDataSource fds = new FileDataSource(sUrl);
                    jpgBody.setDataHandler(new DataHandler(fds));
                    jpgBody.setContentID(str);
                    mp.addBodyPart(jpgBody);
            	}else{
                	System.out.println("logo 不存在:"+logoarr[i]);
            	}
			}
            
            //设置附件
            if (fileList != null && fileList.length > 0) {
                for (int i = 0; i < fileList.length; i++) {
                	boolean flag = fileIsTrue(fileList[i]);
                	if(!flag){
                		System.out.println("此附件不存在："+fileList[i]);
                		continue;
                	}
                    bp = new MimeBodyPart();
                    FileDataSource fds_file = new FileDataSource(fileList[i]);
                    bp.setDataHandler(new DataHandler(fds_file));
                    String filename = MimeUtility.encodeText(fds_file.getName(), "UTF-8", "B");
                    filename = filename.replaceAll("\r","").replaceAll("\n","");
                    bp.setFileName(filename);
                    mp.addBodyPart(bp);
                }
            }
            mimeMsg.setContent(mp);
            mimeMsg.saveChanges();
            //发送邮件
            if (auth.equals("true")) {
                Transport transport = session.getTransport(protocol);
                transport.connect(host, username, password);
                transport.sendMessage(mimeMsg, mimeMsg.getAllRecipients());
                transport.close();
            } else {
                Transport.send(mimeMsg);
            }
            System.out.println("邮件发送成功");
        } catch (MessagingException e) {
            e.printStackTrace();
            success = false;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            success = false;
        }
        return success;
    }
    
    /**
     * 
     * @Title: readEamilModel
     * @Description: TODO 读取模板,路径存在返回，不存在返回 null
     * @param modelPath 模板路径
     * @return
     * @return: String
     */
    private static String readEamilModel(String modelPath){
    	sbf = new StringBuffer();
    	String modelFilePath = rpath+modelPath;
    	boolean flag = fileIsTrue(modelFilePath);
    	if(!flag){
    		System.out.println("路径不正确:"+rpath+",或模板不存在："+modelPath);
    		return null;
    	}
    	InputStreamReader in = null;
    	BufferedReader br = null;
    	try {
    		in = new InputStreamReader(new FileInputStream(modelFilePath));
			br = new BufferedReader(in);
			String line=null;
			while((line=br.readLine()) != null){
				int index = line.indexOf("[lqs-##]");
				if(index != -1){
					System.out.println("过滤注释行："+line);
					line = line.substring(0, index);
					if("".equals(line))continue;
				}
				sbf.append(line).append("\n");
			}
		} catch (FileNotFoundException e) {
			System.out.println("IO 异常：模板不存在！"+e.toString());
		} catch (IOException e) {
			System.out.println("IO 异常：获取模板流出现异常！"+e.toString());
		} finally {
			try {
				if(br != null){
					br.close();
				}
				if(in != null){
					in.close();
				}
			} catch (IOException e) {
				System.out.println("IO 异常：关闭流出现异常！"+e.toString());
			}
		}
    	return sbf.toString();
    }
    
    /**
     * 
     * @Title: getMailList
     * @Description: TODO 收件人地址处理
     * @param mailArray
     * @return
     * @return: String
     */
    private String getMailList(String[] mailArray){
        sbf = new StringBuffer();
        int length = mailArray.length;
        if(mailArray != null && length < 2){
        	sbf.append(mailArray[0]);
        }else{
            for(int i = 0; i < length; i++){
            	sbf.append(mailArray[i]);
                if(i != (length - 1)){
                	sbf.append(",");
                }
            }
        }
        return sbf.toString();
    }
    
    /**
     * 
     * @Title: fileIsTrue
     * @Description: TODO 判断文件路径是否存在
     * @param filePath 文件路径
     * @return
     * @return: boolean
     */
    public static boolean fileIsTrue(String filePath){
    	File file = new File(filePath);
    	if(file.exists())return true;
    	return false;
    }
    
    /**
     * 
     * @Title: sendEmailCase
     * @Description: TODO 邮件参数处理
     * @param emailmodel 模板全名+后缀
     * @param copyto 抄送人
     * @param subject 主题
     * @param content 正文
     * @param fileList 附件列表
     * @param to 收件人
     * @return
     * @return: boolean
     */
    public boolean sendEmailCase(String emailmodel, String[] copyto, String subject, String content, String[] fileList, String... to){
    	/*******************************模板处理*******************************/
    	if(emailmodel != null){//测试模板是否存在,不存在的话直接使用正文作为邮件发送内容
	    	int indexof = emailmodel.lastIndexOf(".");
	    	if(indexof == -1){
	    		System.out.println("邮件模板异常:["+emailmodel+"],将不使用模板！");
	    	}else{
	    		if(!"model".equals(emailmodel.substring(indexof+1, emailmodel.length()))){//拿到模板后缀
	    			System.out.println("邮件模板后缀异常：["+emailmodel+"],将不使用模板！");
	    		}else{
	    	    	emailmodel = readEamilModel(emailmodel);//获取模板
	    	    	if(emailmodel == null){
	    	    		System.out.println("邮件模板为空,将不使用模板！");
	    	    	}else{
	    	    		content = StringUtils.replace(emailmodel, "${content}", content);//替换模板中的正文
	    	    	}
	    		}
	    	}
    	}else{
    		System.out.println("邮件模板异常:[NULL],将不使用模板！");
    	}
    	/*******************************收件人处理*******************************/
    	List<String> toFrom = null;//用于接收处理过的收件人
    	int k=0;
    	do{//k==1 处理收件人，k>1 处理转送人
    		k++;
    		String[] stri;
    		toFrom = new ArrayList<String>();
    		if(k==1){
    			stri = to;
    		}else{
    			stri = copyto;
    		}
    		for (int i = 0; i < stri.length; i++) {
    			String str = stri[i];
    			str = str.replaceAll(REGEX, "");//去除空格
    			Pattern r = Pattern.compile(PATTERN);//匹配邮箱
    			Matcher m = r.matcher(str);
    			if(m.matches()){
    				toFrom.add(str);
    			}
    		}
        	int size = toFrom.size();
        	if(size<1 && k==1){
        		System.out.println("无收件人,邮件发送失败");
        		return false;
        	}else if(size<1 && k>1){
        		System.out.println("此邮件无需转送他人");
        		copyto = null;
        	}else{
        		if(k==1){
        			to = (String[])toFrom.toArray(new String[size]);
        		}else if(k>1){
        			copyto = (String[])toFrom.toArray(new String[size]);
        		}
        	}
    	}while(k<2);
    	/*******************************正文图片处理*******************************/
    	String[] logoarr = logoUrl.split(",");//配置文件的图片路径
    	if(logoarr.length > 0){
        	List<String> logolist = new ArrayList<String>(Arrays.asList(logoarr));
        	Iterator<String> it = logolist.iterator();
        	while(it.hasNext()){
        		String str = it.next();
        		int num = str.indexOf(".");//判断文件是否有 . 存在
        		if(num == -1){
        			it.remove();
        		}
        	}
        	logoarr = logolist.toArray(new String[logolist.size()]);
    	}
    	return sendMail(to, copyto, subject, content, logoarr, fileList);
    }
    
    
    /**
     * 
     * @Title: getRealPath
     * @Description: TODO 获取项目 src 路径
     * @return
     * @return: String
     */
    private static String getRealPath(){
    	rpath = EmailUtils.class.getResource("/").getPath().toString();
    	rpath = rpath.substring(1, rpath.length());
    	rpath = rpath.replace("\\","");
    	rpath = rpath.replace("/","\\");
    	try {
			rpath = new String(rpath.getBytes(), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	/*realPath = realPath.replace("file:","");
    	realPath = realPath.replace("classes\\","");
    	String path = Thread.currentThread().getContextClassLoader().getResource("").toString();
		path = path.replace("/","\\");
		path = path.replace("file:","");
		path = path.replace("classes\\","");
		path = path.substring(1);
    	*/
    	return rpath;
    }
    
    /**
     * @Title: getRealPath
     * @Description: TODO 获取项目真实路径+后缀
     * @param fileName
     * @return
     * @return: String
     */
	public static String getRealPath(String fileName){
		return getRealPath()+fileName;
	}
    
	/**
	 * 
	 * @Title: main
	 * @Description: TODO 测试
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args) {
		EmailUtils eu = EmailUtils.getInstance();
		eu.configurationFile();//测试配置文件
		String[] to = {"294420786@qq.com","294420785@qq.com"};//收件人
		String[] copyto = {};//转送人
		String subject = "注册激活";//主题
		sbf = new StringBuffer();
		sbf.append("您好：<p class=\"body\" style=\"margin: 1em 0px; color: rgb(51, 51, 51); font-size: 10px;\">如果有一天：<br><br><br>你不再寻找爱情，只是去爱；<br><br><br>你不再渴望成功，只是去做；<br><br><br>你人生的一切，才真正开始。");
		sbf.append("<a href=\"mailto:294420785@qq.com\" target=\"_blank\">A<wbr>JIE</a> 长情。</p>");
		sbf.append("<p class=\"body\" style=\"margin: 1em 0px; color: rgb(51, 51, 51); font-size: 10px;\">AJIE</p>");
		sbf.append("<p class=\"body salutation\" style=\"margin: 1em 0px; color: rgb(51, 51, 51); font-size: 10px;\">此致<br>AJIE</p>");
		String content = sbf.toString();//正文
		String emailmodel = "email.model";//模板名称.后缀
		List<String> list = new ArrayList<String>();//附件地址
		list.add(getRealPath()+"TaiziLuoyc.gif");
		int size = list.size();
		String[] fileList = (String[])list.toArray(new String[size]);
		eu.sendEmailCase(emailmodel, copyto, subject, content, fileList, to);
	}
	
	/**
	 * 
	 * @Title: configurationFile
	 * @Description: TODO 测试配置文件
	 * @return: void
	 */
	private void configurationFile(){
		System.out.println("当前路径："+rpath);
		System.out.println("配置文件路径："+filePath);
		Set<String> spn = pro.stringPropertyNames();
		if(spn.size() == 0){
			System.out.println("无数据");
			return;
		}
		Iterator<String> it = spn.iterator();
		System.out.println("打印配置文件参数：");
		while(it.hasNext()){
			String key = it.next();
			System.out.println(key+":"+pro.getProperty(key));
		}
	}
}