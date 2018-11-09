package com.taotao.common.utils;

import java.util.ArrayList;
import java.util.List;

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
public class StringToListLong {
	public static List<Long> stringToListLong (String str) {
		String[] strList = str.split(",");
		List<Long> list = new ArrayList<Long>();
		for (int i = 0; i < strList.length; i ++) {
			list.add(Long.valueOf(strList[i]));
		}
		return list;
	}
}
