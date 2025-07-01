package com.pro.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.Cookie;

import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.pro.dao.UserDao;
import com.pro.entity.User;

@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	private UserDao userDao;
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	
	@RequestMapping(path="/registerUser",method = RequestMethod.POST)
	public String registerUser(@ModelAttribute User user,HttpSession session) {
	     System.out.println(user);
	     userDao.saveUser(user);
		 return "redirect:/login";
	}
	
	@RequestMapping(path="/loginUser", method = RequestMethod.POST)
	public String loginUser(@RequestParam("email") String email,
	    @RequestParam("password") String password,HttpSession session) {
	    User user = userDao.login(email, password);
	    if (user != null) {
	        session.setAttribute("userObj", user); // ✅ Store in session
	        return "redirect:/home"; // or redirect:/home
	    }
	    return "redirect:/register";
	}
	
	


}
