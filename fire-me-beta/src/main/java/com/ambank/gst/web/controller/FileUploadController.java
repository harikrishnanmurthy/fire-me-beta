package com.ambank.gst.web.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ambank.core.utility.xlsreader.XLSReaderUtility;
import com.ambank.gst.web.model.FileListWrapper;
import com.ambank.gst.web.model.TransactionOutputTaxManual;

import net.sf.jxls.transformer.XLSTransformer;

/**
 * Handles requests for the application file upload requests
 */

@Controller
public class FileUploadController{

	private static final Logger logger = Logger.getLogger(FileUploadController.class);

	private static String finalGstFile = System.getenv("FINALGSTSUCCESS");
	
	private static String errorgstFile = System.getenv("FINALGSTFAIL");
	
	private static String xlsFileName = null;
	
	@Autowired
	@Qualifier("customerProperties")
	Properties customerProperties;
	
	@Autowired
	@Qualifier("transactionProperties")
	Properties transactionProperties;
	
	public Properties getCustomerProperties() {
		return customerProperties;
	}

	public void setCustomerProperties(Properties customerProperties) {
		this.customerProperties = customerProperties;
	}

	public Properties getTransactionProperties() {
		return transactionProperties;
	}

	public void setTransactionProperties(Properties transactionProperties) {
		this.transactionProperties = transactionProperties;
	}
	
