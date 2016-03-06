$("document").ready(function(){
	
	   if ($("#fitrTable").length > 0) {
	        $('#fitrTable').dataTable( {
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
	                        { "sType": "string" }
	            ],
	            "aaSorting": [[ 1, "desc" ]]
	        } );
	        // Initialize Database table
	        initDatabase();
	        
	    }
});

function initDatabase() {
    // call service to get list of users and populate table
    $("#fitrTable").dataTable().fnClearTable();
    var dtArray = new Array();
    
    fitrService.getFITRList("#status", function(data) {
    	
    	if(null!=data){
    	for (var i = 0; i < data.ids.fitrCodes.length; i++) {
            var obj = data.ids.fitrCodes[i];
            
			        dtArray.push([ obj.taxCode,obj.fitr,obj.userId,obj.effectiveDate,obj.endDate,
					approveTask(obj.processInstanceId,obj.taxCode,obj.fitr,obj.userId,obj.effectiveDate,obj.endDate),
					rejectTaskWorkflow(obj.processInstanceId) ]);    
        	}
    	
    		$("#fitrTable").dataTable().fnAddData(dtArray);
    	}
    },  function( xhr, err ) { 
        xhrErr( "#status", xhr, err, "There was a problem getting the uploaded files list." ); 
    });
}

$("#changePasswordAction").click(function() {
    // Reset error classes
    $("#changePasswordForm .control-group").removeClass("error success");
    $('#changePasswordForm').validate().resetForm();
    $("#changePasswordStatus").empty();        
    
        // After validation, call change password service
        var taskId = $("#changePasswordForm input[name=rejectTaskId]").val();
        var reason = $("#changePasswordForm input[name=rejectreason]").val();
     
    	//calling Task Rejection Service Service
        fitrService.rejectTask("#status", taskId, reason, function(data){
    		resetPasswordScreen();
            $("#rejectGSTTask").modal('hide');
    		initDatabase();
        },  function( xhr, err ) { 
            xhrErr( "#status", xhr, err, "There was a problem getting the uploaded files list." ); 
        });

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

function completeTask(combinedString){
	
	var valueArray = combinedString.split(",");
	
	//calling Task Completion Service
	fitrService.completeTask("#status", valueArray[0], valueArray[1],valueArray[2],valueArray[3],valueArray[4],valueArray[5],function(data){
		initDatabase();
    },  function( xhr, err ) { 
        xhrErr( "#status", xhr, err, "There was a problem getting the uploaded files list." ); 
    });
}

function returnBackTask(objId){
	
	resetPasswordScreen();
	$("#rejectTaskId").val(objId);
	$('#rejectGSTTask').modal('show');
}

function approveTask(objId,taxCode,fitr,userId, effectivedate, enddate) {
    return '<button class="btn btn-mini btn-success" onclick="completeTask(\'' +objId+","+taxCode+","+fitr+","+userId+","+effectivedate+","+enddate+'\');"><i class="icon-ok-sign icon-white"></i>Approve</button>';
}

function rejectTaskWorkflow(objId) {
    return '<button class="btn btn-mini btn-danger" onclick="returnBackTask(\'' + objId + '\');"><i class="icon-remove-sign icon-white"></i>Reject</button>';
}