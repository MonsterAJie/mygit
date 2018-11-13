package com.jie.part8;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
/**
 * 
 * @ClassName:  CyslicBarrierTest2   
 * @Description:TODO(参数2：其他线程执行完后首先执行该线程（其他线程没有执行完不执行），该线程执行完后执行其他线程（该线程没有执行完不执行其他线程）)   
 * @author: AJie
 * @date:   2018年11月12日 下午7:29:54   
 *     类似分治算法，给每个线程分配较小的任务，最后启动barrierAction处理每个线程的运行结果得到最后结果
 * @Copyright: 2018 https://github.com/MonsterAJie/mygit
 *
 */
public class CyslicBarrierTest2 {
	static CyclicBarrier c = new CyclicBarrier(2, new A());
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println(4);
					Thread.sleep(2000);
					c.await();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(1);
			}
		}).start();
		try {
			System.out.println(5);
			c.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(2);
	}
	static class A implements Runnable {
		@Override
		public void run() {
			try {
				System.out.println(6);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(3);
		}
	}
}
