package com.taotao.search.mapper;

import java.util.List;

import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.search.pojo.Item;

public interface ItemMapper {

	List<Item> getItemList();
	Item getItemByItemId(Long itemId);
	List<Item> getItemListByIds(List<String> idList);
}
