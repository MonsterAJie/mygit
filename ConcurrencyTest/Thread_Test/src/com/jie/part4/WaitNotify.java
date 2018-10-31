package com.jie.part4;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
/**
 * 
 * @ClassName:  WaitNotify   
 * @Description:TODO(���̼߳�ͨ��)   
 * @author: AJie
 * @date:   2018��10��31�� ����4:44:25   
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
			//������ӵ��lock��Monitor
			synchronized (lock) {
				//�������������ǣ�����wait��ͬʱ�ͷ���lock����
				while(flag) {
					try {
						System.out.println(Thread.currentThread() + " flag is true. "
								+ new SimpleDateFormat("HH:mm:ss").format(new Date()));
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				//��������ʱ����ɹ���
				System.out.println(Thread.currentThread() + " flag is false. running" 
						+ new SimpleDateFormat("HH:mm:ss").format(new Date()));
			}
		}
	}
	static class Notify implements Runnable {
		public void run() {
			//������ӵ��lock��Monitor
			synchronized (lock) {
				//��ȡlock������Ȼ�����֪ͨ��֪ͨʱ�����ͷ�lock����
				//֪����ǰ�߳��ͷ���lock��waitThread���ܴ�wait�����з���
				System.out.println(Thread.currentThread() + " hold lock. notiry" +
				new SimpleDateFormat("HH:mm:ss").format(new Date()));
				flag = false;		//*2	˳���Ƿ�����
				lock.notifyAll();	//1
//				flag = false;		//2	˳���Ƿ�����
				SleepUtils.second(5);
			}
			//�ٴμ���
			synchronized (lock) {
				System.out.println(Thread.currentThread() + " hold lock again. sleep " 
						+new SimpleDateFormat("HH:mm:ss").format(new Date()));
				SleepUtils.second(5);
			}
		}
	}
}
