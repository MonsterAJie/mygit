package com.jie.part4;

import java.util.concurrent.TimeUnit;

import org.omg.Messaging.SyncScopeHelper;
/**
 * 
 * @ClassName:  Profiler   
 * @Description:TODO(����Ӧ�õ����ú�ʱͳ�ƵĹ�����:AOP)   
 * @author: AJie
 * @date:   2018��10��31�� ����6:18:12   
 *     
 * @Copyright: 2018 https://github.com/MonsterAJie/mygit
 *
 */
public class Profiler {
	//��һ��get��������ʱ����г�ʼ�������set����û�е��ã���ÿ���̻߳����һ��
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
