package com.taotao.mapper;

import com.taotao.pojo.TbCode;
import com.taotao.pojo.TbCodeExample;
import com.taotao.pojo.TbCodeWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbCodeMapper {
    int countByExample(TbCodeExample example);

    int deleteByExample(TbCodeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbCodeWithBLOBs record);

    int insertSelective(TbCodeWithBLOBs record);

    List<TbCodeWithBLOBs> selectByExampleWithBLOBs(TbCodeExample example);

    List<TbCode> selectByExample(TbCodeExample example);

    TbCodeWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbCodeWithBLOBs record, @Param("example") TbCodeExample example);

    int updateByExampleWithBLOBs(@Param("record") TbCodeWithBLOBs record, @Param("example") TbCodeExample example);

    int updateByExample(@Param("record") TbCode record, @Param("example") TbCodeExample example);

    int updateByPrimaryKeySelective(TbCodeWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TbCodeWithBLOBs record);

    int updateByPrimaryKey(TbCode record);
}