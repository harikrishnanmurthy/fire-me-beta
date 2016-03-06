package com.ambank.gst.web.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ambank.gst.web.dao.ManageUserDAO;
import com.ambank.gst.web.model.User;
import com.ambank.gst.web.model.UserWrapper;

/**
 * User Management REST API
 */

@Controller
public class UserManagementController{

	private static final Logger logger = Logger.getLogger(UserManagementController.class);

	@Autowired
	private ManageUserDAO userDao;
	/**
     * Create User
     */
    @RequestMapping(value = "/createUser" , method = RequestMethod.GET)
    public ModelAndView createuser(@RequestParam("approverOneDomain") String domain,
			@RequestParam("lanId") String lanId,
			@RequestParam("name") String name,
			@RequestParam("role") String userRole,
			@RequestParam("approverOneLanID") String approverId1,
			@RequestParam("approverTwoLanId") String approverId2,
			@RequestParam("sourceSystem") String sourceSystem) {
    	
    	User user = new User(domain,lanId,name,lanId,userRole,approverId1,approverId2,sourceSystem);
    	System.out.println("Creating User Object == " + user);
    	String result = userDao.createuser(user);
    	ModelAndView model = new ModelAndView();
    	if(result.equalsIgnoreCase("success")){
    		model.setViewName("success");
    		model.addObject("message", "User Created Successfully");
    	}else{
    		model.setViewName("error");
    		model.addObject("message", "User creation Errored out. Please Check logs");
    	}
    	return model;
    }
    
    @RequestMapping(value = "/users" , method = RequestMethod.GET)
    public @ResponseBody UserWrapper fetchAllUsers(){
    	
    	List<User> userList = userDao.listUsers();
    	UserWrapper wrapper = new UserWrapper();
    	wrapper.setUserList(userList);
    	System.out.println("wrapper Object == " + wrapper);
    	return wrapper;
    }
    
    @RequestMapping(value = "/updateUser" , method = RequestMethod.POST)
    public @ResponseBody boolean updateUser(@RequestBody User user) {
    	
    	System.out.println("Updating User object ======== " + user);
    	String status = userDao.updateUser(user);
    	System.out.println("Printing Status from update query == " + status);
    	if(status.equalsIgnoreCase("success")){
    		return true;
    	}else{
    		return false;
    	}
    }
}
