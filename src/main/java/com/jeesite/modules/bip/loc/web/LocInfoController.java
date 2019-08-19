/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.bip.loc.web;

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
import com.jeesite.modules.bip.loc.entity.LocInfo;
import com.jeesite.modules.bip.loc.service.LocInfoService;

/**
 * 位置信息Controller
 * @author FangMao
 * @version 2019-08-17
 */
@Controller
@RequestMapping(value = "${adminPath}/loc/locInfo")
public class LocInfoController extends BaseController {

	@Autowired
	private LocInfoService locInfoService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public LocInfo get(String id, boolean isNewRecord) {
		return locInfoService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("loc:locInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(LocInfo locInfo, Model model) {
		model.addAttribute("locInfo", locInfo);
		return "bip/loc/locInfoList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("loc:locInfo:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<LocInfo> listData(LocInfo locInfo, HttpServletRequest request, HttpServletResponse response) {
		locInfo.setPage(new Page<>(request, response));
		Page<LocInfo> page = locInfoService.findPage(locInfo);
		return page;
	}

	@RequestMapping(value = "search/{locId}")
	@ResponseBody
	public LocInfo searchLocation(String locId, HttpServletRequest request, HttpServletResponse response) {
		LocInfo locInfo = locInfoService.get(locId);
		return locInfo;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("loc:locInfo:view")
	@RequestMapping(value = "form")
	public String form(LocInfo locInfo, Model model) {
		model.addAttribute("locInfo", locInfo);
		return "bip/loc/locInfoForm";
	}

	/**
	 * 保存位置信息
	 */
	@RequiresPermissions("loc:locInfo:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated LocInfo locInfo) {
		locInfoService.save(locInfo);
		return renderResult(Global.TRUE, text("保存位置信息成功！"));
	}
	
	/**
	 * 删除位置信息
	 */
	@RequiresPermissions("loc:locInfo:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(LocInfo locInfo) {
		locInfoService.delete(locInfo);
		return renderResult(Global.TRUE, text("删除位置信息成功！"));
	}
	
}