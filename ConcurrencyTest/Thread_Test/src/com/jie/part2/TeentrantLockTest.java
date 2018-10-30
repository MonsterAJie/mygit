package com.jie.part2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TeentrantLockTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class ReentrantLockExample {
	int a = 0;
	ReentrantLock lock = new ReentrantLock();
	public void writer() {
		lock.lock();
		try {
			a ++;
		} finally {
			lock.unlock();
		}
	}
	
	public void reader() {
		lock.lock();
		try {
			int i = a;
		} finally {
			lock.unlock();
		}
	}
}