/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.bip.loc.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.bip.loc.entity.LocInfo;

/**
 * 位置信息DAO接口
 * @author FangMao
 * @version 2019-08-17
 */
@MyBatisDao
public interface LocInfoDao extends CrudDao<LocInfo> {
	
}