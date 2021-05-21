package com.avengers.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.avengers.user.dto.Address;
import com.avengers.user.dto.Card;
import com.avengers.user.dto.Jumun;
import com.avengers.user.dto.UserInfo;
import com.avengers.user.service.AddressService;
import com.avengers.user.service.CardService;
import com.avengers.user.service.JumunDetailService;
import com.avengers.user.service.JumunService;
import com.avengers.user.service.ProductService;
import com.avengers.user.service.UserInfoService;

@Controller
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private AddressService addressService;
	@Autowired
	private CardService cardService;
	@Autowired
	private JumunService jumunService;
	@Autowired
	private JumunDetailService jumunDetailService;
	@Autowired
	private ProductService productService;

	// 아이디 찾기 페이지
	@RequestMapping(value = "/account_findid_page")
	public String account_findid_page() {
		return "account_findid";
	}

	// 아이디 찾기 액션
	@ResponseBody
	@PostMapping(value = "/account_findid_action", produces = "application/json; charset=utf-8")
	public Map<String, Object> account_findid_action(@RequestParam("userEmail") String userEmail) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		int count=0;
		List<UserInfo> userInfoList=userInfoService.selectAll();
		for (UserInfo userInfo1 : userInfoList) {
			if (userInfo1.getUser_email().equals(userEmail)) {
				count=1;
			}
		}
		UserInfo userInfo = userInfoService.selectUserIdByEmail(userEmail);
		map.put("count", count);
		map.put("userInfo", userInfo);
		return map;
	}

	// 비밀번호 찾기 페이지
	@RequestMapping(value = "/account_findpassword_page")
	public String account_findpassword_page() {
		return "account_findpassword";
	}

	// 비밀번호에서 아이디찾기 액션
	@ResponseBody
	@PostMapping(value = "/account_findPassword_action", produces = "application/json; charset=utf-8")
	public UserInfo account_findPassword_action(@RequestParam("user_id") String user_id) throws Exception {

		UserInfo userInfo = userInfoService.selectUserPasswordById(user_id);

		return userInfo;
	}

	

	// 유저정보
	@RequestMapping(value = "/account_info_page")
	public String account_info(HttpSession session, Model model) throws Exception {
		UserInfo user = (UserInfo) session.getAttribute("user");
		UserInfo userInfo = userInfoService.selectUserInfoByNo(user.getUser_no());
		List<Address> address = addressService.selectAddressAllByNo(user.getUser_no());
		List<Card> card = cardService.cardSelect(user.getUser_no());
		model.addAttribute("userInfo", userInfo);
		model.addAttribute("address", address);
		model.addAttribute("card", card);

		return "account_info";
	}

	// 유저 주문목록
	@RequestMapping(value = "/account_order_page")
	public String order_page(HttpSession session, Model model) throws Exception {
		UserInfo user = (UserInfo) session.getAttribute("user");
		List<Jumun> jumunList = jumunService.selectJumunAllByUserNo(user.getUser_no());
		model.addAttribute("jumunList", jumunList);
		return "account_order";
	}
	
	//사용자 회원탈퇴
	@RequestMapping(value="/account_delete_action")
	public String account_delete_action(HttpSession session) {
		UserInfo user = (UserInfo) session.getAttribute("user");
		try {
			userInfoService.deleteUserInfoByNo(user.getUser_no());
			session.invalidate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "forward:main_page";
	}
}
