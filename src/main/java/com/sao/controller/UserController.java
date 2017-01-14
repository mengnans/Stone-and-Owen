package com.sao.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sao.pojo.User;
import com.sao.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService userService;

	@RequestMapping("/login")
	public String getUser(HttpServletRequest request, Model model) {
//		String userEmail = request.getParameter("inputEmail");
//		String userPassword = request.getParameter("inputPassword");
//		User user = this.userService.getUserById(userId)
//		User user = this.userService.getUserById(userId);
//		model.addAttribute("user", user);
		return "login";
	}
}
