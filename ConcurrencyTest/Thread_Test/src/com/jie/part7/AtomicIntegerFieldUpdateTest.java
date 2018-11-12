package com.jie.part7;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFieldUpdateTest {
	
	private static AtomicIntegerFieldUpdater<User> a = AtomicIntegerFieldUpdater.newUpdater(User.class, "old");
	
	public static void main(String[] args) {
		User user = new User("user", 10);
		System.out.println(a.getAndIncrement(user));
		System.out.println(a.get(user));
	}
	
	public static class User {
		private String name;
		public volatile int old;
		public User(String name, int old) {
			this.name = name;
			this.old = old;
		}
		public String getname() {
			return name;
		}
		public int getOld() {
			return old;
		}
	}
	
}
