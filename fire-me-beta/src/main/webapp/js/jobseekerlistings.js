$("document").ready(function(){
	
    $('#jobSeekerListings').dataTable( {
//		 "bLengthChange": false,
	     "bInfo": false,
    	 "oLanguage": {
             "sLengthMenu": "_MENU_ records per page"
         },
        "lengthMenu": [[5, 10, 15, -1], [5, 10, 15, "All"]],
        "aoColumns": [
                    { "sType": "string" },
                    { "sType": "string" },
                    { "sType": "string" },
                    { "sType": "string" },
                    { "sType": "string" },
                    { "sType": "string" },
                    { "sType": "string" }
        ],
        "aaSorting": [[ 0, "desc" ]]
    } );
    // Initialize Job Seeker Listings table
    initJobSeekerListings();
});

function initJobSeekerListings() {
	// call service to get list of jobs and populate table
	
	$("#jobSeekerListings").dataTable().fnClearTable();
	var dtArray = new Array();
	
	$.ajax({
    	type: 'GET',
    	url: '/fire-me-beta/listjobseekers',
        dataType: 'json',
        success: function (data) { 
        	for (var i = 0; i < data.length; i++) {
        		var obj = data[i];
        		dtArray.push([ obj.userName,obj.noticePeriod,obj.designation,obj.experience,obj.currentSalary,obj.expSalary,moreInfo(obj.userName)]);
        	}
        	
        	$("#jobSeekerListings").dataTable().fnAddData(dtArray);
        },
        cache: false,
        error: function( xhr, err) { 
            if (error) {
                error( xhr, err );
            } else {
                return xhrErr( statusId, xhr, err, "There was a problem while trying to get list of job seekers" ); 
            }
        }
    });
}

function displayMore(username){
	$("#jobseekerusername").val(username);
	$('#moreInfo').modal('show');
}

function moreInfo(username) {
    return '<button class="btn btn-info btn-xs" onclick="displayMore(\'' + username + '\');"><i class="icon-remove-sign icon-white"></i>More Info</button>';
}

$("#profileDownload").click(function(){
	window.open("/fire-me-beta/profiledownload?username="+$("#jobseekerusername").val());
})


$("#sendEmail").click(function(){
	var username = $("#jobseekerusername").val();
	console.log("UserName == " + username);
	var emailBody = $("#comment").val()
	console.log("emailBody == " + emailBody);
	
	var myKeyVals = { "userName" : username, "message" : emailBody }
	
	$.ajax({
		type : "POST",
		async : true,
		url : "/fire-me-beta/sendemail",
		data : JSON.stringify(myKeyVals),
		dataType : 'json',
		contentType : "application/json",
		success : function(data) {
			console.log("SUCCESS: ", data);
			$('#moreInfo').modal('hide');
		},
		error : function(e) {
			console.log("ERROR: ", e);
			$('#moreInfo').modal('hide');
		},
		done : function(e) {
			console.log("DONE");
			$('#moreInfo').modal('hide');
		}
	});
});

$("#sendSMS").click(function(){
	var username = $("#jobseekerusername").val();
	console.log("UserName == " + username);
	var emailBody = $("#comment").val()
	console.log("emailBody == " + emailBody);
	
	var myKeyVals = { "userName" : username, "message" : emailBody }
	
	$.ajax({
		type : "POST",
		async : true,
		url : "/fire-me-beta/sendsms",
		data : JSON.stringify(myKeyVals),
		dataType : 'json',
		contentType : "application/json",
		success : function(data) {
			console.log("SUCCESS: ", data);
			$('#moreInfo').modal('hide');
		},
		error : function(e) {
			console.log("ERROR: ", e);
			$('#moreInfo').modal('hide');
		},
		done : function(e) {
			console.log("DONE");
			$('#moreInfo').modal('hide');
		}
	});
	
});

$("#jobseekeremail").click(function(){
	$("#jobseekerusername").val(username);
});
	
