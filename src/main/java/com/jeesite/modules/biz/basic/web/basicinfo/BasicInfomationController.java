/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.biz.basic.web.basicinfo;

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
import com.jeesite.modules.biz.basic.entity.basicinfo.BasicInfomation;
import com.jeesite.modules.biz.basic.service.basicinfo.BasicInfomationService;

/**
 * 基础信息管理Controller
 * @author FangMao
 * @version 2019-08-17
 */
@Controller
@RequestMapping(value = "${adminPath}/basic/basicinfo/basicInfo")
public class BasicInfomationController extends BaseController {

	@Autowired
	private BasicInfomationService basicInfoService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public BasicInfomation get(String id, boolean isNewRecord) {
		return basicInfoService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("basic:basicinfo:basicInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(BasicInfomation basicInfo, Model model) {
		model.addAttribute("basicInfo", basicInfo);
		return "biz/basic/basicinfo/basicInfoList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("basic:basicinfo:basicInfo:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<BasicInfomation> listData(BasicInfomation basicInfo, HttpServletRequest request, HttpServletResponse response) {
		basicInfo.setPage(new Page<>(request, response));
//		basicInfo.getSqlMap().getWhere().and(basicInfo.getnam)
//        this.sqlMap.getWhere().and(this.getIdColumnName(), QueryType.IN, ids);
		Page<BasicInfomation> page = basicInfoService.findPage(basicInfo);
		return page;
	}

    @RequiresPermissions("basic:basicinfo:basicInfo:view")
    @RequestMapping(value = "listData_nc")
    @ResponseBody
    public Page<BasicInfomation> listData_nc(BasicInfomation basicInfo, HttpServletRequest request, HttpServletResponse response) {
        basicInfo.setPage(new Page<>(request, response));
        Page<BasicInfomation> page = basicInfoService.findPage(basicInfo);
        return page;
    }


	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("basic:basicinfo:basicInfo:view")
	@RequestMapping(value = "form")
	public String form(BasicInfomation basicInfo, Model model) {
		model.addAttribute("basicInfo", basicInfo);
		return "biz/basic/basicinfo/basicInfoForm";
	}

	/**
	 * 保存基础信息
	 */
	@RequiresPermissions("basic:basicinfo:basicInfo:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated BasicInfomation basicInfo) {
		basicInfoService.save(basicInfo);
		return renderResult(Global.TRUE, text("保存基础信息成功！"));
	}
	
	/**
	 * 删除基础信息
	 */
	@RequiresPermissions("basic:basicinfo:basicInfo:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(BasicInfomation basicInfo) {
		basicInfoService.delete(basicInfo);
		return renderResult(Global.TRUE, text("删除基础信息成功！"));
	}
	
}