package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.sql.visitor.functions.Insert;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.IDUtils;
import com.taotao.common.utils.StringToListLong;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbItemExample.Criteria;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.service.ItemService;

/**
 * 商品管理Service
 * <p>Title: ItemServiceImpl</p>

 */
@Service
public class ItemServiceImpl implements ItemService {

	private final static Logger logger = Logger.getLogger(ItemServiceImpl.class);
	
	@Autowired
	private TbItemMapper itemMapper;
	
	@Autowired
	private TbItemDescMapper itemDescMapper;
	
	@Autowired
	private TbItemParamItemMapper itemParamItemMapper;
	
	@Override
	public TbItem getItemById(long itemId) {
		
		//TbItem item = itemMapper.selectByPrimaryKey(itemId);
		//添加查询条件
		TbItemExample example = new TbItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(itemId);
		List<TbItem> list = itemMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			TbItem item = list.get(0);
			return item;
		}
		return null;
	}

	/**
	 * 商品列表查询
	 * <p>Title: getItemList</p>
	 * <p>Description: </p>
	 * @param page
	 * @param rows
	 * @return
	 * @see com.taotao.service.ItemService#getItemList(long, long)
	 */
	@Override
	public EUDataGridResult getItemList(int page, int rows) {
		//查询商品列表
		TbItemExample example = new TbItemExample();
		//分页处理
		PageHelper.startPage(page, rows);
		List<TbItem> list = itemMapper.selectByExample(example);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public TaotaoResult createItem(TbItem item, String desc, String itemParam) throws Exception {
		//item补全
		//生成商品ID
		Long itemId = IDUtils.genItemId();
		item.setId(itemId);
		// '商品状态，1-正常，2-下架，3-删除',
		item.setStatus((byte) 1);
		item.setCreated(new Date());
		item.setUpdated(new Date());
		//插入到数据库
		itemMapper.insert(item);
		//添加商品描述信息
		TaotaoResult result = insertItemDesc(itemId, desc);
		if (result.getStatus() != 200) {
			throw new Exception();
		}
		//添加规格参数
		result = insertItemParamItem(itemId, itemParam);
		if (result.getStatus() != 200) {
			throw new Exception();
		}
		return TaotaoResult.ok();
	}
	/**
	 * 添加商品描述
	 * <p>Title: insertItemDesc</p>
	 * <p>Description: </p>
	 * @param desc
	 */
	private TaotaoResult insertItemDesc(Long itemId, String desc) {
		TbItemDesc itemDesc = new TbItemDesc();
		itemDesc.setItemId(itemId);
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(new Date());
		itemDesc.setUpdated(new Date());
		itemDescMapper.insert(itemDesc);
		return TaotaoResult.ok();
	}
	
	/**
	 * 添加规格参数
	 * <p>Title: insertItemParamItem</p>
	 * <p>Description: </p>
	 * @param itemId
	 * @param itemParam
	 * @return
	 */
	private TaotaoResult insertItemParamItem(Long itemId, String itemParam) {
		//创建一个pojo
		TbItemParamItem itemParamItem = new TbItemParamItem();
		itemParamItem.setItemId(itemId);
		itemParamItem.setParamData(itemParam);
		itemParamItem.setCreated(new Date());
		itemParamItem.setUpdated(new Date());
		//向表中插入数据
		itemParamItemMapper.insert(itemParamItem);
		return TaotaoResult.ok();
	}
	
	/**
	 * 
	 * <p>Title: getItemDescById</p>   
	 * <p>Description: </p>   
	 * @param itemId
	 * @return   得到商品描述信息
	 * @see com.taotao.service.ItemService#getItemDescById(java.lang.Long)
	 */
	@Override
	public TaotaoResult getItemDescById(Long itemId) {
		TbItemDesc itemDesc = itemDescMapper.selectByPrimaryKey(itemId);
		return TaotaoResult.ok(itemDesc);
	}

	@Override
	public TaotaoResult deleteItemById(String ids) {
		TbItemExample tbItemExample = new TbItemExample();
		Criteria criteria = tbItemExample.createCriteria();
		String[] strList = ids.split(",");
		List<Long> list = new ArrayList<Long>();
		for (int i = 0; i < strList.length; i ++) {
			list.add(Long.valueOf(strList[i]));
		}
		criteria.andIdIn(list);
		itemMapper.deleteByExample(tbItemExample);
		return TaotaoResult.ok();
	}

	@Override
	public TaotaoResult instockItemByIds(String ids) {
		TbItemExample tbItemExample = new TbItemExample();
		Criteria criteria = tbItemExample.createCriteria();
		List<Long> list = StringToListLong.stringToListLong(ids);
		criteria.andIdIn(list);
		logger.debug("------------使用ids得到item列表信息---------------");
		List<TbItem> itemList = itemMapper.selectByExample(tbItemExample);
		logger.debug("------------修改item列表信息---------------");
		for (int i = 0; i < itemList.size(); i ++) {
			TbItem item = itemList.get(i);
			item.setStatus((byte) 2);
			item.setUpdated(new Date());
			logger.debug("------------更新数据库item信息---------------");
			itemMapper.updateByPrimaryKey(item);
		}
		return TaotaoResult.ok();
	}

	@Override
	public TaotaoResult reshelfItemByIds(String ids) {
		TbItemExample tbItemExample = new TbItemExample();
		Criteria criteria = tbItemExample.createCriteria();
		List<Long> list = StringToListLong.stringToListLong(ids);
		criteria.andIdIn(list);
		logger.debug("------------使用ids得到item列表信息---------------");
		List<TbItem> itemList = itemMapper.selectByExample(tbItemExample);
		logger.debug("------------修改item列表信息---------------");
		for (int i = 0; i < itemList.size(); i ++) {
			TbItem item = itemList.get(i);
			item.setStatus((byte) 1);
			item.setUpdated(new Date());
			logger.debug("------------更新数据库item信息---------------");
			itemMapper.updateByPrimaryKey(item);
		}
		return TaotaoResult.ok();
	}

}
