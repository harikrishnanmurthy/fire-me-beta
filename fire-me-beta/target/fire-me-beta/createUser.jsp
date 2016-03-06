<!DOCTYPE html>
<HTML lang="en">
<HEAD>
<META charset="utf-8">
<META http-equiv="X-UA-Compatible" content="IE=edge">
<META name="viewport" content="width=device-width, initial-scale=1">
<TITLE>Create User</TITLE>
<LINK href="bootstrap.min.css" rel="stylesheet">
<LINK
	href="jquery-ui-1.9.2.custom.css"
	rel="stylesheet">
<SCRIPT src="jquery-1.8.3.js"
	type="text/javascript"></SCRIPT>
<SCRIPT src="jquery-ui-1.9.2.custom.js"
	type="text/javascript"></SCRIPT>
<SCRIPT src="jquery.validate.js" type="text/javascript"></SCRIPT>
<LINK rel="stylesheet" type="text/css" href="font.css">
<SCRIPT src="dateUtil.js" type="text/javascript"></SCRIPT>
<STYLE type="text/css">
label {
	padding-left: 5px;
	width: 200px;
	font-weight: bold;
}

input[type="button"] {
	width: 100px;
	text-align: center;
}

.FormButtonLeft {
	margin-left: 20px;
	margin-right: 450px;
}

body {
	font: 62.5% "Trebuchet MS", sans-serif;
}

.demoHeaders {
	margin-top: 2em;
}

#dialog-link {
	padding: .4em 1em .4em 20px;
	text-decoration: none;
	position: relative;
}

#dialog-link span.ui-icon {
	margin: 0 5px 0 0;
	position: absolute;
	left: .2em;
	top: 50%;
	margin-top: -8px;
}

#icons {
	margin: 0;
	padding: 0;
}

#icons li {
	margin: 2px;
	position: relative;
	padding: 4px 0;
	cursor: pointer;
	float: left;
	list-style: none;
}

#icons span.ui-icon {
	float: left;
	margin: 0 4px;
}

.fakewindowcontain .ui-widget-overlay {
	position: absolute;
}

#ui-datepicker-div.ui-widget {
	background-color: #ffffff
}

select:focus {
	border-color: #2da5da;
}

h4 {
	color: green;
	text-align: center;
}

.tg {
	border-collapse: collapse;
	border-spacing: 0;
}

td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	overflow: hidden;
	word-break: normal;
	width: 50%;
	padding-left: 20px;
}

th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: bold;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
}
</STYLE>
<SCRIPT type="text/javascript" src="admin_user_management.js"></SCRIPT>
<SCRIPT type="text/javascript">
	$(function() {
		ShowLocalDate();
		 $("#searchApprover1").click(function() {
		 //alert("here");
		 if ($("#approverOneLanID").val() == "") {
		 alert("Enter a valid Lan ID first !");
		 } else if ($("#approverOneLanID").val() != "c0001676") {
		 alert("No match found!");
		 } else {
		 if ($("#approverOneLanID").val() == "c0001676")
		 {
		 alert("match found !")
		 }
		 }
		 }); 
		  $("#searchApprover2").click(function() {
		 //alert("here");
		 if ($("#approverTwoLanId").val() == "") {
		 alert("Enter a valid Lan ID first !");
		 } else if ($("#approverTwoLanId").val() != "c0001676") {
		 alert("No match found!");
		 } else {
		 if ($("#approverTwoLanId").val() == "c0001676")
		 {
		 alert("match found !")
		 }
		 }
		 }); 
	});
</SCRIPT>

