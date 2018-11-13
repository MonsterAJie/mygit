package com.jie.part8;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * 
 * @ClassName:  ExchangerTest   
 * @Description:TODO(应用于两个线程之间的信息交换exchange方法参数为数据包)   
 * @author: AJie
 * @date:   2018年11月12日 下午8:52:59   
 *     
 * @Copyright: 2018 https://github.com/MonsterAJie/mygit
 *
 */
public class ExchangerTest {
	private static final Exchanger<String> exgr = new Exchanger<String>();
	private static ExecutorService threadPool = Executors.newFixedThreadPool(2);
	public static void main(String[] args) {
		threadPool.execute(new Runnable() {
			@Override
			public void run() {
				String A = "银行流水A";
				String B = null;
				try {
					B = exgr.exchange("321");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("A和B数据是否一致1：" + A.equals(B) + "，A录入的是：" + A + "，B录入是：" + B);
			}
		});
		threadPool.execute(new Runnable() {
			@Override
			public void run() {
				String B = "银行流水B";
				String A = null;
				try {
					A = exgr.exchange("12345");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("A和B数据是否一致：" + A.equals(B) + "，A录入的是：" + A + "，B录入是：" + B);
			}
		});
		threadPool.shutdown();
	}

}
