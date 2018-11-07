package com.dahan.jie.test;

import org.junit.jupiter.api.Test;
/**
 * 
 * @ClassName:  RecursiveFac   
 * @Description:TODO(实现n的阶乘)   
 * @author: AJie
 * @date:   2018年11月7日 下午5:36:04   
 *     这个递归函数仅支持n数字较小，可以使用‘数组进位’方法实现大整数的运算
 * @Copyright: 2018 https://github.com/MonsterAJie/mygit
 *
 */
public class RecursiveFac {
	@Test
	public int recursiveFacTest (int n) {
		if (n == 1) {
			return n;
		}
		return n * recursiveFacTest(n - 1);
	}
}
