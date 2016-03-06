$("document").ready(function(){
	
	   if ($("#listGstMappingTable").length > 0) {
	        $('#listGstMappingTable').dataTable( {
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
								{ "sType": "string" },
								{ "sType": "string" },
								{ "sType": "string" },
								{ "sType": "string" }
	            ],
	            "aaSorting": [[ 1, "desc" ]]
	        } );
	        // Initialize Tax Codes table
	        initGSTMapping();
	    }
});

$.validator.addMethod("loginRegexString", function(value, element) {
    return this.optional(element) || /^[a-zA-Z0-9 _-]+$/i.test(value);
}, "Please enter a valid character");

$('#changePasswordForm').validate({
    rules : {
    	src_cd : {
            required : true,
            minlength : 2,
            loginRegexString: true
        },
        pritransid : {
            minlength : 2,
            required : true,
            loginRegexString: true
        },
        sectransid : {
            minlength : 2,
            required : true,
            loginRegexString: true
        },
        ieflag : {
            minlength : 2,
            required : true,
            loginRegexString: true
        },
        ioflag : {
            minlength : 2,
            required : true,
            loginRegexString: true
        },
        taxcode0 : {
            minlength : 1,
            required : true,
            loginRegexString: true
        },
        txndesc : {
            minlength : 1,
            required : true,
            loginRegexString: true
        },
        effstart : {
            minlength : 10,
            required : true,
            loginRegexString: true
        },
        effend : {
            minlength : 10,
            required : true,
            loginRegexString: true
        }
    },
    messages: {
    	
    	src_cd: {
            required: "You must enter a Source System Code",
            loginRegexPassword: "Please enter a valid Source System Code"
        },
        pritransid: {
            required: "You must enter a Primary Transaction Code",
            loginRegexPassword: "Please enter a valid Primary Transaction Code"
        },
        sectransid: {
            required: "You must enter a Secondary ansaction Code",
            loginRegexPassword: "Please enter a valid Secondary Transaction Code"
        },
        ieflag: {
            required: "You must enter a I/E Indicator",
            loginRegexPassword: "Please enter a valid I/E Indicator"
        },
        ioflag: {
            required: "You must enter a I/O Flag",
            loginRegexPassword: "Please enter a valid I/O Relief Flag"
        },
        taxcode0: {
            required: "You must enter a Tax Code",
            loginRegexPassword: "Please enter a valid Tax Code"
        },
        txndesc: {
            required: "You must enter a Transaction Description",
            loginRegexPassword: "Please enter a valid Transaction Description"
        },
        effstart: {
            required: "You must enter a Effective Date",
            loginRegexPassword: "Please enter a valid Effective Date"
        },
        effend: {
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


function initGSTMapping() {
    // call service to get list of users and populate table
    $("#listGstMappingTable").dataTable().fnClearTable();
    var dtArray = new Array();
    console.log("you are here");
    gstMappingService.fetchEntryList("#status", function(data) {
    	console.log("Success Block");
    	console.log(data);
    	
    	for (var i = 0; i < data.mappingModelList.length; i++) {
            var code = data.mappingModelList[i];
            //console.log(user.name);
            dtArray.push([
					code.srcSysCode,
					code.primaryTransactionCode,
					code.secondaryTransactionCode,
					code.ieInd,
					code.tiFlag,
					code.taxCode0,
					code.transactionDesc,
					code.userId,
					code.effectiveDate,
					code.endDate,
					editHtml(code.srcSysCode, code.primaryTransactionCode,code.secondaryTransactionCode,
							code.ieInd, code.tiFlag, code.taxCode0,
							code.transactionDesc,code.userId,code.effectiveDate,code.endDate) ]);    
        }
    	$("#listGstMappingTable").dataTable().fnAddData(dtArray);
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
        initGSTMapping();
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
     
    $("#changesrcsyscode").val(valueArray[0]);
    $("#changepritxncode").val(valueArray[1]);
    $("#changesectxncode").val(valueArray[2]);
    $("#changeie").val(valueArray[3]);
    $("#changeio").val(valueArray[4]);
    $("#changetaxcode0").val(valueArray[5]);
    $("#changetxndesc").val(valueArray[6]);
    $("#changeuserid").val(valueArray[7]);
    $("#changeeffdate").val(valueArray[8]);
    $("#changeenddate").val(valueArray[9]);
    $('#changePassword').modal('show');
}

function editHtml(srcSysCode,primaryTransactionCode,secondaryTransactionCode,ieInd,tiFlag,taxCode0,transactionDesc,userId,effectivedate,enddate) {
    return '<button class="btn btn-mini btn-info" onclick="changePassword(\'' + srcSysCode +","+ primaryTransactionCode+ "," + secondaryTransactionCode+","+ieInd+","+tiFlag+","+taxCode0+","+transactionDesc+","+userId+","+effectivedate+","+enddate+ '\');"><i class="icon-edit icon-white"></i>Edit</button>';
}