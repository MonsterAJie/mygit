package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.QbcItem;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemParamItemService;
import com.taotao.service.ItemParamService;
import com.taotao.service.ItemService;

/**
 * 商品管理Controller
 * <p>Title: ItemController</p>

 */

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ItemParamItemService itemParamItemService;
	
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable Long itemId) {
		TbItem tbItem = itemService.getItemById(itemId);
		return tbItem;
	}
	
	@RequestMapping("/item/qbc")
	@ResponseBody
	public EUDataGridResult getItemByQbc(QbcItem item, Integer page, Integer rows) {
		EUDataGridResult tbItemList = itemService.getItemByQbc(item, page, rows);
		return tbItemList;
	}
	
	@RequestMapping("/item/desc/{itemId}")
	@ResponseBody
	public TaotaoResult getItemDescById(@PathVariable Long itemId) {
		TaotaoResult result = itemService.getItemDescById(itemId);
		return result;
	}
	
	@RequestMapping("/item/param/{itemId}")
	@ResponseBody
	public TaotaoResult getItemParamItemById(@PathVariable Long itemId) {
		TaotaoResult result = itemParamItemService.getItemParamItemById(itemId);
		return result;
	}
	
	@RequestMapping("/item/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows) {
		EUDataGridResult result = itemService.getItemList(page, rows);
		return result;
	}
	
	@RequestMapping(value="/item/save", method=RequestMethod.POST)
	@ResponseBody
	private TaotaoResult createItem(TbItem item, String desc, String itemParams) throws Exception {
		TaotaoResult result = itemService.createItem(item, desc, itemParams);
		return result;
	}
	
	@RequestMapping(value="/item/update", method=RequestMethod.POST)
	@ResponseBody
	private TaotaoResult updateItem(TbItem item, String desc, String itemParams) throws Exception {
		TaotaoResult result = itemService.updateItem(item, desc, itemParams);
		return result;
	}
	
	@RequestMapping("/item/delete")
	@ResponseBody
	public TaotaoResult deleteItemById(String ids) {
		TaotaoResult result = itemService.deleteItemById(ids);
		return result;
	}
	
	@RequestMapping("/item/instock")
	@ResponseBody
	public TaotaoResult instockItemByIds(String ids) {
		TaotaoResult result = itemService.instockItemByIds(ids);
		return result;
	}
	
	@RequestMapping("/item/reshelf")
	@ResponseBody
	public TaotaoResult reshelfItemByIds(String ids) {
		TaotaoResult result = itemService.reshelfItemByIds(ids);
		return result;
	}
}
