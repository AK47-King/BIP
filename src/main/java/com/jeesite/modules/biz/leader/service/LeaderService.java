/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.biz.leader.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.biz.leader.entity.Leader;
import com.jeesite.modules.biz.leader.dao.LeaderDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * leaderService
 * @author FangMao
 * @version 2019-08-22
 */
@Service
@Transactional(readOnly=true)
public class LeaderService extends CrudService<LeaderDao, Leader> {
	
	/**
	 * 获取单条数据
	 * @param leader
	 * @return
	 */
	@Override
	public Leader get(Leader leader) {
		return super.get(leader);
	}
	
	/**
	 * 查询分页数据
	 * @param leader 查询条件
	 * @param leader.page 分页对象
	 * @return
	 */
	@Override
	public Page<Leader> findPage(Leader leader) {
		return super.findPage(leader);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param leader
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(Leader leader) {
		super.save(leader);
		// 保存上传图片
		FileUploadUtils.saveFileUpload(leader.getId(), "leader_image");
	}
	
	/**
	 * 更新状态
	 * @param leader
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(Leader leader) {
		super.updateStatus(leader);
	}
	
	/**
	 * 删除数据
	 * @param leader
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(Leader leader) {
		super.delete(leader);
	}
	
}