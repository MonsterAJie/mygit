package com.jie.part5;

import java.util.concurrent.locks.Lock;

import org.junit.jupiter.api.Test;

import com.jie.part4.SleepUtils;
/**
 * 
 * @ClassName:  TwinsLockTest   
 * @Description:TODO(仅支持双线程的同步锁测试)   
 * @author: AJie
 * @date:   2018年11月1日 下午1:06:49   
 *     
 * @Copyright: 2018 https://github.com/MonsterAJie/mygit
 *
 */
public class TwinsLockTest {
	
	@Test
	public void test() {
		final Lock lock = new TwinsLock();
		class Worker extends Thread {
			public void run() {
				while (true) {
					lock.lock();
					try {
						SleepUtils.second(1);
						System.out.println(Thread.currentThread().getName());
						SleepUtils.second(1);
					} finally {
						lock.unlock();
					}
				}
			}
		}
		//启动10个线程
		for (int i = 0; i < 10; i ++) {
			Worker w = new Worker();
//			w.setDaemon(true);
			w.start();
		}
		//每隔1秒换行
		for (int i = 0; i < 10; i ++) {
			SleepUtils.second(1);
			System.out.println();
		}
	}
	
}
