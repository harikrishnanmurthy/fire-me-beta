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
				<h4>List GST Mapping Entries</h4>
				<div class="row"
					style="margin-left: 0px !important; margin-top: 20px;">
					<div>
						<div style="background-color: #E9E9E9; text-align: center;">
							<h5>GST Mapping Entries</h5>
						</div>
						<div class="datatableFix datatableFixPadding">
							<div id="status" style="word-wrap: break-word;"></div>
							<table class="table table-striped table-condensed"
								id="listGstMappingTable">
								<thead>
									<tr>
										<th width="2%" font-size="5px;">SrcSysCode</th>
										<th>PrimaryTxn</th>
										<th>SecondaryTxn</th>
										<th>I/E</th>
										<th>I/O</th>
										<th>TaxCode0</th>
										<th>TxnDesc</th>
										<th>User Id</th>
										<th>Effective Start</th>
										<th>End Date</th>
										<th>Action</th>
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
						<h5>Edit GST Mapping Entry</h5>
					</div>
					<div class="modal-body" style="height: 220px;">
						<div id="changePasswordStatus"></div>
						<form id="changePasswordForm" name="changePasswordForm"
							method="get" class="well form-horizontal" action="http://10.3.9.245:9998/testing/create/49">
							<div class="control-group">
								<label class="control-label" for="inputPassword">SrcSysCode</label>
								<div class="controls">
									<input type="text" id="changesrcsyscode" name="src_cd"
										class="noEnterSubmit" />
								</div>
							</div>
							<div class="control-group" id="changePasswordFormPasswordGroup">
								<label class="control-label" for="inputPassword">Primary Transaction Code</label>
								<div class="controls">
									<input type="text" id="changepritxncode" name="pritransid"
										class="noEnterSubmit" />
								</div>
							</div>
							<div class="control-group" id="changePasswordFormPasswordGroup">
								<label class="control-label" for="inputPassword">Secondary Transaction Code</label>
								<div class="controls">
									<input type="text" id="changesectxncode" name="sectransid"
										class="noEnterSubmit" />
								</div>
							</div>
							<div class="control-group"
								id="changePasswordFormonfirmPasswordGroup">
								<label class="control-label" for="inputonfirmPassword">I/E Indicator</label>
								<div class="controls">
									<input type="text" id="changeie" name="ieflag"
										class="noEnterSubmit" />
								</div>
							</div>
							<div class="control-group"
								id="changePasswordFormonfirmPasswordGroup">
								<label class="control-label" for="inputonfirmPassword">I/O Flag</label>
								<div class="controls">
									<input type="text" id="changeio" name="ioflag"
										class="noEnterSubmit" />
								</div>
							</div>
							<div class="control-group"
								id="changePasswordFormonfirmPasswordGroup">
								<label class="control-label" for="inputonfirmPassword">TaxCode</label>
								<div class="controls">
									<input type="text" id="changetaxcode0" name="taxcode0"
										class="noEnterSubmit" />
								</div>
							</div>
							<div class="control-group"
								id="changePasswordFormonfirmPasswordGroup">
								<label class="control-label" for="inputonfirmPassword">Transaction Description</label>
								<div class="controls">
									<input type="text" id="changetxndesc" name="txndesc"
										class="noEnterSubmit" />
								</div>
							</div>
							<div class="control-group"
								id="changePasswordFormonfirmPasswordGroup">
								<label class="control-label" for="inputonfirmPassword">User Id</label>
								<div class="controls">
									<input type="text" id="changeuserid" name="userid"
										class="noEnterSubmit" />
								</div>
							</div>
							<div class="control-group"
								id="changePasswordFormonfirmPasswordGroup">
								<label class="control-label" for="inputonfirmPassword">Effective Start Date</label>
								<div class="controls">
									<input type="text" id="changeeffdate" name="effstart"
										class="noEnterSubmit" />
								</div>
							</div>
							<div class="control-group"
								id="changePasswordFormonfirmPasswordGroup">
								<label class="control-label" for="inputonfirmPassword">End Date</label>
								<div class="controls">
									<input type="text" id="changeenddate" name="effend"
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
	<script type="text/javascript" src="js/gstMappingservices.js"></script>
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
	<script type="text/javascript" src="js/listGstMappinghome.js"></script>

</body>
</html>