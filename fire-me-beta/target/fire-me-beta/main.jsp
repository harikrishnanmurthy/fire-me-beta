<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
<title>Upload File Request Page</title>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">

<link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="main.css">
<script src="jquery.min.js"></script>
<link rel="stylesheet" href="jquery-ui.css" />
<script src="jquery-ui.min.js"></script>
<script src="min.js"></script>
<script src="file-upload.js"></script>
<link rel="stylesheet" href="file-upload.css" />

<style>
.uploading label {
padding-left: 10px;
width: 400px;
padding-left:20px;
}
 .file-upload, .file-upload span {
    width: 102px;
}
.file-upload span {
    display: inline-block;
    left: 0;
    position: absolute;
    top: 0;
}
</style>
</head>
<body>

<div class="elegant-aero" id="dwnldTemplate"> 
	Download the GCR Template from here <button class="btn btn-mini btn-info" id="gcrtemplate" style="margin-left:10px;"><i class="icon-download icon-white"></i>&nbsp;GCR Template</button>
</div>

<br>

<div class="elegant-aero" id="dwnldupldGST">
<div id="status" style="word-wrap: break-word;">
	<c:if test="${uploadflag=='success'}">
		<c:out value="${message}"></c:out>
	</c:if>
	<c:if test="${uploadflag=='error'}">
		<c:out value="${message}"></c:out>
	</c:if>
</div>
<br>
	<div id="uploadGST">
		<form method="POST" name="myForm" action="uploadFile" enctype="multipart/form-data" onsubmit="return validateForm()">
			<input name="file" type="file" id="gstfiletype">
			<input type="hidden" name="name"><br/>
			<button name="gstfilebutton" id="gstfilebutton" style="color:#ffffff;font-size: 10.5px; font-weight: normal; margin-top: 10px;background:#49AFCD;border:medium none;" onclick="document.formname.submit()"><i class="icon-upload icon-white"></i>&nbsp;Upload for GST Calculation</button> 
		</form>
	</div>
	
	<c:if test="${uploadflag=='success'}">
		<div align=right id="dwnldGST">
			Download the GST Computed File <button class="btn btn-mini btn-info" id="gstcalcfile" style="margin-left:10px;"><i class="icon-download icon-white"></i>&nbsp;GST File</button>
		</div>
	</c:if>
	
	<c:if test="${uploadflag=='error'}">
		<div align=right id="dwnldGST">
			Download the GST Computed File <button class="btn btn-mini btn-info" id="gsterrorfile" style="margin-left:10px;"><i class="icon-download icon-white"></i>&nbsp;GST File</button>
		</div>
	</c:if>
	
	
</div>

<br>
<div class="elegant-aero" id="uploadGCR">
<div id="status" style="word-wrap: break-word;">
	<c:if test="${gcruploadflag=='success'}">
		<c:out value="${gcrmessage}"></c:out>
	</c:if>
	<c:if test="${gcruploadflag=='failure'}">
		<c:out value="${gcrmessage}"></c:out>
	</c:if>
</div>
<br>
	<div>
		<form method="POST" name="mygcrForm" action="uploadgcrFile" enctype="multipart/form-data" onsubmit="return validategcrForm()">
			<input name="gcrfile" type="file">
			<input type="hidden" name="name"><br/>
			<button style="color:#ffffff;font-size: 10.5px; font-weight: normal; margin-top: 10px;background:#49AFCD;border:medium none;" onclick="document.formname.submit()"><i class="icon-upload icon-white"></i>&nbsp;Upload to GCR</button> 
		</form>
	</div>
	<br>
	<br>
</div>

<br>

</body>
<script>
function validateForm() {
    document.forms["myForm"]["name"].value = document.forms["myForm"]["file"].value;
}
function validategcrForm() {
    document.forms["mygcrForm"]["name"].value = document.forms["mygcrForm"]["gcrfile"].value;
}
</script>
<script type="text/javascript" src="js/downloadTemplate.js"></script>
</html>