package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.Code;
import com.taotao.common.pojo.EUTreeNode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.JsonUtils;
import com.taotao.pojo.TbCode;
import com.taotao.service.CodeService;
import com.taotao.service.ContentCategoryService;

@Controller
@RequestMapping("/code")
public class CodeController {
	@Autowired
	private CodeService codeService;
	
	@RequestMapping("/price")
	@ResponseBody
	public List<Code> getPriceList(String name) {
		List<Code> list = codeService.getPriceList(name);
		String json = JsonUtils.objectToJson(list);
		return list;
	}
	

}
