package com.jie.part5;

import java.util.AbstractQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
/**
 * 
 * @ClassName:  Mutex   
 * @Description:TODO(独占锁)   
 * @author: AJie
 * @date:   2018年11月1日 下午1:07:43   
 *     
 * @Copyright: 2018 https://github.com/MonsterAJie/mygit
 *
 */
public class Mutex {
	
	//静态内部类，自定义同步器
	private static class Sync extends AbstractQueuedSynchronizer {
		//是否处于占用状态
		protected boolean isHeldExclusively() {
			return getState() == 1;
		}
		//当状态为0的时候获取锁
		public boolean tryAcquire(int accquires) {
			if (compareAndSetState(0, 1)) {
				setExclusiveOwnerThread(Thread.currentThread());
				return true;
			}
			return false;
		}
		//释放锁，将状态设置为0
		protected boolean tryRelease(int releases) {
			if (getState() == 0) {
				throw new IllegalMonitorStateException();
			}
			setExclusiveOwnerThread(null);
			setState(0);
			return true;
		}
		//返回一个Condition,每个condition都包含了一个condition队列
		Condition newCondition() {
			return new ConditionObject();
		}
	}
	//仅需要将操作代理到Sync上即可
	private final Sync sync = new Sync();
	public void lock() {
		sync.acquire(1);
	}
	public boolean tryLock() {
		return sync.tryAcquire(1);
	}
	public void unlock() {
		sync.release(1);
	}
	public Condition newCondition() {
		return sync.newCondition();
	}
	public boolean isLocked() {
		return sync.isHeldExclusively();
	}
	public boolean hasQueuedhreads() {
		return sync.hasQueuedThreads();
	}
	public void lockInterruptibly() throws InterruptedException {
		sync.acquireInterruptibly(1);
	}
	public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
		return sync.tryAcquireNanos(1, unit.toNanos(timeout));
	}

}
