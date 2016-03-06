package com.fireme.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fireme.model.JobSeeker;
import com.fireme.model.User;
import com.fireme.service.UserService;

@Controller
public class JobSeekerController {
	
	@Inject
	private UserService userService;
	

	@RequestMapping(value="/registerJobSeeker",method=RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("jobSeeker") JobSeeker jobSeeker)
	{
		ModelAndView model= null;
		System.out.println("Inside JobSeeker register");
		
		User user = new User();
		user.setFirstName(jobSeeker.getFirstName());
		user.setLastName(jobSeeker.getLastName());
		user.setUserName(jobSeeker.getUserName());
		user.setPassword(jobSeeker.getPassword());
		user.setEmail(jobSeeker.getEmail());
		user.setPhoneNo(jobSeeker.getPhoneNo());
		user.setType("J");
		
		
		userService.registerJobSeeker(user, jobSeeker);
		
		try
		{
//			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return model;
	}
}
