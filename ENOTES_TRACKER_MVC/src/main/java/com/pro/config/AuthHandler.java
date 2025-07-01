package com.pro.config;

import org.springframework.web.servlet.HandlerInterceptor;

import com.pro.entity.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthHandler implements HandlerInterceptor{
   public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler)
      throws Exception {
	   
	   User user = (User)request.getSession().getAttribute("userObj");
	   if(user!=null) {
		   return true;
	   }
	   else {
		   response.getWriter().print("<h1>Please Login</h1>");
		  return false;
	   }
   }
}
