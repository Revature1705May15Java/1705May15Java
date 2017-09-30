package com.revature.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home.do")
public class UserHomeController {

	@RequestMapping(method = RequestMethod.GET)
	public String getLoginView(HttpServletRequest request) {
		return "home";
	}
}
