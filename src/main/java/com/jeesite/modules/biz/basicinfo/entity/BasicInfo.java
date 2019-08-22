/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.biz.basicinfo.entity;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 基础信息管理Entity
 * @author FangMao
 * @version 2019-08-22
 */
@Table(name="basic_info", alias="a", columns={
		@Column(name="id", attrName="id", label="编号", isPK=true),
		@Column(name="name", attrName="name", label="名称", queryType=QueryType.LIKE),
		@Column(name="desc", attrName="desc", label="描述", queryType=QueryType.LIKE),
		@Column(name="pid", attrName="pid", label="父节点"),
	}, orderBy="a.id DESC"
)
public class BasicInfo extends DataEntity<BasicInfo> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 名称
	private String desc;		// 描述
	private String pid;		// 父节点
	
	public BasicInfo() {
		this(null);
	}

	public BasicInfo(String id){
		super(id);
	}
	
	@NotBlank(message="名称不能为空")
	@Length(min=0, max=255, message="名称长度不能超过 255 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=500, message="描述长度不能超过 500 个字符")
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}
	
}