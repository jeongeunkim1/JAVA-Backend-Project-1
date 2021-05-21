package com.avengers.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.avengers.user.dto.UserInfo;
import com.avengers.user.service.UserInfoService;

@Controller
public class LoginController {
	
	@Autowired
	private UserInfoService userInfoService;
	
	@RequestMapping(value = "/login_page")
	public String login_page() {
		return "login";
	}
	
	@RequestMapping(value = "/login_action",method = RequestMethod.POST)
	public String login_action(@ModelAttribute UserInfo userinfo,HttpSession session) {
		String findpath="login";
		
		try {
			UserInfo user = userInfoService.userLogin(userinfo);
			if(user!=null) {
				session.setAttribute("user", user);
				findpath="forward:/";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return findpath;
	}
	
	@RequestMapping(value="/logout_action")
	public String logout_action(HttpSession session) {
		session.invalidate();
		return "forward:/";
	}
	
}
