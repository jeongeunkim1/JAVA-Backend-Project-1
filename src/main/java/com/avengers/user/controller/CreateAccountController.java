package com.avengers.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.RequestScope;

import com.avengers.user.dto.Address;
import com.avengers.user.dto.UserInfo;
import com.avengers.user.service.AddressService;
import com.avengers.user.service.UserInfoService;

@Controller
public class CreateAccountController {
	@Autowired
	UserInfoService userInfoService;
	
	@Autowired
	AddressService addressService;
	
	@RequestMapping(value = "/create_account_page")
	public String create_account_page() throws Exception{
		return "create-account";
	}
	@PostMapping(value = "/create_user_action")
	public String create_account_action(@ModelAttribute Address address, @ModelAttribute UserInfo userInfo) throws Exception {
		userInfoService.insertUserInfo(userInfo);
		Timer t_task=new Timer();
		TimerTask task=new TimerTask() {
			@Override
			public void run() {
				int user_no;
				try {
					user_no = (userInfoService.selectCurrentUserNo() - 1);
					address.setUser_no(user_no);
					addressService.insertAddress(address);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		t_task.schedule(task, 3000);
		return "login";
	}
	
	@ResponseBody
	@RequestMapping(value ="/create_account_ajax_id", produces = "application/json; charset=utf-8")
	public Map<String, Object> create_account_ajax(@RequestParam(value="inputedId")String inputedId) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		int count=0;
		List<UserInfo> userInfoList=userInfoService.selectAll();
		for (UserInfo userInfo : userInfoList) {
			if (userInfo.getUser_id().equals(inputedId)) {
				count=1;
			}
		}
		map.put("count", count);
		return map;
	}
	@ResponseBody
	@RequestMapping(value ="/create_account_ajax_email", produces = "application/json; charset=utf-8")
	public Map<String, Object> create_account_ajax_email(@RequestParam(value="inputedEmail")String inputedEmail) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		int count=0;
		List<UserInfo> userInfoList=userInfoService.selectAll();
		for (UserInfo userInfo : userInfoList) {
			if (userInfo.getUser_email().equals(inputedEmail)) {
				count=1;
			}
		}
		map.put("count", count);
		return map;
	}
	
}
