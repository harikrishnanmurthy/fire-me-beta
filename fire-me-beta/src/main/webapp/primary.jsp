<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="false"%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>Upload File Request Page</title>
<link rel="stylesheet" type="text/css" href="main.css">
<script src="jquery.min.js"></script>
<link rel="stylesheet" href="jquery-ui.css" />
<script src="jquery-ui.min.js"></script>
<script>
	$(function() {
		$("#accordion").accordion();
	});
</script>
<style>
iframe {
	border: 0px;
}
</style>
</head>
<body>
	<img src="ambank_header.jpg" /> Welcome
	<c:out value="${username}" />
	<input id="username" type="hidden" value='<c:out value="${username}"></c:out>' />
	<input id="approverid1" type="hidden" value='<c:out value="${approverid1}"></c:out>' />
	<input id="approverid2" type="hidden" value='<c:out value="${approverid2}"></c:out>' />
	<a id="logoutflag" href="#"> Logout</a>
	<br>
	<br>
	<br>
	<div class="accordian-wrapper">
		<div id="accordion">
			<h3>GCR Interfaces</h3>
			<div>
				<a href="main.jsp" target="displayFrame">Upload & Download</a> <br><br>
			</div>
			<h3>Rejected Files</h3>
			<div>
				<a href="" target="displayFrame">GCR Rejected Files</a> <br><br>
				<a href="" target="displayFrame">Workflow Rejected Files</a>
			</div>
			<h3>Tax Code Management</h3>
			<div>
				<c:if test="${role=='2'}">
					<a href="createTaxCode.jsp" target="displayFrame">Create TaxCode</a> <br><br>
				</c:if>
				<c:if test="${role=='3'}">
					<a href="approvalTaxCode.jsp" target="displayFrame">Approve TaxCode</a> <br>
				</c:if>
				<c:if test="${role=='2'}">
					<a href="listTaxCode.jsp" target="displayFrame">List All TaxCodes</a> <br>
				</c:if>
			</div>
			<h3>GDE Mapping Management</h3>
			<div>
				<c:if test="${role=='2'}">
					<a href="createGSTMapping.jsp" target="displayFrame">Create GDE Mapping Entry</a> <br><br>
				</c:if>
				<c:if test="${role=='3'}">
					<a href="approvalGSTMapping.jsp" target="displayFrame">Approve GDE Mapping Entry</a> <br><br>
				</c:if>
				<c:if test="${role=='2'}">
					<a href="listGSTMappingEntry.jsp" target="displayFrame">List All GDE Mapping Entries</a> <br>
				</c:if>
			</div>
			<h3>FITR Management</h3>
			<div>
				<c:if test="${role=='2'}">
					<a href="createFITR.jsp" target="displayFrame">Create FITR</a> <br><br>
				</c:if>
				<c:if test="${role=='3'}">
					<a href="approvalFITR.jsp" target="displayFrame">Approve FITR</a> <br><br>
				</c:if>
				<c:if test="${role=='2'}">
					<a href="listFITR.jsp" target="displayFrame">List FITR</a> <br><br>
				</c:if>
			</div>
			<h3>Legal Entity Code Management</h3>
			<div>
				<c:if test="${role=='2'}">
					<a href="createLegalEntity.jsp" target="displayFrame">Create Legal Entity</a> <br><br>
				</c:if>
				<c:if test="${role=='3'}">
					<a href="approvalLegalEntity.jsp" target="displayFrame">Approve Legal Entity</a> <br><br>
				</c:if>
				<c:if test="${role=='2'}">
					<a href="listlegalentity.jsp" target="displayFrame">List Legal Entity</a> <br><br>
				</c:if>
			</div>
			<h3>User Management</h3>
			<div>
				<c:if test="${role=='2'}">
					<a href="createUser.jsp" target="displayFrame">Create User</a> <br><br>
					<a href="listUser.jsp" target="displayFrame">List Users</a> <br>
				</c:if>
			</div>
		</div>
	</div>
	
	
	<iframe src="main.jsp" name="displayFrame" class="upload"
		frameborder="0"
		style="border: 0; overflow: hidden; height: 90%; width: 80%"
		height="90%" width="80%">
		<p>Please select a link to display content here !</p>
	</iframe>

</body>
<script>
$("#logoutflag").click(function(){
	window.location.href="logoutRedirect.jsp";
});

</script>

</html>