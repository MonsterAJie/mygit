package com.jie.part4;
/**
 * 
 * @ClassName:  Daemon   
 * @Description:TODO(Daemon �߳��е�finally���еĴ��벻һ����ִ��) *Daemon�߳��еĴ��벻һ����ִ��
 * @author: AJie
 * @date:   2018��10��30�� ����10:05:59   
 *     
 * @Copyright: 2018 https://github.com/MonsterAJie/mygit
 *
 */
public class Daemon {

	public static void main(String[] args) throws InterruptedException {
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				SleepUtils.second(10);
			}
			
		});
//		thread1.start();
//		thread1.join();
		Thread thread = new Thread(new DaemonRunner(), "DaemonRunner");
		thread.setDaemon(true);
		thread.start();
//		thread.join();
	}
	static class DaemonRunner implements Runnable {

		@Override
		public void run() {
			try {
				System.out.println("DaemonThread sleep before run.");
//				SleepUtils.second(5);
				System.out.println("DaemonThread sleep after run.");
			} finally {
				System.out.println("DaemonThread finally run.");
			}
		}
		
	}
}

