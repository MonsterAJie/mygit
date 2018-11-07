package com.dahan.jie.test;

import java.util.LinkedList;

public class MyStack {
	LinkedList list = new LinkedList();
	
	public synchronized void push(Object x) {
		synchronized (list) {
			list.addLast(x);
			notify();
		}
	}
	
	public synchronized Object pup() throws InterruptedException {
		synchronized (list) {
			if(list.size() <= 0) {
				wait();
			}
			return list.removeLast();
		}
	}
	
}
