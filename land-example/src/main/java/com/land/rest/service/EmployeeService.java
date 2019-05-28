package com.land.rest.service;

import com.land.rest.pojo.EmpInfo;
import com.land.rest.pojo.ResultResponse;
import com.land.rest.pojo.EmpParm;

/**
 * 
 * @ClassName:  CompanyService   
 * @Description:TODO(雇员处理类接口)   
 * @author: AJie
 * @date:   2019年5月19日 下午3:44:45   
 *     
 * @Copyright: 2019 https://github.com/MonsterAJie/mygit
 *
 */
public interface EmployeeService extends BaseService<EmpInfo>{

	/**
	 * 
	 * @Title: getListInfoByParm   
	 * @Description: TODO(得到满足条件参数的雇员信息结果集)   
	 * @param: @param parm
	 * @param: @return      
	 * @return: ResultResponse      
	 * @throws
	 */
	ResultResponse getListInfoByParm(EmpParm parm);
	
}
