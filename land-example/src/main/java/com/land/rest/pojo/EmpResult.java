package com.land.rest.pojo;

import com.land.rest.model.EmployeeInfo;

/**
 * 
 * @ClassName:  EmpResult   
 * @Description:TODO(雇员信息包装类)   
 * @author: AJie
 * @date:   2019年5月19日 下午3:24:50   
 *     
 * @Copyright: 2019 https://github.com/MonsterAJie/mygit
 *
 */
public class EmpResult extends EmployeeInfo {

	private String comName;
	
	private String deptName;
	
	public String getComName() {
		return comName;
	}
	
	public void setComName(String comName) {
		this.comName = comName;
	}
	
	public String getDeptName() {
		return deptName;
	}
	
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
}
