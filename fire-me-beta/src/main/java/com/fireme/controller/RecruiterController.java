package com.fireme.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
	
	@Inject
    protected AuthenticationManager authenticationManager;
	
	@RequestMapping(value="/registerRecruiter",method=RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("recruiter") Recruiter recruiter)
	{
		ModelAndView model= new ModelAndView();
		System.out.println("Inside JobSeeker register");
		
		User user = new User();

		try
		{
			user.setFirstName(recruiter.getFirstName());
			user.setLastName(recruiter.getLastName());
			user.setUserName(recruiter.getUserName());
			user.setPassword(recruiter.getPassword());
			user.setEmail(recruiter.getEmail());
			user.setPhoneNo(recruiter.getPhoneNo());
			user.setType("R");
			user.setRole("ROLE_USER");
			
			userService.registerRecruiter(user, recruiter);
			authenticateUserAndSetSession(user, request);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		model.addObject("fullname", user.getFirstName()+" "+ user.getLastName());
		model.addObject("username", user.getUserName());
		model.setViewName("menu");
		model.addObject("type", "R");
		return model;
	}
	
    private void authenticateUserAndSetSession(User user, HttpServletRequest request) {
        String username = user.getUserName();
        String password = user.getPassword();

        // generate session if one doesn't exist
        request.getSession();

        Authentication authenticatedUser = new UsernamePasswordAuthenticationToken(username, password);
        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
    }

}
