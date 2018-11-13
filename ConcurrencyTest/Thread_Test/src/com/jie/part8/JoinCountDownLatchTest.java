package com.jie.part8;
/**
 * 
 * @ClassName:  JoinCountDownLatchTest   
 * @Description:TODO(应用场景：需要一个或多个线程等待其他线程完成操作)   
 * @author: AJie
 * @date:   2018年11月12日 下午6:50:13   
 *     
 * @Copyright: 2018 https://github.com/MonsterAJie/mygit
 *
 */
public class JoinCountDownLatchTest {

	public static void main(String[] args) throws InterruptedException {
		Thread parser1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("parser1 finish");
			}
		});
		Thread parser2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("parser2 finish");
			}
		});
		parser1.start();
		parser2.start();
		parser1.join();
		parser2.join();
		System.out.println("all parser finish");
	}

}
