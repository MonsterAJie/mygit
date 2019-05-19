package com.land.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.land.rest.constant.Constant;
import com.land.rest.dao.JedisClient;
import com.land.rest.mapper.DepartmentMapper;
import com.land.rest.model.Department;
import com.land.rest.model.DepartmentExample;
import com.land.rest.pojo.DeptResult;
import com.land.rest.pojo.ResultResponse;
import com.land.rest.pojo.SelectDeptParm;
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
	
	@Autowired
	private JedisClient jedisClient;
	
	public ResultResponse getInfo(int id) {
		return ResultResponse.success(departmentMapper.selectByPrimaryKey(1));
	}

	public ResultResponse insertInfo(Department dept) {
		long l = jedisClient.incr(Constant.REDIS_DEPT_ID_KEY);
		dept.setDeptId((int) l);
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
			return ResultResponse.fail("数据库中不存在需要删除的数据.");
		}
	}

	public ResultResponse getAllInfo() {
		DepartmentExample example = new DepartmentExample();
		List<Department> list = departmentMapper.selectByExample(example);
		return ResultResponse.success(list);
	}

	public ResultResponse getListInfoByParm(SelectDeptParm parm) {
		List<DeptResult> list = departmentMapper.getDeptListInfoByParm(parm);
		return ResultResponse.success(list);
	}

	public ResultResponse getDeptListInfoByParm(SelectDeptParm parm) {
		List<DeptResult> list = departmentMapper.getDeptListInfoByParm(parm);
		return ResultResponse.success(list);
	}
}
