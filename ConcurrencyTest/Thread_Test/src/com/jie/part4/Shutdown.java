package com.jie.part4;

import java.util.concurrent.TimeUnit;
/**
 * 
 * @ClassName:  Shutdown   
 * @Description:TODO(�̰߳�ȫ���жϲ���)   
 * @author: AJie
 * @date:   2018��10��31�� ����4:01:03   
 *     
 * @Copyright: 2018 https://github.com/MonsterAJie/mygit
 *
 */
public class Shutdown {

	public static void main(String[] args) throws InterruptedException {
		Runner one = new Runner();
		Thread countThread = new Thread(one, "CountThread");
		countThread.start();
		//˯��1�룬main�̶߳�CountThread�����жϣ�ʹCountThread�ܹ���֪�ж϶�����
		TimeUnit.SECONDS.sleep(1);
		countThread.interrupt();
		Runner two = new Runner();
		countThread = new Thread(two, "CountThread");
		countThread.start();
		//˯��1�룬main�̶߳�Runner two����ȡ������CountThread�ܹ���֪onΪfalse������
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
