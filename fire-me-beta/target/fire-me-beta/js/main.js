var showDebug = false;
var toggle = false;
var maxResultsTabs = 50;

// Configure page elements when the document is ready
$("document").ready(function(){

	$("#toggleSidebar").height($("#sidebar").height() + 34);
	$('#toggleSidebar').click(function() {
	  if (toggle) {
	    sidebar(false);
	    toggle = false;
	  } else {
	    sidebar(true);
	    toggle = true;
	  }
	  this.blur();
	});
	
    // Check for support of placeholder for login page
	jQuery.support.placeholder = false;
	test = document.createElement('input');
	if('placeholder' in test) jQuery.support.placeholder = true;
	if (!$.support.placeholder) {
		$('.field').find ('label').show ();
	}
	
	// No enter submit
	$('.noEnterSubmit').keypress(function(e){
	    if ( e.which == 13 ) {
            e.preventDefault();
            var inputs = $(this).closest('form').find(':input:visible');
            inputs.eq( inputs.index(this)+ 1 ).focus();
	    }
	});
	
	// Minimized left navigation after 300ms
//	setTimeout(function(){
//		$('#toggleSidebar').click();		
//	}, 300);
	
	$('#toggleSidebar').tooltip({title: "Click to toggle the left navigation menu.", placement: "right"});
	
	// Tooltip initialization
	$("#activeCheckpoint").tooltip({title: "This is the active checkpoint."});
	$(".dataCheckpoint").tooltip({title: "This data is included in the active checkpoint."});
	$(".queuedData").tooltip({title: "This data is in the queue awaiting to be executed."});
	
	if ($.browser.msie && parseInt($.browser.version, 10) <= 8) {
		// do nothing as it causes a loop in IE 7 & 8
	} else {
		// Resize results table header on window resize
		$(window).on('resize', function() {
			resizeSparqlResults();
		});
	}
});



// Functions
function resizeSparqlResults() {
	$("table[id^=tableResults-]").each(function () {
		$(this).dataTable().fnAdjustColumnSizing();
	});
}
function sidebar(collapse) {
    if (collapse) {
      $('#sidebar').hide("fade", {}, 300);
      $('#content').switchClass('span9', 'span11', 500, null, function () { resizeSparqlResults(); });
      $("#topsidebar").switchClass('span3','showToggleBar', 500);
	  $('#toggleSidebar i').removeClass('icon-chevron-left');
      $('#toggleSidebar i').addClass('icon-chevron-right');
    } else {
      $('#content').switchClass('span11', 'span9', 500, null, function () { resizeSparqlResults(); });
      $('#topsidebar').switchClass('showToggleBar', 'span3', 500);
      $('#sidebar').show("fade", {}, 400);
	  $('#toggleSidebar i').addClass('icon-chevron-left');
	  $('#toggleSidebar i').removeClass('icon-chevron-right');
    }
};	
	
function addAlert(divId, type, message) {
	$(divId).show().prepend(makeAlertDetails(type, message));
}

function makeAlertDetails(type, message) {
	var alert = "";
	if (type === 'error') {
        alert =  '<div class="alert alert-error fade in"><button class="close" data-dismiss="alert">x</button><strong>Error!</strong> ' + message + '</div>';
	} else if (type === 'info') {
        alert =  '<div class="alert alert-info fade in"><button class="close" data-dismiss="alert">x</button>' + message + '</div>';
	} else if (type === 'success') {
        alert =  '<div class="alert alert-success fade in"><button class="close" data-dismiss="alert">x</button>' + message + '</div>';
	} else {
        alert =  '<div class="alert fade in"><button class="close" data-dismiss="alert">x</button>' + message + '</div>';
	}
	
	return alert;
}

function timeoutAlert() {
	bootbox.dialog("The browser session has timed out.  Please refresh the page to log back in.", {
	    "label" : "Refresh page",
	    "class" : "btn-primary",
	    "callback": function() {
	    	location.reload();
	    }
	});
}
function validateName(nameVal){
	if (/[^a-z0-9+_-]/gi.test(nameVal)) 
		return true;
	else
		return false;
}

function getParameterByName(name)
{
  name = name.replace(/[\[]/, "\\\[").replace(/[\]]/, "\\\]");
  var regexS = "[\\?&]" + name + "=([^&#]*)";
  var regex = new RegExp(regexS);
  var results = regex.exec(window.location.search);
  if(results == null)
    return "";
  else
    return decodeURIComponent(results[1].replace(/\+/g, " "));
}

function readableFileSize(size) {
	size = parseInt(size);
    var units = ['B', 'KB', 'MB', 'GB', 'TB', 'PB', 'EB', 'ZB', 'YB'];
    var i = 0;
    while(size >= 1024) {
        size /= 1024;
        ++i;
    }
    return size.toFixed(1) + ' ' + units[i];
}

function debug(msg) {
	if (window.console) {
		console.log(msg);
	}
    if (showDebug) {
        alert(msg);
    }
} // end function

function xhrErr(divId, xhr, err, msg) {
    debug("xhr:" + JSON.stringify(xhr) + ",err:"+JSON.stringify(err));
    // Check for session timeout
    if (xhr.status === 401) {
    	timeoutAlert();
    } else if (xhr.status === 500) {
        debug("Error: " + msg);
        // If default tomcat logs display, show default error message instead
        if (msg !== "" && msg.match(/Apache Tomcat.* Error report/)) {
        	msg = "Unhandled exception occured.  Please consult the logs.";
        }
   	    addAlert(divId, "error", msg);
    } else if (divId !== "") {
    	if (xhr.responseText) {
            addAlert(divId, "error", xhr.responseText);
    	} else {
            addAlert(divId, "error", msg);
    	}
    }
}// end function


