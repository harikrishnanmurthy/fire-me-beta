$("document").ready(function(){
	
	   if ($("#userTable").length > 0) {
	        $('#userTable').dataTable( {
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
	            ],
	            "aaSorting": [[ 1, "desc" ]]
	        } );
       
	        // Initialize Database table
	        initUsers();
	    }
});

$.validator.addMethod("loginRegexString", function(value, element) {
    return this.optional(element) || /^[a-zA-Z0-9 _-]+$/i.test(value);
}, "Please enter a valid character");

$('#changePasswordForm').validate({
    rules : {
    	userid : {
            required : true,
            minlength : 2,
            loginRegexString: true
        },
        name : {
            minlength : 2,
            required : true,
            loginRegexString: true
        },
        empno : {
            minlength : 2,
            required : true,
            loginRegexString: true
        },
        domainid : {
            minlength : 1,
            required : true,
            loginRegexString: true
        },
        roleid : {
            minlength : 1,
            required : true,
            loginRegexString: true
        },
        appid1 : {
            minlength : 2,
            required : true,
            loginRegexString: true
        },
        appid2 : {
            minlength : 2,
            required : true,
            loginRegexString: true
        },
        sourcesystem : {
            minlength : 2,
            required : true,
            loginRegexString: true
        }
    },
    messages: {
    	
    	userid: {
            required: "You must enter a User Id",
            loginRegexPassword: "Please enter a valid User Id"
        },
        name: {
            required: "You must enter a Name",
            loginRegexPassword: "Please enter a valid Name"
        },
        empno: {
            required: "You must enter a Employee Number",
            loginRegexPassword: "Please enter a valid Employee Number"
        },
        domainid: {
            required: "You must enter a Domain Id",
            loginRegexPassword: "Please enter a valid Domain Id"
        },
        roleid: {
            required: "You must enter a Role Id",
            loginRegexPassword: "Please enter a valid Role Id"
        },
        appid1: {
            required: "You must enter a Approver Id",
            loginRegexPassword: "Please enter a valid Approver Id"
        },
        appid2: {
            required: "You must enter a Approver Id",
            loginRegexPassword: "Please enter a valid Approver Id"
        },
        sourcesystem: {
            required: "You must enter a Source System",
            loginRegexPassword: "Please enter a valid Source System"
        }
    },
    highlight : function(label) {
        $(label).closest('.control-group').removeClass('error success').addClass('error');
    },
    success: function(label) {
        $(label).closest('.control-group').removeClass('error success').addClass('success');
    }
});


function initUsers() {
    // call service to get list of users and populate table
    $("#userTable").dataTable().fnClearTable();
    var dtArray = new Array();
    console.log("you are here");
    userService.getUserList("#status", function(data) {
    	console.log("Success Block");
    	console.log(data);
    	for (var i = 0; i < data.userList.length; i++) {
            var user = data.userList[i];
            //console.log(user.name);
			            dtArray.push([
					user.lanId,
					user.name,
					user.employeeNo,
					user.domainId,
					user.userRole,
					user.approverId1,
					user.approverId2,
					user.sourceSystem,
					editHtml(user.lanId, user.name,
							user.employeeNo, user.domainId, user.userRole,
							user.approverId1, user.approverId2, user.sourceSystem) ]);    
        }
        
    	$("#userTable").dataTable().fnAddData(dtArray);
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
        // After validation, call change password service
        var userid = $("#changePasswordForm input[name=userid]").val();
        var name = $("#changePasswordForm input[name=name]").val();
        var empno = $("#changePasswordForm input[name=empno]").val();
        var domainid = $("#changePasswordForm input[name=domainid]").val();
        var roleid = $("#changePasswordForm input[name=roleid]").val();
        var appid1 = $("#changePasswordForm input[name=appid1]").val();
        var appid2 = $("#changePasswordForm input[name=appid2]").val();
        var sourcesystem = $("#changePasswordForm input[name=sourcesystem]").val();
        
        userService.changePassword("#changePasswordStatus",userid,name,empno,domainid,roleid,appid1,appid2,sourcesystem,function(data) {
        	console.log("Data from Update Operation === " + data);
            if (data==true) {
                resetPasswordScreen();
                $("#changePassword").modal('hide');
                if ($("#userTable").length > 0) {
                	initUsers();
                    addAlert("#status", "success", "The Update was Successful.");
                } else {
                    addAlert("#changePasswordStatus", "success", "The Update was Successful");
                }
            } else {
                if ($("#userTable").length > 0) {
                    addAlert("#changePasswordStatus", "error", "There was a problem while updating the field");
                } else {
                    addAlert("#changePasswordStatus", "error", "There was a problem while updating the field");
                }
            }
        },  function( xhr, err ) { 
                if ($("#userTable").length > 0) {
                    xhrErr( "#changePasswordStatus", xhr, err, "Field Updation errored out" ); 
                } else {
                    xhrErr( "#changePasswordStatus", xhr, err, "Field Updation errored out" ); 
                }
        });
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
    $("#changeuserid").val(valueArray[0]);
    $("#changename").val(valueArray[1]);
    $("#changeempno").val(valueArray[2]);
    $("#changedomainid").val(valueArray[3]);
    $("#changeroleid").val(valueArray[4]);
    $("#changeappid1").val(valueArray[5]);
    $("#changeappid2").val(valueArray[6]);
    $("#changesourcesystem").val(valueArray[7]);
    $('#changePassword').modal('show');
}

function editHtml(lanId,name,employeeNo,domainId,userRole,approverId1,approverId2,sourceSystem) {
    return '<button class="btn btn-mini btn-info" onclick="changePassword(\'' + lanId +","+ name+","+employeeNo+","+domainId+","+userRole+","+approverId1+","+approverId2+","+sourceSystem + '\');"><i class="icon-edit icon-white"></i>Edit</button>';
}