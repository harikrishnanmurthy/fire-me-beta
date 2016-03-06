//AJAX Legal Entity Code management service functions
var legalentityService = new function () {
    var serviceBase = 'http://10.3.9.245:9995/legalentity/read?callback=?';
    var taskcompleteBase = 'http://10.3.9.245:9995/legalentity/complete';
    var taskRejectBase = 'http://10.3.9.245:9995/legalentity/reject';
    // Get list of LE for approval
    getLegalEntityList = function (statusId, callback, error) {
        $.ajax({
        	type: 'GET',
            url: serviceBase,
            async: false,
            jsonpCallback: 'jsonCallback',
            contentType: "application/json",
            dataType: 'jsonp',
            success: function(data){
            	callback(data);
            },
            error: function( xhr, err) { 
                if (error) {
                    error( xhr, err );
                } else {
                    return xhrErr( statusId, xhr, err, "There was a problem while trying to get list of pending Tasks." ); 
                }
            }
        });

    },
    // Get list of LE for editing
    fetchLegalEntityList = function (statusId, callback, error) {
        $.ajax({
        	type: 'GET',
        	url: '/gst-gcr-webportal/legalentitycodes',
            dataType: 'json',
            success: function (data) { callback(data);},
            cache: false,
            error: function( xhr, err) { 
                if (error) {
                    error( xhr, err );
                } else {
                    return xhrErr( statusId, xhr, err, "There was a problem while trying to get list of approved Tasks." ); 
                }
            }
        });

    },
    // Approve  task
    completeTask = function (statusId, objId, entityCode,entityName,entityDesc,busRegNum,gstRegNum,userId,effectivedate,enddate, callback, error) {
        $.ajax({
        	type: 'GET',
            url: taskcompleteBase+'/'+objId+'/'+entityCode+'/'+entityName+'/'+entityDesc+'/'+busRegNum+'/'+gstRegNum+'/'+userId+'/'+effectivedate+'/'+enddate+'?callback=?',
            async: false,
            jsonpCallback: 'jsonCallback',
            contentType: "application/json",
            dataType: 'jsonp',
            success: function(data){
            	callback(data);
            },
            error: function( xhr, err) { 
                if (error) {
                    error( xhr, err );
                } else {
                    return xhrErr( statusId, xhr, err, "There was a problem while trying to approve the tasks." ); 
                }
            }
        });

    },
    // Reject  task
    rejectTask = function (statusId, objId, reason, callback, error) {
        $.ajax({
        	type: 'GET',
            url: taskRejectBase+'/'+objId+'/'+reason+'?callback=?',
            async: false,
            jsonpCallback: 'jsonCallback',
            contentType: "application/json",
            dataType: 'jsonp',
            success: function(data){
            	callback(data);
            },
            error: function( xhr, err) { 
                if (error) {
                    error( xhr, err );
                } else {
                    return xhrErr( statusId, xhr, err, "There was a problem while trying to reject the tasks." ); 
                }
            }
        });
    };
    
    return {
    	getLegalEntityList: getLegalEntityList,
    	fetchLegalEntityList: fetchLegalEntityList,
    	completeTask: completeTask,
    	rejectTask: rejectTask
    };
} ();

