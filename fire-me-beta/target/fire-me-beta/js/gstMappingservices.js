//AJAX user management service functions
var gstMappingService = new function () {
    var serviceBase = 'http://10.3.9.245:9998/testing/read?callback=?';
    var taskcompleteBase = 'http://10.3.9.245:9998/testing/complete';
    var taskRejectBase = 'http://10.3.9.245:9998/testing/reject';
    // Get a list of pending tasks
    getEntryList = function (statusId, callback, error) {
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
    
    //Fetching list of all approved GST Mapping Entries
    fetchEntryList = function (statusId, callback, error) {
        $.ajax({
        	type: 'GET',
        	url: '/gst-gcr-webportal/gstmapping',
            dataType: 'json',
            success: function (data) { callback(data);},
            error: function( xhr, err) { 
                if (error) {
                    error( xhr, err );
                } else {
                    return xhrErr( statusId, xhr, err, "There was a problem while trying to get list of approved GST Mapping entries." ); 
                }
            }
        });

    },
    //Task Approval
    completeTask = function (statusId,objId,srcsysid,pritransid,sectransid,ieflag,ioflag,userid,taxcode0,txndesc,effdate,enddate,callback,error) {
        $.ajax({
        	type: 'GET',
            url: taskcompleteBase+'/'+objId+'/'+srcsysid+'/'+pritransid+'/'+sectransid+'/'+ieflag+'/'+ioflag+'/'+userid+'/'+taxcode0+'/'+txndesc+'/'+effdate+'/'+enddate+'?callback=?',
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
  //Task Rejection
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
                    return xhrErr( statusId, xhr, err, "There was a problem while trying to approve the tasks." ); 
                }
            }
        });

    };
    
    return {
    	getEntryList: getEntryList,
    	fetchEntryList: fetchEntryList,
    	completeTask: completeTask,
    	rejectTask: rejectTask
    };
} ();

