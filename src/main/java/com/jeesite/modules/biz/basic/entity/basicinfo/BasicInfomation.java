/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.biz.basic.entity.basicinfo;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 基础信息管理Entity
 * @author FangMao
 * @version 2019-08-17
 */
@Table(name="basic_info", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="name", attrName="name", label="name", queryType=QueryType.LIKE),
		@Column(name="desc", attrName="desc", label="desc", queryType=QueryType.LIKE),
	}, orderBy="a.id DESC"
)
public class BasicInfomation extends DataEntity<BasicInfomation> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// name
	private String desc;		// desc
	
	public BasicInfomation() {
		this(null);
	}

	public BasicInfomation(String id){
		super(id);
	}
	
	@NotBlank(message="name不能为空")
	@Length(min=0, max=255, message="name长度不能超过 255 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=500, message="desc长度不能超过 500 个字符")
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}