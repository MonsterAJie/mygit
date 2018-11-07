package com.dahan.jie.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import org.junit.jupiter.api.Test;

/**
 * 
 * @ClassName:  EX1   
 * @Description:TODO(保证三个线程有序执行)   
 * @author: AJie
 * @date:   2018年11月7日 下午4:06:20   
 *     三种方法的实现
 * @Copyright: 2018 https://github.com/MonsterAJie/mygit
 *
 */
public class EX1 {

	/**
	 * 方法一：实现callable接口
	 */
	@Test
	public void Test_EX1() throws InterruptedException, ExecutionException {
		Callable<String> callable1 = new MyThread("小胡");
		Callable<String> callable2 = new MyThread("小明");
		Callable<String> callable3 = new MyThread("小亮");

		FutureTask<String> task1 = new FutureTask<>(callable1);
        FutureTask<String> task2 = new FutureTask<>(callable2);
        FutureTask<String> task3 = new FutureTask<>(callable3);

        new Thread(task1).start();
        System.out.println(task1.get());
        new Thread(task2).start();
        System.out.println(task2.get());
        new Thread(task3).start();
        System.out.println(task3.get());
	}
	
	/**
	 * 方法二：调用join
	 */
	@Test
	public void Test_EX2() throws InterruptedException {
		MyRunnable myRunnable1 = new MyRunnable("小明");
		MyRunnable myRunnable2 = new MyRunnable("小亮");
		MyRunnable myRunnable3 = new MyRunnable("小虎");
		Thread thread1 = new Thread(myRunnable1);
		thread1.setName("小明");
		Thread thread2 = new Thread(myRunnable2);
		thread2.setName("小亮");
		Thread thread3 = new Thread(myRunnable3);
		thread3.setName("小虎");
		thread1.start();
		thread1.join();
		thread2.start();
		thread2.join();
		thread3.start();
		thread3.join();
	}
	
	/**
	 * 方法二：使用线程池
	 */
	@Test
	public void Test_EX3() {
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		MyRunnable myRunnable1 = new MyRunnable("小明");
		MyRunnable myRunnable2 = new MyRunnable("小亮");
		MyRunnable myRunnable3 = new MyRunnable("小虎");
		Thread thread1 = new Thread(myRunnable1);
		Thread thread2 = new Thread(myRunnable2);
		Thread thread3 = new Thread(myRunnable3);
		threadPool.submit(thread1);
		threadPool.submit(thread2);
		threadPool.submit(thread3);
		threadPool.shutdown();
	}
}
