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

	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "home/face";
	}

	@RequestMapping(value = "/home")
	public String home(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "home/index";
	}

	@RequestMapping(value = "/home/phone/tongliang")
	public String phoneTL(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "home/phone_booke_tong_liang";
	}

	@RequestMapping(value = "/home/content_1") //铜梁
	public String homeContent1() {
		return "home/content_1";
	}

	@RequestMapping(value = "/home/content_2") // 城南街道
	public String homeContent2() {
		return "home/content_2";
	}

	@RequestMapping(value = "/home/content_3") // 安居镇
	public String homeContent3() {
		return "home/content_3";
	}

	@RequestMapping(value = "/home/dept_trans")
	public String deptTrans() {
		return "home/dept_trans";
	}

	@RequestMapping(value = "/home/phone_book_dept_trans")
	public String phoneBookDeptTrans() {
		return "home/phone_book_dept_trans";
	}

}