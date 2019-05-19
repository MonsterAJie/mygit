package com.land.rest.pojo;

import com.land.rest.model.Department;

/**
 * 
 * @ClassName:  DeptResult   
 * @Description:TODO(部门信息包装类)   
 * @author: AJie
 * @date:   2019年5月19日 下午3:25:15   
 *     
 * @Copyright: 2019 https://github.com/MonsterAJie/mygit
 *
 */
public class DeptResult extends Department{

	private String companyName;
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
}
