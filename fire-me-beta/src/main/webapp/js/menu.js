$(function(){
	$("#jobSeekerDashboard").click(function(){
		console.log("dashboard");
		$("#dframe").attr("src","jobSeekerDashboard.jsp")
	});
	$("#jobListings").click(function(){
		console.log("jobListings");
		$("#dframe").attr("src","jobListings.jsp")
	});
	$("#jobSeekerProfile").click(function(){
		console.log("profile");
		$("#dframe").attr("src","jobSeekerProfile.jsp")
	});
	$("#signout").click(function(){
		console.log("signout");
		window.location.href = 'signOut.jsp';
	});
	
	$("#recruiterDashboard").click(function(){
		console.log("profile");
		$("#dframe").attr("src","recruiterDashboard.jsp")
	});
	$("#recruiterProfile").click(function(){
		console.log("profile");
		$("#dframe").attr("src","recruiterProfile.jsp")
	});
	$("#jobSeekerListings").click(function(){
		console.log("profile");
		$("#dframe").attr("src","jobSeekerListings.jsp")
	});

});