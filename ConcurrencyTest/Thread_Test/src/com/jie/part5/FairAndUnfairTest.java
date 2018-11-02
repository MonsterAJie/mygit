package com.jie.part5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

import com.jie.part4.SleepUtils;

/**
 * 
 * @ClassName:  FairAndUnfairTest   
 * @Description:TODO(公平锁和非公平锁区别测试)   
 * @author: AJie
 * @date:   2018年11月1日 下午1:23:48   
 *     
 * @Copyright: 2018 https://github.com/MonsterAJie/mygit
 *
 */
public class FairAndUnfairTest {
	
	private static Lock fairLock = new ReentrantLock2(true);
	private static Lock unfairLock = new ReentrantLock2(false);
	//保证线程同时进行
	private static CountDownLatch start;
	
	@Test
	public void fair() {
		testLock(fairLock);
	}
	@Test
	public void unfair() {
		testLock(unfairLock);
	}
	private void testLock(Lock lock) {
		//启动5个job
		start = new CountDownLatch(1);
		for (int i = 0; i < 5; i ++) {
//			Job job = Job();
			Thread thread = new Job(lock);
			thread.setName("" + i);
			thread.start();
		}
		start.countDown();
	}
	private static class Job extends Thread {
		private Lock lock;
		public Job(Lock lock) {
			this.lock = lock;
		}
		public void run() {
			//连续2次打印当前的Thread和等待队列中的Thread
			try {
//				SleepUtils.second(1);
				start.await();
			} catch (InterruptedException e) {
				
			}
			for (int i = 0; i < 2; i ++) {
				lock.lock();
				try {
					System.out.println("Lock by [" + getName() + "], Waiting by " + ((ReentrantLock2) lock).getQueuedThreads());
				} finally {
					lock.unlock();
				}
			}
		}
		public String toString() {
			return getName();
		}
	}
	
	private static class ReentrantLock2 extends ReentrantLock {

		private static final long serialVersionUID = -7367755978641341455L;

		public ReentrantLock2(boolean fair) {
			super(fair);
		}
		
		public Collection<Thread> getQueuedThreads() {
			List<Thread> arrayList = new ArrayList<Thread>( 
					super.getQueuedThreads());
			Collections.reverse(arrayList);
			return arrayList;
		}
	}

}
