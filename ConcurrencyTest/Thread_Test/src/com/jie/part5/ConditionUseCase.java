package com.jie.part5;
/**
 * 
 * @ClassName:  ConditionUseCase   
 * @Description:TODO(������һ�仰��������������)   
 * @author: AJie
 * @date:   2018��11��2�� ����4:14:29   
 *     
 * @Copyright: 2018 https://github.com/MonsterAJie/mygit
 *
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 
 * @ClassName:  ConditionUseCase   
 * @Description:TODO(Condition�ȴ�֪ͨ��Ӧ��)   
 * @author: AJie
 * @date:   2018��11��2�� ����4:20:27   
 *     
 * @Copyright: 2018 https://github.com/MonsterAJie/mygit
 *
 */
public class ConditionUseCase {
	Lock lock = new ReentrantLock();
	Condition condition = lock.newCondition();
	public void conditionWati() throws InterruptedException {
		lock.lock();
		try {
			condition.await();
		} finally {
			lock.unlock();
		}
	}
	public void conditionSignal() {
		lock.lock();
		try {
			condition.signal();
		} finally {
			lock.unlock();
		}
	}
}
