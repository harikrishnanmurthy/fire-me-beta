<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<HTML>
<HEAD>
<TITLE>Task Creation</TITLE>
<LINK rel="stylesheet" type="text/css" href="main.css">
<LINK href="bootstrap/css/bootstrap.css" rel="stylesheet">
<LINK href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<SCRIPT src="jquery.min.js" type="text/javascript"></SCRIPT>
<LINK rel="stylesheet" href="jquery-ui.css" />
<LINK href="jquery-ui-1.9.2.custom.css" rel="stylesheet">
<SCRIPT src="jquery-1.8.3.js" type="text/javascript"></SCRIPT>
<SCRIPT src="jquery-ui-1.9.2.custom.js" type="text/javascript"></SCRIPT>
<SCRIPT src="jquery-ui.min.js" type="text/javascript"></SCRIPT>
<SCRIPT type="text/javascript" src="bootstrap/js/bootstrap.min.js"></SCRIPT>
<SCRIPT type="text/javascript" src="js/bootbox.min.js"></SCRIPT>
</HEAD>
<STYLE type="text/css">
label {
	width: 250px;
}

.help {
padding-right: 450px;
}
</STYLE>
<BODY>

	<TABLE>
		<TR>
			<TD class="help"><H5>Create Entry</H5></TD>
			<TD><div onclick="javascript:displayHelpContact()"  class="help" id="ownerInfo" style="cursor: pointer"><h5>Help Contact ??</h5></div></TD>
		</TR>
	</TABLE>
	<FORM action="http://10.3.9.245:9998/testing/create/49" method="get"
		class="elegant-aero" onsubmit="">
		<LABEL for="src_cd">Source System Code</LABEL> <INPUT type="text"
			name="src_cd" id="src_cd" /> <I id="srccodetooltip"
			class="icon-question-sign icon-black" title="Source System Code"></I> <BR>
			
		<LABEL for="pritransid">Primary Transaction Code</LABEL> <INPUT type="text"
			name="pritransid" id="pritransid" /> <I id="srccodetooltip"
			class="icon-question-sign icon-black" title="Source System Code"></I> <BR>
			
		<LABEL for="sectransid">Secondary Transaction Code</LABEL> <INPUT
			type="text" name="sectransid" id="sectransid" /> <I id="txncodetooltip"
			class="icon-question-sign icon-black" title="Transaction Code"></I> <BR>
			
		<LABEL for="ieflag">I/E Flag*</LABEL> <INPUT type="text"
			name="ieflag" id="ieflag" /> <I id="ieindtooltip"
			class="icon-question-sign icon-black"
			title="Inclusive/Exclusive Indicator"></I> <BR> 
			
		<LABEL for="ioflag">TI Flag*</LABEL> <INPUT type="text" name="ioflag"
			id="ioflag" /> <I id="tiflagtootltip"
			class="icon-question-sign icon-black" title="TI Flag"></I> <BR>
			
		<LABEL for="taxcode0">Tax Code</LABEL> <INPUT type="text"
			name="taxcode0" id="taxcode0" /> <I id="txcodetooltip"
			class="icon-question-sign icon-black" title="Tax Code 0"></I> <BR>
			
		<LABEL for="txndesc">Transaction Description</LABEL> <INPUT type="text"
			name="txndesc" id="txndesc" /> <I id="txratetooltip"
			class="icon-question-sign icon-black" title="Tax Rate 0"></I> <BR>
			
		<LABEL for="effstart">Effective Date*</LABEL> <INPUT type="text"
			name="effstart" id="effstart" /> <I id="effdatetooltip"
			class="icon-question-sign icon-black" title="Effective Date"></I> <BR>
			
		<LABEL for="effend">End Date*</LABEL> <INPUT type="text"
			name="effend" id="effend" /> <I id="enddatetooltip"
			class="icon-question-sign icon-black" title="End Date"></I> <BR>
			
		<LABEL for="userid">User Id*</LABEL> <INPUT type="text"
			name="userid" id="userid" /> <I id="enddatetooltip"
			class="icon-question-sign icon-black" title="End Date"></I> <BR>
			
		<BR>
		<DIV align="center">
			<INPUT type="submit" value="Create Task" class="button">
		</DIV>
	</FORM>
	<!-- Modal Pop up for Help Contact -->

 <div class="modal hide" id="helpContactInfoModal" tabindex="-1">
                    <div class="modal-header">
                        <h5>Help Contact</h5>
                    </div>
                    <div class="modal-body" style="height: 220px;">
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

</BODY>

	<SCRIPT type="text/javascript">
	var lgduser = window.parent.document.getElementById('username').value;
	var approverId1 = window.parent.document.getElementById('approverid1').value;
	var approverId2 = window.parent.document.getElementById('approverid2').value;
	
		$('#userid').val(lgduser);
		$("#effstart").datepicker({
			dateFormat : 'yy-mm-dd'
		});
		$("#effend").datepicker({
			dateFormat : 'yy-mm-dd'
		});
		$(function() {
			$("#ownerInfo").tooltip();
			$("#srccodetooltip").tooltip();
			$("#txncodetooltip").tooltip();
			$("#ieindtooltip").tooltip();
			$("#tiflagtootltip").tooltip();
			$("#txcodetooltip").tooltip();
			$("#txratetooltip").tooltip();
			$("#effdatetooltip").tooltip();
			$("#enddatetooltip").tooltip();
		});
		
		 
		 function displayHelpContact(){
			 	$('#approver').val(approverId1);
			 	$('#escalation').val(approverId2);
				$('#helpContactInfoModal').modal('show');
			}
		
		 $("#helpContactInfoOk").click(function() {
			    $("#helpContactInfoModal").modal('hide');
			});
	</SCRIPT>
	
	
</HTML>