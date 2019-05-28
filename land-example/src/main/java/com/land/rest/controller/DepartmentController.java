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

import com.land.rest.model.Department;
import com.land.rest.pojo.ResultResponse;
import com.land.rest.pojo.DeptParm;
import com.land.rest.service.DepartmentService;

/**
 * 
 * @ClassName:  DepartmentController   
 * @Description:TODO(department接口入口)   
 * @author: AJie
 * @date:   2019年5月19日 下午3:17:25   
 *     
 * @Copyright: 2019 https://github.com/MonsterAJie/mygit
 *
 */
@RequestMapping("/dept")
@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("{id}")
	public ResultResponse getInfo(@PathVariable int id) {
		try {
			return departmentService.getInfo(id);
		} catch (Exception e) {
			return ResultResponse.fail(e.getMessage());
		}
	}
	
	@GetMapping("/all")
	public ResultResponse getAllInfo() {
		return departmentService.getAllInfo();
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
	public ResultResponse getInfoByPram(@RequestBody DeptParm pram) {
		return departmentService.getListInfoByParm(pram);
	}
	
	@PostMapping
	public ResultResponse insertInfo(@RequestBody Department dept) {
		return departmentService.insertInfo(dept);
	}
	
	@PutMapping
	public ResultResponse updateInfo(@RequestBody Department dept) {
		return departmentService.updateInfo(dept);
	}
	
	@DeleteMapping("{id}")
	public ResultResponse deleteInfo(@PathVariable int id) {
		return departmentService.deleteInfo(id);
	}
}
