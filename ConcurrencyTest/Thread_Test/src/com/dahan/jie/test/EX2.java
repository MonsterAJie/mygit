package com.dahan.jie.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * 
 * @ClassName:  EX2   
 * @Description:TODO(代码问题分析)   
 * @author: AJie
 * @date:   2018年11月7日 下午5:03:12   
 *     测试了很多种情况还是没有测出问题
 *     		数据填充数		线程数
 *     		10000		10 10000 
 *     		100000		10 10000
 *     		1000000		10 10000
 *     		10000000	10 10000
 * @Copyright: 2018 https://github.com/MonsterAJie/mygit
 *
 */
public class EX2 {

	@Test
	public void Test() throws InterruptedException {
		MyStack myStack = new MyStack();
		List<Thread> threadList = new ArrayList<Thread>();	
		for (int i = 0; i < 100000; i ++) {
			myStack.push("" + i);
		}
		for (int i = 0; i < 10; i ++) {
			Thread thread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						for (int i = 0; i < 10000; i ++) {
							myStack.pup();
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			threadList.add(thread);
		}
		for (int i = 0; i < 10; i ++) {
			threadList.get(i).start();
		}
	}
}
