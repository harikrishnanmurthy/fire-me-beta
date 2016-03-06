package com.fireme.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fireme.model.JobSeeker;
import com.fireme.service.UserService;

@Controller
public class JobSeekerController {
	
	@Inject
	private UserService userService;
	

	@RequestMapping(value="/registerJobSeeker",method=RequestMethod.GET)
	public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView model= null;
		System.out.println("Inside recruiter register");
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
