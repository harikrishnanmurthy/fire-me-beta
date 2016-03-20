$(function(){
	$("#dashboard").click(function(){
		console.log("dashboard");
		$("#dframe").attr("src","dashboard.jsp")
	});
	$("#listings").click(function(){
		console.log("jobListings");
		$("#dframe").attr("src","jobListings.jsp")
	});
	$("#profile").click(function(){
		console.log("profile");
		$("#dframe").attr("src","profile.jsp")
	});
	$("#signout").click(function(){
		console.log("signout");
		
		window.location.href = 'signOut.jsp';
		//$("#dframe").attr("src","signIn.jsp")
	});

});