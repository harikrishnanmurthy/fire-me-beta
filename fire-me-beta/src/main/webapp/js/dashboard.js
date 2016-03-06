/*
 * Copyright 2012 YarcData LLC All Rights Reserved.
 */
// Configure page elements when the document is ready

$("document").ready(function(){

	initServicesDash();
	initConfigDash();
	initCurrentDb("#currentDb", "#currentDbStatus");

	// Dashboard setup
    $('#accordion').collapse({
        toggle: false
        });
    $('#collapseOne').on('show', function () {
    	$("#accordion-show").show();
    	$("#accordion-hide").hide();
    });
    $('#collapseOne').on('hide', function () {
    	$("#accordion-show").hide();
    	$("#accordion-hide").show();
    });
	// End Dashboard setup
    
    //Statistics
		/*Fill the database dropdown values*/
    	fillDatabaseOptions();
		
		/*Action for accordion collapse and open*/
    	$('#accordion_query').collapse({
            toggle: false
            });
        $('#collapseOne_query').on('show', function () {
        	$("#accordion-show-query").show();
        	$("#accordion-hide-query").hide();
        });
        $('#collapseOne_query').on('hide', function () {
        	$("#accordion-show-query").hide();
        	$("#accordion-hide-query").show();
        });
        
    //End Statistics
    
});


// Functions
function initServicesDash() {
	dashboardService.getServiceStatusList("#status", function(data){
		for (var i = 0; i < data.service.length; i++) {
			var service = data.service[i];
			$("#dashboardTable > tbody:last").append("<tr><td>" + service.name + "</td><td>" + statusDashHtml(service.runState) + "</td></tr>");
		}
		$("#dashboardUpdateDate").text(moment().format("MM/DD/YYYY h:mm a"));
	});
};

function initConfigDash() {
	dashboardService.getSystemParams("#status", function(data){
		for (var i = 0; i < data.property.length; i++) {
			var prop = data.property[i];
			$("#configurationTable > tbody:last").append("<tr><td>" + prop.name + "</td><td>" + prop.value + "</td></tr>");
		}
	});	
};


function statusDashHtml(status) {
	if (status === "Running") {
		return '<span class="label label-success">Running</span>';
	} else if (status === "Stopped") {
		return '<span class="label label-important">Stopped</span>';
	} else {
		return '';
	}
}

function serviceNodeStats() {
	dashboardService.getServiceNodeStats("#status", function(data){
		var sigar = data.all;
		sigar = sigar.replace(/\n/g, "\r\n");  // IE fix to update new line to include carriage return
		$("#serviceNodeStats").html(sigar);
		$("#sigarStats").modal('show');
	});	
}

/*Load the statistics on database change or on refresh*/
function loadStatistics(){
	var filterDB=$("#filterDB option:selected").attr("id");
	if(filterDB!="-1"){
		dashboardStatistics(filterDB);
	}
	else{
		var renderDataTable = $("#statisticsTable tbody");
		renderDataTable.empty();
		renderDataTable.append("<tr><td colspan=2 align='center'> Select a database to view its statistics. </td></tr>");
	}
}

/*On clicking refresh, reload the statistics*/
$("#refreshStats").click(function() {
	loadStatistics();
});

/*On changing the database, load the statistics*/
$("#filterDB").change(function() {
	
	//Fix for GAMOS-347
	$('#filterDB').attr('title',$("#filterDB :selected").attr('title'));
	loadStatistics();
});

