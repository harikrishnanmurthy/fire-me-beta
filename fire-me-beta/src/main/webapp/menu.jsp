<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
<meta charset="UTF-8">
<title>Menu</title>
<%@include file="resources.jsp" %>
<link href="css/menu.css" rel="stylesheet">
</head>
<body>
	<nav class="menu" tabindex="0">
		<div class="smartphone-menu-trigger"></div>
		<header class="avatar">
			<img
				src="https://s3.amazonaws.com/uifaces/faces/twitter/kolage/128.jpg" />
			<h2><c:out value="${requestScope.fullname}"></c:out></h2>
			<input type="hidden" id="menuusername" value="${requestScope.username}">
		</header>
		<c:if test="${requestScope.type == 'J'}">
			<ul>
				<li tabindex="0" class="icon-dashboard"><span id="jobSeekerDashboard">Dashboard</span></li>
				<li tabindex="0" class="icon-customers"><span id="jobListings">Job Listings</span></li>
				<li tabindex="0" class="icon-man"><span id="jobSeekerProfile">Profile</span></li>
				<li tabindex="0" class="icon-settings"><span id="settings">Settings</span></li>
				<li tabindex="0" class="icon-block"><span id="signout">Sign Out</span></li>
			</ul>
		</c:if>
		<c:if test="${requestScope.type == 'R'}">
			<ul>
				<li tabindex="0" class="icon-dashboard"><span id="recruiterDashboard">Dashboard</span></li>
				<li tabindex="0" class="icon-customers"><span id="jobSeekerListings">Job Seeker Listings</span></li>
				<li tabindex="0" class="icon-customers"><span id="postJob">Post A Job</span></li>
				<li tabindex="0" class="icon-customers"><span id="jobPostedList">Job Postings already offered</span></li>
				<li tabindex="0" class="icon-man"><span id="recruiterProfile">Profile</span></li>
				<li tabindex="0" class="icon-settings"><span id="settings">Settings</span></li>
				<li tabindex="0" class="icon-block"><span id="signout">Sign Out</span></li>
			</ul>
		</c:if>
	</nav>

	<main>
	<iframe src="jobSeekerDashboard.jsp" name="displayFrame" id="dframe" class="upload"
		frameborder="0"
		style="border: 0; overflow: hidden; height: 100%; width: 100%">
		<p>Please select a link to display content here !</p>
	</iframe>
	</main>
</body>
<script type="text/javascript" src="js/menu.js"></script>
</html>