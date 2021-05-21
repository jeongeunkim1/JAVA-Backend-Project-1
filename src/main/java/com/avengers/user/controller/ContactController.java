package com.avengers.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactController {
	@RequestMapping(value = "/contact_page")
	public String contact_page() {
		
		return "contact";
	}
}
