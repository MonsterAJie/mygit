package com.taotao.controller;

import java.util.regex.Pattern;

import com.taotao.common.utils.StringUtils;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "111,222,a,b,333";
		StringUtils.stringToListLong(str, ",");
	}
	

}
