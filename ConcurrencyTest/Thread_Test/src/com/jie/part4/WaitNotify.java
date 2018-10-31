package com.jie.part4;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
/**
 * 
 * @ClassName:  WaitNotify   
 * @Description:TODO(多线程间通信)   
 * @author: AJie
 * @date:   2018年10月31日 下午4:44:25   
 *     
 * @Copyright: 2018 https://github.com/MonsterAJie/mygit
 *
 */
public class WaitNotify {
	static boolean flag = true;
	static Object lock = new Object();
	public static void main(String[] args) throws InterruptedException {
		Thread waitThread = new Thread(new Wait(), "WaitThread");
		waitThread.start();
		TimeUnit.SECONDS.sleep(1);
		Thread notifyThread = new Thread(new Notify(), "NotifyThread");
		notifyThread.start();
	}
	static class Wait implements Runnable {
		public void run() {
			//加锁，拥有lock的Monitor
			synchronized (lock) {
				//当条件不满足是，继续wait，同时释放了lock的锁
				while(flag) {
					try {
						System.out.println(Thread.currentThread() + " flag is true. "
								+ new SimpleDateFormat("HH:mm:ss").format(new Date()));
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				//条件满足时，完成工作
				System.out.println(Thread.currentThread() + " flag is false. running" 
						+ new SimpleDateFormat("HH:mm:ss").format(new Date()));
			}
		}
	}
	static class Notify implements Runnable {
		public void run() {
			//加锁，拥有lock的Monitor
			synchronized (lock) {
				//获取lock的锁，然后进行通知，通知时不会释放lock的锁
				//知道当前线程释放了lock后，waitThread才能从wait方法中返回
				System.out.println(Thread.currentThread() + " hold lock. notiry" +
				new SimpleDateFormat("HH:mm:ss").format(new Date()));
				flag = false;		//*2	顺序是否有误？
				lock.notifyAll();	//1
//				flag = false;		//2	顺序是否有误？
				SleepUtils.second(5);
			}
			//再次加锁
			synchronized (lock) {
				System.out.println(Thread.currentThread() + " hold lock again. sleep " 
						+new SimpleDateFormat("HH:mm:ss").format(new Date()));
				SleepUtils.second(5);
			}
		}
	}
}
