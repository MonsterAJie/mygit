package com.taotao.common.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.taotao.common.pojo.Code;
import com.taotao.common.pojo.QbcItem;
//import com.taotao.common.pojo.TbCode;
/**
 * 
 * @ClassName:  ObjectUtils   
 * @Description:TODO(类信息转换工具)   
 * @author: AJie
 * @date:   2018年11月11日 下午11:11:15   
 *     
 * @Copyright: 2018 https://github.com/MonsterAJie/mygit
 *
 */
public class ObjectUtils {
	
	private final static Logger logger = Logger.getLogger(ObjectUtils.class);
	
	/**
	 * 
	 * @Title: ObjectExtractToObjects   
	 * @Description: TODO(集合中的TbCode类code字段值与o类的属性名相同时，得到该对象的codename值写入o类中，返回o类集合)   
	 * @param: @param list	待处理类
	 * @param: @param o		目标类
	 * @param: @return      目标类集合
	 * @return: List<Object>      
	 * @throws			内部处理
	 */
	public static List<Object> ObjectExtractToObjects (List<Object> list, Object o) {
		if (list.size() < 1) {
			return new ArrayList<Object>();
		}
		List codeList = new ArrayList<Object>();
		for (int i = 0; i < list.size(); i ++) {
			Field field = null;
			try {
				field = list.get(i).getClass().getDeclaredField("code");
			} catch (Exception e) {
				logger.debug(e.getStackTrace());
			}
			Object code = null;
			try {
				code = o.getClass().newInstance();
			} catch (Exception e) {
				logger.debug(e.getStackTrace());
			}
			try {
				field.setAccessible(true);
				System.out.println(String.valueOf(field.get(list.get(i))));
				if (compare(code, String.valueOf(field.get(list.get(i))))) {
					Field fd = null;
					Field valuefd = null;
					try {
						fd = code.getClass().getDeclaredField(String.valueOf(field.get(list.get(i))));
						valuefd = list.get(i).getClass().getDeclaredField("codename");
					} catch (Exception e) {
						logger.debug(e.getStackTrace());
					}
					fd.setAccessible(true);
					valuefd.setAccessible(true);
					try {
						fd.set(code, valuefd.get(list.get(i)));
					} catch (Exception e) {
						logger.debug(e.getStackTrace());
					}
					codeList.add(code);
				}
			} catch (Exception e) {
				logger.debug(e.getStackTrace());
			}
	
		}
		return codeList;
	}
	
	/**
	 * 
	 * @Title: ObjectExtractToObject   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param list	带值的list集合
	 * @param: @param o		目标类
	 * @param: @return      转换成目标类的list集合，值来自参数list集合，不相同字段名的值丢弃
	 * @return: List<Object>      
	 * @throws				异常内部处理
	 */
	public static List<Object> ObjectExtractToObject (List<Object> list, Object o) {
		if (list.size() < 1) {
			return new ArrayList<Object>();
		}
		List codeList = new ArrayList<Object>();
		Field[ ] fields = list.get(0).getClass().getDeclaredFields();
		for (int i = 0; i < list.size(); i ++) {
			Object code = null;
			try {
				code = o.getClass().newInstance();
			} catch (Exception e) {
				logger.debug(e.getStackTrace());
			}
			for (Field field : fields) {
				if (compare(code, field.getName())) {
					Field fd = null;
					try {
						fd = code.getClass().getDeclaredField(field.getName());
					} catch (Exception e) {
						logger.debug(e.getStackTrace());
					}
					fd.setAccessible(true);
					field.setAccessible(true);
					try {
						fd.set(code, field.get(list.get(i)));
					} catch (Exception e) {
						logger.debug(e.getStackTrace());
					}
					codeList.add(code);
				}
			}
	
		}
		return codeList;
	}
	
	private static boolean compare(Object code, String str) {
		try {
			code.getClass().getDeclaredField(str);
		} catch (NoSuchFieldException e) {
			logger.debug("无字段" + str + "信息！");
			return false;
		} catch (SecurityException e) {
			logger.debug("字段" + str + "异常！");
			return false;
		}
		return true;
		
	}
	
	public static void main(String[] args) {
//		QbcItem item = new QbcItem();
//		QbcItem item1 = new QbcItem();
//		List list = new ArrayList<QbcItem>();
//		item.setPrice("1");
//		item1.setPrice("2");
//		item.setRows(1);
//		item1.setRows(1);
//		list.add(item);
//		list.add(item1);
//		List<Code> list1 = ObjectExtractToObject(list, new Code());
//		list1.size();
//		TbCode item = new TbCode();
//		TbCode item1 = new TbCode();
//		List list = new ArrayList<TbCode>();
//		list.add(item);
//		list.add(item1);
//		item.setCode("price");
//		item.setCodename("1-2");
//		item1.setCode("price");
//		item1.setCodename("1-2");
//		List<Code> list1 = ObjectExtractToObjects(list, new Code());
	}
	
}
