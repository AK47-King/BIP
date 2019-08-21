/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.biz.baseinfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.biz.baseinfo.entity.BaseInfo;
import com.jeesite.modules.biz.baseinfo.dao.BaseInfoDao;
import com.jeesite.modules.biz.baseinfo.entity.Travel;
import com.jeesite.modules.biz.baseinfo.dao.TravelDao;

/**
 * base_infoService
 * @author FangMao
 * @version 2019-08-21
 */
@Service
@Transactional(readOnly=true)
public class BaseInfoService extends CrudService<BaseInfoDao, BaseInfo> {
	
	@Autowired
	private TravelDao travelDao;
	
	/**
	 * 获取单条数据
	 * @param baseInfo
	 * @return
	 */
	@Override
	public BaseInfo get(BaseInfo baseInfo) {
		BaseInfo entity = super.get(baseInfo);
		if (entity != null){
			Travel travel = new Travel(entity);
			travel.setStatus(Travel.STATUS_NORMAL);
			entity.setTravelList(travelDao.findList(travel));
		}
		return entity;
	}
	
	/**
	 * 查询分页数据
	 * @param baseInfo 查询条件
	 * @param baseInfo.page 分页对象
	 * @return
	 */
	@Override
	public Page<BaseInfo> findPage(BaseInfo baseInfo) {
		return super.findPage(baseInfo);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param baseInfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(BaseInfo baseInfo) {
		super.save(baseInfo);
		// 保存 BaseInfo子表
		for (Travel travel : baseInfo.getTravelList()){
			if (!Travel.STATUS_DELETE.equals(travel.getStatus())){
				travel.setBaseInfoId(baseInfo);
				if (travel.getIsNewRecord()){
					travelDao.insert(travel);
				}else{
					travelDao.update(travel);
				}
			}else{
				travelDao.delete(travel);
			}
		}
	}
	
	/**
	 * 更新状态
	 * @param baseInfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(BaseInfo baseInfo) {
		super.updateStatus(baseInfo);
	}
	
	/**
	 * 删除数据
	 * @param baseInfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(BaseInfo baseInfo) {
		super.delete(baseInfo);
		Travel travel = new Travel();
		travel.setBaseInfoId(baseInfo);
		travelDao.deleteByEntity(travel);
	}
	
}