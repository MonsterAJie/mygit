package com.land.rest.pojo;

import com.land.rest.model.Employee;
import com.land.rest.model.EmployeeInfo;

/**
 * 
 * @ClassName:  EmpInfo   
 * @Description:TODO(雇员信息包装类)   
 * @author: AJie
 * @date:   2019年5月19日 下午3:24:31   
 *     
 * @Copyright: 2019 https://github.com/MonsterAJie/mygit
 *
 */
public class EmpInfo {

	private Employee emp;
	
	private EmployeeInfo empinfo;
	
	public Employee getEmp() {
		return emp;
	}
	
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	
	public EmployeeInfo getEmpinfo() {
		return empinfo;
	}
	
	public void setEmpinfo(EmployeeInfo empinfo) {
		this.empinfo = empinfo;
	}
	
}
