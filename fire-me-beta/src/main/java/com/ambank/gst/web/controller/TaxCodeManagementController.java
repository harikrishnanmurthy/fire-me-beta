package com.ambank.gst.web.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ambank.gst.web.dao.TaxCodeDAO;
import com.ambank.gst.web.model.TaxCodeModel;
import com.ambank.gst.web.model.TaxCodeModelWrapper;

/**
 * Tax Code Management REST API
 */

@Controller
public class TaxCodeManagementController{

	private static final Logger logger = Logger.getLogger(TaxCodeManagementController.class);

	@Autowired
	private TaxCodeDAO taxCodeDao;

	@RequestMapping(value = "/taxcodes" , method = RequestMethod.GET)
    public @ResponseBody TaxCodeModelWrapper fetchAllTaxCodes(){
    	
		List<TaxCodeModel> taxCodeList = taxCodeDao.listTaxCodes();
		TaxCodeModelWrapper wrapper = new TaxCodeModelWrapper();
		wrapper.setTaxCodeList(taxCodeList);
		return wrapper;
		
    }
    
}
