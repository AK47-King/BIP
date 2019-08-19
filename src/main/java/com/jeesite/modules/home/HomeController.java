/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.home;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.biz.basic.entity.basicinfo.BasicInfo;
import com.jeesite.modules.biz.basic.service.basicinfo.BasicInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class HomeController extends BaseController {

	@RequestMapping(value = "/home")
	public String home() {
		System.out.println(">>>>>>>>>>>>>>>>>HomePage<<<<<<<<<<<<<<<<");
		return "home/index";
	}

	@RequestMapping(value = "/home/content")
	public String homeContent() {
		System.out.println(">>>>>>>>>>>>>>>>>HomePageContent<<<<<<<<<<<<<<<<");
		return "home/content";
	}
	
}