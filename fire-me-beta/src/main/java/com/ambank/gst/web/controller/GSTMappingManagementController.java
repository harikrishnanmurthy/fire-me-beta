package com.ambank.gst.web.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ambank.gst.web.dao.GSTMappingDAO;
import com.ambank.gst.web.model.GSTMappingModel;
import com.ambank.gst.web.model.GSTMappingModelWrapper;

/**
 * GST Mapping Management REST API
 */

@Controller
public class GSTMappingManagementController{

	private static final Logger logger = Logger.getLogger(GSTMappingManagementController.class);

	@Autowired
	private GSTMappingDAO mappingDao;

	@RequestMapping(value = "/gstmapping" , method = RequestMethod.GET)
    public @ResponseBody GSTMappingModelWrapper fetchAllTaxCodes(){
    	
		List<GSTMappingModel> mappingList = mappingDao.listGSTMappingEntries();
		GSTMappingModelWrapper wrapper = new GSTMappingModelWrapper();
		wrapper.setMappingModelList(mappingList);
		return wrapper;
		
    }
    
}
