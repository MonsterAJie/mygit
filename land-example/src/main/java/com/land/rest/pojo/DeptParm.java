package com.land.rest.pojo;

/**
 * 
 * @ClassName:  DeptParm   
 * @Description:TODO(部门查询参数类)   
 * @author: AJie
 * @date:   2019年5月19日 下午3:26:00   
 *     
 * @Copyright: 2019 https://github.com/MonsterAJie/mygit
 *
 */
public class DeptParm {

	//人数最小值
	private int countMin;

	//人数最大值
	private int countMax;
	
	public int getCountMin() {
		return countMin;
	}

	public void setCountMin(int countMin) {
		this.countMin = countMin;
	}

	public int getCountMax() {
		return countMax;
	}

	public void setCountMax(int countMax) {
		this.countMax = countMax;
	}
}
