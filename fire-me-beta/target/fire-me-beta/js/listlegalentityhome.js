$("document").ready(function(){
	
	   if ($("#listlegalentityTable").length > 0) {
	        $('#listlegalentityTable').dataTable( {
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
	                        { "sType": "string" }
	            ],
	            "aaSorting": [[ 1, "desc" ]]
	        } );
       
	        // Initialize FITR table
	        initLegalEntity();
	    }
});

$.validator.addMethod("loginRegexString", function(value, element) {
    return this.optional(element) || /^[a-zA-Z0-9 _-]+$/i.test(value);
}, "Please enter a valid character");

$('#changePasswordForm').validate({
    rules : {
    	entitycode : {
            required : true,
            minlength : 2,
            loginRegexString: true
        },
        entityname : {
            required : true,
            minlength : 2,
            loginRegexString: true
        },
        entitydesc : {
            required : true,
            minlength : 2,
            loginRegexString: true
        },
        busregnum : {
            required : true,
            minlength : 2,
            loginRegexString: true
        },
        gstregnum : {
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
    	
    	entitycode: {
            required: "You must enter a Entity Code",
            loginRegexPassword: "Please enter a valid Entity Code"
        },
        entityname: {
            required: "You must enter a Entity Name",
            loginRegexPassword: "Please enter a valid Entity Name"
        },
        entitydesc: {
            required: "You must enter a Entity Desc",
            loginRegexPassword: "Please enter a valid Entity Desc"
        },
        busregnum: {
            required: "You must enter a Bus Reg Num",
            loginRegexPassword: "Please enter a valid Bus Reg Num"
        },
        gstregnum: {
            required: "You must enter a GST Reg Num",
            loginRegexPassword: "Please enter a valid GST Reg Num"
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


function initLegalEntity() {
    // call service to get list of users and populate table
    $("#listlegalentityTable").dataTable().fnClearTable();
    var dtArray = new Array();
    console.log("you are here");
    legalentityService.fetchLegalEntityList("#status", function(data) {
    	console.log("Success Block");
    	console.log(data);
    	for (var i = 0; i < data.entityModelList.length; i++) {
            var code = data.entityModelList[i];
            //console.log(user.name);
			        dtArray.push([
					code.entityCode,
					code.entityName,
					code.entityDesc,
					code.busRegNum,
					code.gstRegNum,
					code.userId,
					code.effectiveStartDate,
					code.endDate,
					editHtml(code.entityCode,code.entityName,code.entityDesc,code.busRegNum,code.gstRegNum,
							code.userId, code.effectiveStartDate,
							code.endDate) ]);    
        }
        
    	$("#listlegalentityTable").dataTable().fnAddData(dtArray);
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
        initLegalEntity();
        // After validation, call change password service
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
    $("#changeentitycode").val(valueArray[0]);
    $("#changeentityname").val(valueArray[1]);
    $("#changeentitydesc").val(valueArray[2]);
    $("#changebusregnum").val(valueArray[3]);
    $("#changegstregnum").val(valueArray[4]);
    $("#changeuserid").val(valueArray[5]);
    $("#changeeffectivedate").val(valueArray[6]);
    $("#changeenddate").val(valueArray[7]);
    $('#changePassword').modal('show');
}

function editHtml(entityCode,entityName,entityDesc,busRegNum,gstRegNum,user,effectiveDate,endDate) {
    return '<button class="btn btn-mini btn-info" onclick="changePassword(\'' + entityCode +","+entityName+","+entityDesc+","+busRegNum+","+gstRegNum+","+user+","+effectiveDate+","+endDate+ '\');"><i class="icon-edit icon-white"></i>Edit</button>';
}