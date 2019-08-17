/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.biz.basic.dao.basicinfo;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.biz.basic.entity.basicinfo.BasicInfo;

/**
 * 基础信息管理DAO接口
 * @author FangMao
 * @version 2019-08-17
 */
@MyBatisDao
public interface BasicInfoDao extends CrudDao<BasicInfo> {
	
}