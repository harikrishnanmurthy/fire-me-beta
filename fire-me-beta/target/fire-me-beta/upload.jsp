<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
<title>Upload File Request Page</title>
<link rel="stylesheet" type="text/css" href="main.css">
<script src="jquery.min.js"></script>
<link rel="stylesheet" href="jquery-ui.css" />
<script src="jquery-ui.min.js"></script>
</head>
<body>
<div class="wrapper" > 
	<form method="POST" name="myForm" action="uploadFile" enctype="multipart/form-data" onsubmit="return validateForm()" class="elegant-aero">
		GCR File to upload: <input type="file" name="file"><br/><br/><br/>
		<input type="hidden" name="name"><br/>
		<input type="submit" value="Upload" class="button"> Click here to upload the file!
	</form>
</div>
</body>

<script>
function validateForm() {
    document.forms["myForm"]["name"].value = document.forms["myForm"]["file"].value;
}
</script>


</html>