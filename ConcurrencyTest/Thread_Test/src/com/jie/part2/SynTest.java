package com.jie.part2;

public class SynTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassSynTest();
		ObejectSynTest();
	}
	/**
	 * ∂‘œÛÀ¯≤‚ ‘
	 */
	private static void ObejectSynTest() {
		Syn syn = new Syn();
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				syn.obejectadd();
			}
		});
		thread.start();
		Thread thread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				syn.obejectdel();
			}
		});
		thread1.start();
		
	}
	/**
	 * ¿‡À¯≤‚ ‘
	 */
	private static void ClassSynTest() {

		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				Syn syn = new Syn();
				// TODO Auto-generated method stub
				syn.add();
			}
		});
		thread.start();
		Thread thread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				Syn syn = new Syn();
				// TODO Auto-generated method stub
				syn.del();
			}
		});
		thread1.start();
		
	}

}

class Syn {
	
	private int i = 0;
	
	private static int j = 0;
	
	public static synchronized void add() {
		System.out.println(j);
		j ++;
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static synchronized void del() {
		System.out.println(j);
		j --;
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void obejectdel() {
		System.out.println(i);
		i ++;
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void obejectadd() {
		System.out.println(i);
		i --;
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}