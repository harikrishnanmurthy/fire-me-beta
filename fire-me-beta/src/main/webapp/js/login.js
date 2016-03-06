
$("document").ready(function(){
	
	$("#recruiter").click(function(){
		$('#recruiterRegisterDiv').modal('show');
	});
	
	$("#jobSeeker").click(function(){
		$('#jobSeekerRegisterDiv').modal('show');
	});
	
	$("#registerJobSeeker").click(function(){
		$('#registerJobSeekerForm').submit();
	});
	
	$("#registerRecruiter").click(function(){
		$('#registerRecruiterForm').submit();
	});
});

