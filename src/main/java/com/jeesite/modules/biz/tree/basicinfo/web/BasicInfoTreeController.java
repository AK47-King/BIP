/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.biz.tree.basicinfo.web;

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
import com.jeesite.modules.biz.tree.basicinfo.entity.BasicInfoTree;
import com.jeesite.modules.biz.tree.basicinfo.service.BasicInfoTreeService;

/**
 * 基础信息管理Controller
 * @author FangMao
 * @version 2019-08-18
 */
@Controller
@RequestMapping(value = "${adminPath}/basicinfo/basicInfoTree")
public class BasicInfoTreeController extends BaseController {

	@Autowired
	private BasicInfoTreeService basicInfoTreeService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public BasicInfoTree get(String id, boolean isNewRecord) {
		return basicInfoTreeService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("basicinfo:basicInfoTree:view")
	@RequestMapping(value = {"list", ""})
	public String list(BasicInfoTree basicInfoTree, Model model) {
		model.addAttribute("basicInfoTree", basicInfoTree);
		return "tree/basicinfo/basicInfoTreeList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("basicinfo:basicInfoTree:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<BasicInfoTree> listData(BasicInfoTree basicInfoTree, HttpServletRequest request, HttpServletResponse response) {
		basicInfoTree.setPage(new Page<>(request, response));
		Page<BasicInfoTree> page = basicInfoTreeService.findPage(basicInfoTree);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("basicinfo:basicInfoTree:view")
	@RequestMapping(value = "form")
	public String form(BasicInfoTree basicInfoTree, Model model) {
		model.addAttribute("basicInfoTree", basicInfoTree);
		return "tree/basicinfo/basicInfoTreeForm";
	}

	/**
	 * 保存基础信息
	 */
	@RequiresPermissions("basicinfo:basicInfoTree:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated BasicInfoTree basicInfoTree) {
		basicInfoTreeService.save(basicInfoTree);
		return renderResult(Global.TRUE, text("保存基础信息成功！"));
	}
	
	/**
	 * 删除基础信息
	 */
	@RequiresPermissions("basicinfo:basicInfoTree:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(BasicInfoTree basicInfoTree) {
		basicInfoTreeService.delete(basicInfoTree);
		return renderResult(Global.TRUE, text("删除基础信息成功！"));
	}
	
}