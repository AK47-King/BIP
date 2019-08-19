/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.biz.basicinfo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.biz.basicinfo.entity.BasicInfoCN;
import com.jeesite.modules.biz.basicinfo.dao.BasicInfoDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * 基础信息管理Service
 * @author FangMao
 * @version 2019-08-18
 */
@Service("basicInfoServiceCN")
@Transactional(readOnly=true)
public class BasicInfoService extends CrudService<BasicInfoDao, BasicInfoCN> {
	
	/**
	 * 获取单条数据
	 * @param basicInfo
	 * @return
	 */
	@Override
	public BasicInfoCN get(BasicInfoCN basicInfo) {
		return super.get(basicInfo);
	}
	
	/**
	 * 查询分页数据
	 * @param basicInfo 查询条件
	 * @param basicInfo.page 分页对象
	 * @return
	 */
	@Override
	public Page<BasicInfoCN> findPage(BasicInfoCN basicInfo) {
		return super.findPage(basicInfo);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param basicInfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(BasicInfoCN basicInfo) {
		super.save(basicInfo);
		// 保存上传图片
		FileUploadUtils.saveFileUpload(basicInfo.getId(), "basicInfo_image");
	}
	
	/**
	 * 更新状态
	 * @param basicInfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(BasicInfoCN basicInfo) {
		super.updateStatus(basicInfo);
	}
	
	/**
	 * 删除数据
	 * @param basicInfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(BasicInfoCN basicInfo) {
		super.delete(basicInfo);
	}
	
}