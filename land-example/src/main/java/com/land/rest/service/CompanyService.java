package com.land.rest.service;

import com.land.rest.model.Company;
import com.land.rest.pojo.ResultResponse;
import com.land.rest.pojo.SelectCoParm;

public interface CompanyService extends BaseService<Company>{
	//包装类  object
	ResultResponse getListInfoByParm(SelectCoParm parm);
}
