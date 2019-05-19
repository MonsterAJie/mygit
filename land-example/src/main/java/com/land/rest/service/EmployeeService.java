package com.land.rest.service;

import com.land.rest.model.Employee;
import com.land.rest.model.EmployeeInfo;
import com.land.rest.pojo.EmpInfo;
import com.land.rest.pojo.ResultResponse;
import com.land.rest.pojo.SelectEmpParm;

public interface EmployeeService extends BaseService<EmpInfo>{
	//包装类  object
	ResultResponse getListInfoByParm(SelectEmpParm parm);
	ResultResponse getListInfoByParmOne(SelectEmpParm parm);
}
