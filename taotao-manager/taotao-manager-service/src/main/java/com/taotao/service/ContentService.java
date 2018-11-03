package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;

public interface ContentService {

	TaotaoResult insertContent(TbContent content);
	TaotaoResult updateContent(TbContent content);
	TaotaoResult deleteContent(String ids);
	EUDataGridResult selectContentList(Long categoryId, Integer page, Integer rows);
}
