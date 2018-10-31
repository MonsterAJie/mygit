package com.jie.part4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;
/**
 * 
 * @ClassName:  ConnectionDriver   
 * @Description:TODO(��̬������Connection)   
 * @author: AJie
 * @date:   2018��10��31�� ����7:02:47   
 *     
 * @Copyright: 2018 https://github.com/MonsterAJie/mygit
 *
 */
public class ConnectionDriver {

	static class ConnectionHandler implements InvocationHandler {

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			if(method.getName().equals("commit")) {
				TimeUnit.MILLISECONDS.sleep(100);
			}
			return null;
		}

	}

	//����һ��Connection�Ĵ�����commitʱ����100����
	public static final Connection createConnection() {
		return (Connection) Proxy.newProxyInstance(Connection.class.getClassLoader(), new Class[] { Connection.class }, new ConnectionHandler());
	}
}
