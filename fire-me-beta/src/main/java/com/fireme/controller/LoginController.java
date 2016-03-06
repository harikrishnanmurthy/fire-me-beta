package com.fireme.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fireme.model.JobSeeker;
import com.fireme.model.User;
import com.fireme.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	@RequestMapping(value="/getUser")
	public void getUser()
	{
		userService.getUsers();
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("loginBean")User loginBean)
	{
		ModelAndView model= null;
		try
		{
			boolean isValidUser = userService.isValidUser(loginBean.getUserName(), loginBean.getPassword());
			if(isValidUser)
			{
				System.out.println("User Login Successful");
				request.setAttribute("loggedInUser", loginBean.getUserName());
				model = new ModelAndView("welcome");
			}
			else
			{
				model = new ModelAndView("login");
				model.addObject("loginBean", loginBean);
				request.setAttribute("message", "Invalid credentials!!");
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return model;
	}
	@RequestMapping(value="/registerJobSeeker",method=RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response,  @ModelAttribute("userBeen")User userBean,@ModelAttribute("jobSeekerBeen")JobSeeker jobSeekerBean)
	{
		ModelAndView model= null;
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
