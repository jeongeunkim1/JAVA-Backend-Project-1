package com.avengers.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IntroduceController {
	@RequestMapping(value = "/introduce_page")
	public String introduce_page() {
		return "introduce";
	}
}
