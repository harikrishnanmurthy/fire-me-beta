$("document").ready(function(){
	
	   if ($("#failedrecordstable").length > 0) {
	        $('#failedrecordstable').dataTable( {
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
    $("#failedrecordstable").dataTable().fnClearTable();
    var dtArray = new Array();
    console.log("you are here");
    failedRecordService.getFailedRecords("#status", function(data) {
    	for (var i = 0; i < data.codeStandardizations.length; i++) {
            var user = data.codeStandardizations[i];
            //console.log(user.name);
            dtArray.push([user.positionDate, user.subjectID, user.targetCode, user.targetDesc, user.host, user.hostCode, user.hostCodeDesc]);    
        }
        
    	$("#failedrecordstable").dataTable().fnAddData(dtArray);
    },  function( xhr, err ) { 
        xhrErr( "#status", xhr, err, "There was a problem getting the list of users." ); 
    });
}