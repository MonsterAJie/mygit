package com.jie.part8;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
/**
 * 
 * @ClassName:  CyclicBarrierTest   
 * @Description:TODO(每个线程只能调用一次（包括主线程），满足次数唤醒所有线程)   
 * @author: AJie
 * @date:   2018年11月12日 下午7:19:08   
 *     
 * @Copyright: 2018 https://github.com/MonsterAJie/mygit
 *
 */
public class CyclicBarrierTest {
	
	static CyclicBarrier c = new CyclicBarrier(2);
	
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					c.await();
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println(1);
			}
		}).start();
		try {
			c.await();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(2);
	}

}
