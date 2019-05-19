package com.land.rest.service;

import com.land.rest.pojo.ResultResponse;

public interface BaseService <T>{
	ResultResponse getInfo(int id);

	ResultResponse insertInfo(T o);

	ResultResponse updateInfo(T o);

	ResultResponse deleteInfo(int id);
	
	ResultResponse getAllInfo();

}
