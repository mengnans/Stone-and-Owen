package com.sao.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sao.error.MyError;
import com.sao.pojo.User;
import com.sao.service.IUserService;
import com.sao.util.UserUtil;
import com.sao.util.Util;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService userService;

	@RequestMapping("/tologin")
	public String toLogin(HttpServletRequest request, Model model) {
		return "login";
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model) {
		String inputEmail = request.getParameter("inputEmail");
		String inputPassword = request.getParameter("inputPassword");
		User user = this.userService.getUserByEmail(inputEmail);
		if(user != null){
			boolean flag = false;
			try {
				flag = UserUtil.matchPassword(inputPassword, user.getUserpassword());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(flag){
				model.addAttribute("user",user);
				return "main";
			}
		}
		MyError error = new MyError();
		error.setErrorMsg("Wrong email or password!");
		model.addAttribute("error",error);
		return "login";
	}
	
	@RequestMapping("/toregister")
	public String toRegister(HttpServletRequest request, Model model) {
		return "register";
	}
	
	@RequestMapping("/register")
	public String register(HttpServletRequest request, Model model) {
		String inputEmail = request.getParameter("inputEmail");
		String inputPassword = request.getParameter("inputPassword");
		String inputUsername = request.getParameter("inputUsername");
		
		if(illegalUserame(inputUsername) || 
				illegalPassword(inputPassword))
		{
			MyError error = new MyError();
			error.setErrorMsg("Illegal username or password!");
			model.addAttribute("error",error);
			return "register";
		}
		User user = new User();
		user.setUseremail(inputEmail);
		user.setUsername(inputUsername);
		try {
			user.setUserpassword(Util.getMD5Str(inputPassword));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.userService.newUser(user);
		model.addAttribute("user",user);
		return "main";
	}
	
	public boolean illegalUserame(String userName){
		User user = this.userService.getUserByName(userName);
		if(userName.contains(" ") || userName.contains("@"))
			return true;
		if(user != null){			//repetitive user's name
			return true;
		}
		return false;
	}
	
	public boolean illegalPassword(String str){
		//code here
		return false;
	}
	
}
