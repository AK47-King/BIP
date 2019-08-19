/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.biz.basicinfo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.biz.basicinfo.entity.BasicInfoCN;
import com.jeesite.modules.biz.basicinfo.service.BasicInfoService;

/**
 * 基础信息管理Controller
 * @author FangMao
 * @version 2019-08-18
 */
@Controller("basicInfoControllerCN")
@RequestMapping(value = "${adminPath}/basicinfo/basicInfo")
public class BasicInfoController extends BaseController {

	@Autowired
	private BasicInfoService basicInfoService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public BasicInfoCN get(String id, boolean isNewRecord) {
		return basicInfoService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("basicinfo:basicInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(BasicInfoCN basicInfo, Model model) {
		model.addAttribute("basicInfo", basicInfo);
		return "biz/basicinfo/basicInfoList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("basicinfo:basicInfo:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<BasicInfoCN> listData(BasicInfoCN basicInfo, HttpServletRequest request, HttpServletResponse response) {
		basicInfo.setPage(new Page<>(request, response));
		basicInfo.setPid("1162710962322722816");
		Page<BasicInfoCN> page = basicInfoService.findPage(basicInfo);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("basicinfo:basicInfo:view")
	@RequestMapping(value = "form")
	public String form(BasicInfoCN basicInfo, Model model) {
		model.addAttribute("basicInfo", basicInfo);
		return "biz/basicinfo/basicInfoForm";
	}

	/**
	 * 保存基础信息
	 */
	@RequiresPermissions("basicinfo:basicInfo:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated BasicInfoCN basicInfo) {
		basicInfo.setPid("1162710962322722816");
		basicInfoService.save(basicInfo);
		return renderResult(Global.TRUE, text("保存基础信息成功！"));
	}
	
	/**
	 * 删除基础信息
	 */
	@RequiresPermissions("basicinfo:basicInfo:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(BasicInfoCN basicInfo) {
		basicInfoService.delete(basicInfo);
		return renderResult(Global.TRUE, text("删除基础信息成功！"));
	}
	
}