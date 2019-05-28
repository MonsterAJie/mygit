package com.land.rest.service;

import com.land.rest.model.Department;
import com.land.rest.pojo.ResultResponse;
import com.land.rest.pojo.DeptParm;

/**
 * 
 * @ClassName:  CompanyService   
 * @Description:TODO(部门处理类接口)   
 * @author: AJie
 * @date:   2019年5月19日 下午3:44:45   
 *     
 * @Copyright: 2019 https://github.com/MonsterAJie/mygit
 *
 */
public interface DepartmentService extends BaseService<Department>{

	/**
	 * 
	 * @Title: getListInfoByParm   
	 * @Description: TODO(得到满足条件的部门信息结果集)   
	 * @param: @param parm 条件参数
	 * @param: @return      
	 * @return: ResultResponse      
	 * @throws
	 */
	ResultResponse getListInfoByParm(DeptParm parm);
}
