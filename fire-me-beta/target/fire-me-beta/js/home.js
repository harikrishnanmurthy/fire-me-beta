$("document").ready(function(){
	
	   if ($("#fileTable").length > 0) {
	        $('#fileTable').dataTable( {
	            "sDom": "<'row'<'span4'l><'span8'f>r>t<'row'<'span6'i><'span6'p>>",
	            "bLengthChange": false,
	            "bInfo": false,
	            "sPaginationType": "bootstrap",
	            "oLanguage": {
	                "sLengthMenu": "_MENU_ records per page"
	            },
	            "aoColumns": [
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
    $("#fileTable").dataTable().fnClearTable();
    var dtArray = new Array();
    console.log("you are here");
    userManageService.getFileList("#status", function(data) {
    	for (var i = 0; i < data.filelist.length; i++) {
            var file = data.filelist[i];
            dtArray.push([file,editHtml(file)]);    
        }
        
    	$("#fileTable").dataTable().fnAddData(dtArray);
    },  function( xhr, err ) { 
        xhrErr( "#status", xhr, err, "There was a problem getting the list of users." ); 
    });
}

function downloadFile(filepath) {
	var modfilepath = filepath.substring(filepath.lastIndexOf("/")+1);
	window.location.href='/gst-gcr-webportal/downloadFile?file='+modfilepath;
}


function editHtml(filepath) {
	var modfilepath = filepath.split('\\').join('/');
    return '<button class="btn btn-mini btn-info" onclick="downloadFile(\'' + modfilepath + '\');"><i class="icon-download icon-white"></i>Download</button>';
}