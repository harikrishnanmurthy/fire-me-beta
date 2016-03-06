//AJAX user management service functions
var userManageService = new function () {
    var serviceBase = '/gst-gcr-webportal/listAllFiles';
    // Get a list of users
    getFileList = function (statusId, callback, error) {
        $.ajax({
            type: 'GET',
            url: serviceBase,
            dataType: 'json',
            success: function (data) { callback(data);},
            cache: false,
            error: function( xhr, err) { 
                if (error) {
                    error( xhr, err );
                } else {
                    return xhrErr( statusId, xhr, err, "There was a problem while trying to get list of users." ); 
                }
            }
        });
    };
    return {
    	getFileList: getFileList
    };
} ();

