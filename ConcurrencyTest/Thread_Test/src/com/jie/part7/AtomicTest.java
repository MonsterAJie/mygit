package com.jie.part7;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicTest {
	static int[] value = new int[] { 1,2 };
	static AtomicIntegerArray ai = new AtomicIntegerArray(value);
	public static void main(String[] args) {
		
//		AtomicInteger integer = new AtomicInteger(5);
//		System.out.println(integer.addAndGet(1));//增加新值并返回
//		System.out.println(integer.compareAndSet(6, 4));//等于预期值更新旧值为新值，返回ture
//		System.out.println(integer.compareAndSet(5, 4));
//		System.out.println(integer.getAndIncrement());//返回自增前的值
//		System.out.println(integer.compareAndSet(5, 4));
//		System.out.println(integer.get());
//		System.out.println(integer.getAndSet(7));//设置新值返回旧值
//		System.out.println(integer.get());
		
		
		ai.getAndSet(0,3);
		System.out.println(ai.get(0));
		System.out.println(value[0]);


	}
}
