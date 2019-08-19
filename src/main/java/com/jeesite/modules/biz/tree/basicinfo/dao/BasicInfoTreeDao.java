/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.biz.tree.basicinfo.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.biz.tree.basicinfo.entity.BasicInfoTree;

/**
 * 基础信息管理DAO接口
 * @author FangMao
 * @version 2019-08-18
 */
@MyBatisDao
public interface BasicInfoTreeDao extends CrudDao<BasicInfoTree> {
	
}