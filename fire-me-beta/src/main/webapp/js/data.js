var dataItems;
var ruleItems;

// Configure page elements when the document is ready
$("document").ready(function(){

    // Actions for adding files and rules
    $('#dataSource').change(function()
	{
	   $("#" + $(this).attr('value') + "Tab").tab("show");
	    $("#copyFlagText").tooltip({title: "Copying files will increase import time."});
	    $("#moveFlagText").tooltip({title: "Moving files will remove the file from it's original location."});
	});

    $('#importDataAction').button();
    
    $('#importDataAction').click(function() {
    	var source = $("#dataSource").attr('value');
    	var filename = $("#filenameInput").val();
    	var comments = $("#commentsInput").val();
    	
    	if (validateData()) {
    		return;
    	} 
    	
    	$('#importDataAction').button('loading');

    	if (source === "url") {
    		var url = $("#urlInput").val();
    		dataService.importURL("#status", filename, url, comments, importCallback);
    	} else if (source === "lustre") {
    		var location = $("#lustreInput").val();
    		var copyFlag = $('#importDataForm input[name=copyFlag]:checked').val();
    		dataService.importLustre("#status", filename, location, comments, copyFlag, importCallback);
    	} else if (source === "rdf") {
    		var rdf = $("#rdfInput").val();
    		dataService.importRDF("#status", filename, rdf, comments, importCallback);
    	} else if (source === "local") {
    		// submit form to hidden iframe 
        		var id = new Date().getTime();
    			var iframe = $('<iframe name="upload-' + id + '" id="upload-' + id + '" />');
                $('div#iframe').append(iframe);
        		addIframeDataProgressCheck(id, filename, "#upload-" + id);
                $('#importDataForm').attr("target", "upload-" + id);

    			$("#importDataForm").submit();
        		addToTable("#dataTable", filename, id, "data");
        		$("#data-action-row-" + id + " * .bar").addClass("formUpload");	
        		$("#data-action-row-" + id + " * .bar").width("100%");	
        		$("#data-action-row-" + id + " * .bar").text(" Loading...");	
    	}    		

    	$("#importDataForm")[0].reset();
    	$('#addFiles').modal('hide');
    	$('#importDataAction').button('reset');
    });
    
    $('#importDataCancel').click(function() {
    	// Reset error class
    	$("#filenameGroup").removeClass("error");
    	$("#urlGroup").removeClass("error");
    	$("#lustreGroup").removeClass("error");
    	$("#rdfGroup").removeClass("error");
    	$("#fileGroup").removeClass("error");
    	$("#dataStatus").empty();

    	// Reset form
    	$("#importDataForm")[0].reset();
    });
    
    $('#importRuleAction').click(function() {
    	var filename = $("#ruleNameInput").val();
    	
    	if (validateRule()) {
    		return;
    	} 
    	
		// submit form to hidden iframe 
		var id = new Date().getTime();
		var iframe = $('<iframe name="upload-' + id + '" id="upload-' + id + '" />');
        $('div#iframe').append(iframe);
		addIframeRuleProgressCheck(id, filename, "#upload-" + id);
        $('#importRuleForm').attr("target", "upload-" + id);

		$("#importRuleForm").submit();
		addToTable("#ruleTable", filename, id, "rule");
		$("#data-action-row-" + id + " * .bar").addClass("formUpload");	
		$("#data-action-row-" + id + " * .bar").width("100%");	
		$("#data-action-row-" + id + " * .bar").text(" Loading...");	
    	
    	$("#importRuleForm")[0].reset();
    	$('#addRule').modal('hide');
    	$('#importRuleAction').button('reset');
    });
    
    $('#importRuleCancel').click(function() {
    	// Reset error class
    	$("#rulenameGroup").removeClass("error");
    	$("#ruleGroup").removeClass("error");
    	$("#ruleStatus").empty();

    	// Reset form
    	$("#importRuleForm")[0].reset();
    });
    // End Actions for adding files and rules

    // For data and rule pages
    if ($("#dataManageTable").length > 0) {
    	initData('#dataManageTable', "actions");
    	displayInProgress();
    }
    if ($("#ruleManageTable").length > 0) {
    	initRules('#ruleManageTable', "actions");
    }
    
	$('#ruleManageTable').dataTable( {
		"sDom": "<'row'<'span4'l><'span8'f>r>t<'row'<'span6'i><'span6'p>>",
		"bLengthChange": false,
		"bInfo": false,
        "sPaginationType": "bootstrap",
		"oLanguage": {
			"sLengthMenu": "_MENU_ records per page"
		},
	    "aoColumns": [
	                { "sType": "string" },
	                { "sType": "date" },
	                { "sType": "string" },
	                { "sType": "string" }
	    ],
	    "aaSorting": [[ 1, "desc" ]]
	} );
	
	$('#dataManageTable').dataTable( {
		"sDom": "<'row'<'span4'l><'span8'f>r>t<'row'<'span6'i><'span6'p>>",
		"bLengthChange": false,
		"bInfo": false,
		"sPaginationType": "bootstrap",
		"oLanguage": {
			"sLengthMenu": "_MENU_ records per page"
		},
	    "aoColumns": [
	                { "sType": "string" },
	                { "sType": "date" },
	                { "sType": "string" },
	                { "sType": "file-size" },
	                { "sType": "string" }
	    ],
	    "aaSorting": [[ 1, "desc" ]]
	} );

	
	// Warn user if they leave the page before form upload is finished
	$(window).bind('beforeunload', function(){
		if ($(".formUpload").length > 0) {
			  return 'Are you sure you want to leave?  All current local file imports will be cancelled.';
		}
	});
});


