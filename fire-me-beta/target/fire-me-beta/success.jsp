<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <title>Success</title>

   
    <link href="main.css" rel="stylesheet">
    <style>
		#success{
		font-family: "Times New Roman", Times, serif;
		}
	</style>

  </head>
<body>
<br>
<br>
<br>
<br>
<div class="elegant-aero" align="center">
<h3 id="success">
	<c:out value="${message}"></c:out>
</h3>

<br>
<br>
   <!-- <input class="button" type="button" onClick="newFile()" value="Upload New File"/> -->
</div>
  
</body>
<script type="text/javascript">
function newFile(){
	window.location.href = 'upload.jsp';
}
</script>
</html>