//Render the dashboard statistics
function dashboardStatistics(database){
	databaseStatisticsService.fetchStatistics(database, function( data){	
		/* render the results fetched to the data table!!  */
		var renderDataTable = $("#statisticsTable tbody");
		/* rendering the results */
		var jsonData = data.queryStatisticsList;
		/* when NO RESULTS are found */
		if($.isEmptyObject(jsonData))
		{
			/* clear the data table of the previous results */
			renderDataTable.empty();
			renderDataTable.append("<tr><td colspan=2 align='center'> There are no statistics for the database selected. </td></tr>");
		}
		else
		{
			/* clear the data table of the previous results */
			renderDataTable.empty();

			/* populate the data table with the result fetched */
			for ( var i = 1; i <= jsonData.length; i++) {	

				var units="";
				if(jsonData[i - 1].units!="-"){
					units="("+jsonData[i - 1].units+")";
				}
				renderDataTable
				.append('<tr />')
				.children('tr:last')
				.append("<td>" + jsonData[i - 1].name + " "+ units+" </td>")
				.append("<td>" + jsonData[i - 1].value + "</td>");				
				
			}
			var lastUpdatedOn = data.asUpdatedOn;
			if(lastUpdatedOn.length!=0){
				  $("#asUpdatedOn").html(lastUpdatedOn);
			 }
		}
		
		var errorMessage = data.errorMessage;
		if(errorMessage.length!=0)
			  addAlert("#status", "error", errorMessage);
		
		
	},function( xhr, err ) { 
		xhrErr( "#status", xhr, err, "There was a problem fetching statistics from the database." ); 
	});
}

//Populate the database drop-down
function fillDatabaseOptions() {
	var currDBName="";
	var currDBStatus="";
	var currDBId ="";
	$('#filterDB option').remove();
	$('#filterDB').append('<option id=' + '"-1"' +'>--Select--</option>');

	/* Get the current database and its state */
	databaseService.getDbState("#status", function(data) {
		currDBName = data["name"];
		currDBId = data["id"];
		currDBStatus = data["databaseStatus"];
				/* Get the list of all databases */
	            databaseService.getList("", function(data) { 
	        		dataItems = data;
	        		for (var i = 0; i < data.database.length; i++) {
	        			var item = data.database[i];
	        			var name = item["name"];
	        			var fid = item["id"];
	        			
	        			//Fix for GAMOS-347
	        			if(name.length > 20){
	        				name = name.substring(0,18)+'..';
	        				$('#filterDB').append('<option id=' + '"' + fid + '"' + 'value='+ '"'+name+ '"'+'>' + name + '</option>');
	        				$("#"+fid).attr("title",item["name"]);
	        			}
	        			//Fix for GAMOS-364
	        			else{
	        				$('#filterDB').append('<option id=' + '"' + fid + '"' + 'value='+ '"'+name+ '"'+'>' + name + '</option>');
	        				$("#"+fid).attr("title",item["name"]);
	        				
	        			}
	        			
	        		}	
	        		
	        		/*If a database is connected, display the statistics of the database.*/
	        		if(currDBStatus=="CONNECTED"||currDBStatus=="STARTING"){
	        			
	        			if(currDBName.length < 21){
	        				$('#filterDB').val(currDBName);
	        				$('#filterDB').attr('title',currDBName);
	        				
	        			}
	        			else{
	        				$('#filterDB').val(currDBName.substring(0,18)+'..');
	        				
	        					$('#filterDB').attr('title',currDBName);
	        					
	        			}
	        			
	        		    dashboardStatistics(currDBId);
	        		}
	        		/*If a database is not connected, ask the user to choose a database.*/
	        		else{
	        			$('#filterDB').val($('#filterDB option:first').val());
	        			var renderDataTable = $("#statisticsTable tbody");
	        			renderDataTable.empty();
	        			renderDataTable.append("<tr><td colspan=2 align='center'> There are no databases that are currently running. Select a database to view its statistics. </td></tr>");
	        			$("#asUpdatedOn").html("-");
	        			 
	        		}
	        	},function( xhr, err ) { 
	        		xhrErr( "#status", xhr, err, "There was a problem fetching database details." ); 
	        	});
	},function( xhr, err ) { 
		/* getDbState service throws a 404 error if no database is currently running. To handle that, 404 error is captured separately. */
		if (xhr.status === 404) {
			$('#filterDB').val($('#filterDB option:first').val());
			var renderDataTable = $("#statisticsTable tbody");
			renderDataTable.empty();
			renderDataTable.append("<tr><td colspan=2 align='center'> There are no databases that are currently running. Select a database to view its statistics. </td></tr>");
			$("#asUpdatedOn").html("-");
		} else {	
			xhrErr( "#status", xhr, err, "There was a problem fetching list of databases." );
		}
	});	
}
