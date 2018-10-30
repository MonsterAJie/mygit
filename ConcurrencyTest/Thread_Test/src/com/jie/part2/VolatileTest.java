package com.jie.part2;

public class VolatileTest {

	public static void main(String[] args) {
		
	}

}

class VolatileExample {
	
	int a = 0;
	
	volatile boolean flag = false;
	
	public void writer() {
		a = 1;
		flag = true;
	}
	
	public void reader() {
		if (flag) {
			int i = a;
		}
	}
	
}