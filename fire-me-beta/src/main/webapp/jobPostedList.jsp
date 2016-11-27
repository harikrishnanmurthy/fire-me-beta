<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Job Postings History</title>
<%@include file="resources.jsp" %>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.datatables.net/1.10.11/css/dataTables.bootstrap.min.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Pragma" content="no-cache">
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div id="content" class="span9" style="width:80%;">
				<div class="row"
					style="margin-left: 0px !important; margin-top: 20px;">
					<div>
						<div class="datatableFix datatableFixPadding">
							<div id="status" style="word-wrap: break-word;"></div>
							<input type="hidden" id="userId" name="userId"/>
							<table id="jobPostedListings" class="table table-striped table-bordered" cellspacing="0" width="100%">
		        <thead>
		            <tr>
		                <th width="25%">Title</th>
		                <th>Skill Set</th>
		                <th>Type</th>
		                <th>Status</th>
		                <th>Action</th>
		            </tr>
		        </thead>
    		</table>
					</div>
				</div>
			</div>

			<div class="modal fade" id="moreInfo" tabindex="-1" role="dialog" aria-labelledby="moreInfoLabel">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="moreInfoLabel">More Information</h4>
			      </div>
					<div class="modal-body">
						<div class="form-group">
							<label for="comment">Job Description</label>
							<textarea class="form-control" rows="4" id="jobdescription" readonly="readonly"></textarea>
							<input type="hidden" id="statustoggle" />
<!-- 							<input type="hidden" id="jobseekeremail" /> -->
						</div>
					</div>
				  <div class="modal-footer">
				 	<button type="button" class="btn btn-info" id="editJob"><span class="glyphicon glyphicon-download-alt"></span>&nbsp Edit Job</button>
<!-- 			        <button type="button" class="btn btn-primary" id="sendEmail"><span class="glyphicon glyphicon-envelope"></span>&nbsp Email</button> -->
<!-- 			        <button type="button" class="btn btn-warning" id="sendSMS"><span class="glyphicon glyphicon-phone"></span>&nbsp SMS</button> -->
			      </div>
			    </div>
			  </div>
			</div>

			</div>
			<!--/span-->
		</div>
		<!--/row-->
	</div>
		<script type="text/javascript" src="https://cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/1.10.11/js/dataTables.bootstrap.min.js"></script>
		<script type="text/javascript" src="js/jobPostedList.js"></script>
</body>
</html>