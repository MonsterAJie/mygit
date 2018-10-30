package com.jie.part3;
/**
 * 
 * @ClassName:  DoubleCheckedLockingTest   
 * @Description:TODO(������һ�仰��������������)   
 * @author: AJie
 * @date:   2018��10��30�� ����4:45:34   
 *     
 * @Copyright: 2018 https://github.com/MonsterAJie/mygit
 *
 */
public class DoubleCheckedLockingTest {

	public static void main(String[] args) {

	}

}
/**
 * 
 * @ClassName:  DoubleCheckedLocking   
 * @Description:TODO(�̳߳�ʼ�����ӳټ��� ˫�ؼ����������)   
 * @author: AJie
 * @date:   2018��10��30�� ����4:45:45   
 *     ����һ�ŵ㣺��ʵ���ֶ�ʵ���ӳٳ�ʼ��
 *     �������ŵ㣺������
 *     ��ͬ�㣺���ܶԾ�̬�����ӳٳ�ʼ��
 * @Copyright: 2018 https://github.com/MonsterAJie/mygit
 *
 */
class DoubleCheckedLocking {
	/**
	 * �������һ������Ա��������Ϊvolatile
	 * ex:private volatile static Integer instance;
	 * principle:��ֹ2.3������
	 */
	private static Integer instance;
	public static Integer getInstance() {
		if (instance == null) {
			synchronized (DoubleCheckedLocking.class) {
				if (instance == null) {
					/**
					 * memory = allocate();	1.���������ڴ�ռ�
					 * ctorInstance(memory);2.��ʼ������
					 * instance = memory;	3.����instanceָ��շ�����ڴ��ַ
					 * 2.3����������
					 */
					instance = new Integer(1);
				}
			}
		}
		return instance;
	}
}
/**
 * 
 * @ClassName:  InstanceFactory   
 * @Description:TODO(������������������ʼ��)   
 * @author: AJie
 * @date:   2018��10��30�� ����4:51:17   
 *     
 * @Copyright: 2018 https://github.com/MonsterAJie/mygit
 *
 */
class InstanceFactory {
	private static class InstanceHolder {
		public static InstanceFactory instance = new InstanceFactory();
	}
	public static InstanceFactory getInstance() {
		/**
		 * principle:�����߳̿�����2.3��������
		 * happens-before��ϵ��֤���߳�Aִ����ĳ�ʼ����д��������߳�Bһ���ܿ���
		 */
		return InstanceHolder.instance;		//���ﵼ��InstanceHolder�౻��ʼ��
	}
}

