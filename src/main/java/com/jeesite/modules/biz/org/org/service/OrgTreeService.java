/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.biz.org.org.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.service.TreeService;
import com.jeesite.modules.biz.org.org.entity.OrgTree;
import com.jeesite.modules.biz.org.org.dao.OrgTreeDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * 测试树表Service
 * @author ThinkGem
 * @version 2019-08-21
 */
@Service
@Transactional(readOnly=true)
public class OrgTreeService extends TreeService<OrgTreeDao, OrgTree> {
	
	/**
	 * 获取单条数据
	 * @param testTree
	 * @return
	 */
	@Override
	public OrgTree get(OrgTree testTree) {
		return super.get(testTree);
	}
	
	/**
	 * 查询列表数据
	 * @param testTree
	 * @return
	 */
	@Override
	public List<OrgTree> findList(OrgTree testTree) {
		return super.findList(testTree);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param testTree
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(OrgTree testTree) {
		super.save(testTree);
		// 保存上传图片
		FileUploadUtils.saveFileUpload(testTree.getId(), "testTree_image");
		// 保存上传附件
		FileUploadUtils.saveFileUpload(testTree.getId(), "testTree_file");
	}
	
	/**
	 * 更新状态
	 * @param testTree
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(OrgTree testTree) {
		super.updateStatus(testTree);
	}
	
	/**
	 * 删除数据
	 * @param testTree
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(OrgTree testTree) {
		super.delete(testTree);
	}
	
}