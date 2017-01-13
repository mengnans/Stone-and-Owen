package com.sao.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sao.pojo.User_t;
import com.sao.service.IUser_tService;  
  
@Controller  
@RequestMapping("/user_t")  
public class User_tController {  
    @Resource  
    private IUser_tService userService;  
      
    @RequestMapping("/showUser_t")  
    public String toIndex(HttpServletRequest request,Model model){  
        int userId = Integer.parseInt(request.getParameter("id"));  
        User_t user = this.userService.getUserById(userId);  
        model.addAttribute("user", user);  
        return "showUser";  
    }  
}