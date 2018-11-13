package com.jie.part8;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
/**
 * 
 * @ClassName:  SemaphoreTest   
 * @Description:TODO(应用于连接指定数量的链接)   
 * @author: AJie
 * @date:   2018年11月12日 下午8:09:20   
 *     
 * @Copyright: 2018 https://github.com/MonsterAJie/mygit
 *
 */
public class SemaphoreTest {
	
	private static final int THREAD_COUNT = 30;
	
	private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);
			
	private static Semaphore s = new Semaphore(10);
	
	public static void main(String[] args) {
		for (int i = 0; i < THREAD_COUNT; i ++) {
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					try {
						s.acquire();
						System.out.println("save data");
						s.release();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
		threadPool.shutdown();
	}

}
