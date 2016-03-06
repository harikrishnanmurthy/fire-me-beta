package com.ambank.gst.web.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ambank.gst.web.dao.FITRDAO;
import com.ambank.gst.web.dao.TaxCodeDAO;
import com.ambank.gst.web.model.FITRModel;
import com.ambank.gst.web.model.FITRModelWrapper;
import com.ambank.gst.web.model.TaxCodeModel;
import com.ambank.gst.web.model.TaxCodeModelWrapper;

/**
 * FITR Management REST API
 */

@Controller
public class FITRManagementController{

	private static final Logger logger = Logger.getLogger(FITRManagementController.class);

	@Autowired
	private FITRDAO fitrDao;

	@RequestMapping(value = "/fitrcodes" , method = RequestMethod.GET)
    public @ResponseBody FITRModelWrapper fetchAllFITRCodes(){
    	
		List<FITRModel>fitrList = fitrDao.listFITR();
		FITRModelWrapper wrapper = new FITRModelWrapper();
		wrapper.setFitrList(fitrList);
		return wrapper;
		
    }
    
}
