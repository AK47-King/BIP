/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.biz.leader.web;

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
import com.jeesite.modules.biz.leader.entity.Leader;
import com.jeesite.modules.biz.leader.service.LeaderService;

/**
 * leaderController
 * @author FangMao
 * @version 2019-08-22
 */
@Controller
@RequestMapping(value = "${adminPath}/leader/leader")
public class LeaderController extends BaseController {

	@Autowired
	private LeaderService leaderService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public Leader get(String id, boolean isNewRecord) {
		return leaderService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("leader:leader:view")
	@RequestMapping(value = {"list", ""})
	public String list(Leader leader, Model model) {
		model.addAttribute("leader", leader);
		return "biz/leader/leaderList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("leader:leader:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<Leader> listData(Leader leader, HttpServletRequest request, HttpServletResponse response) {
		leader.setPage(new Page<>(request, response));
		Page<Leader> page = leaderService.findPage(leader);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("leader:leader:view")
	@RequestMapping(value = "form")
	public String form(Leader leader, Model model) {
		model.addAttribute("leader", leader);
		return "biz/leader/leaderForm";
	}

	/**
	 * 保存leader
	 */
	@RequiresPermissions("leader:leader:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated Leader leader) {
		leaderService.save(leader);
		return renderResult(Global.TRUE, text("保存leader成功！"));
	}
	
	/**
	 * 删除leader
	 */
	@RequiresPermissions("leader:leader:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Leader leader) {
		leaderService.delete(leader);
		return renderResult(Global.TRUE, text("删除leader成功！"));
	}
	
}