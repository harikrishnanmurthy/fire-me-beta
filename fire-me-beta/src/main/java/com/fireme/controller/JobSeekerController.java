package com.fireme.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fireme.model.Job;
import com.fireme.model.JobSeeker;
import com.fireme.model.User;
import com.fireme.service.JobSeekerService;
import com.fireme.service.UserService;

@Controller
@EnableWebMvc
public class JobSeekerController {

	@Inject
	private UserService userService;
	
	@Inject
	private JobSeekerService jobSeekerService;

	@Inject
    protected AuthenticationManager authenticationManager;
	
	@RequestMapping(value = "/registerJobSeeker", method = RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("jobSeeker") JobSeeker jobSeeker) {
		ModelAndView model = new ModelAndView();
		System.out.println("Inside JobSeeker register");
		User user = new User();
		try {
			user.setFirstName(jobSeeker.getFirstName());
			user.setLastName(jobSeeker.getLastName());
			user.setUserName(jobSeeker.getUserName());
			user.setPassword(jobSeeker.getPassword());
			user.setEmail(jobSeeker.getEmail());
			user.setPhoneNo(jobSeeker.getPhoneNo());
			user.setType("J");
			user.setRole("ROLE_USER");

			userService.registerJobSeeker(user, jobSeeker);
			authenticateUserAndSetSession(user, request);

		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addObject("fullname", user.getFirstName()+" "+ user.getLastName());
		model.addObject("username", user.getUserName());
		model.setViewName("menu");
		model.addObject("type", "J");
		return model;
	}

	@RequestMapping(value = "/listJobs", method = RequestMethod.GET)
	@ResponseBody
	public List<Job> listJobs(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside List Jobs");
		
		Authentication auth  = SecurityContextHolder.getContext().getAuthentication();
		
		String loggedInUser = auth.getName();
		
		System.out.println("Logged in User === " + loggedInUser);
		
		List<Job> jobList = new ArrayList<Job>();
		jobList.add(new Job("Vedel", "Java Developer", "VJ001"));
		jobList.add(new Job("Xchanging", "Java Developer", "XJ001"));
		jobList.add(new Job("BT", "Java Developer", "BJ001"));
		jobList.add(new Job("Randstad", "Java Developer", "RJ001"));
		jobList.add(new Job("Vedel", "Java Developer", "VJ001"));
		jobList.add(new Job("Xchanging", "Java Developer", "XJ001"));
		jobList.add(new Job("BT", "Java Developer", "BJ001"));
		jobList.add(new Job("Randstad", "Java Developer", "RJ001"));
		jobList.add(new Job("Vedel", "Java Developer", "VJ001"));
		jobList.add(new Job("Xchanging", "Java Developer", "XJ001"));
		jobList.add(new Job("BT", "Java Developer", "BJ001"));
		jobList.add(new Job("Randstad", "Java Developer", "RJ001"));
		jobList.add(new Job("Vedel", "Java Developer", "VJ001"));
		jobList.add(new Job("Xchanging", "Java Developer", "XJ001"));
		jobList.add(new Job("BT", "Java Developer", "BJ001"));
		jobList.add(new Job("Randstad", "Java Developer", "RJ001"));
		jobList.add(new Job("Vedel", "Java Developer", "VJ001"));
		jobList.add(new Job("Xchanging", "Java Developer", "XJ001"));
		jobList.add(new Job("BT", "Java Developer", "BJ001"));
		jobList.add(new Job("Randstad", "Java Developer", "RJ001"));
		return jobList;
	}
	
	@RequestMapping(value = "/jobSeekerprofile", method = RequestMethod.POST)
	public String updateRecruiterProfile(HttpServletRequest request, HttpServletResponse response,@RequestParam("resumename") String name,
			@ModelAttribute("jobSeeker") JobSeeker jobSeeker, @RequestParam("resume") MultipartFile file) {
		System.out.println("Inside update profile job seeker");
		try {
			String modifiedName = name.substring(name.lastIndexOf("\\")+1);
			jobSeeker.setProfileName(modifiedName);
			jobSeeker.setProfile(file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jobSeekerService.updateJobSeeker(jobSeeker);
		return "updateRecruiterProfile";
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
