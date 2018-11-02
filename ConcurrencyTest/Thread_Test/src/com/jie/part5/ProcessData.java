package com.jie.part5;
/**
 * 
 * @ClassName:  ProcessData   
 * @Description:TODO(锁降级:保证数据可见性)   
 * @author: AJie
 * @date:   2018年11月1日 下午3:38:13   
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
			//必须先释放读锁
			readLock.unlock();
			//锁降级从写锁获取到开始
			writeLock.lock();
			try {
				if (!update) {
					//准备数据的流程
					/**
					 * 
					 */
					update = true;
				}
				readLock.lock();
			} finally {
				writeLock.unlock();
			}
			//锁降级完成，写锁降级为读锁
		}
		try {
			//使用数据的流程
			/**
			 * 
			 */
		} finally {
			readLock.unlock();
		}
	}
}
