package com.jie.part8;

import java.util.Map.Entry;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 
 * @ClassName:  BankWaterService   
 * @Description:TODO(银行流水处理服务类)   
 * @author: AJie
 * @date:   2018年11月12日 下午7:37:20   
 *     
 * @Copyright: 2018 https://github.com/MonsterAJie/mygit
 *
 */
public class BankWaterService implements Runnable {
	
	private CyclicBarrier c = new CyclicBarrier(4, this);
	
	private Executor executor = Executors.newFixedThreadPool(4);
	
	private ConcurrentHashMap<String, Integer> sheetBankWaterCount = new ConcurrentHashMap<String, Integer>();

	private void count() {
		for (int i = 0; i < 4; i ++) {
			executor.execute(new Runnable() {
				@Override
				public void run() {
					sheetBankWaterCount.put(Thread.currentThread().getName(), 1);
					try {
						c.await();
					} catch (InterruptedException | BrokenBarrierException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
	}
	
	@Override
	public void run() {
		int result = 0;
		for (Entry<String, Integer> sheet : sheetBankWaterCount.entrySet()) {
			result += sheet.getValue();
		}
		sheetBankWaterCount.put("result", result);
		System.out.println(result);
	}
	public static void main(String[] args) {
		BankWaterService bankWaterCount = new BankWaterService();
		bankWaterCount.count();
	}
	
}
