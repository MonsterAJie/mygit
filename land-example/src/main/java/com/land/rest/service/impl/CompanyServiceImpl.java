package com.land.rest.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.land.rest.mapper.CompanyMapper;
import com.land.rest.model.Company;
import com.land.rest.model.CompanyExample;
import com.land.rest.pojo.ResultResponse;
import com.land.rest.service.CompanyService;
import com.land.rest.utils.IDUtils;

/**
 * 
 * @ClassName:  CompanyServiceImpl   
 * @Description:TODO(公司信息处理类)   
 * @author: AJie
 * @date:   2019年5月16日 下午5:20:29   
 *     
 * @Copyright: 2019 https://github.com/MonsterAJie/mygit
 *
 */
@Service
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	private CompanyMapper companyMapper;
	
	/**
	 * 
	 * <p>Title: getInfo</p>   
	 * <p>Description: </p>   
	 * @param id 公司id
	 * @return   
	 * @see com.land.rest.service.BaseService#getInfo(int)
	 */
	public ResultResponse getInfo(int id) {
		return ResultResponse.success(companyMapper.selectByPrimaryKey(1));
	}

	public ResultResponse insertInfo(Company company) {
		IDUtils.setComId(company);
		companyMapper.insert(company);
		return ResultResponse.success(company);
	}

	public ResultResponse updateInfo(Company company) {
		companyMapper.updateByPrimaryKey(company);
		return ResultResponse.success(company);
	}

	public ResultResponse deleteInfo(int id) {
		Company company = companyMapper.selectByPrimaryKey(id);
		if (null != company) {
			companyMapper.deleteByPrimaryKey(id);
			return ResultResponse.success(company);
		} else {
			return ResultResponse.fail("数据库中不存在需要删除的数据.");
		}
	}

	public ResultResponse getAllInfo() {
		CompanyExample example = new CompanyExample();
		List<Company> companyList = companyMapper.selectByExample(example);
		return ResultResponse.success(companyList);
	}

}
