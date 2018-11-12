package com.taotao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.Code;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.ObjectUtils;
import com.taotao.mapper.TbCodeMapper;
import com.taotao.pojo.TbCode;
import com.taotao.pojo.TbCodeExample;
import com.taotao.pojo.TbCodeExample.Criteria;
import com.taotao.service.CodeService;
@Service
public class CodeServiceImpl implements CodeService{
	
	@Autowired
	private TbCodeMapper codeMapper;
	
	@Override
	public List<Code> getPriceList(String name) {
		TbCodeExample codeExample = new TbCodeExample();
		Criteria criteria = codeExample.createCriteria();
		criteria.andCodeEqualTo(name);
		List list = codeMapper.selectByExample(codeExample);
		List<Code> list1 = ObjectUtils.ObjectExtractToObjects(list, new Code());
		return list1;
	}
	
}
