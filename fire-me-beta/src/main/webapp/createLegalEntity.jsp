<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Legal Entity</title>
    <link rel="stylesheet" type="text/css" href="main.css">
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
    <script src="jquery.min.js"></script>
	<link rel="stylesheet" href="jquery-ui.css" />
	<link href="jquery-ui-1.9.2.custom.css" rel="stylesheet">
 	<script src="jquery-1.8.3.js" type="text/javascript"></script> 
	<script src="jquery-ui-1.9.2.custom.js" type="text/javascript"></script>
	<script src="jquery-ui.min.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/bootbox.min.js"></script>
</head>
<style>

label{
width:250px;
}

.help {
padding-right: 450px;
}

</style>
<body>

<TABLE>
		<TR>
			<TD class="help"><H5>Create Legal Entity</H5></TD>
			<TD><div onclick="javascript:displayHelpContact()"  class="help" id="ownerInfo" style="cursor: pointer"><h5>Help Contact ??</h5></div></TD>
		</TR>
</TABLE>
<form action="http://10.3.9.245:9995/legalentity/create/49" method="get" class="elegant-aero" onsubmit="">
<label for="entitycode">Entity Code*</label>
<input type="text" name="entitycode" id="entitycode"/>
<i id="taxCodetooltip" class="icon-question-sign icon-black" title="Tax Code"></i>
<br>
<label for="entityname">Entity Name*</label>
<input type="text" name="entityname" id="entityname"/>
<i id="fitrtooltip" class="icon-question-sign icon-black" title="Tax Code Description"></i>
<br>
<label for="entitydesc">Entity Desc*</label>
<input type="text" name="entitydesc" id="entitydesc"/>
<i id="usertooltip" class="icon-question-sign icon-black" title="User"></i>
<br>
<label for="busregnum">Bus Reg Num*</label>
<input type="text" name="busregnum" id="busregnum" />
<i id="effDatetooltip" class="icon-question-sign icon-black" title="Effective Date"></i>
<br>
<label for="gstregnum">GST Reg Num*</label>
<input type="text" name="gstregnum" id="gstregnum" />
<i id="endDatetooltip" class="icon-question-sign icon-black" title="End Date"></i>
<br>
<label for="effective_date">Effective Start Date*</label>
<input type="text" name="effective_date" id="effective_date" />
<i id="endDatetooltip" class="icon-question-sign icon-black" title="End Date"></i>
<br>
<label for="end_date">Effective End Date*</label>
<input type="text" name="end_date" id="end_date" />
<i id="endDatetooltip" class="icon-question-sign icon-black" title="End Date"></i>
<br>
<label for="user_id">User*</label>
<input type="text" name="user_id" id="user_id" readonly=readonly/>
<i id="usertooltip" class="icon-question-sign icon-black" title="User"></i>
<br>
<br>
<div align="center" >
<input type="submit" value="Submit FITR" class="button">
</div>
</form>

<!-- Modal Pop up for Help Contact -->

 <div class="modal hide" id="helpContactInfoModal" tabindex="-1">
                    <div class="modal-header">
                        <h5>Help Contact</h5>
                    </div>
                    <div class="modal-body" style="height: 150px;">
                        	<div class="control-group">
                                <label class="control-label" for="inputPassword">Owner</label>
                                <div class="controls">
                                    <input type="text" id="owner" name="owner"  class="noEnterSubmit"/>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="inputPassword">Responsibility</label>
                                <div class="controls">
                                    <input type="text" id="owner" name="owner"  class="noEnterSubmit"/>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="inputPassword">Approver Id</label>
                                <div class="controls">
                                	<input type="text" id="approver" name="approver"  class="noEnterSubmit" />
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="inputPassword">Escalation Id</label>
                                <div class="controls">
                                	<input type="text" id="escalation" name="escalation"  class="noEnterSubmit" />
                                </div>
                            </div>
                    </div>
                    <div class="modal-footer">
                        <button id="helpContactInfoOk" class="btn" data-dismiss="modal">OK</button>
                    </div>
</div>

</body>

<script>
	var lgduser = window.parent.document.getElementById('username').value;
	var approverId1 = window.parent.document.getElementById('approverid1').value;
	var approverId2 = window.parent.document.getElementById('approverid2').value;
	
	$('#user_id').val(lgduser);
	$("#effective_date").datepicker({dateFormat: 'yy-mm-dd'});
	$("#end_date").datepicker({dateFormat: 'yy-mm-dd'});
	
	 $(function() {
		 $( "#taxCodetooltip" ).tooltip();
		 $( "#fitrtooltip" ).tooltip();
		 });
	 
	 function displayHelpContact(){
		 	$('#approver').val(approverId1);
		 	$('#escalation').val(approverId2);
			$('#helpContactInfoModal').modal('show');
		}
	
	 $("#helpContactInfoOk").click(function() {
		    $("#helpContactInfoModal").modal('hide');
		});
	
</script>
</html>