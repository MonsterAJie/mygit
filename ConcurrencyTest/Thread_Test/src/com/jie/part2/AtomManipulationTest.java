package com.jie.part2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.w3c.dom.css.Counter;

public class AtomManipulationTest {
	//AtomicBoolean��AtomicLong
	private AtomicInteger atomicI = new AtomicInteger(0);
	
	private int i = 0;

	private volatile int j = 0;
	
	public static void main(String[] args) {
		final AtomManipulationTest cas = new AtomManipulationTest();
		List<Thread> ts = new ArrayList<Thread>(600);
		long start = System.currentTimeMillis();
		for (int j = 0; j < 100; j ++) {
			Thread t = new Thread(new Runnable() {

				@Override
				public void run() {
					for (int i = 0; i < 10000; i ++) {
						cas.count();
						cas.safeCount();
					}
					
				}	
				
			});
			ts.add(t);
		}
		for (Thread t : ts) {
			t.start();
		}
		//�ȴ������߳�ִ�����
		for (Thread t : ts) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(cas.i);
		System.out.println(cas.atomicI.get());
		System.out.println(cas.j);
		System.out.println(System.currentTimeMillis() - start);
	}
	/**
	 * ʹ��casʵ���̰߳�ȫ������
	 */
	private void safeCount() {
		for (;;) {
			int i = atomicI.get();
			boolean suc = atomicI.compareAndSet(i, ++i);
			if (suc) {
				break;
			}
		}
	}
	/**
	 * ���̰߳�ȫ������
	 */
	private void count() {
		i++;
		j++;
	}

}
