package com.jie.part3;
/**
 * 
 * @ClassName:  DoubleCheckedLockingTest   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: AJie
 * @date:   2018年10月30日 下午4:45:34   
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
 * @Description:TODO(线程初始化的延迟加载 双重检查锁定问题)   
 * @author: AJie
 * @date:   2018年10月30日 下午4:45:45   
 *     方案一优点：对实例字段实现延迟初始化
 *     方案二优点：代码简洁
 *     共同点：都能对静态变量延迟初始化
 * @Copyright: 2018 https://github.com/MonsterAJie/mygit
 *
 */
class DoubleCheckedLocking {
	/**
	 * 解决方案一：将成员变量声明为volatile
	 * ex:private volatile static Integer instance;
	 * principle:禁止2.3重排序
	 */
	private static Integer instance;
	public static Integer getInstance() {
		if (instance == null) {
			synchronized (DoubleCheckedLocking.class) {
				if (instance == null) {
					/**
					 * memory = allocate();	1.分配对象的内存空间
					 * ctorInstance(memory);2.初始化对象
					 * instance = memory;	3.设置instance指向刚分配的内存地址
					 * 2.3可能重排序
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
 * @Description:TODO(解决方案二：基于类初始化)   
 * @author: AJie
 * @date:   2018年10月30日 下午4:51:17   
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
		 * principle:其他线程看不到2.3的重排序
		 * happens-before关系保证：线程A执行类的初始化的写入操作，线程B一定能看到
		 */
		return InstanceHolder.instance;		//这里导致InstanceHolder类被初始化
	}
}

