/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.biz.baseinfo.entity;

import org.hibernate.validator.constraints.Length;
import java.util.List;
import com.jeesite.common.collect.ListUtils;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * base_infoEntity
 * @author FangMao
 * @version 2019-08-22
 */
@Table(name="base_info", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="name", attrName="name", label="单位名称", queryType=QueryType.LIKE),
		@Column(name="env_desc", attrName="envDesc", label="地理环境"),
		@Column(name="population", attrName="population", label="区划人口"),
		@Column(name="history", attrName="history", label="历史文化"),
		@Column(name="guide", attrName="guide", label="旅游指南"),
		@Column(name="trafic", attrName="trafic", label="交通概况"),
		@Column(name="lng", attrName="lng", label="经度"),
		@Column(name="lat", attrName="lat", label="纬度"),
		@Column(name="org", attrName="org", label="组织结构"),
		@Column(name="area", attrName="area", label="行政划区"),
		@Column(name="org_name", attrName="orgName", label="组织结构名", queryType=QueryType.LIKE),
		@Column(name="area_name", attrName="areaName", label="行政划区名", queryType=QueryType.LIKE),
	}, orderBy="a.id DESC"
)
public class BaseInfo extends DataEntity<BaseInfo> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 单位名称
	private String envDesc;		// 地理环境
	private String population;		// 区划人口
	private String history;		// 历史文化
	private String guide;		// 旅游指南
	private String trafic;		// 交通概况
	private Double lng;		// 经度
	private Double lat;		// 纬度
	private String org;		// 组织结构
	private String area;		// 行政划区
	private String orgName;		// 组织结构名
	private String areaName;		// 行政划区名
	private List<Travel> travelList = ListUtils.newArrayList();		// 子表列表
	
	public BaseInfo() {
		this(null);
	}

	public BaseInfo(String id){
		super(id);
	}
	
	@Length(min=0, max=500, message="单位名称长度不能超过 500 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=2000, message="地理环境长度不能超过 2000 个字符")
	public String getEnvDesc() {
		return envDesc;
	}

	public void setEnvDesc(String envDesc) {
		this.envDesc = envDesc;
	}
	
	@Length(min=0, max=1000, message="区划人口长度不能超过 1000 个字符")
	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}
	
	@Length(min=0, max=2000, message="历史文化长度不能超过 2000 个字符")
	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}
	
	@Length(min=0, max=2000, message="旅游指南长度不能超过 2000 个字符")
	public String getGuide() {
		return guide;
	}

	public void setGuide(String guide) {
		this.guide = guide;
	}
	
	@Length(min=0, max=1000, message="交通概况长度不能超过 1000 个字符")
	public String getTrafic() {
		return trafic;
	}

	public void setTrafic(String trafic) {
		this.trafic = trafic;
	}
	
	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}
	
	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}
	
	@Length(min=0, max=64, message="组织结构长度不能超过 64 个字符")
	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
	}
	
	@Length(min=0, max=64, message="行政划区长度不能超过 64 个字符")
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	
	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
	public List<Travel> getTravelList() {
		return travelList;
	}

	public void setTravelList(List<Travel> travelList) {
		this.travelList = travelList;
	}
	
}