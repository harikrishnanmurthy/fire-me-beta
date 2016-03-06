package com.ambank.gst.web.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ambank.gst.web.dao.FITRDAO;
import com.ambank.gst.web.dao.LegalEntityDAO;
import com.ambank.gst.web.dao.TaxCodeDAO;
import com.ambank.gst.web.model.FITRModel;
import com.ambank.gst.web.model.FITRModelWrapper;
import com.ambank.gst.web.model.LegalEntityModel;
import com.ambank.gst.web.model.LegalEntityModelWrapper;
import com.ambank.gst.web.model.TaxCodeModel;
import com.ambank.gst.web.model.TaxCodeModelWrapper;

/**
 * FITR Management REST API
 */

@Controller
public class LegalEntityManagementController{

	private static final Logger logger = Logger.getLogger(LegalEntityManagementController.class);

	@Autowired
	private LegalEntityDAO legalDao;

	@RequestMapping(value = "/legalentitycodes" , method = RequestMethod.GET)
    public @ResponseBody LegalEntityModelWrapper fetchAllLegalEntities(){
    	
		List<LegalEntityModel>entityModelList = legalDao.listLegalEntity();
		LegalEntityModelWrapper wrapper = new LegalEntityModelWrapper();
		wrapper.setEntityModelList(entityModelList);
		return wrapper;
		
    }
    
}
