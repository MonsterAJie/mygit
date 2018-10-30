package com.jie.part2;

import java.util.ArrayList;
import java.util.List;

public class ReorderThreadTest {
	
//	private static 
	
	int a = 0;
	
	boolean flag = false;
	
	public void writer() {
		a = 1;
		flag = true;
		System.out.println(a);
	}
	
	public void reader() {
		if (flag) {
			int i = a + a;
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		

		List<Thread> list = new ArrayList<Thread>();
		for (int i = 0; i < 10; i ++) {
			ReorderThreadTest reorderThread = new ReorderThreadTest();
			Thread thread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					reorderThread.writer();
				}
			});
			thread.start();
			list.add(thread);
		}

		for (int i = 0; i < 10; i ++) {
			ReorderThreadTest reorderThread = new ReorderThreadTest();
			Thread thread1 = new Thread(new Runnable() {
				
				@Override
				public void run() {
					reorderThread.reader();
				}
			});
			thread1.start();
			list.add(thread1);
		}
		for(Thread thread : list) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
