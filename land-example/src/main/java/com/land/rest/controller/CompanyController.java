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

import com.land.rest.model.Company;
import com.land.rest.pojo.ResultResponse;
import com.land.rest.service.CompanyService;

/**
 * 
 * @ClassName:  CompanyController   
 * @Description:TODO(company接口入口)   
 * @author: AJie
 * @date:   2019年5月19日 下午3:12:04   
 *     
 * @Copyright: 2019 https://github.com/MonsterAJie/mygit
 *
 */
@RequestMapping("/co")
@RestController
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@GetMapping("{id}")
	public ResultResponse getInfo(@PathVariable int id) {
		try {
			return companyService.getInfo(id);
		} catch (Exception e) {
			return ResultResponse.fail(e.getMessage());
		}
	}
	
	@GetMapping("/all")
	public ResultResponse getAllInfo() {
		try {
			return companyService.getAllInfo();
		} catch (Exception e) {
			return ResultResponse.fail(e.getMessage());
		}
	}
	
	@PostMapping
	public ResultResponse insertInfo(@RequestBody Company company) {
		return companyService.insertInfo(company);
	}
	
	@PutMapping
	public ResultResponse updateInfo(@RequestBody Company company) {
		return companyService.updateInfo(company);
	}
	
	@DeleteMapping("{id}")
	public ResultResponse deleteInfo(@PathVariable int id) {
		return companyService.deleteInfo(id);
	}
}
