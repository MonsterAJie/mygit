package com.taotao.email.listener;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;

import com.taotao.email.thread.EmailDealThread;

public class EmailMessageListener implements MessageListener {
	
	private Logger logger = Logger.getLogger(EmailMessageListener.class);
	
    /**
     * 创建一个线程池(完整入参): 
     * 核心线程数为5 (corePoolSize), 
     * 最大线程数为10 (maximumPoolSize), 
     * 存活时间为60分钟(keepAliveTime), 
     * 工作队列为LinkedBlockingQueue (workQueue),
     * 线程工厂为默认的DefaultThreadFactory (threadFactory), 
     * 饱和策略(拒绝策略)为AbortPolicy: 抛出异常(handler).
     */
    private static ExecutorService THREAD_POOL = new ThreadPoolExecutor(5, 10, 60, TimeUnit.MINUTES,
            new LinkedBlockingQueue<Runnable>(), Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy());
    
	@Override
	public void onMessage(Message message) {
		THREAD_POOL.submit(new EmailDealThread(message));
	}
}
