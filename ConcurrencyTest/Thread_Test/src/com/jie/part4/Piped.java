package com.jie.part4;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
/**
 * 
 * @ClassName:  Piped   
 * @Description:TODO(�ܵ����������)   
 * @author: AJie
 * @date:   2018��10��31�� ����5:12:41   
 *     
 * @Copyright: 2018 https://github.com/MonsterAJie/mygit
 *
 */
public class Piped {
	
	public static void main(String[] args) throws IOException {
		PipedWriter out = new PipedWriter();
		PipedReader in = new PipedReader();
		//����������������������ӣ�������ʹ��ʱ���׳�IOEXCEPTION
		out.connect(in);
		Thread printThread = new Thread(new Print(in), "PrintThread");
		printThread.start();
		int receive = 0;
		try {
			while((receive = System.in.read()) != -1) {
				out.write(receive);
			}
		} finally {
			out.close();
		}
	}
	static class Print implements Runnable {
		private PipedReader in;
		public Print(PipedReader in) {
			this.in = in;
		}
		@Override
		public void run() {
			int receive = 0;
			try {
				while((receive = in.read()) != -1) {
					System.out.print((char)receive);
				}
			} catch (IOException e) {
				
			}
		}
	}
}
