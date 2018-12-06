package com.taotao.email.thread;

import org.springframework.amqp.core.Message;

import org.apache.commons.codec.binary.Base64;

import com.taotao.email.service.MailService;
import com.taotao.email.utils.AllBean;

public class EmailDealThread implements Runnable {
	
	private Message message;
	
	public EmailDealThread() {}
	
	public EmailDealThread(Message tmessage) {
		message = tmessage;
	}

	@Override
	public void run() {
		MailService mailService = (MailService) AllBean.getBean("mailServiceImpl");
		String messageBody = new String(message.getBody());
        //id解码
        Base64 base64 = new Base64();
        String id = new String(base64.decode(messageBody));
        mailService.createMail(Long.valueOf(id));
	}
}