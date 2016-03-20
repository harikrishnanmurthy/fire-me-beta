<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@page session="true"%> --%>
<html>
<head>
<title>FireMe #beta</title>
<%@include file="resources.jsp" %>
<link href="css/signin.css" rel="stylesheet">
<link href="css/sandbox.css" rel="stylesheet">
<link href="css/crosscover.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.3.0/animate.min.css">
</head>
<body>
  <div class="crosscover">
    <div class="crosscover-overlay">
      <div class="crosscover-island">
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
      </div>
    </div>

    <div class="crosscover-list">
      <a class="crosscover-item" href="http://blivesta.com" target="_blank">
        <img src="https://unsplash.it/1800/1200?image=741" alt="image01">
      </a>
      <div class="crosscover-item">
        <img src="https://unsplash.it/1800/1200?image=641" alt="image02">
      </div>
      <a class="crosscover-item" href="http://blivesta.com" target="_blank">
        <img src="https://unsplash.it/1800/1200?image=541" alt="image03">
      </a>
      <div class="crosscover-item">
        <img src="https://unsplash.it/1800/1200?image=441" alt="image04">
      </div>
      <a class="crosscover-item" href="http://blivesta.com" target="_blank">
       <img src="https://unsplash.it/1800/1200?image=341" alt="image05">
      </a>
    </div>

  </div>

<%@include file="recruiterRegister.jsp" %>
<%@include file="jobSeekerRegister.jsp" %>
</body>
<script src="js/crosscover.js" charset="utf-8"></script>
<script type="text/javascript" src="js/login.js"></script>
  <script>
  $(document).on('ready', function(){
    $('.crosscover').crosscover({
    	controller: true,
        dotNav: true
    });
  });
  </script>
</html>