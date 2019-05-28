package com.land.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.land.rest.pojo.EmpInfo;
import com.land.rest.pojo.ResultResponse;
import com.land.rest.pojo.EmpParm;
import com.land.rest.service.EmployeeService;


/**
 * 
 * @ClassName:  EmployeeController   
 * @Description:TODO(employee信息处理接口入口)   
 * @author: AJie
 * @date:   2019年5月19日 下午3:21:02   
 *     
 * @Copyright: 2019 https://github.com/MonsterAJie/mygit
 *
 */
@RequestMapping("/emp")
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService emploeeService;
	
	@GetMapping("{id}")
	public ResultResponse getInfo(@PathVariable int id) {
		return emploeeService.getInfo(id);
	}
	
	@GetMapping("/all")
	public ResultResponse getAllInfo() {
		return emploeeService.getAllInfo();
	}
	
	/**
	 * 
	 * @Title: getInfoByPram   
	 * @Description: TODO(得到满足参数pram的结果集)   
	 * @param: @param pram	参数
	 * @param: @return      
	 * @return: ResultResponse      
	 * @throws
	 */
	@GetMapping
	public ResultResponse getInfoByPram(@RequestBody EmpParm pram) {
		return emploeeService.getListInfoByParm(pram);
	}
	
	@PostMapping
	public ResultResponse insertInfo(@RequestBody EmpInfo emp) {
		return emploeeService.insertInfo(emp);
	}
	
	@PutMapping
	public ResultResponse updateInfo(@RequestBody EmpInfo emp) {
		return emploeeService.updateInfo(emp);
	}
	
	@DeleteMapping("{id}")
	public ResultResponse deleteInfo(@PathVariable int id) {
		return emploeeService.deleteInfo(id);
	}
}
