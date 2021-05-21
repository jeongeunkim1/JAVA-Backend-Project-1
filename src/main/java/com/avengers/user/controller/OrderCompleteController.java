package com.avengers.user.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.avengers.user.dto.Address;
import com.avengers.user.dto.JumunDetail;
import com.avengers.user.dto.Product;
import com.avengers.user.dto.UserInfo;
import com.avengers.user.service.AddressService;
import com.avengers.user.service.JumunDetailService;
import com.avengers.user.service.ProductService;

@Controller
public class OrderCompleteController {
	
	@Autowired
	private JumunDetailService jumuDetailService;
	@Autowired
	private AddressService addressService;
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/order_complete_page")
	public String order_complete_page( Model model, HttpSession session ) throws Exception{
		UserInfo user= (UserInfo) session.getAttribute("user");
		List<JumunDetail> jumun_Detail_List = jumuDetailService.findCompleteJumunDetail(user.getUser_no());
		Address address= addressService.selectAddressByNo(user.getUser_no());
		int tot=0;
		for (JumunDetail jumunDetail : jumun_Detail_List) {
			Product product = productService.findByProductNo(jumunDetail.getProduct_no());
			tot += (jumunDetail.getJd_quantity()*product.getProduct_price());
		}
		
		model.addAttribute("product",jumun_Detail_List);
		model.addAttribute("address",address);
		model.addAttribute("tot",tot);
		return "order-complete";
	}
}
