<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Users</title>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
<link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Pragma" content="no-cache">
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div id="content" class="span9" style="width:100%;">
				<h5>List All Users</h5>
				<div class="row"
					style="margin-left: 0px !important; margin-top: 20px;">
					<div>
						<div style="background-color: #E9E9E9; text-align: center;">
							<h5>Users</h5>
						</div>
						<div class="datatableFix datatableFixPadding">
							<div id="status" style="word-wrap: break-word;"></div>
							<table class="table table-striped table-condensed"
								id="userTable">
								<thead>
									<tr>
										<th width="7%">User Id</th>
										<th width="7%">Name</th>
										<th width="7%">Emp No</th>
										<th width="7%">Domain Id</th>
										<th width="7%">Role Id</th>
										<th width="7%">Approver Id 1</th>
										<th width="7%">Approver Id 2</th>
										<th width="7%">Source System</th>
										<th width="5%">Action</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>

						</div>
					</div>
				</div>

				<div class="modal hide" id="changePassword" tabindex="-1">
					<div class="modal-header">
						<h3>Edit Users</h3>
					</div>
					<div class="modal-body" style="height: 220px;">
						<div id="changePasswordStatus"></div>
						<form id="changePasswordForm" name="changePasswordForm"
							method="post" class="well form-horizontal" action="">
							<div class="control-group">
								<label class="control-label" for="inputPassword">User ID</label>
								<div class="controls">
									<input type="text" id="changeuserid" name="userid"
										class="noEnterSubmit" readonly="readonly"/>
								</div>
							</div>
							<div class="control-group" id="changePasswordFormPasswordGroup">
								<label class="control-label" for="inputPassword">Name</label>
								<div class="controls">
									<input type="text" id="changename" name="name"
										class="noEnterSubmit" />
								</div>
							</div>
							<div class="control-group"
								id="changePasswordFormonfirmPasswordGroup">
								<label class="control-label" for="inputonfirmPassword">Emp No</label>
								<div class="controls">
									<input type="text" id="changeempno" name="empno"
										class="noEnterSubmit" />
								</div>
							</div>
							<div class="control-group"
								id="changePasswordFormonfirmPasswordGroup">
								<label class="control-label" for="inputonfirmPassword">Domain Id</label>
								<div class="controls">
									<input type="text" id="changedomainid" name="domainid"
										class="noEnterSubmit" />
								</div>
							</div>
							<div class="control-group"
								id="changePasswordFormonfirmPasswordGroup">
								<label class="control-label" for="inputonfirmPassword">Role Id</label>
								<div class="controls">
									<input type="text" id="changeroleid" name="roleid"
										class="noEnterSubmit" />
								</div>
							</div>
							<div class="control-group"
								id="changePasswordFormonfirmPasswordGroup">
								<label class="control-label" for="inputonfirmPassword">Approver Id 1</label>
								<div class="controls">
									<input type="text" id="changeappid1" name="appid1"
										class="noEnterSubmit" />
								</div>
							</div>
							<div class="control-group"
								id="changePasswordFormonfirmPasswordGroup">
								<label class="control-label" for="inputonfirmPassword">Approver Id 2</label>
								<div class="controls">
									<input type="text" id="changeappid2" name="appid2"
										class="noEnterSubmit" />
								</div>
							</div>
							<div class="control-group"
								id="changePasswordFormonfirmPasswordGroup">
								<label class="control-label" for="inputonfirmPassword">Source System</label>
								<div class="controls">
									<input type="text" id="changesourcesystem" name="sourcesystem"
										class="noEnterSubmit" />
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
			<!--/span-->
		</div>
		<!--/row-->
	</div>


	<script type="text/javascript" src="js/json2.js"></script>
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/bootbox.min.js"></script>
	<script type="text/javascript" src="js/moment-1.6.2.min.js"></script>
	<script type="text/javascript" src="js/userservices.js"></script>
	<script type="text/javascript"
		src="js/jquery-ui-1.8.21.custom/development-bundle/ui/jquery.effects.core.js"></script>
	<script type="text/javascript"
		src="js/jquery-ui-1.8.21.custom/development-bundle/ui/jquery.effects.fade.js"></script>
	<script type="text/javascript" src="js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="js/jquery.dataTables.js"></script>
	<script type="text/javascript" src="js/datatable.js"></script>
	<script type="text/javascript" src="js/datatable.filterclear.js"></script>
	<script type="text/javascript" src="js/datatable.findcellrownodes.js"></script>
	<script type="text/javascript" src="js/datatable.sort.js"></script>
	<script type="text/javascript" src="js/main.js"></script>
	<script type="text/javascript" src="js/userhome.js"></script>

</body>
</html>