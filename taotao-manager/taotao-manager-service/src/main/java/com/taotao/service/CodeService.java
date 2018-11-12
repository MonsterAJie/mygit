package com.taotao.service;

import java.util.List;

import com.taotao.common.pojo.Code;
import com.taotao.common.pojo.TaotaoResult;

public interface CodeService {
	List<Code> getPriceList(String name);
}
