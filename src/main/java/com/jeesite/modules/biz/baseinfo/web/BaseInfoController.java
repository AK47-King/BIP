/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.biz.baseinfo.web;

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
import com.jeesite.modules.biz.baseinfo.entity.BaseInfo;
import com.jeesite.modules.biz.baseinfo.service.BaseInfoService;

/**
 * base_infoController
 * @author FangMao
 * @version 2019-08-21
 */
@Controller
@RequestMapping(value = "${adminPath}/baseinfo/baseInfo")
public class BaseInfoController extends BaseController {

	@Autowired
	private BaseInfoService baseInfoService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public BaseInfo get(String id, boolean isNewRecord) {
		return baseInfoService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("baseinfo:baseInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(BaseInfo baseInfo, Model model) {
		model.addAttribute("baseInfo", baseInfo);
		return "biz/baseinfo/baseInfoList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("baseinfo:baseInfo:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<BaseInfo> listData(BaseInfo baseInfo, HttpServletRequest request, HttpServletResponse response) {
		baseInfo.setPage(new Page<>(request, response));
		Page<BaseInfo> page = baseInfoService.findPage(baseInfo);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("baseinfo:baseInfo:view")
	@RequestMapping(value = "form")
	public String form(BaseInfo baseInfo, Model model) {
		model.addAttribute("baseInfo", baseInfo);
		return "biz/baseinfo/baseInfoForm";
	}

	/**
	 * 保存base_info
	 */
	@RequiresPermissions("baseinfo:baseInfo:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated BaseInfo baseInfo) {
		baseInfoService.save(baseInfo);
		return renderResult(Global.TRUE, text("保存base_info成功！"));
	}
	
	/**
	 * 删除base_info
	 */
	@RequiresPermissions("baseinfo:baseInfo:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(BaseInfo baseInfo) {
		baseInfoService.delete(baseInfo);
		return renderResult(Global.TRUE, text("删除base_info成功！"));
	}
	
}