package com.jie.part8;

import java.util.concurrent.CountDownLatch;
/**
 * 
 * @ClassName:  CountDownLatchTest   
 * @Description:TODO(调用countDown的次数后唤醒线程，调用可由一个或多个线程)   
 * @author: AJie
 * @date:   2018年11月12日 下午7:12:10   
 *     
 * @Copyright: 2018 https://github.com/MonsterAJie/mygit
 *
 */
public class CountDownLatchTest {
	static CountDownLatch c = new CountDownLatch(2);//参数为调用.countDown的次数后唤醒
	public static void main(String[] args) throws InterruptedException {
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(1);
				c.countDown();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(2);
				c.countDown();
			}
		}).start();
		System.out.println(3);
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(4);
				try {
					c.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(5);
			}
		}).start();
		c.await();
		System.out.println(6);
	}

}
