package com.jie.part4;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
/**
 * 
 * @ClassName:  Deprecated   
 * @Description:TODO(�������ڲ�����ʹ�ã���������)   
 * @author: AJie
 * @date:   2018��10��30�� ����10:40:29   
 *     suspend:ռ����Դ�������������������
 *     stop:���ᱣ֤�̵߳���Դ�����ͷ�
 *     ʹ�õȴ�/֪ͨ���������
 * @Copyright: 2018 https://github.com/MonsterAJie/mygit
 *
 */
public class Deprecated {

	public static void main(String[] args) throws InterruptedException {
		DateFormat format = new SimpleDateFormat("HH:mm:ss");
		Thread printThread = new Thread(new Runner(), "PrintThread");
		printThread.setDaemon(true);
		printThread.start();
		TimeUnit.SECONDS.sleep(3);
		//ǿPringThread����չ����������ݹ���ֹͣ
		printThread.suspend();
		System.out.println("mian suspend PrintThread at " + format.format(new Date()));
		TimeUnit.SECONDS.sleep(3);
		//��PrintThread���лָ���������ݼ���
		printThread.resume();
		System.out.println("main resume PrintThread at " +format.format(new Date()));
		TimeUnit.SECONDS.sleep(3);
		//��PrintThread������ֹ���������ֹͣ
		printThread.stop();
		System.out.println("main stop PrintThread at " + format.format(new Date()));
		TimeUnit.SECONDS.sleep(3);
	}
	static class Runner implements Runnable {

		@Override
		public void run() {
			DateFormat format = new SimpleDateFormat("HH:mm:ss");
			while(true) {
				System.out.println(Thread.currentThread().getName() + " run at " + 
						format.format(new Date()));
				SleepUtils.second(1);
			}
		}
		
	}
}
