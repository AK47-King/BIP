/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.bip.loc.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.bip.loc.entity.LocInfo;
import com.jeesite.modules.bip.loc.dao.LocInfoDao;

/**
 * 位置信息Service
 * @author FangMao
 * @version 2019-08-17
 */
@Service
@Transactional(readOnly=true)
public class LocInfoService extends CrudService<LocInfoDao, LocInfo> {
	
	/**
	 * 获取单条数据
	 * @param locInfo
	 * @return
	 */
	@Override
	public LocInfo get(LocInfo locInfo) {
		return super.get(locInfo);
	}
	
	/**
	 * 查询分页数据
	 * @param locInfo 查询条件
	 * @param locInfo.page 分页对象
	 * @return
	 */
	@Override
	public Page<LocInfo> findPage(LocInfo locInfo) {
		return super.findPage(locInfo);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param locInfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(LocInfo locInfo) {
		super.save(locInfo);
	}
	
	/**
	 * 更新状态
	 * @param locInfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(LocInfo locInfo) {
		super.updateStatus(locInfo);
	}
	
	/**
	 * 删除数据
	 * @param locInfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(LocInfo locInfo) {
		super.delete(locInfo);
	}
	
}