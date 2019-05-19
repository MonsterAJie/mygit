package com.land.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.land.rest.constant.Constant;
import com.land.rest.dao.JedisClient;
import com.land.rest.mapper.EmployeeInfoMapper;
import com.land.rest.mapper.EmployeeMapper;
import com.land.rest.model.Employee;
import com.land.rest.model.EmployeeExample;
import com.land.rest.model.EmployeeInfo;
import com.land.rest.model.EmployeeInfoExample;
import com.land.rest.pojo.EmpInfo;
import com.land.rest.pojo.EmpResult;
import com.land.rest.pojo.ResultResponse;
import com.land.rest.pojo.SelectEmpParm;
import com.land.rest.service.EmployeeService;

/**
 * 
 * @ClassName:  EmployeeServiceImpl   
 * @Description:TODO(雇员信息处理类)   
 * @author: AJie
 * @date:   2019年5月19日 下午3:27:12   
 *     
 * @Copyright: 2019 https://github.com/MonsterAJie/mygit
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Autowired
	private EmployeeInfoMapper employeeInfoMapper;
	
	@Autowired
	private JedisClient jedisClient;

	public ResultResponse getInfo(int id) {
		Employee employee = employeeMapper.selectByPrimaryKey(id);
		EmployeeInfo employeeInfo = employeeInfoMapper.selectByPrimaryKey(id);
		EmpInfo empInfo = new EmpInfo();
		empInfo.setEmp(employee);
		empInfo.setEmpinfo(employeeInfo);
		return ResultResponse.success(empInfo);
	}

	public ResultResponse insertInfo(EmpInfo o) {
		setId(o);
		employeeMapper.insert(o.getEmp());
		employeeInfoMapper.insert(o.getEmpinfo());
		return ResultResponse.success(o);
	}

	public ResultResponse updateInfo(EmpInfo o) {
		employeeMapper.updateByPrimaryKey(o.getEmp());
		employeeInfoMapper.updateByPrimaryKey(o.getEmpinfo());
		return ResultResponse.success(o);
	}

	public ResultResponse deleteInfo(int id) {
		EmpInfo empInfo = new EmpInfo();
		Employee employee = employeeMapper.selectByPrimaryKey(id);
		if (null != employee) {
			empInfo.setEmp(employee);
			EmployeeInfo employeeInfo = employeeInfoMapper.selectByPrimaryKey(id);
			if (null != employeeInfo) {
				empInfo.setEmpinfo(employeeInfo);
				employeeInfoMapper.deleteByPrimaryKey(id);
				employeeMapper.deleteByPrimaryKey(id);
			} else {
				return ResultResponse.fail("数据库中不存在需要删除的数据.");
			}
			return ResultResponse.success(empInfo);
		} else {
			return ResultResponse.fail("数据库中不存在需要删除的数据.");
		}
	}
	
	public ResultResponse getAllInfo() {
		EmployeeExample example = new EmployeeExample();
		EmployeeInfoExample exampleInfo = new EmployeeInfoExample();
		List<Employee> listEmp = employeeMapper.selectByExample(example);
		List<EmployeeInfo> listEmpInfo = employeeInfoMapper.selectByExample(exampleInfo);
		List<EmpInfo> list = new ArrayList<EmpInfo>();
		for (Employee emp : listEmp) {
			for (EmployeeInfo empInfo : listEmpInfo) {
				if (emp.getEmpId() == empInfo.getEmpId()) {
					EmpInfo empTemp = new EmpInfo();
					empTemp.setEmp(emp);
					empTemp.setEmpinfo(empInfo);
					list.add(empTemp);
					break;
				}
			}
		}
		return ResultResponse.success(list);
	}

	public ResultResponse getListInfoByParmOne(SelectEmpParm parm) {
		List<EmpResult> list = employeeMapper.getListInfoByParmOne(parm);
		return ResultResponse.success(list);
	}

	public ResultResponse getListInfoByParm(SelectEmpParm parm) {
		List<EmpResult> list = employeeMapper.getListInfoByParmOne(parm);
		return ResultResponse.success(list);
	}
	
	private void setId(EmpInfo o) {
		if (null == o) {
			return;
		}
		long l = jedisClient.incr(Constant.REDIS_EMP_ID_KEY);
		o.getEmp().setEmpId((int) l);
		o.getEmpinfo().setEmpId((int) l);
	}
}
