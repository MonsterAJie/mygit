package com.jie.part4;

public class Synchronized {

	public static void main(String[] args) {
		//��Synchronized Class �Զ�����м���
		synchronized (Synchronized.class) {
			
		}
		//��̬ͬ����������Synchronized Class������м���
		m();
	}
	public static synchronized void m() {
		
	}

}
