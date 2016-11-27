package com.fireme.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fireme.model.Job;
import com.fireme.service.JobService;

@Controller
@EnableWebMvc
public class JobController {
	
	@Inject
	JobService jobService;
	
	@RequestMapping(value = "/postJob", method = RequestMethod.POST)
	public String postJob(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("job") Job job){
		
		try {
			jobService.createJob(job);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jobPostConfirm";
	}
	
	@RequestMapping(value = "/jobsPostedByUser", method = RequestMethod.GET)
	@ResponseBody
	public List<Job> jobsPostedByUser(@RequestParam("username") String userName){
		List<Job> jobsPosted =  new ArrayList<>();
		try {
			jobsPosted = jobService.listJobsPostedByUser(userName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jobsPosted;
	}
}
