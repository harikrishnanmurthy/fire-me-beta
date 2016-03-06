//AJAX Tax Code management service functions
var fitrService = new function () {
    var serviceBase = 'http://10.3.9.245:9996/fitr/read?callback=?';
    var taskcompleteBase = 'http://10.3.9.245:9996/fitr/complete';
    var taskRejectBase = 'http://10.3.9.245:9996/fitr/reject';
    // Get list of FITR for approval
    getFITRList = function (statusId, callback, error) {
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
    // Get list of FITR for editing
    fetchFITRList = function (statusId, callback, error) {
        $.ajax({
        	type: 'GET',
        	url: '/gst-gcr-webportal/fitrcodes',
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
    completeTask = function (statusId, objId, taxcode, fitr, userid,effectivedate,enddate, callback, error) {
        $.ajax({
        	type: 'GET',
            url: taskcompleteBase+'/'+objId+'/'+taxcode+'/'+fitr+'/'+userid+'/'+effectivedate+'/'+enddate+'?callback=?',
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
    	getFITRList: getFITRList,
    	fetchFITRList: fetchFITRList,
    	completeTask: completeTask,
    	rejectTask: rejectTask
    };
} ();

