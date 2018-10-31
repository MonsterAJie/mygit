package com.jie.part4;

import java.util.concurrent.TimeUnit;
/**
 * 
 * @ClassName:  Shutdown   
 * @Description:TODO(线程安全的中断操作)   
 * @author: AJie
 * @date:   2018年10月31日 下午4:01:03   
 *     
 * @Copyright: 2018 https://github.com/MonsterAJie/mygit
 *
 */
public class Shutdown {

	public static void main(String[] args) throws InterruptedException {
		Runner one = new Runner();
		Thread countThread = new Thread(one, "CountThread");
		countThread.start();
		//睡眠1秒，main线程对CountThread进行中断，使CountThread能够感知中断而结束
		TimeUnit.SECONDS.sleep(1);
		countThread.interrupt();
		Runner two = new Runner();
		countThread = new Thread(two, "CountThread");
		countThread.start();
		//睡眠1秒，main线程对Runner two进行取消，是CountThread能够感知on为false而结束
		TimeUnit.SECONDS.sleep(1);
		two.cancel();
	}
	
	private static class Runner implements Runnable {
		private long i;
		private volatile boolean on = true;
		@Override
		public void run() {
			while(on && !Thread.currentThread().isInterrupted()) {
				i ++;
			}
			System.out.println("Count i = " + i);
		}
		public void cancel() {
			on = false;
		}
	}
}
