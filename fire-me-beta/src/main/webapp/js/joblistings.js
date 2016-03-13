$("document").ready(function(){
	
    $('#jobListings').dataTable( {
//		 "bLengthChange": false,
	     "bInfo": false,
    	 "oLanguage": {
             "sLengthMenu": "_MENU_ records per page"
         },
        "lengthMenu": [[5, 10, 15, -1], [5, 10, 15, "All"]],
        "aoColumns": [
                    { "sType": "string" },
                    { "sType": "string" },
                    { "sType": "string" }
        ],
        "aaSorting": [[ 0, "desc" ]]
    } );
    // Initialize Job Listings table
    initJobListings();
});

function initJobListings() {
	// call service to get list of jobs and populate table
	
	$("#jobListings").dataTable().fnClearTable();
	var dtArray = new Array();
	
	$.ajax({
    	type: 'GET',
    	url: '/fire-me-beta/listJobs',
        dataType: 'json',
        success: function (data) { 
        	for (var i = 0; i < data.length; i++) {
        		var obj = data[i];
        		dtArray.push([ obj.company, obj.jobDescription, rejectTaskWorkflow() ]);
        	}
        	
        	$("#jobListings").dataTable().fnAddData(dtArray);
        },
        cache: false,
        error: function( xhr, err) { 
            if (error) {
                error( xhr, err );
            } else {
                return xhrErr( statusId, xhr, err, "There was a problem while trying to get list of approved Tasks." ); 
            }
        }
    });
}

function rejectTaskWorkflow() {
    return '<button class="btn btn-mini btn-danger"><i class="icon-remove-sign icon-white"></i>Reject</button>';
}