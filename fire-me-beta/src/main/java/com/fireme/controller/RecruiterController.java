package com.fireme.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fireme.model.EmailCriteria;
import com.fireme.model.JobSeeker;
import com.fireme.model.Recruiter;
import com.fireme.model.User;
import com.fireme.service.JobSeekerService;
import com.fireme.service.UserService;
import com.fireme.utilities.SendMailSSL;
import com.fireme.utilities.SendSMS;

@Controller
public class RecruiterController {
	
	@Inject
	private UserService userService;
	
	@Inject
	private JobSeekerService jobSeekerService;
	
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
	
	@RequestMapping(value="/listjobseekers",method=RequestMethod.GET)
	@ResponseBody
	public List<JobSeeker> listJobSeekers(){
		List<JobSeeker> jobSeekerList = new ArrayList<JobSeeker>();
		jobSeekerList = jobSeekerService.listJobSeekers();
		return jobSeekerList;
	}
	
	@RequestMapping(value="/profiledownload",method=RequestMethod.GET)
	public void findJobSeeker(@RequestParam("username") String userName, HttpServletResponse response){
		JobSeeker jobSeeker = jobSeekerService.findJobSeeker(userName);
		try {
			File file = new File(System.getProperty("user.home")+ File.separator +File.separator+ jobSeeker.getProfileName());
			FileUtils.writeByteArrayToFile(file, jobSeeker.getProfile());
		    
		    response.setContentLength(new Long(file.length()).intValue());
	        response.setHeader("Content-Disposition","attachment; filename="+jobSeeker.getProfileName());
	        
	        FileCopyUtils.copy(new FileInputStream(file), response.getOutputStream());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/sendemail",method=RequestMethod.POST)
	@ResponseBody
	public void sendEmail(@RequestBody EmailCriteria criteria){
		JobSeeker jobSeeker = jobSeekerService.findJobSeeker(criteria.getUserName());
		String recipientEmail = jobSeeker.getEmail();
		SendMailSSL.sendEmail(recipientEmail, criteria.getMessage());
	}
	
	@RequestMapping(value="/sendsms",method=RequestMethod.POST)
	@ResponseBody
	public void sendSMS(@RequestBody EmailCriteria criteria){
		JobSeeker jobSeeker = jobSeekerService.findJobSeeker(criteria.getUserName());
		String phoneNumber = jobSeeker.getPhoneNo();
		SendSMS.sendSMS(phoneNumber,criteria.getMessage());
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
