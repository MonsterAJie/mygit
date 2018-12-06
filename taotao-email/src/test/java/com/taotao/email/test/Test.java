package com.taotao.email.test;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(final String... args) throws Exception {
    	//applicationContext-rabbitmq.xml
        AbstractApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring/applicationContext-rabbitmq.xml");
        RabbitTemplate template = ctx.getBean(RabbitTemplate.class);
        template.convertAndSend("Hello, world!");
        Thread.sleep(1000);
        ctx.destroy();
    }
}
