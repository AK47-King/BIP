/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.biz.org.org.dao;

import com.jeesite.common.dao.TreeDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.biz.org.org.entity.OrgTree;

/**
 * 测试树表DAO接口
 * @author ThinkGem
 * @version 2019-08-21
 */
@MyBatisDao
public interface OrgTreeDao extends TreeDao<OrgTree> {
	
}