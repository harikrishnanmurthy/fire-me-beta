<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Job Listings</title>
<%@include file="resources.jsp" %>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.datatables.net/1.10.11/css/dataTables.bootstrap.min.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Pragma" content="no-cache">
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div id="content" class="span9" style="width:100%;">
				<div class="row"
					style="margin-left: 0px !important; margin-top: 20px;">
					<div>
						<div class="datatableFix datatableFixPadding">
							<div id="status" style="word-wrap: break-word;"></div>
							<table id="jobListings" class="table table-striped table-bordered" cellspacing="0" width="100%">
		        <thead>
		            <tr>
		                <th>Company</th>
		                <th>Job Summary</th>
		                <th>Action</th>
		            </tr>
		        </thead>
		        <tfoot>
		            <tr>
		                <th>Company</th>
		                <th>Job Summary</th>
		                <th>Action</th>
		            </tr>
		        </tfoot>
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
		<script type="text/javascript" src="https://cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/1.10.11/js/dataTables.bootstrap.min.js"></script>
		<script type="text/javascript" src="js/joblistings.js"></script>
</body>
</html>