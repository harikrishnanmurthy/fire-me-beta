//AJAX user management service functions
var userService = new function () {
    var serviceBase = '/gst-gcr-webportal/users',
    // Get a list of users
    getUserList = function (statusId, callback, error) {
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
    },
    
    changePassword = function (statusId,userid,name,empno,domainid,roleid,appid1,appid2,sourcesystem,callback, error) {
        $.ajax({
            type: 'POST',
            url: '/gst-gcr-webportal/updateUser',
            dataType: 'json',
            contentType: "application/json",
            data: JSON.stringify({ "lanId": userid, "name": name, "employeeNo": empno, "domainId": domainid, "userRole": roleid, "approverId1": appid1, "approverId2": appid2, "sourceSystem":sourcesystem }),
            success: function (data) { callback(data); },
            cache: false,
            error: function( xhr, err) { 
                if (error) {
                    error( xhr, err );
                } else {
                    return xhrErr( statusId, xhr, err, "There was a problem while changing password." ); 
                }
            }
        });
    };

    return {
        getUserList: getUserList,
        changePassword:changePassword
    };
} ();