	/**
     * Downloads the GCR GST Template
     */
    @RequestMapping(value = "/downloadTemplate" , method = RequestMethod.GET)
    public void downloadTemplate(HttpServletResponse response) {
    
    	logger.debug("Entering Download File Path");
    	logger.debug(System.getenv("TEMPLATEDOWNLOAD"));
    	String str = "Tax-ManualTemplatev0.1.xlsx";
    	File file = new File(System.getenv("TEMPLATEDOWNLOAD")+ File.separator +File.separator+str);
        //response.setContentType("application/xls"); //in my example this was an xls file
        response.setContentLength(new Long(file.length()).intValue());
        response.setHeader("Content-Disposition","attachment; filename="+str );
 
        try {
            FileCopyUtils.copy(new FileInputStream(file), response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	/**
     * Uploads the file for GST Calculation
     */
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public @ResponseBody ModelAndView uploadFileHandler(@RequestParam("name") String name,
            @RequestParam("file") MultipartFile file) {
 
     
        	logger.debug("File Size == " + file.getSize());
            try {
                byte[] bytes = file.getBytes();
                //Fix for IE
                if(name.lastIndexOf("\\")>0){
                	name=name.substring(name.lastIndexOf("\\")+1);
                }
                logger.debug("Name of the file ==== " + name);
                
                xlsFileName = name;
                
                // Creating the directory to store file
                String rootPath = System.getenv("TEMPGSTFILE");
                logger.debug("Temp GST File Root Path ==" + rootPath);
                File dir = new File(rootPath);
                if (!dir.exists())
                    dir.mkdirs();
 
                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + name);
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();
 
                logger.info("Temp GST File Location="+ serverFile.getAbsolutePath());
                
                List<TransactionOutputTaxManual> transList = XLSReaderUtility.fetchPOJOFromXLS(serverFile.getAbsolutePath(), transactionProperties);
                List<TransactionOutputTaxManual> errorObjList = new ArrayList<TransactionOutputTaxManual>();
                
                if(null!=transList && transList.size()<=0){
                	
                	ModelAndView model = new ModelAndView("main");
                    model.addObject("message","No records Found");
                    model.addObject("uploadflag", "fail");
                    return model;
                	
                }
//                for(TransactionOutputTaxManual outputTax : transList){
//                	
//                	TransactionDetailsBO detailsBo = new TransactionDetailsBO();
//                	detailsBo.setSourceSystemCode(outputTax.getSourceSystemCode());
//                	detailsBo.setTransactionCode(outputTax.getTransactionCode());
//                	detailsBo.setTransactionBranchCode(outputTax.getTransactionBranchCode());
//                	detailsBo.setTransactionHomeBranchCode(outputTax.getHomebranchCode());
//                	detailsBo.setTransactionFeeAmount(outputTax.getTransactionAmountRM());
//                	detailsBo.setLegalEntityCode(outputTax.getLegalEntity());
//                	detailsBo.setGstReliefFlag(outputTax.getGstReliefFlag());
//                	GSTComputeCalImpl calImpl = new GSTComputeCalImpl();
//                	try {
//						TransactionDetailsResponseBO respbo = calImpl.calculateGST(detailsBo);
//						outputTax.setGstAmountRM(respbo.getGstAmount());
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						outputTax.setError(e.getMessage());
//						errorObjList.add(outputTax);
//					}
//                }
                
                Map beans = new HashMap();
                beans.put("transList", transList);
                XLSTransformer transformer = new XLSTransformer();
              //Inspecting if the error list is empty and returning the appropriate file.
                if(null!=errorObjList && errorObjList.size()<=0){
                try {
        			transformer.transformXLS("C:\\Documents and Settings\\c0001646\\Desktop\\gst_web_jxls\\basictags.xls", beans, finalGstFile+File.separator +File.separator+"Output.xls");
        		}  catch (Exception e) {
        			e.printStackTrace();
        		}
                	ModelAndView model = new ModelAndView("main");
                	model.addObject("message","You have Successfully Uploaded file " + name );
                	model.addObject("uploadflag", "success");
                	return model;
                }else{
                	try {
            			transformer.transformXLS("C:\\Documents and Settings\\c0001646\\Desktop\\gst_web_jxls\\basictags.xls", beans, errorgstFile+File.separator +File.separator+"Output.xls");
            		}  catch (Exception e) {
            			// TODO Auto-generated catch block
            			e.printStackTrace();
            		}
                	ModelAndView model = new ModelAndView("main");
                    model.addObject("message","Upload Failed because of validation Errors");
                    model.addObject("uploadflag", "error");
                    return model;
                }
                
            } catch (Exception e) {
	            	ModelAndView model = new ModelAndView("main");
	                model.addObject("message","Failed due to System Problem" );
	                model.addObject("uploadflag", "failure");
	                return model;
            }
        } 
 
    
	/**
     * Downloads the GST Computed File
     */
    @RequestMapping(value = "/downloadGstCalcFile" , method = RequestMethod.GET)
    public void downloadGstCalcFile(HttpServletResponse response) {
        
    	logger.debug("Entering GST File Download");
    	logger.debug("Path for the Final GSt File == " + finalGstFile);
    	String str = "Output.xls";
    	File file = new File(finalGstFile+ File.separator +File.separator+str);
        //response.setContentType("application/xls"); //in my example this was an xls file
        response.setContentLength(new Long(file.length()).intValue());
        response.setHeader("Content-Disposition","attachment; filename="+str);
 
        try {
            FileCopyUtils.copy(new FileInputStream(file), response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
	/**
     * Downloads the GST Error File
     */
    @RequestMapping(value = "/downloadGstErrorFile" , method = RequestMethod.GET)
    public void downloadGstErrorFile(HttpServletResponse response) {
        
    	logger.debug("Entering GST File Download");
    	logger.debug("Path for the Final GSt File == " + errorgstFile);
    	String str = "Output.xls";
    	File file = new File(errorgstFile+ File.separator +File.separator+str);
        //response.setContentType("application/xls"); //in my example this was an xls file
        response.setContentLength(new Long(file.length()).intValue());
        response.setHeader("Content-Disposition","attachment; filename="+str );
 
        try {
            FileCopyUtils.copy(new FileInputStream(file), response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Uploads the file to GCR
     */
    @RequestMapping(value = "/uploadgcrFile", method = RequestMethod.POST)
    public @ResponseBody ModelAndView uploadgcrFileHandler(@RequestParam("name") String name,
            @RequestParam("gcrfile") MultipartFile file) {
 
    	
    	System.out.println("*************Am in upload gcr file******************");
    	
    	
     
        	System.out.println("File Size == " + file.getSize());
            try {
                byte[] bytes = file.getBytes();
                //Fix for IE
                if(name.lastIndexOf("\\")>0){
                	name=name.substring(name.lastIndexOf("\\")+1);
                }
                System.out.println("Name of the file ==== " + name);
                
                xlsFileName = name;
                
                // Creating the directory to store file
                String rootPath = System.getenv("TEMPGSTFILE");
                System.out.println("Temp GST File Root Path ==" + rootPath);
                File dir = new File(rootPath);
                if (!dir.exists())
                    dir.mkdirs();
 
                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + name);
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();
                
                ModelAndView model = new ModelAndView("main");
            	model.addObject("gcrmessage","GCR file Upload Completed" + name );
            	model.addObject("gcruploadflag", "success");
            	return model;
                
            } catch (Exception e) {
	            	ModelAndView model = new ModelAndView("main");
	                model.addObject("gcrmessage"," File Upload failed due to System Problem" );
	                model.addObject("gcruploadflag", "failure");
	                return model;
            }
        }
    
    
    @RequestMapping(value = "/listAllFiles" , method = RequestMethod.GET)
    public @ResponseBody FileListWrapper listAllFileshandler(){
    	
    	logger.debug("Am inside List all file handler");
    	File dir = new File(System.getenv("GSTUPLOAD")+ File.separator + "tmpFiles");
    	//String[] extensions = new String[] {"xls", "xml", "pdf", "jsp","java" };
    	List<String> fileList = new ArrayList<String>();
		try {
			logger.debug("Getting all files in " + dir.getCanonicalPath()
					+ " including those in subdirectories");
			
			List<File> files = (List<File>) FileUtils.listFiles(dir, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
			for (File file : files) {
				fileList.add(file.getCanonicalPath());
			}
			logger.debug("File List == " + fileList);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FileListWrapper lstWrapper = new FileListWrapper();
		lstWrapper.setFilelist(fileList);
    	return lstWrapper;
    }
}
