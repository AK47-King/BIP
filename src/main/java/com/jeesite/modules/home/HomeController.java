/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.home;

import com.jeesite.common.codec.DesUtils;
import com.jeesite.common.config.Global;
import com.jeesite.common.lang.StringUtils;
import com.jeesite.common.shiro.filter.FormAuthenticationFilter;
import com.jeesite.common.shiro.realm.BaseAuthorizingRealm;
import com.jeesite.common.shiro.realm.LoginInfo;
import com.jeesite.common.web.BaseController;
import com.jeesite.common.web.CookieUtils;
import com.jeesite.common.web.http.ServletUtils;
import com.jeesite.modules.sys.utils.UserUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.session.Session;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


@Controller
public class HomeController extends BaseController {

	@RequestMapping(value = "/home")
	public String home(HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println(">>>>>>>>>>>>>>>>>HomePage<<<<<<<<<<<<<<<<");
		return "home/index";
	}

	@RequestMapping(value = "/home/content")
	public String homeContent() {
		System.out.println(">>>>>>>>>>>>>>>>>HomePageContent<<<<<<<<<<<<<<<<");
		return "home/content";
	}
	
}