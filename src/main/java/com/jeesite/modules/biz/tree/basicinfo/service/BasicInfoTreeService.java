/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.biz.tree.basicinfo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.biz.tree.basicinfo.entity.BasicInfoTree;
import com.jeesite.modules.biz.tree.basicinfo.dao.BasicInfoTreeDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * 基础信息管理Service
 * @author FangMao
 * @version 2019-08-18
 */
@Service
@Transactional(readOnly=true)
public class BasicInfoTreeService extends CrudService<BasicInfoTreeDao, BasicInfoTree> {
	
	/**
	 * 获取单条数据
	 * @param basicInfoTree
	 * @return
	 */
	@Override
	public BasicInfoTree get(BasicInfoTree basicInfoTree) {
		return super.get(basicInfoTree);
	}
	
	/**
	 * 查询分页数据
	 * @param basicInfoTree 查询条件
	 * @param basicInfoTree.page 分页对象
	 * @return
	 */
	@Override
	public Page<BasicInfoTree> findPage(BasicInfoTree basicInfoTree) {
		return super.findPage(basicInfoTree);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param basicInfoTree
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(BasicInfoTree basicInfoTree) {
		super.save(basicInfoTree);
		// 保存上传图片
		FileUploadUtils.saveFileUpload(basicInfoTree.getId(), "basicInfoTree_image");
	}
	
	/**
	 * 更新状态
	 * @param basicInfoTree
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(BasicInfoTree basicInfoTree) {
		super.updateStatus(basicInfoTree);
	}
	
	/**
	 * 删除数据
	 * @param basicInfoTree
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(BasicInfoTree basicInfoTree) {
		super.delete(basicInfoTree);
	}
	
}