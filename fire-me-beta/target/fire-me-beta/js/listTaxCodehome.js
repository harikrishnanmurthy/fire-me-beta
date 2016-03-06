$("document").ready(function(){
	
	   if ($("#listTaxCodeTable").length > 0) {
	        $('#listTaxCodeTable').dataTable( {
	            "sDom": "<'row'<'span4'l><'span8'f>r>t<'row'<'span6'i><'span6'p>>",
	            "bLengthChange": false,
	            "bInfo": false,
	            "sPaginationType": "bootstrap",
	            "oLanguage": {
	                "sLengthMenu": "_MENU_ records per page"
	            },
	            "aoColumns": [
	                        { "sType": "string" },
	                        { "sType": "string" },
	                        { "sType": "string" },
	                        { "sType": "string" },
	                        { "sType": "string" },
	                        { "sType": "string" },
	                        { "sType": "string" },
	                        { "sType": "string" }
	            ],
	            "aaSorting": [[ 1, "desc" ]]
	        } );
       
	        // Initialize Tax Codes table
	        initTaxCodes();
	    }
});

$.validator.addMethod("loginRegexString", function(value, element) {
    return this.optional(element) || /^[a-zA-Z0-9 _-]+$/i.test(value);
}, "Please enter a valid character");

$('#changePasswordForm').validate({
    rules : {
    	tax_cd : {
            required : true,
            minlength : 2,
            loginRegexString: true
        },
        fitr : {
            minlength : 2,
            required : true,
            loginRegexString: true
        },
        tax_cd_desc : {
            minlength : 2,
            required : true,
            loginRegexString: true
        },
        user_id : {
            minlength : 1,
            required : true,
            loginRegexString: true
        },
        effective_date : {
            minlength : 10,
            required : true,
            loginRegexString: true
        },
        end_date : {
            minlength : 10,
            required : true,
            loginRegexString: true
        }
    },
    messages: {
    	
    	tax_cd: {
            required: "You must enter a Tax Code",
            loginRegexPassword: "Please enter a valid Tax Code"
        },
        fitr: {
            required: "You must enter a FITR",
            loginRegexPassword: "Please enter a valid FITR"
        },
        tax_cd_desc: {
            required: "You must enter a Tax Code Description",
            loginRegexPassword: "Please enter a valid Tax Code Description"
        },
        user_id: {
            required: "You must enter a User Id",
            loginRegexPassword: "Please enter a valid User Id"
        },
        effective_date: {
            required: "You must enter a Effective Date",
            loginRegexPassword: "Please enter a valid Effective Date"
        },
        end_date: {
            required: "You must enter a End Date",
            loginRegexPassword: "Please enter a valid End Date"
        }
    },
    highlight : function(label) {
        $(label).closest('.control-group').removeClass('error success').addClass('error');
    },
    success: function(label) {
        $(label).closest('.control-group').removeClass('error success').addClass('success');
    }
});


function initTaxCodes() {
    // call service to get list of users and populate table
    $("#listTaxCodeTable").dataTable().fnClearTable();
    var dtArray = new Array();
    console.log("you are here");
    taxCodeService.fetchTaxCodeList("#status", function(data) {
    	console.log("Success Block");
    	console.log(data);
    	for (var i = 0; i < data.taxCodeList.length; i++) {
            var code = data.taxCodeList[i];
            //console.log(user.name);
			            dtArray.push([
					code.taxCode,
					code.taxRate,
					code.taxInvoiceFlag,
					code.taxCodeDesc,
					code.user,
					code.effectiveDate,
					code.endDate,
					editHtml(code.taxCode, code.taxRate,code.taxInvoiceFlag,
							code.taxCodeDesc, code.user, code.effectiveDate,
							code.endDate) ]);    
        }
        
    	$("#listTaxCodeTable").dataTable().fnAddData(dtArray);
    },  function( xhr, err ) { 
        xhrErr( "#status", xhr, err, "There was a problem getting the list of users." ); 
    });
}

$("#changePasswordAction").click(function() {
    // Reset error classes
    $("#changePasswordForm .control-group").removeClass("error success");
    $('#changePasswordForm').validate().resetForm();
    $("#changePasswordStatus").empty();        
    
    if ($('#changePasswordForm').validate().form()) {
        console.log("form validated");
        $("#changePasswordForm").submit();
        resetPasswordScreen();
        $("#changePassword").modal('hide');
        initTaxCodes();
        // After validation, call change password service
/*        var taxcode = $("#changePasswordForm input[name=taxcode]").val();
        var fitr = $("#changePasswordForm input[name=fitr]").val();
        var taxcodedesc = $("#changePasswordForm input[name=taxcodedesc]").val();
        var userid = $("#changePasswordForm input[name=userid]").val();
        var effectivedate = $("#changePasswordForm input[name=effectivedate]").val();
        var enddate = $("#changePasswordForm input[name=enddate]").val();
        
        userService.changePassword("#changePasswordStatus",userid,name,empno,domainid,roleid,appid1,appid2,sourcesystem,function(data) {
        	console.log("Data from Update Operation === " + data);
            if (data==true) {
                resetPasswordScreen();
                $("#changePassword").modal('hide');
                if ($("#listTaxCodeTable").length > 0) {
                	initTaxCodes();
                    addAlert("#status", "success", "The Update was Successful.");
                } else {
                    addAlert("#changePasswordStatus", "success", "The Update was Successful");
                }
            } else {
                if ($("#listTaxCodeTable").length > 0) {
                    addAlert("#changePasswordStatus", "error", "There was a problem while updating the field");
                } else {
                    addAlert("#changePasswordStatus", "error", "There was a problem while updating the field");
                }
            }
        },  function( xhr, err ) { 
                if ($("#listTaxCodeTable").length > 0) {
                    xhrErr( "#changePasswordStatus", xhr, err, "Field Updation errored out" ); 
                } else {
                    xhrErr( "#changePasswordStatus", xhr, err, "Field Updation errored out" ); 
                }
        });*/
    } else {
        console.log("form not valid");
    }        
});

$("#changePasswordCancel").click(function() {
    // Reset error classes
    resetPasswordScreen();
    $("#changePassword").modal('hide');
});


function resetPasswordScreen() {
    $("#changePasswordForm .control-group").removeClass("error success");
   // $('#changePasswordForm').validate().resetForm();
    $("#changePasswordStatus").empty();    
    $("#changePasswordForm")[0].reset();
}

function changePassword(combinedString) {
    // Retrieve userId and populate hidden field
    resetPasswordScreen();
    var valueArray = combinedString.split(",");
     
    //console.log("Am inside change Password");
    $("#changetaxcode").val(valueArray[0]);
    $("#changetaxrate").val(valueArray[1]);
    $("#changetaxinvoiceflag").val(valueArray[2]);
    $("#changetaxcodedesc").val(valueArray[3]);
    $("#changeuserid").val(valueArray[4]);
    $("#changeeffectivedate").val(valueArray[5]);
    $("#changeenddate").val(valueArray[6]);
    $('#changePassword').modal('show');
}

function editHtml(taxCode,taxRate, taxInvoiceFlag, taxCodeDesc,user,effectiveDate,endDate) {
    return '<button class="btn btn-mini btn-info" onclick="changePassword(\'' + taxCode +","+ taxRate+","+taxInvoiceFlag+","+taxCodeDesc+","+user+","+effectiveDate+","+endDate+ '\');"><i class="icon-edit icon-white"></i>Edit</button>';
}