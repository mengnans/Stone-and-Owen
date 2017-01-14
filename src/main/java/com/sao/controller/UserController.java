package com.sao.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sao.error.MyError;
import com.sao.pojo.User;
import com.sao.service.IUserService;
import com.sao.util.Util;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService userService;

	@RequestMapping("/login")
	public String getUser(HttpServletRequest request, Model model) {
		String inputEmail = request.getParameter("inputEmail");
		String inputPassword = request.getParameter("inputPassword");
		User user = this.userService.getUserByEmail(inputEmail);
		if(user != null){
			boolean flag = false;
			try {
				flag = matchPassword(inputPassword, user.getUserpassword());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(flag){
				model.addAttribute(user);
				return "main";
			}else{
				MyError error = new MyError();
				error.setErrorMsg("Wrong password!");
				model.addAttribute(error);
				return "login";
			}
		}
		MyError error = new MyError();
		error.setErrorMsg("Wrong password!");
		model.addAttribute(error);
		return "login";
	}
	
	private boolean matchPassword(String inputPassword, String md5Password) throws Exception{
		return Util.getMD5Str(inputPassword) == md5Password;
	}
}
