package com.taotao.search.service;

import com.taotao.common.pojo.TaotaoResult;

public interface ItemService {

	TaotaoResult importAllItems();

	TaotaoResult importItem(String itemId);

	TaotaoResult deleteItem(String itemId);

	TaotaoResult updateItem(Long itemId);
}
