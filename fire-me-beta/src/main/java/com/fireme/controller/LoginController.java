package com.fireme.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/primary**", method = RequestMethod.GET)
	public ModelAndView adminPage(HttpServletRequest request) {

		ModelAndView model = new ModelAndView();
		
		Authentication auth  = SecurityContextHolder.getContext().getAuthentication();
		
		String loggedInUser = auth.getName();
		List<? extends GrantedAuthority> authCollect = (List<? extends GrantedAuthority>) auth.getAuthorities();
		String role = authCollect.get(0).getAuthority();
		if(!role.equalsIgnoreCase("ROLE_ANONYMOUS")){
			
//		String loggedInFlag = authCollect.get(1).getAuthority();
//		String approverId1 = authCollect.get(2).getAuthority();
//		String approverId2 = authCollect.get(3).getAuthority();
//		
//		System.out.println("Printing Role for the User == " + role);
//		System.out.println("Logged in Flag == " + loggedInFlag);
//		model.addObject("role", role);
//		model.addObject("username", loggedInUser);
//		model.addObject("approverid1", approverId1);
//		model.addObject("approverid2", approverId2);
		request.getSession().setAttribute("LoginUser", loggedInUser);
//		if(loggedInFlag.equalsIgnoreCase("Y")){
//			model.setViewName("invalidSession");
//		}else{
			model.setViewName("primary");
//		}
			return model;
		}
		else{
			model.setViewName("invalidUser");
			return model;
		}

	}
	
	@RequestMapping(value = {"/","/signin"}, method = RequestMethod.GET)
	public ModelAndView signin(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("SignIn");

		return model;

	}
}
