/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.biz.baseinfo.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * base_infoEntity
 * @author FangMao
 * @version 2019-08-21
 */
@Table(name="travel", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="name", attrName="name", label="名称", queryType=QueryType.LIKE),
		@Column(name="link", attrName="link", label="link"),
		@Column(name="desc", attrName="desc", label="desc"),
		@Column(name="base_info_id", attrName="baseInfoId.id", label="base_info_id"),
	}, orderBy="a.id ASC"
)
public class Travel extends DataEntity<Travel> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 名称
	private String link;		// link
	private String desc;		// desc
	private BaseInfo baseInfoId;		// base_info_id 父类
	
	public Travel() {
		this(null);
	}


	public Travel(BaseInfo baseInfoId){
		this.baseInfoId = baseInfoId;
	}
	
	@Length(min=0, max=255, message="名称长度不能超过 255 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public BaseInfo getBaseInfoId() {
		return baseInfoId;
	}

	public void setBaseInfoId(BaseInfo baseInfoId) {
		this.baseInfoId = baseInfoId;
	}
	
}