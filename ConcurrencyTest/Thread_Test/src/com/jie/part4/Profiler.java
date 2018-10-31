package com.jie.part4;

import java.util.concurrent.TimeUnit;

import org.omg.Messaging.SyncScopeHelper;
/**
 * 
 * @ClassName:  Profiler   
 * @Description:TODO(可以应用到调用耗时统计的功能上:AOP)   
 * @author: AJie
 * @date:   2018年10月31日 下午6:18:12   
 *     
 * @Copyright: 2018 https://github.com/MonsterAJie/mygit
 *
 */
public class Profiler {
	//第一次get方法调用时会进行初始化（如果set方法没有调用），每个线程会调用一次
	private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>() {
		protected Long initialValue() {
			return System.currentTimeMillis();
		}
	};
	public static final void begin() {
		TIME_THREADLOCAL.set(System.currentTimeMillis());
	}
	public static final long end() {
		return System.currentTimeMillis() - TIME_THREADLOCAL.get();
	}
	public static void main(String[] args) throws InterruptedException {
		Profiler.begin();
		TimeUnit.SECONDS.sleep(1);
		System.out.println("Cost:" + Profiler.end() + " mills");
	}
}
