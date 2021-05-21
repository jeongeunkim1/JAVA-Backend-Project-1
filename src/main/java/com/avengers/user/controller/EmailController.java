package com.avengers.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avengers.user.service.EmailService;

@RestController
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/out_check_number")
	public void out_check_number(HttpSession session,@RequestParam("user_email") String user_email) {
		emailService.mailSend(session, user_email);
	}
	
	@PostMapping("/get_check_number")
	public boolean get_check_number(HttpSession session,@RequestParam("user_email") String user_email,@RequestParam("check_code") int check_code) {
		int out_code=(int)session.getAttribute(user_email);
		if(out_code==check_code) {
			return true;
		}
		
		return false;
	}
	
	
}