// Functions

// Validate data input form
function validateData() {
	var source = $("#dataSource").attr('value');
	var filename = $("#filenameInput").val();
	var displayError = false;
	var maxChars = 4 * 1024 * 1024; //4MB
    var max = 2 * 1024 * 1024 * 1024; // 2GB

	// Reset error class
	$("#filenameGroup").removeClass("error");
	$("#urlGroup").removeClass("error");
	$("#lustreGroup").removeClass("error");
	$("#rdfGroup").removeClass("error");
	$("#fileGroup").removeClass("error");
	$("#dataStatus").empty();

	
	if (filename === "") {
		$("#filenameGroup").addClass("error");
		displayError = true;
	} else {
		if (validateName(filename)) {
			addAlert("#dataStatus", "error", "The name you entered contains invalid characters.  The valid characters that can be used are: a-z, A-Z, 0-9, +, _, -");
			$("#filenameGroup").addClass("error");
			displayError = true;	
		} else {
			if (dataItems && dataItems.item) {
				for (var i = 0; i < dataItems.item.length; i++) {
					var item = dataItems.item[i];
					var name = item["name"];
					if (name === filename) {
						addAlert("#dataStatus", "error", "An artifact with the same name already exists: " + filename);
						$("#filenameGroup").addClass("error");
						displayError = true;
						break;
					}
				}
			}
		}
	}
	if (source === "url") {
		var url = $("#urlInput").val();
		if (url === "") {
    		$("#urlGroup").addClass("error");
    		displayError = true;
		} else {
			// Grabbed from http://stackoverflow.com/questions/2723140/validating-url-with-jquery-without-the-validate-plugin to validate url
			if (/^(http|https|ftp):(\/\/(((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:)*@)?((\[(|(v[\da-f]{1,}\.(([a-z]|\d|-|\.|_|~)|[!\$&'\(\)\*\+,;=]|:)+))\])|((\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5]))|(([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=])*)(:\d*)?)(\/(([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)*)*|(\/((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)+(\/(([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)*)*)?)|((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)+(\/(([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)*)*)|((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)){0})(\?((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|[\uE000-\uF8FF]|\/|\?)*)?(\#((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|\/|\?)*)?$/i
					.test(url) === false) {
		        addAlert("#dataStatus", "error", "The url is invalid.");
	    		$("#urlGroup").addClass("error");
	    		displayError = true;
			}
			var ext = url.split('.').pop().toLowerCase();
			if($.inArray(ext, ['nt','nq']) == -1) {
		        addAlert("#dataStatus", "error", "The file extension is not supported.");
	    		$("#urlGroup").addClass("error");
	    		displayError = true;
			}
		}
	} else if (source === "lustre") {
		var location = $("#lustreInput").val();
		if (location === "") {
    		$("#lustreGroup").addClass("error");
    		displayError = true;
		} else {
			var ext = location.split('.').pop().toLowerCase();
			if($.inArray(ext, ['nt','nq']) == -1) {
		        addAlert("#dataStatus", "error", "The file extension is not supported.");
	    		$("#lustreGroup").addClass("error");
	    		displayError = true;
			}
		}
	} else if (source === "rdf") {
		var rdf = $("#rdfInput").val();
		if (rdf === "") {
    		$("#rdfGroup").addClass("error");
    		displayError = true;
		} else if (rdf.length > maxChars) {
			addAlert("#dataStatus", "error", "Raw RDF data is more than the 4MB limit.");
			$("#rdfGroup").addClass("error");
			displayError = true;
		}
	} else if (source === "local") {
		var local = $("#localInput").val();
		if (local === "") {
    		$("#fileGroup").addClass("error");
    		displayError = true;
		} else {
			var ext = local.split('.').pop().toLowerCase();
			if($.inArray(ext, ['nt','nq']) == -1) {
		        addAlert("#dataStatus", "error", "The file extension is not supported.");
	    		$("#fileGroup").addClass("error");
	    		displayError = true;
			}
			try {
				// Check if Files API is available in newer HTML5 supported browsers to validate size limit
				if ($("#localInput")[0].files) {
					var size = $("#localInput")[0].files[0].size;
				    if (size > max) {
				        addAlert("#dataStatus", "error", "The file size is larger than the 2GB limit.");
			    		$("#fileGroup").addClass("error");
			    		displayError = true;
			    	}
				}
			} catch(err) {
				// Do Nothing
			}
		}
	}
	
	return displayError;
}

// Validate rule input form
function validateRule() {
	var filename = $("#ruleNameInput").val();
	var ruleFile = $("#ruleFile").val();
	var displayError = false;
    var max = 2 * 1024 * 1024 * 1024; // 2GB
	
	// Reset error class
	$("#rulenameGroup").removeClass("error");
	$("#ruleGroup").removeClass("error");
	$("#ruleStatus").empty();

	if (filename === "") {
		$("#rulenameGroup").addClass("error");
		displayError = true;
	} else {
		if (validateName(filename)) {
			addAlert("#ruleStatus", "error", "The name you entered contains invalid characters.  The valid characters that can be used are: a-z, A-Z, 0-9, +, _, -");
			$("#rulenameGroup").addClass("error");
			displayError = true;	
		} else {
			if (ruleItems && ruleItems.ruleSet) {
				for (var i = 0; i < ruleItems.ruleSet.length; i++) {
					var rule = ruleItems.ruleSet[i];
					var name = rule["name"];
					if (name === filename) {
						addAlert("#ruleStatus", "error", "A rule with the same name already exists: " + filename);
						$("#rulenameGroup").addClass("error");
						displayError = true;
						break;
					}
				}
			}
		}
	}
	if (ruleFile === "") {
		$("#ruleGroup").addClass("error");
		displayError = true;
	}  else {
		try {
			// Check if Files API is available in newer HTML5 supported browsers to validate size limit
			if ($("#ruleFile")[0].files) {
				var size = $("#ruleFile")[0].files[0].size;
			    if (size > max) {
			        addAlert("#ruleStatus", "error", "The file size is larger than the 2GB limit.");
		    		$("#ruleGroup").addClass("error");
		    		displayError = true;
		    	}
			}
		} catch(err) {
			// Do Nothing
		}
	}
	
	return displayError;
}

// Display all in progress data import operations
function displayInProgress() {
	var filter = "state=IN_PROGRESS";
	dataService.getAllImports("#status", filter, function(data) {
		for (var i = 0; i < data.operation.length; i++) {
			var op = data.operation[i];
			var item = op.item;
			var id = op.id;
			var filename = item.name;
			var progress = op.progress;
			$("#dataTable > tbody:last").append('<tr id="data-row-' + id + '" style="border: 1px solid #E9E9E9;"><td>' + filename + progressActions(id) +  '<div id="data-action-row-' + id + '" style="width: 165px; float: right;">' + progressHtml(progress) + '</div></td></tr>');
			addDataProgressCheck(id);
		}
	});
}

// Initialize data table
function initData(tableId, type) {
	dataService.getList("#status", function(data) { 
		dataItems = data;
		var dtArray = new Array();
		for (var i = 0; i < data.item.length; i++) {
			var item = data.item[i];
			var name = item["name"];
			var subName=name;
			//alert(name);
			if(name.length > 20){
				
				subName = name.substring(0,18)+'..';
			}
			var fid = item["id"];
			var size = parseInt(item["size"]);
			var date = item["date"];
			var user = item["createdBy"];
			if (type === "actions") {
				var actions = '<a id="dataArtifactInfoButton-' + fid + '" href="javascript:void(0)" onclick="dataArtifactInfo(\'' + fid + '\');" class="btn btn-mini btn-info"><i class="icon-info-sign icon-white"></i></a> <a id="deleteDataArtifactButton-' + fid + '" href="javascript:deleteData(\'' + tableId + "', '" + name + "', '" + fid + '\');" class="btn btn-mini btn-danger"><i class="icon-remove-sign icon-white"></i></a>';
				dtArray.push([
				              '<span class="nameSubStr" title="'+name+'">'+subName+'</span>',
                              moment(date).format("MM/DD/YYYY h:mm a"),
                              user,
                              readableFileSize(size),
                              actions ]);
			} else {
				dtArray.push([
                              '<label class="checkbox"><input name="file" type="checkbox" value="' + fid + '"/>' + '<span class="nameSubStr" title="'+name+'">'+subName+'</span>' + '</label>',
                              moment(date).format("MM/DD/YYYY h:mm a"),
                              user,
                              readableFileSize(size) ] );
			}
			
		}
		
		$(tableId).dataTable().fnClearTable();
		$(tableId).dataTable().fnAddData(dtArray);
		
	/*	//Fix for GAMOS-348
		var j = data.item.length;
		for (var i = 0; i < data.item.length; i++) {
			var item = data.item[i];
			var name = item["name"];
			
			$('#dataManageTable tr:nth-child('+j+') td:nth-child(1)').attr('title',name);
			j--;
			
			
		}*/
	});
}

// Initialize rules table
function initRules(tableId, type) {
	ruleService.getList("#status", function(data) { 
		ruleItems = data;
		var dtArray = new Array();
		for (var i = 0; i < data.ruleSet.length; i++) {
			var item = data.ruleSet[i];
			var name = item["name"];
			var rid = item["id"];
			var date = item["date"];
			var user = item["createdBy"];
			if (type === "actions") {
				var actions = '<a id="ruleArtifactInfoButton-' + rid + '" href="javascript:void(0)" onclick="ruleArtifactInfo(\'' + rid + '\');" class="btn btn-mini btn-info"><i class="icon-info-sign icon-white"></i></a> <a id="deleteRuleArtifactButton-' + rid + '" href="javascript:deleteRule(\'' + tableId + "', '" + name + "', '" + rid + '\');" class="btn btn-mini btn-danger"><i class="icon-remove-sign icon-white"></i></a>';
				dtArray.push([
                              name,
                              moment(date).format("MM/DD/YYYY h:mm a"),
                              user, 
                              actions ]);
			} else {
				dtArray.push([
                              '<label class="radio"><input name="rule" type="radio" value="' + rid + '"/>' + name + '</label>',
                              moment(date).format("MM/DD/YYYY h:mm a"),
                              user ]);
			}
		}
		$(tableId).dataTable().fnClearTable();
		$(tableId).dataTable().fnAddData(dtArray);
	});
}

// Delete data artifact
function deleteData(tableId, name, id) {
	bootbox.confirm("Are you sure you want to delete the artifact: " + name + "?", function(result) {
	    if (result) {
	    	dataService.remove("#status", id, function(data) { 
    	    	// Clear table and re-initialize
    	    	initData('#dataManageTable', "actions");
		        addAlert("#status", "success", "The artifact " + name + " was deleted.");
	    	},  function( xhr, err ) { 
				if (xhr.status === 404 || xhr.status === 500) {
	    	    	// Clear table and re-initialize
	    	    	initData('#dataManageTable', "actions");
			        addAlert("#status", "error", "The artifact " + name + " does not exist.");
				} else if (xhr.status === 409) {
	    	    	// Clear table and re-initialize
	    	    	initData('#dataManageTable', "actions");
			        addAlert("#status", "error", "The artifact " + name + " is in use and cannot be deleted.");
				} else {
                	return xhrErr( "#status", xhr, err, "There was a problem while trying to delete the artifact." ); 
				}
	    	});
	    } 
	});
}

// Delete rule artifact
function deleteRule(tableId, name, id) {
	bootbox.confirm("Are you sure you want to delete the rule: " + name + "?", function(result) {
	    if (result) {
	        ruleService.remove("#status", id, function(data) { 
    	    	// Clear table and re-initialize
    	    	initRules('#ruleManageTable', "actions");
		        addAlert("#status", "success", "The rule " + name + " was deleted.");
	        },  function( xhr, err ) { 
	    		if (xhr.status === 404 || xhr.status === 500) {
	    	    	// Clear table and re-initialize
	    	    	initRules('#ruleManageTable', "actions");
	    	        addAlert("#status", "error", "The rule " + name + " does not exist.");
	    		} else {
                	return xhrErr( "#status", xhr, err, "There was a problem while trying to delete rule." ); 
				}
	    	});
	    } 
	});
}

// Display cancel button
function progressActions(id) {
	var action = '<div style="float: right; padding-left: 5px;"> <a id="cancelUploadButton-' + id + '" class="btn btn-mini btn-warning" href=\'javascript:cancelImport("' + id + '");\'>Cancel upload</a></div>';
	return action;
}

// Import artifact callback
function importCallback(data) { 
	var filename = data.item["name"];
	var id = data["id"];
	addToTable("#dataTable", filename, id, "data"); 
	addDataProgressCheck(id);
	// Adding temporary class so that if user tries to leave page, they will be warned
	$("#data-action-row-" + id + " * .bar").addClass("formUpload");	
}

// Progress check for url, lustre, and rdf import
function addDataProgressCheck(id) {
	// closure to poll for progress, currently every 2 seconds
	(function progressPoll(){
	    setTimeout(function(){
	    	if ($("#data-row-" + id).length > 0) {
		    	dataService.getImportProgress("#status", id, function(data) {
		    		// Once import is tracked in the repo, it is okay for the user to leave the page (and if not in the wizard)
		    		if ($(".wizard").length == 0) {
			    		$("#data-action-row-" + id + " * .bar").removeClass("formUpload");	
		    		}
					var name = data.item["name"];
					
					var did = data.item["id"];
					var state = data.state;
					if (state === "FAILED") {
						if (name == null) name = $("#data-row-name-" + id).text();
				        addAlert("#status", "error", "The import for artifact " + name + " failed. " + data.comment);
			    		$("#checkbox-row-" + id).remove();
			    		$("#data-row-" + id).remove();
					} else {
			            var percentVal = data.progress + '%';
			            $("#data-action-row-" + id + " * .bar").width(percentVal);	
			    		$("#data-action-row-" + id + " * .bar").text(" " + percentVal);	
						if (data.progress === 100) {
				    		$("#checkbox-row-" + id +" * input:checkbox").val(did);
				    		$("#checkbox-row-" + id +" * div").remove();
				    		$("#data-row-" + id).remove();
				    	    if ($("#dataManageTable").length > 0) {
				    	    	// Clear table
				    	    	initData('#dataManageTable', "actions");
				    	    	//alert("hiii");
						        addAlert("#status", "success", "The artifact " + name + " was added.");
				    	    } 
						} else {
							progressPoll(); // If progress isn't 100%, setup next polling check
						}
					}
				});
	    	}
	   }, 2000);
	})();
}

// Progress check for local file import
function addIframeDataProgressCheck(id, fid, iframeId) {
	// closure to poll for progress in case of browser timeout on upload, currently every 5 minutes
	(function timeoutPoll(){
	    setTimeout(function(){
	    	if ($("#data-row-" + id).length > 0) {
				dataService.getList("", function(data) {
					var match = false;
					for (var i = 0; i < data.item.length; i++) {
						var item = data.item[i];
						var name = item["name"];
						if (name === fid) {
							match = true;
							break;
						}
					}
					// If file is found and the data row is still present
					if (match) {
						$(iframeId).unbind('load').prop('src', 'javascript'.concat(':false;'));
			    		$("#checkbox-row-" + id +" * input:checkbox").val(did);
			    		$("#checkbox-row-" + id +" * div").remove();
			    		$("#data-row-" + id).remove();
			    	    if ($("#dataManageTable").length > 0) {
			    	    	// Clear table
			    	    	initData('#dataManageTable', "actions");
					        addAlert("#status", "success", "The artifact " + fid + " was added.");
			    	    } 
					} else {
						timeoutPoll(); // If file isn't found in the list, setup a next poll to run in 5 minutes
					}
				});
	    	}
	   }, 300000);
	})();
	$(iframeId).load(
            function () {
                var iframeContents = $(iframeId).contents();
                // Check for IE, due to xml handling: http://forum.jquery.com/topic/agony-in-ie7-8-while-trying-to-parse-xml-in-an-iframe
                var frame = window.frames[$(iframeId).attr("name")];
        		if (frame && frame.document.XMLDocument) {
        			iframeContents = frame.document.XMLDocument;
        		}
                var status = $(iframeContents).find("state").text();
                var filename = $(iframeContents).find("name").text();
                
                if(filename.length >20){
                	
                	filename = filename.substring(0,18)+"..";
                	 $('#status').attr('title',$(iframeContents).find("name").text());
                	
                }
                
                var fileId = $(iframeContents).find("item").attr("id");
                if (status === "COMPLETE") {
    	    		$("#checkbox-row-" + id +" * input:checkbox").val(fileId);
    	    		$("#checkbox-row-" + id +" * div").remove();
    	    		$("#data-row-" + id).remove();
    	    	    if ($("#dataManageTable").length > 0) {
    	    	    	// Clear table and re-initialize
    	    	    	initData('#dataManageTable', "actions");
    			        addAlert("#status", "success", "The artifact " + filename + " was added.");
    			       
    	    	    } 
                } else {
    	    		// check for timeout
                    var headerText = $(iframeContents).find("h1").text();
                    if (headerText && headerText === "Urika Login") {
                    	timeoutAlert();
                    }
                    
                    filename = $("#data-row-name-" + id).text();
                    $("#data-row-" + id).remove();
                    var error = $(iframeContents).find("pre").text();
                    // In case for IE, the iframe will be empty.  I will give a generic error with a possible suggestion
                    if (!error || error === "") {
                    	error = "There was a problem with importing " + filename + ".  It could be an item with the same name already exists.";
                    }
    	    	    if ($("#dataManageTable").length > 0) {
    	    	    	// Clear table and re-initialize
    	    	    	initData('#dataManageTable', "actions");
    	    	    }
    		        addAlert("#status", "error", error);
                }
            }
    );
}

// Progress check for rule import
function addIframeRuleProgressCheck(id, fid, iframeId) {
	$(iframeId).load(
            function () {
                var iframeContents = $(iframeId).contents();
                // Check for IE, due to xml handling: http://forum.jquery.com/topic/agony-in-ie7-8-while-trying-to-parse-xml-in-an-iframe
                var frame = window.frames[$(iframeId).attr("name")];
        		if (frame && frame.document.XMLDocument) {
        			iframeContents = frame.document.XMLDocument;
        		}
                var ruleName = $(iframeContents).find("name").text();
                var ruleId = $(iframeContents).find("ruleSet").attr("id");
                if (ruleName === fid) {
    	    		$("#radio-row-" + id +" * input:radio").val(ruleId);
    	    		$("#radio-row-" + id +" * div").remove();
    	    		$("#data-row-" + id).remove();
    	    	    if ($("#ruleManageTable").length > 0) {
    	    	    	// Clear table and re-initialize
    	    	    	initRules('#ruleManageTable', "actions");
    			        addAlert("#status", "success", "The rule " + ruleName + " was added.");
    	    	    } 
                } else {
    	    		// check for timeout
                    var headerText = $(iframeContents).find("h1").text();
                    if (headerText && headerText === "Urika Login") {
                    	timeoutAlert();
                    }

                    ruleName = $("#data-row-name-" + id).text();
                    $("#data-row-" + id).remove();
                    var error = $(iframeContents).find("pre").text();
                    // In case for IE, the iframe will be empty.  I will give a generic error with a possible suggestion
                    if (!error || error === "") {
                    	error = "There was a problem with importing " + ruleName + ".  It could be an item with the same name already exists.";
                    }
    	    	    if ($("#ruleManageTable").length > 0) {
    	    	    	// Clear table and re-initialize
    	    	    	initRules('#ruleManageTable', "actions");
    	    	    }
                    addAlert("#status", "error", error);
                }
            }
    );	
	
}

// Function to add import file to wizard or manage data or manage rule pages
function addToTable(divId, filename, id, type) {
	
	var dispName = filename;
	
	if(filename.length > 20){
		
		filename = filename.substring(0,18)+"..";
	}
	
	$(divId + " tr:last").before('<tr id="data-row-' + id + '" style="border: 1px solid #E9E9E9;"><td><span id="data-row-name-' + id + '"title="'+dispName+'">' + filename + '</span>' + progressActions(id) +  '<div id="data-action-row-' + id + '" style="width: 165px; float: right;">' + progressHtml() + '</div></td></tr>');
	$(divId + "2").toggle();
	if (type === "data") {
		$(divId + "2 > tbody:last").append('<tr id="checkbox-row-' + id + '" style="border: 1px solid #E9E9E9;"><td><label class="checkbox"><input name="file" type="checkbox" checked /> ' + '<span id="dispNameTitle" title="'+dispName+'">' + filename + '</span>'  + progressActions(id) +  '<div id="data-action-row-' + id + '" style="width: 165px; float: right;">' + progressHtml() + '</div></label></td></tr>');
	} else if (type === "rule") {
		$(divId + "2 > tbody:last").append('<tr id="radio-row-' + id + '" style="border: 1px solid #E9E9E9;"><td><label class="radio"><input name="rule" type="radio" checked /> ' + filename + progressActions(id) +  '<div id="data-action-row-' + id + '" style="width: 165px; float: right;">' + progressHtml() + '</div></label></td></tr>');
	}
}

// Function to cancel import action
function cancelImport(id) {
	// if upload was submitted to hidden iframe, remove iframe to try and cancel form submission
	if ($("#upload-" + id).length) {
		var iframeObj = $("#upload-" + id);
		iframeObj.unbind('load').prop('src', 'javascript'.concat(':false;'));

        addAlert("#status", "success", "The import has been cancelled");
		$("#checkbox-row-" + id).remove();
        $("#radio-row-" + id).remove();
        $("#data-row-" + id).remove();
	} else { // Else, cancel import through rest
		dataService.cancelImport("#status", id, function(data) {
	        addAlert("#status", "success", "The import has been cancelled");
            $("#checkbox-row-" + id).remove();
            $("#radio-row-" + id).remove();
			$("#data-row-" + id).remove();
		}, function( xhr, err ) {
				if (xhr.status === 404) {
    				$("#data-row-" + id).remove();
    		        addAlert("#status", "info", "The import no longer exists and has been removed.");
				} else {
					xhrErr( "#status", xhr, err, "There was a problem trying to cancel the import.");
				}
		});	
	}
}

// Funciton to display a progress bar on import action
function progressHtml(percent) {
	if (percent && percent !== '') {
		return '<div class="data-progress progress progress-warning progress-striped active"><div style="width: ' + percent + '%;" class="bar"> ' + percent + '%</div></div>';
	} else {
		return '<div class="data-progress progress progress-warning progress-striped active"><div style="width: 0%;" class="bar"></div></div>';
	}
}

// Data artifact info
function dataArtifactInfo(id) {
	dataService.get("#status", id, function(data) {
		var name = data.name;
		//Fix for GAMOS-348
		if(name.length > 20){
			
			name = name.substring(0,18)+"..";
		}
		var creationTime = data.date;
		var size = data.size;
		var description = data.description;
		
		$("#artifactNameInfo").text(name);
		$("#artifactNameInfo").attr('title',data.name);
		$("#artifactSize").text(readableFileSize(size));
		$("#artifactCreation").text(moment(creationTime).format("MM/DD/YYYY h:mm a"));
		$("#artifactDescription").text(description);
		$("#artifactDbInfo > tbody:last").empty();
		
		dataService.getDbList("#status", id, function(data) {
			var dbList = new Array();
			for (var i = 0; i < data.database.length; i++){
				var db = data.database[i];
				var id = db["id"];
				var name = db["name"];
				
				if ($.inArray(id, dbList) == -1) {
					dbList.push(id);
					// Fix for Gamos 316
					if(name.length>20){
						name=name.substring(0,18)+"..";
					}
					$("#artifactDbInfo > tbody:last").append("<tr><td title=" +db['name']+ "> " + name + "</td></tr>");
				}
				
			}
		});
		$('#viewArtifactInfo').modal('show');		
	}, function( xhr, err ) {
		if (xhr.status === 404 || xhr.status === 500) {
	    	initData('#dataManageTable', "actions");
	        addAlert("#status", "error", "The artifact does not exist.");
		} else {
			xhrErr( "#status", xhr, err, "There was a problem retrieving the artifact info.");
		}
	});

}

// Rule artifact info
function ruleArtifactInfo(id) {
	ruleService.get("#status", id, function(data) {
		var name = data.name;
		var date = data.date;
		var description = data.description;
		
		$("#ruleNameInfo").text(name);
		$("#ruleCreation").text(moment(date).format("MM/DD/YYYY h:mm a"));
		$("#ruleDescription").text(description);
		$("#ruleDbInfo > tbody:last").empty();

		ruleService.getDbList("#status", id, function(data) {
			var dbList = new Array();
			for (var i = 0; i < data.database.length; i++){
				var db = data.database[i];
				var id = db["id"];
				var name = db["name"];
				var subName=name;
				
				if ($.inArray(id, dbList) == -1) {
					if(name.length > 20){
						subName = name.substring(0,18)+"..";
					}
					$("#ruleDbInfo > tbody:last").append("<tr><td title='"+name+"'>" + subName + "</td></tr>");
				}
			}		
		});
		$('#viewRuleInfo').modal('show');
	}, function( xhr, err ) {
		if (xhr.status === 404 || xhr.status === 500) {
	    	initRules('#ruleManageTable', "actions");
	        addAlert("#status", "error", "The rule does not exist.");
		} else {
			xhrErr( "#status", xhr, err, "There was a problem retrieving the rule info.");
		}
	});
}
