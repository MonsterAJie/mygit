package com.jie.part10;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
/**
 * 
 * @ClassName:  FutrueTest   
 * @Description:TODO(当多个线程试图同时执行同一个任务时，只允许一个线程执行任务，其他线程需要等待这个任务执行完后才能继续执行)   
 * @author: AJie
 * @date:   2018年11月13日 下午4:48:42   
 *     
 * @Copyright: 2018 https://github.com/MonsterAJie/mygit
 *
 */
public class FutrueTest {
	
	private final ConcurrentMap<Object, Future<String>> taskCache = 
			new ConcurrentHashMap<Object, Future<String>>();
	
	private String executionTask(final String taskName) throws InterruptedException, ExecutionException {
		while (true) {
			Future<String> future = taskCache.get(taskName);
			if (future == null) {
				Callable<String> task = new Callable<String>() {
					public String call() {
						return taskName;
					}
				};
				FutureTask<String> futureTask = new FutureTask<String>(task);
				future = taskCache.putIfAbsent(taskName, futureTask);
				if (future == null) {
					future = futureTask;
					futureTask.run();
				}
			}
			try {
				return future.get();
			} catch (CancellationException e) {
				taskCache.remove(taskName, future);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
