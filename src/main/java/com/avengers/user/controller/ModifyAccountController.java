package com.avengers.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.avengers.user.dto.Address;
import com.avengers.user.dto.UserInfo;
import com.avengers.user.service.AddressService;
import com.avengers.user.service.UserInfoService;

@Controller
public class ModifyAccountController {
	@Autowired
	private AddressService addressService;
	@Autowired
	private UserInfoService userInfoService;
	
	//@정은 사용자정보 수정하기 타임리프 작업
	@RequestMapping(value = "/modify-account_page")
	public String modify_user(Model model,HttpSession session) throws Exception {
		UserInfo user = (UserInfo)session.getAttribute("user");
		UserInfo userInfo = userInfoService.selectUserInfoByNo(user.getUser_no());
		List<Address> address = addressService.selectAddressAllByNo(userInfo.getUser_no());
		
		model.addAttribute("userInfo",userInfo);
		model.addAttribute("address",address);
		return "modify-account";
	}
	
	//@정은 사용자정보 업데이트하기
	@PostMapping(value = "/user_update_action")
	public String user_update_action(@ModelAttribute Address address, UserInfo userInfo, HttpSession session) {
		String forwardPath="";
		int user_no=userInfo.getUser_no();
		address.setUser_no(user_no);
		try {
			addressService.updateAddress(address);
			userInfoService.updateUserInfoById(userInfo);
			session.invalidate();
			forwardPath="login";
		}catch (Exception e) {
			e.printStackTrace();
			forwardPath="modify-account";
		}
		return forwardPath;
	}
	//@정은 이메일 중복체크
		@ResponseBody
		@PostMapping(value = "/modify_account_ajax_email", produces = "application/json; charset=utf-8")
		public Map<String, Object> modify_account_ajax_email(@RequestParam String user_email) throws Exception{
			Map<String, Object> map = new HashMap<String, Object>();
			int count=0;
			List<UserInfo> userList = userInfoService.selectAll();
			for (UserInfo userInfo : userList) {
				if (userInfo.getUser_email().equals(user_email)) {
					count=1;
				}
			}
			map.put("count", count);
			return map;
		}
		
		
		
		
		
		
		
		
		
		
		
}