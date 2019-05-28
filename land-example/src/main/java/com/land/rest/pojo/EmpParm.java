package com.land.rest.pojo;

/**
 * 
 * @ClassName:  EmpPram   
 * @Description:TODO(查询雇员所用参数包装类)   
 * @author: AJie
 * @date:   2019年5月16日 上午10:59:56   
 *     
 * @Copyright: 2019 https://github.com/MonsterAJie/mygit
 *
 */
public class EmpParm {

	//提成奖金最小值
	private double commMin;
	
	//提成奖金最大值
	private double commMax;
	
	public double getCommMin() {
		return commMin;
	}
	
	public void setCommMin(double commMin) {
		this.commMin = commMin;
	}
	
	public double getCommMax() {
		return commMax;
	}
	
	public void setCommMax(double commMax) {
		this.commMax = commMax;
	}
	
}
