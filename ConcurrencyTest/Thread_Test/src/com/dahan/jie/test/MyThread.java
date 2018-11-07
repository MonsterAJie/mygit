package com.dahan.jie.test;

import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
	
	private String acceptStr;
	
	public MyThread(String acceptStr) {
		this.acceptStr = acceptStr;
	}
	
	@Override
	public String call() throws Exception {
		String str = "我是：" + acceptStr;
		System.out.println("我是：" + acceptStr);
		return str;
	}

}
