package com.land.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.land.rest.enums.ResultCode;
import com.land.rest.exception.BusinessException;
import com.land.rest.mapper.DepartmentMapper;
import com.land.rest.model.Department;
import com.land.rest.model.DepartmentExample;
import com.land.rest.pojo.DeptResult;
import com.land.rest.pojo.ResultResponse;
import com.land.rest.pojo.DeptParm;
import com.land.rest.service.DepartmentService;
import com.land.rest.utils.IDUtils;

/**
 * 
 * @ClassName:  DepartmentServiceImpl   
 * @Description:TODO(部门信息处理类)   
 * @author: AJie
 * @date:   2019年5月19日 下午3:26:44   
 *     
 * @Copyright: 2019 https://github.com/MonsterAJie/mygit
 *
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentMapper departmentMapper;
	
	public ResultResponse getInfo(int id) {
		return ResultResponse.success(departmentMapper.selectByPrimaryKey(1));
	}

	public ResultResponse insertInfo(Department dept) {
		IDUtils.setDeptId(dept);
		departmentMapper.insert(dept);
		return ResultResponse.success(dept);
	}

	public ResultResponse updateInfo(Department dept) {
		departmentMapper.updateByPrimaryKey(dept);
		return ResultResponse.success(dept);
	}

	public ResultResponse deleteInfo(int id) {
		Department dept = departmentMapper.selectByPrimaryKey(id);
		if (null != dept) {
			departmentMapper.deleteByPrimaryKey(id);
			return ResultResponse.success(dept);
		} else {
//			BusinessException e = new BusinessException(new ResultCode());
//			throw e;
			return null;
		}
	}

	public ResultResponse getAllInfo() {
		int i = 1 / 0;
		DepartmentExample example = new DepartmentExample();
		List<Department> list = departmentMapper.selectByExample(example);
		return ResultResponse.success(list);
	}

	public ResultResponse getListInfoByParm(DeptParm parm) {
		List<DeptResult> list = departmentMapper.getDeptListInfoByParm(parm);
		return ResultResponse.success(list);
	}
}
