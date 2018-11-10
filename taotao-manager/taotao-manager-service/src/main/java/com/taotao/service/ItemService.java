package com.taotao.service;

import java.util.List;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.QbcItem;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

public interface ItemService {

	TbItem getItemById(long itemId);
	EUDataGridResult getItemList(int page, int rows);
	TaotaoResult createItem(TbItem item, String desc, String itemParam) throws Exception;
	TaotaoResult getItemDescById(Long itemId);
	TaotaoResult deleteItemById(String itemId);
	TaotaoResult instockItemByIds(String ids);
	TaotaoResult reshelfItemByIds(String ids);
	EUDataGridResult getItemByQbc(QbcItem item, Integer page, Integer rows);
}
