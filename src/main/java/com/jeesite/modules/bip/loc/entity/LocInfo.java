/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.bip.loc.entity;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 位置信息Entity
 * @author FangMao
 * @version 2019-08-17
 */
@Table(name="loc_info", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="address", attrName="address", label="address"),
		@Column(name="lng", attrName="lng", label="经度"),
		@Column(name="lat", attrName="lat", label="维度"),
	}, orderBy="a.id DESC"
)
public class LocInfo extends DataEntity<LocInfo> {
	
	private static final long serialVersionUID = 1L;
	private String address;		// address
	private Double lng;		// 经度
	private Double lat;		// 维度
	
	public LocInfo() {
		this(null);
	}

	public LocInfo(String id){
		super(id);
	}
	
	@NotBlank(message="address不能为空")
	@Length(min=0, max=255, message="address长度不能超过 255 个字符")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@NotNull(message="经度不能为空")
	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}
	
	@NotNull(message="维度不能为空")
	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}
	
}