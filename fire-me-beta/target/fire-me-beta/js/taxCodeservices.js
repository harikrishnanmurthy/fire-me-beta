//AJAX Tax Code management service functions
var taxCodeService = new function () {
    var serviceBase = 'http://10.3.9.245:9997/taxcode/read?callback=?';
    var taskcompleteBase = 'http://10.3.9.245:9997/taxcode/complete';
    var taskRejectBase = 'http://10.3.9.245:9997/taxcode/reject';
    // Get list of tax codes for approval
    getTaxCodeList = function (statusId, callback, error) {
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
    // Get list of tax codes for editing
    fetchTaxCodeList = function (statusId, callback, error) {
        $.ajax({
        	type: 'GET',
        	url: '/gst-gcr-webportal/taxcodes',
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
    completeTask = function (statusId, objId, taxcode, taxrate, taxinvoiceflag, taxcodedesc, userid,effectivedate,enddate, callback, error) {
        $.ajax({
        	type: 'GET',
            url: taskcompleteBase+'/'+objId+'/'+taxcode+'/'+taxrate+'/'+taxinvoiceflag+'/'+taxcodedesc+'/'+userid+'/'+effectivedate+'/'+enddate+'?callback=?',
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
    	getTaxCodeList: getTaxCodeList,
    	fetchTaxCodeList: fetchTaxCodeList,
    	completeTask: completeTask,
    	rejectTask: rejectTask
    };
} ();

