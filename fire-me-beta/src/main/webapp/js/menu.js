$(function(){
	$("#dashboard").click(function(){
		console.log("Hi");
		$("#dframe").attr("src","dashboard.jsp")
	});
	$("#listings").click(function(){
		console.log("Hi");
		$("#dframe").attr("src","jobListings.jsp")
	});
	$("#profile").click(function(){
		console.log("Hi");
		console.log("check");
	
		$("#dframe").attr("src","profile.jsp")
	});
});