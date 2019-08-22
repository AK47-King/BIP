/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.biz.leader.entity;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * leaderEntity
 * @author FangMao
 * @version 2019-08-22
 */
@Table(name="leader", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="name", attrName="name", label="名称", queryType=QueryType.LIKE),
		@Column(name="title", attrName="title", label="职务", queryType=QueryType.LIKE),
		@Column(name="pic", attrName="pic", label="照片", isInsert=false, isUpdate=false, isQuery=false),
		@Column(name="base_info_id", attrName="baseInfoId", label="单位"),
		@Column(name="type", attrName="type", label="职别"),
	}, orderBy="a.id DESC"
)
public class Leader extends DataEntity<Leader> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 名称
	private String title;		// 职务
	private String pic;		// 照片
	private String baseInfoId;		// 单位
	private String type;		// 职别
	
	public Leader() {
		this(null);
	}

	public Leader(String id){
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
	
	@Length(min=0, max=255, message="职务长度不能超过 255 个字符")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Length(min=0, max=1000, message="照片长度不能超过 1000 个字符")
	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}
	
	@Length(min=0, max=64, message="单位长度不能超过 64 个字符")
	public String getBaseInfoId() {
		return baseInfoId;
	}

	public void setBaseInfoId(String baseInfoId) {
		this.baseInfoId = baseInfoId;
	}
	
	@Length(min=0, max=1, message="职别长度不能超过 1 个字符")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}