$("document").ready(function(){
	
	   if ($("#listfitrTable").length > 0) {
	        $('#listfitrTable').dataTable( {
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
	                        { "sType": "string" }
	            ],
	            "aaSorting": [[ 1, "desc" ]]
	        } );
       
	        // Initialize FITR table
	        initFITR();
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


function initFITR() {
    // call service to get list of users and populate table
    $("#listfitrTable").dataTable().fnClearTable();
    var dtArray = new Array();
    console.log("you are here");
    fitrService.fetchFITRList("#status", function(data) {
    	console.log("Success Block");
    	console.log(data);
    	for (var i = 0; i < data.fitrList.length; i++) {
            var code = data.fitrList[i];
            //console.log(user.name);
			            dtArray.push([
					code.taxCode,
					code.fitr,
					code.user,
					code.effectiveDate,
					code.endDate,
					editHtml(code.taxCode, code.fitr,
							code.user, code.effectiveDate,
							code.endDate) ]);    
        }
        
    	$("#listfitrTable").dataTable().fnAddData(dtArray);
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
        initFITR();
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
     
    //console.log("Am inside change Password");
    $("#changetaxcode").val(valueArray[0]);
    $("#changefitr").val(valueArray[1]);
    $("#changeuserid").val(valueArray[2]);
    $("#changeeffectivedate").val(valueArray[3]);
    $("#changeenddate").val(valueArray[4]);
    $('#changePassword').modal('show');
}

function editHtml(taxCode,fitr,user,effectiveDate,endDate) {
    return '<button class="btn btn-mini btn-info" onclick="changePassword(\'' + taxCode +","+ fitr+","+user+","+effectiveDate+","+endDate+ '\');"><i class="icon-edit icon-white"></i>Edit</button>';
}