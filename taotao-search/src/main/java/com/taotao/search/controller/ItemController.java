package com.taotao.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.search.service.ItemService;

/**
 * 索引库维护
 * <p>Title: ItemController</p>

 */
@Controller
@RequestMapping("/manager")
public class ItemController {
	
	@Autowired
	private ItemService itemService;

	/**
	 * 导入商品数据到索引库
	 */
	@RequestMapping("/importall")
	@ResponseBody
	public TaotaoResult importAllItems() {
		TaotaoResult result = itemService.importAllItems();
		return result;
	}
	/**
	 * 单个商品数据添加到索引库
	 */
	@RequestMapping("/import/item/{itemId}")
	@ResponseBody
	public TaotaoResult importItem(@PathVariable String itemId) {
		TaotaoResult result = itemService.importItem(itemId);
		return result;
	}
	/**
	 * 单个商品数据修改更新到索引库
	 */
	@RequestMapping("/update/item/{itemId}")
	@ResponseBody
	public TaotaoResult updateItem(@PathVariable Long itemId) {
		TaotaoResult result = itemService.updateItem(itemId);
		return result;
	}
	/**
	 *  删除索引库中商品数据信息
	 */
	@RequestMapping("/delete/item/{itemId}")
	@ResponseBody
	public TaotaoResult deleteItem(@PathVariable String itemId) {
		TaotaoResult result = itemService.deleteItem(itemId);
		return result;
	}
}