<LINK rel="stylesheet" type="text/css" href="main.css">
<LINK rel="stylesheet" type="text/css" href="css/AmBank_Style.css">
<LINK rel="stylesheet" type="text/css" href="css/normalize.css">
</HEAD>
<BODY>
	<FORM
		action="createUser" method="GET" style="MIN-WIDTH: 150px; BACKGROUND-COLOR: #ffffff; FONT-FAMILY: 'Open Sans', 'Helvetica Neue', 'Helvetica', Arial, Verdana, sans-serif; MAX-WIDTH: 55%; COLOR: #666666; FONT-SIZE: 14px"
		class="ambank-style" id="cmpForm" action="">
		<FIELDSET align="center" style="BACKGROUND-COLOR: #FBFBEF;">
			<H5>Create new user</H5>
			<HR>
			<TABLE>
				<TR>
					<TD><DIV class="element-email">

							<DIV class="col-md-6">
								<LABEL class="title" for="approverOneDomain">Domain: </LABEL> <SELECT
									name="approverOneDomain" id="role">
									<OPTION value="">Please Select</OPTION>
									<OPTION value="1">AMBANKGROUP</OPTION>
									<OPTION value="2">Domain2</OPTION>
									<OPTION value="3">Domain3</OPTION>
									<OPTION value="4">Domain3</OPTION>
								</SELECT>

							</DIV>
						</DIV></TD>
					<TD width="50%"><DIV class="element-email">
							<DIV class="col-md-6">
								<LABEL class="title" for="lanId">LAN ID: <A href="#"
									id="searchUser">&nbsp;<IMG src="img/search-button.png"
										title="Search and populate data" alt="" /></A></LABEL> <INPUT id="lanId"
									name="lanId" placeholder="" class="element-input" required
									type="text">


							</DIV>
						</DIV></TD>

				</TR>
				<TR>
					<TD>
						<DIV class="col-md-6">
							<LABEL class="title" for="name">Name: </LABEL> <INPUT id="name"
								name="name" placeholder="" class="element-input" required
								type="text">

						</DIV>
					</TD>
										<TD><DIV class="element-email">

							<DIV class="col-md-6">
								<LABEL class="title" for="role">User Role </LABEL> <SELECT
									name="role" id="role">
									<OPTION value="">Please Select</OPTION>
									<OPTION value="1">Admin</OPTION>
									<OPTION value="2">Creator</OPTION>
									<OPTION value="3">Approver</OPTION>
									<OPTION value="4">Viewer</OPTION>
									<OPTION value="5">Group Tax Creator</OPTION>
									<OPTION value="6">Group Tax Approver</OPTION>
								</SELECT>

							</DIV>
						</DIV></TD>
				</TR>
				<TR>
					<TD><DIV class="element-email">

							<DIV class="col-md-6">
								<LABEL class="title" for="approver2">Approver 1 (LAN
									ID):<A href="#" id="searchApprover1">&nbsp;<IMG
										src="img/search-button.png" title="Search and populate data"
										alt="" /></A>
								</LABEL> <INPUT id="approverOneLanID" name="approverOneLanID"
									class="element-input" required type="text">

							</DIV>
						</DIV></TD>
						<TD><DIV class="element-email">
							<DIV class="col-md-6">
								<LABEL class="title" for="approver2">Approver 2 (LAN
									ID):<A href="#" id="searchApprover2">&nbsp;<IMG
										src="img/search-button.png" title="Search and populate data"
										alt="" /></A>
								</LABEL> <INPUT id="approverTwoLanId" name="approverTwoLanId"
									class="element-input" required type="text">

							</DIV>
						</DIV></TD>
				</TR>
				<tr>
					<TD width="50%"><DIV class="element-email">
							<DIV class="col-md-6">
								<LABEL class="title" for="sourceSystem">Source System: <A href="#"
									id="searchUser">&nbsp;<IMG src="img/search-button.png"
										title="Search and populate data" alt="" /></A></LABEL> <INPUT id="sourceSystem"
									name="sourceSystem" placeholder="" class="element-input" required
									type="text">
							</DIV>
						</DIV></TD>
				</tr>
			</TABLE>
			<BR>
			<HR>
			<DIV align="center">
				<INPUT type="submit" value="Create User"/>
			</DIV>
		</FIELDSET>
	</FORM>
</BODY>
</HTML>