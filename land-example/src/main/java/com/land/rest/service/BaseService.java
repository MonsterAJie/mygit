package com.land.rest.service;

import com.land.rest.pojo.ResultResponse;

/**
 * 
 * @ClassName:  BaseService   
 * @Description:TODO(公共方法接口)   
 * @author: AJie
 * @date:   2019年5月19日 下午3:44:26   
 *   
 * @param <T>  
 * @Copyright: 2019 https://github.com/MonsterAJie/mygit
 *
 */
public interface BaseService <T>{
	/**
	 * 
	 * @Title: getInfo   
	 * @Description: TODO(得到id对应的T数据)   
	 * @param: @param id
	 * @param: @return      
	 * @return: ResultResponse      
	 * @throws
	 */
	ResultResponse getInfo(int id);
	
	/**
	 * 
	 * @Title: insertInfo   
	 * @Description: TODO(插入T对象数据)   
	 * @param: @param o
	 * @param: @return      
	 * @return: ResultResponse      
	 * @throws
	 */
	ResultResponse insertInfo(T o);

	/**
	 * 
	 * @Title: insertInfo   
	 * @Description: TODO(修改为T对象数据)   
	 * @param: @param o
	 * @param: @return      
	 * @return: ResultResponse      
	 * @throws
	 */
	ResultResponse updateInfo(T o);

	/**
	 * 
	 * @Title: insertInfo   
	 * @Description: TODO(删除T类数据)   
	 * @param: @param o
	 * @param: @return      
	 * @return: ResultResponse      
	 * @throws
	 */
	ResultResponse deleteInfo(int id);
	
	/**
	 * 
	 * @Title: insertInfo   
	 * @Description: TODO(得到所有T类数据)   
	 * @param: @param o
	 * @param: @return      
	 * @return: ResultResponse      
	 * @throws
	 */
	ResultResponse getAllInfo();

}
