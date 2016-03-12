package com.fireme.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fireme.model.Recruiter;
import com.fireme.model.User;
import com.fireme.service.UserService;

@Controller
public class RecruiterController {
	
	@Inject
	private UserService userService;
	

	@RequestMapping(value="/registerRecruiter",method=RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("recruiter") Recruiter recruiter)
	{
		ModelAndView model= new ModelAndView();
		System.out.println("Inside JobSeeker register");
		
		User user = new User();
		user.setFirstName(recruiter.getFirstName());
		user.setLastName(recruiter.getLastName());
		user.setUserName(recruiter.getUserName());
		user.setPassword(recruiter.getPassword());
		user.setEmail(recruiter.getEmail());
		user.setPhoneNo(recruiter.getPhoneNo());
		user.setType("R");
		
		
		userService.registerRecruiter(user, recruiter);
		
		try
		{
//			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		model.setViewName("menu");
		return model;
	}
}
