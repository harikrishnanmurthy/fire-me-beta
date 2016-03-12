<!DOCTYPE html>
<html>
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
			<h2>John D.</h2>
		</header>
		<ul>
			<li tabindex="0" class="icon-dashboard"><span id="dashboard">Dashboard</span></li>
			<li tabindex="0" class="icon-customers"><span id="customers">Customers</span></li>
			<li tabindex="0" class="icon-users"><span>Users</span></li>
			<li tabindex="0" class="icon-settings"><span>Settings</span></li>
		</ul>
	</nav>

	<main>
	<iframe src="dashboard.jsp" name="displayFrame" id="dframe" class="upload"
		frameborder="0"
		style="border: 0; overflow: hidden; height: 100%; width: 100%">
		<p>Please select a link to display content here !</p>
	</iframe>
	</main>
</body>
<script type="text/javascript" src="js/menu.js"></script>
</html>