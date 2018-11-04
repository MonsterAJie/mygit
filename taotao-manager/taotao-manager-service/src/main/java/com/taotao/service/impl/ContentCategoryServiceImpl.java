package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryExample;
import com.taotao.pojo.TbContentCategoryExample.Criteria;
import com.taotao.service.ContentCategoryService;

/**
 * 内容分类管理
 * <p>Title: ContentCategoryServiceImpl</p>

 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

	private Logger logger = Logger.getLogger(ContentCategoryServiceImpl.class);
	
	@Autowired
	private TbContentCategoryMapper contentCategoryMapper;
	@Override
	public List<EUTreeNode> getCategoryList(Long parentId) {
		//根据parentid查询节点列表
		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		//执行查询
		List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);
		List<EUTreeNode> resultList = new ArrayList<>();
		for (TbContentCategory tbContentCategory : list) {
			//创建一个节点
			EUTreeNode node = new EUTreeNode();
			node.setId(tbContentCategory.getId());
			node.setText(tbContentCategory.getName());
			node.setState(tbContentCategory.getIsParent()?"closed":"open");
			
			resultList.add(node);
		}
		return resultList;
	}
	
	@Override
	public TaotaoResult insertContentCategory(Long parentId, String name) {
		
		//创建一个pojo
		TbContentCategory contentCategory = new TbContentCategory();
		contentCategory.setName(name);
		contentCategory.setIsParent(false);
		//'状态。可选值:1(正常),2(删除)',
		contentCategory.setStatus(1);
		contentCategory.setParentId(parentId);
		contentCategory.setSortOrder(1);
		contentCategory.setCreated(new Date());
		contentCategory.setUpdated(new Date());
		//添加记录
		contentCategoryMapper.insert(contentCategory);
		//查看父节点的isParent列是否为true，如果不是true改成true
		TbContentCategory parentCat = contentCategoryMapper.selectByPrimaryKey(parentId);
		//判断是否为true
		if(!parentCat.getIsParent()) {
			parentCat.setIsParent(true);
			//更新父节点
			contentCategoryMapper.updateByPrimaryKey(parentCat);
		}
		//返回结果
		return TaotaoResult.ok(contentCategory);
	}
	
	@Override
	public TaotaoResult updateContentCategory(Long id, String name) {
//		TbContentCategory
		//根据id查询该节点
		TbContentCategoryExample example = new TbContentCategoryExample();
		TbContentCategory contentCategory = new TbContentCategory();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		contentCategory = contentCategoryMapper.selectByPrimaryKey(id);
		contentCategory.setName(name);
		contentCategory.setUpdated(new Date());	
		logger.debug("修改日期和名称");
		//修改名称和时间
		contentCategoryMapper.updateByExample(contentCategory, example);
		return  TaotaoResult.ok();
	}

	@Override
	public TaotaoResult deleteContentCategory(Long id) {
		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		//找到该节点的父节点，判断父节点下是否有其他的节点，有：不处理，没有：将父节点标志至为0
		logger.debug("--------------删除内容分类管理节点-----得到父节点信息-------");
		TbContentCategory contentCategory = contentCategoryMapper.selectByPrimaryKey(id);
		Long parentId = contentCategory.getParentId();
		logger.debug("--------------删除内容分类管理节点添加或条件---------------");
		Criteria criteria2 = example.createCriteria();
		criteria2.andParentIdEqualTo(id);
		example.or(criteria2);		
		logger.debug("--------------删除内容分类管理节点---------------------");
		contentCategoryMapper.deleteByExample(example);
		example.clear();
		logger.debug("--------------删除内容分类管理节点------改变查询条件-------");
		Criteria criteria3 = example.createCriteria();
		criteria3.andParentIdEqualTo(parentId);
		List<TbContentCategory> parentContentCatogory = contentCategoryMapper.selectByExample(example);
		logger.debug("--------------删除内容分类管理节点------判断父节点下是否有子节点--");
		if (parentContentCatogory.size() > 0) {
			logger.debug("--------------删除内容分类管理节点-----父节点属性不变----");
		} else {
			logger.debug("--------------删除内容分类管理节点-----改变父节点属性-------");
			contentCategory = contentCategoryMapper.selectByPrimaryKey(parentId);
			contentCategory.setIsParent(false);
			contentCategory.setUpdated(new Date());
			contentCategoryMapper.updateByPrimaryKey(contentCategory);
		}
		return TaotaoResult.ok();
	}
}
