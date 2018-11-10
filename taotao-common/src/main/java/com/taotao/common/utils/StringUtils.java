package com.taotao.common.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 
 * @ClassName:  StringToListLong   
 * @Description:TODO(以逗号分割的长整型格式字符串转换为长整型集合)   
 * @author: AJie
 * @date:   2018年11月9日 下午8:22:48   
 *     
 * @Copyright: 2018 https://github.com/MonsterAJie/mygit
 *
 */
public class StringUtils {
	public static List<Long> stringToListLong (String str, String spp) {
		String[] strList = str.split(spp);
		List<Long> list = new ArrayList<Long>();
		for (int i = 0; i < strList.length; i ++) {
			if (isNumeric(strList[i])) {
				list.add(Long.valueOf(strList[i]));
			} else {
				return new ArrayList<Long>();
			}
		}
		return list;
	}
	/**
	 * 
	 * @Title: isNumeric   
	 * @Description: TODO(检测字符串是否为纯数字)   
	 * @param: @param str
	 * @param: @return      
	 * @return: boolean      
	 * @throws
	 */
	public static boolean isNumeric(String str){
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}
}
