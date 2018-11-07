package com.dahan.jie.test;

import com.jie.part4.SleepUtils;

public class MyRunnable implements Runnable {
	
	private String name;
	
	public MyRunnable(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
//		try {
//			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + ":" + this.name);
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
