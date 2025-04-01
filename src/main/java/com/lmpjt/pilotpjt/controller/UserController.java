package com.lmpjt.pilotpjt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.User;

@Controller
public class UserController {
	
	@RequestMapping("/login")
	public String login(String id, String pw) {
		return "login";
	}
	@RequestMapping("/join")
	public String join(User user) {
		return "join";
	}
	@RequestMapping("/user_info")
	public String getUserInfo(int u_number) {
		return "user_info";
	}
	@RequestMapping("/update_user_info")
	public String updateUserInfo(User user) {
		return "user_update";
	}
}
