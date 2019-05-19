package com.land.rest.mapper;

import com.land.rest.model.EmployeeInfo;
import com.land.rest.model.EmployeeInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmployeeInfoMapper {
    int countByExample(EmployeeInfoExample example);

    int deleteByExample(EmployeeInfoExample example);

    int deleteByPrimaryKey(Integer empId);

    int insert(EmployeeInfo record);

    int insertSelective(EmployeeInfo record);

    List<EmployeeInfo> selectByExample(EmployeeInfoExample example);

    EmployeeInfo selectByPrimaryKey(Integer empId);

    int updateByExampleSelective(@Param("record") EmployeeInfo record, @Param("example") EmployeeInfoExample example);

    int updateByExample(@Param("record") EmployeeInfo record, @Param("example") EmployeeInfoExample example);

    int updateByPrimaryKeySelective(EmployeeInfo record);

    int updateByPrimaryKey(EmployeeInfo record);
}