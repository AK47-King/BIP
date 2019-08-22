/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.biz.baseinfo.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.biz.baseinfo.entity.Lead;

/**
 * base_infoDAO接口
 * @author FangMao
 * @version 2019-08-22
 */
@MyBatisDao
public interface LeadDao extends CrudDao<Lead> {
	
}