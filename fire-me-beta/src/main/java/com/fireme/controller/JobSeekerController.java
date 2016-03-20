package com.fireme.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fireme.model.Job;
import com.fireme.model.JobSeeker;
import com.fireme.model.JobWrapper;
import com.fireme.model.User;
import com.fireme.service.UserService;

@Controller
@EnableWebMvc
public class JobSeekerController {

	@Inject
	private UserService userService;

	@RequestMapping(value = "/registerJobSeeker", method = RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("jobSeeker") JobSeeker jobSeeker) {
		ModelAndView model = new ModelAndView();
		System.out.println("Inside JobSeeker register");
		try {
			User user = new User();
			user.setFirstName(jobSeeker.getFirstName());
			user.setLastName(jobSeeker.getLastName());
			user.setUserName(jobSeeker.getUserName());
			user.setPassword(jobSeeker.getPassword());
			user.setEmail(jobSeeker.getEmail());
			user.setPhoneNo(jobSeeker.getPhoneNo());
			user.setType("J");

			userService.registerJobSeeker(user, jobSeeker);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.setViewName("menu");
		model.addObject("type", "J");
		return model;
	}

	@RequestMapping(value = "/listJobs", method = RequestMethod.GET)
	@ResponseBody
	public List<Job> listJobs(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside List Jobs");
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
}
