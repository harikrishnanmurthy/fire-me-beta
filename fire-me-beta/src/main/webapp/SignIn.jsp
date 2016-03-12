<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@page session="true"%> --%>
<html>
<head>
<title>FireMe #beta</title>
<%@include file="resources.jsp" %>
<link href="css/signin.css" rel="stylesheet">
<style>
	html { 
	  background: url(skyline_2.jpg) no-repeat center center fixed; 
	  -webkit-background-size: cover;
	  -moz-background-size: cover;
	  -o-background-size: cover;
	  background-size: cover;
	}
</style>
</head>
<body style="background-color: transparent;">

	<div id="login-box">

		<img alt="Fire Me" src="firemeibegyou.png">

		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>

		<form class="form-signin" name='loginForm'
			action="<c:url value='/j_spring_security_check' />" method='POST'>
			<br>
				<input type='text' placeholder="Username" name='username' class='form-control'>
				<br>
				<input type='password' placeholder="Password" name='password' class='form-control'>
				<br>
				<input class='btn btn-lg btn-primary btn-block' name="submit" type="submit"
						value="Sign In	" />
		</form>
	</div>
	<div>
		<input class='btn btn-lg btn-warning margin-left31' name="recruiter" id="recruiter" value="New Recruiter" />
		<input class='btn btn-lg btn-warning margin-left5' name="jobSeeker" id="jobSeeker" value="New Job Seeker" />
	</div>
<%@include file="recruiterRegister.jsp" %>
<%@include file="jobSeekerRegister.jsp" %>
</body>
<script type="text/javascript" src="js/login.js"></script>
</html>