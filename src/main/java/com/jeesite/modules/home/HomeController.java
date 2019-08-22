/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.home;

import com.jeesite.common.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


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