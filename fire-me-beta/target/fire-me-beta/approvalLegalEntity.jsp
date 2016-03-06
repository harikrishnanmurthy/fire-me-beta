<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<title>Legal Entity Approval</title>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
<link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Pragma" content="no-cache">
<script src="jquery.min.js"></script>
<link rel="stylesheet" href="jquery-ui.css" />
<script src="jquery-ui.min.js"></script>
</head>
<body>
<div class="container-fluid" width="100%">
      <div class="row-fluid">
       <div id="content" class="span9">
	<div class="row" style="margin-left: 0px !important; margin-top:20px;">
                    <div>
                        <div style="background-color: #E9E9E9; text-align: center;"><h5>Legal Entity Approval</h5></div>
                        <div class="datatableFix datatableFixPadding">
                        <div id="status" style="word-wrap: break-word;"></div>
                        <table class="table table-striped table-condensed" id="legalentityTable" >
                            <thead>
									<tr>
										<th>Entity Code</th>
										<th>Entity Name</th>
										<th>Entity Desc</th>
										<th>Bus Reg Num</th>
										<th>GST Reg Num</th>
										<th>User</th>
										<th>Effective Start Date</th>
										<th>End Date</th>
										<th>Approve</th>
										<th>Reject</th>
									</tr>
								</thead>
                            <tbody>
                            </tbody>
                        </table>
                       
                        </div>
                    </div>
                </div>
                <div class="modal hide" id="rejectGSTTask" tabindex="-1">
                    <div class="modal-header">
                        <h3>Reject Task</h3>
                    </div>
                    <div class="modal-body" style="height: 220px;">
                        <div id="changePasswordStatus"></div>
                        <form id="changePasswordForm" name="changePasswordForm"  method="post" class="well form-horizontal">
                        	<div class="control-group">
                                <label class="control-label" for="inputPassword">Task Id Rejected</label>
                                <div class="controls">
                                    <input type="text" id="rejectTaskId" name="rejectTaskId"  class="noEnterSubmit"/>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="inputPassword">Reason for Rejection</label>
                                <div class="controls">
                                	<input type="text" id="rejectreason" name="rejectreason"  class="noEnterSubmit" style="height:50px;"/>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button id="changePasswordAction" class="btn btn-primary">Submit</button>
                        <button id="changePasswordCancel" class="btn" data-dismiss="modal">Cancel</button>
                    </div>
                </div>
               </div>
             </div>
</div>
</body>
<script type="text/javascript" src="js/json2.js"></script>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootbox.min.js"></script>
<script type="text/javascript" src="js/legalentityservices.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.js"></script>
<script type="text/javascript" src="js/datatable.js"></script>
<script type="text/javascript" src="js/datatable.filterclear.js"></script>
<script type="text/javascript" src="js/datatable.findcellrownodes.js"></script>
<script type="text/javascript" src="js/datatable.sort.js"></script>
<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript" src="js/legalentityhome.js"></script>

</html>