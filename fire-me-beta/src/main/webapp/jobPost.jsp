<!DOCTYPE html>
<html lang="en">
<head>
	<%@include file="resources.jsp" %>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<title>Job Board - Bootstrap</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	<link rel="stylesheet" href="css/jobPost.css" title="job_blue" type="text/css">
</head>
<body>
	
<div class="container-fluid sidebar_content">
	<div class="row-fluid">
		
		<div class="span8">	
			<br />
			
			<h2><i class="icon-suitcase"></i>&nbsp;&nbsp;Post a new job</h2>
			
			<form class="" action="postJob" method="POST" id="jobPostForm" onsubmit="return validateForm()">
			<input type="hidden" id="userId" name="userId"/>
				<h3>Company Details</h3>
				<div class="row-fluid">
					<div class="span6">
						<div class="control-group">
							<label class="control-label">Company name</label>
							<div class="controls">
								<input type="text" class="span12" id="orgName" name="orgName" placeholder="">
								<span class="help-block">Enter your name or your company name</span>
							</div>
						</div>
					</div>
					
<!-- 					<div class="span6"> -->
<!-- 						<div class="control-group"> -->
<!-- 							<label class="control-label">Website</label> -->
<!-- 							<div class="controls"> -->
<!-- 								<div class="input-prepend"> -->
<!-- 									<span class="add-on">http://</span> -->
<!-- 									<input class="span12" id="prependedInput" name="website" type="text" placeholder=""> -->
<!-- 								</div> -->
<!-- 								<span class="help-block">Do you have a website?</span> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
					
				</div>			
				<br /><h3>Job Details</h3>
				
				<div class="row-fluid">
					
					<div class="span6">
						<div class="control-group">
							<label class="control-label">Job title</label>
							<div class="controls">
								<input type="text" class="span12" id="title" name="title" placeholder="">
							</div>
						</div>
					</div>
					
					<div class="span6">
						<div class="control-group">
							<label class="control-label">Job type</label>
							<div class="controls">
								<select id="type" name="type" class="span12" >
									<option>Freelance</option>
			                        <option>Full-Time</option>
			                        <option>Internship</option>
			                        <option>Part-Time</option>
			                        <option>Temporary</option>
								</select>
							</div>
						</div>
					</div>
				</div>
				
				<div class="row-fluid">
					
					<div class="span12">
						<div class="control-group">
							<label class="control-label">Description</label>
							<span class="help-block">Give details about the position, such as responsibilities &amp; salary.</span>
							<div class="controls">
							    <textarea rows="3" id="description" name="description" class="span12"></textarea>
							</div>
						</div>
					</div>
				</div>
				<div class="row-fluid">
					
					<div class="span6">
						<div class="control-group">
							<label class="control-label">Job skill</label>
							<div class="controls">
								<select class="span12" id="skill" name="skill">
									<option value="">Select a category...</option>
									<option value="Java/JEE" class="level-0">Java/JEE</option>
									<option value="Dot Net" class="level-0">Dot Net</option>
									<option value="Mainframe" class="level-0">Mainframe</option>
									<option value="DWBI" class="level-0">DWBI</option>
									<option value="Testing" class="level-0">Testing</option>
									<option value="Others" class="level-0">Others</option>
								</select>
							</div>
						</div>
					</div>
					
					<div class="span6">
						<div class="control-group">
							<label class="control-label">Job salary</label>
							<div class="controls">
								<select class="span12" id="salary" name="salary">
									<option value="">Select a salary</option>
									<option value="Less than 5,000" class="level-0">Less than 5,000</option>
									<option value="5,000 to 10,000" class="level-0">5,000 &ndash; 10,000</option>
									<option value="Greater than 10,000" class="level-0">10,000 and above</option>
								</select>
							</div>
						</div>
					</div>
					
				</div>			
				<br>
				
				<div class="row-fluid">
					<h3>Contact Details</h3>
					<div class="row-fluid">
						<div class="span6">
							<div class="control-group">
								<label class="control-label">Contact email</label>
								<div class="controls">
									<input type="text" class="span12" id="email" name="email" placeholder="">
								</div>
							</div>
						</div>
						
						<div class="span6">
							<div class="control-group">
								<label class="control-label">Contact Phone</label>
								<div class="controls">
									<input type="text" class="span12" name="phoneNo" name="phoneNo" placeholder="">
	<!-- 								<span class="help-block">Enter contact email address for this job posting</span> -->
								</div>
							</div>
						</div>
					</div>			
				</div>
				
<!-- 				<br /><h3>Job location</h3> -->
<!-- 				<div class="row-fluid"> -->
					
<!-- 					<div class="span12"> -->
<!-- 						<span class="help-block">Leave blank if the location of the applicant does not matter e.g. the job involves working from home.</span> -->
<!-- 						<div class="control-group"> -->
<!-- 							<div class="controls"> -->
<!-- 								<input type="text" class="span6" id="geolocation-address" autocomplete="off" placeholder=""> -->
<!-- 								<a class="btn btn-primary btn-success" id="geolocation-load" href="#">Search</a> -->
								
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div>				 -->
<!-- 				</div>				 -->
<!-- 				<div class="row-fluid"> -->
<!-- 					<div class="span12"> -->
						
<!-- 						<div id="geolocation_box"> -->
							
<!-- 							<input type="hidden" class="text" id="geolocation-latitude" value="" /> -->
<!-- 							<input type="hidden" class="text" id="geolocation-longitude" value="" /> -->
							
<!-- 							<div id="map_wrap"> -->
<!-- 								<div id="geolocation-map"></div> -->
<!-- 							</div> -->
							
<!-- 						</div> -->
						
						
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 				<div class="row-fluid"> -->
<!-- 					<div class="span12"> -->
<!-- 						<br /><h3>How to apply</h3> -->
<!-- 						<div class="control-group"> -->
<!-- 							<span class="help-block">Tell applicants how to apply, they will also be able to email you via the 'apply' form on your job listing's page.</span> -->
<!-- 							<div class="controls"> -->
<!-- 								<textarea rows="3" class="span12"></textarea> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
					
<!-- 				</div> -->

<!-- 					<a class="btn btn-success btn-large pull-right" id="postjob">Post job</a><br/><br/> -->
					<div class="col-submit">
						<button class="btn btn-success btn-large pull-right submitbtn">Post Job</button><br/><br/>
					</div>
				</form>
			
		</div>
		
		<div class="span4 sidebar" style="height:16.5em !important">	
			<br />
			<br />
			<h3>Posting a job is Free!!!</h3>
			
			<div class="row-fluid form-tooltip">	
				
				<div class="span12">
					<h4>Integrated analytics</h4>
				</div>	
			</div>	
			<div class="row-fluid">
				
				<div class="span12">
					<h4>View CVs instantly</h4>
				</div>			
			</div>			
			<div class="row-fluid">
				
				<div class="span12">
					<h4>Reach thousands of users</h4>
					Post jobs that reaches thousands that are immediately available.
				</div>
			</div>
		</div>		
		
	</div>
	
</div>
<script type="text/javascript">
var elems = Array.prototype.slice.call(document.querySelectorAll('.js-switch'));

elems.forEach(function(html) {
  var switchery = new Switchery(html);
});

$(function(){
	 var usernamefrommenu = window.parent.document.getElementById('menuusername').value;
	 console.log(usernamefrommenu);
	 $("#userId").val(usernamefrommenu);
});

function validateForm() {
    
}
</script>
</body>
</html>