package com.jie.part5;
/**
 * 
 * @ClassName:  ProcessData   
 * @Description:TODO(������:��֤���ݿɼ���)   
 * @author: AJie
 * @date:   2018��11��1�� ����3:38:13   
 *     
 * @Copyright: 2018 https://github.com/MonsterAJie/mygit
 *
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ProcessData {
	private static final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	private static final Lock readLock = rwl.readLock();
	private static final Lock writeLock = rwl.writeLock();
	private volatile boolean update = false;
	public void processData() {
		readLock.lock();
		if (!update) {
			//�������ͷŶ���
			readLock.unlock();
			//��������д����ȡ����ʼ
			writeLock.lock();
			try {
				if (!update) {
					//׼�����ݵ�����
					/**
					 * 
					 */
					update = true;
				}
				readLock.lock();
			} finally {
				writeLock.unlock();
			}
			//��������ɣ�д������Ϊ����
		}
		try {
			//ʹ�����ݵ�����
			/**
			 * 
			 */
		} finally {
			readLock.unlock();
		}
	}
}
