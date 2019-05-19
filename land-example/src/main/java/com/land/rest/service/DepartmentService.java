package com.land.rest.service;

import com.land.rest.model.Department;
import com.land.rest.pojo.ResultResponse;
import com.land.rest.pojo.SelectCoParm;
import com.land.rest.pojo.SelectDeptParm;
import com.land.rest.pojo.SelectEmpParm;

public interface DepartmentService extends BaseService<Department>{
	//包装类  object
	ResultResponse getListInfoByParm(SelectDeptParm parm);
	//统计每个公司下有多少满足条件的部门
	ResultResponse getDeptListInfoByParm(SelectDeptParm parm);
}
