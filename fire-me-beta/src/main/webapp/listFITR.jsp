<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List FITR</title>
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
				<h5>List FITR</h5>
				<div class="row"
					style="margin-left: 0px !important; margin-top: 20px;">
					<div>
						<div style="background-color: #E9E9E9; text-align: center;">
							<h5>FITR</h5>
						</div>
						<div class="datatableFix datatableFixPadding">
							<div id="status" style="word-wrap: break-word;"></div>
							<table class="table table-striped table-condensed"
								id="listfitrTable">
								<thead>
									<tr>
										<th width="7%">Tax Code</th>
										<th width="7%">FITR</th>
										<th width="7%">User Id</th>
										<th width="7%">Effective Date</th>
										<th width="7%">End Date</th>
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
						<h3>Edit FITR</h3>
					</div>
					<div class="modal-body" style="height: 220px;">
						<div id="changePasswordStatus"></div>
						<form id="changePasswordForm" name="changePasswordForm"
							method="get" class="well form-horizontal" action="http://10.3.9.245:9996/fitr/create/49">
							<div class="control-group">
								<label class="control-label" for="inputPassword">Tax Code</label>
								<div class="controls">
									<input type="text" id="changetaxcode" name="tax_cd"
										class="noEnterSubmit" />
								</div>
							</div>
							<div class="control-group" id="changePasswordFormPasswordGroup">
								<label class="control-label" for="inputPassword">FITR</label>
								<div class="controls">
									<input type="text" id="changefitr" name="fitr"
										class="noEnterSubmit" />
								</div>
							</div>
							<div class="control-group"
								id="changePasswordFormonfirmPasswordGroup">
								<label class="control-label" for="inputonfirmPassword">User Id</label>
								<div class="controls">
									<input type="text" id="changeuserid" name="user_id"
										class="noEnterSubmit" />
								</div>
							</div>
							<div class="control-group"
								id="changePasswordFormonfirmPasswordGroup">
								<label class="control-label" for="inputonfirmPassword">Effective Date</label>
								<div class="controls">
									<input type="text" id="changeeffectivedate" name="effective_date"
										class="noEnterSubmit" />
								</div>
							</div>
							<div class="control-group"
								id="changePasswordFormonfirmPasswordGroup">
								<label class="control-label" for="inputonfirmPassword">End Date</label>
								<div class="controls">
									<input type="text" id="changeenddate" name="end_date"
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
	<script type="text/javascript" src="js/fitrservices.js"></script>
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
	<script type="text/javascript" src="js/listfitrhome.js"></script>

</body>
</html>