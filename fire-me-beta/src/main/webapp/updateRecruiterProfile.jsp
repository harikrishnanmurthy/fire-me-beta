<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="author" content="Dmitri Voronianski">
	<link rel="stylesheet" href="http://labs.voronianski.com/media/style/reset.css">
	<link rel="stylesheet" href="css/avgrundstyle.css">
	<link rel="stylesheet" href="css/avgrund.css">
</head>
<body>
	<div class="container">
		<div class="buttons">
			<a href="#" id="show" class="button left" style="display:none">Show it</a>
		</div>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
	<script src="js/jquery.avgrund.js"></script>
	<script>
	$(function() {
		$('.container').avgrund({
			height: 200,
			holderClass: 'custom',
			//showClose: true,
			showCloseText: 'close',
			onBlurContainer: '.container',
			template: '<p>You have Successfully updated your profile! Whats next? </p>' +
			'<div>' +
			'<a href="#" id="browseJobs" class="github">Browse Jobs</a>' +
			'<a href="#" id="takeMeToDashBoard" class="dribble">Take me to Dashboard</a>' +
			'</div>'
		});
		
		$("#show").trigger("click");
		
		$("#browseJobs").click(function(){
			window.parent.document.getElementById('dframe').src = "jobListings.jsp";
		});
		
		$("#takeMeToDashBoard").click(function(){
			window.parent.document.getElementById('dframe').src = "jobSeekerDashboard.jsp";
		});
	});
	</script>
</body>
</html>