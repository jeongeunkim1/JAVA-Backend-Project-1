package com.avengers.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.avengers.user.dto.Card;
import com.avengers.user.dto.UserInfo;
import com.avengers.user.service.CardService;

@Controller
public class CardController {
	@Autowired
	CardService cardService;

	@RequestMapping(value = "/card_page")
	public String card_page() {
		return "card";
	}
	
	@PostMapping(value = "/card_register_action_page")
	public String card_register_action_page(@ModelAttribute Card card, @RequestParam("card_month") int card_month,
			@RequestParam("card_year") int card_year, HttpSession session) throws Exception {
		if (session.getAttribute("user") == null || session.getAttribute("user") == "") {
			return "forward:/"; 
		}
		UserInfo userInfo = (UserInfo) session.getAttribute("user");
		int user_no = userInfo.getUser_no();
		String card_deadline = card_month + "/" + card_year;
		card.setCard_deadline(card_deadline);
		card.setUser_no(user_no);
		cardService.regiCard(card);
		
		return "forward:main_page";
	}
	
	@RequestMapping(value = "/card_delete_action")
	public String card_delete_action(@RequestParam("card_no") String card_no) throws Exception{
		try {
			cardService.deleteCard(card_no);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "forward:account_info_page";
	}
	

}
