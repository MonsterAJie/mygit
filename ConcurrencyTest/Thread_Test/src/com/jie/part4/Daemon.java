package com.jie.part4;
/**
 * 
 * @ClassName:  Daemon   
 * @Description:TODO(Daemon 线程中的finally块中的代码不一定会执行) *Daemon线程中的代码不一定被执行
 * @author: AJie
 * @date:   2018年10月30日 下午10:05:59   
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

