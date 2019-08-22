/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.biz.basic.service.basicinfo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.biz.basic.entity.basicinfo.BasicInfomation;
import com.jeesite.modules.biz.basic.dao.basicinfo.BasicInfomationDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * 基础信息管理Service
 * @author FangMao
 * @version 2019-08-17
 */
@Service
@Transactional(readOnly=true)
public class BasicInfomationService extends CrudService<BasicInfomationDao, BasicInfomation> {
	
	/**
	 * 获取单条数据
	 * @param basicInfo
	 * @return
	 */
	@Override
	public BasicInfomation get(BasicInfomation basicInfo) {
		return super.get(basicInfo);
	}
	
	/**
	 * 查询分页数据
	 * @param basicInfo 查询条件
	 * @param basicInfo.page 分页对象
	 * @return
	 */
	@Override
	public Page<BasicInfomation> findPage(BasicInfomation basicInfo) {
		return super.findPage(basicInfo);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param basicInfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(BasicInfomation basicInfo) {
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
	public void updateStatus(BasicInfomation basicInfo) {
		super.updateStatus(basicInfo);
	}
	
	/**
	 * 删除数据
	 * @param basicInfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(BasicInfomation basicInfo) {
		super.delete(basicInfo);
	}
	
}