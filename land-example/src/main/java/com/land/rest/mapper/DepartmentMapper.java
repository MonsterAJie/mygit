package com.land.rest.mapper;

import com.land.rest.model.Department;
import com.land.rest.model.DepartmentExample;
import com.land.rest.pojo.DeptResult;
import com.land.rest.pojo.SelectDeptParm;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DepartmentMapper {
    int countByExample(DepartmentExample example);

    int deleteByExample(DepartmentExample example);

    int deleteByPrimaryKey(Integer deptId);

    int insert(Department record);

    int insertSelective(Department record);

    List<Department> selectByExample(DepartmentExample example);

    Department selectByPrimaryKey(Integer deptId);

    int updateByExampleSelective(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByExample(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
    
    List<DeptResult> getDeptListInfoByParm(SelectDeptParm parm);
}