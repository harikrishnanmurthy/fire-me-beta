<!doctype html>
<html>
<head>
<title>Doughnut Chart</title>
<%@include file="resources.jsp" %>
<script src="js/Chart.js"></script>
<style>
body {
	padding: 0;
	margin: 2%;
}

#canvas-holder {
	width: 30%;
}
</style>
</head>
<body>

	<div style="width: 100%;">
		<div style="float: left; width: 25%">
			<canvas id="chart-area" width="200" height="200"></canvas>
		</div>
		<div style="float: right;">
			<canvas id="canvas" height="250" width="450"></canvas>
		</div>
	</div>
	<div style="clear: both"></div>
	<div style="width: 34.5%; margin-left: auto; margin-right: auto">
		<canvas id="canvas1" height="250" width="250"></canvas>
	</div>
</body>
<script src="js/jobseekerdashboard.js"></script>
</html>
