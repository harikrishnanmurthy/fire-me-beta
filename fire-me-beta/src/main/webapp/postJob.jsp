<!DOCTYPE html>
<html lang="en"><head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<title>Job Board - Bootstrap</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
<!-- 		<link rel="stylesheet" href="css/theme_switcher.css" type="text/css"> -->
		
			<link rel="stylesheet" href="css/jobPost.css" title="job_blue" type="text/css">
<!-- 			<link rel="stylesheet" href="css/job_blue.responsive.css" title="job_blue" type="text/css"> -->
				
    <!--[if lt IE 9]>
		<link rel="stylesheet" href="css/bootstrap_ie7.css" type="text/css">
		<link rel="stylesheet" href="css/ie7.css" type="text/css">
		<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
	
</head>

<body>
	
	
	
			<div class="container-fluid sidebar_content">
	<div class="row-fluid">
		
		<div class="span8">	
			<br />
			
			<h2><i class="icon-suitcase"></i>&nbsp;&nbsp;Post a new job</h2>
			
			<form class="">
				<h3>Company Details</h3>
				<div class="row-fluid">
					<div class="span6">
						<div class="control-group">
							<label class="control-label">Company name</label>
							<div class="controls">
								<input type="text" class="span12" name="orgName" placeholder="">
								<span class="help-block">Enter your name or your company name</span>
							</div>
						</div>
					</div>
					
					<div class="span6">
						<div class="control-group">
							<label class="control-label">Website</label>
							<div class="controls">
								<div class="input-prepend">
									<span class="add-on">http://</span>
									<input class="span12" id="prependedInput" name="website" type="text" placeholder="">
								</div>
								<span class="help-block">Do you have a website?</span>
							</div>
						</div>
					</div>
					
				</div>			
				<br /><h3>Job Details</h3>
				
				<div class="row-fluid">
					
					<div class="span6">
						<div class="control-group">
							<label class="control-label">Job title</label>
							<div class="controls">
								<input type="text" class="span12" name="title" placeholder="">
							</div>
						</div>
					</div>
					
					<div class="span6">
						<div class="control-group">
							<label class="control-label">Job type</label>
							<div class="controls">
								<select id="job_type" name="type" class="span12" >
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
							    <textarea rows="3" name="description" class="span12"></textarea>
							</div>
						</div>
					</div>
				</div>
				<div class="row-fluid">
					
					<div class="span6">
						<div class="control-group">
							<label class="control-label">Job skill</label>
							<div class="controls">
								<select class="span12" id="job_term_cat" name="skill">
									<option value="">Select a category...</option>
									<option value="38" class="level-0">Java/JEE</option>
									<option value="43" class="level-0">Dot Net</option>
									<option value="40" class="level-0">Mainframe</option>
									<option value="41" class="level-0">DWBI</option>
									<option value="39" class="level-0">Testing</option>
									<option value="42" class="level-0">Others</option>
								</select>
							</div>
						</div>
					</div>
					
					<div class="span6">
						<div class="control-group">
							<label class="control-label">Job salary</label>
							<div class="controls">
								<select class="span12" id="job_term_salary" name="salary">
									<option value="">Select a salary/option>
									<option value="9" class="level-0">Less than 20,000</option>
									<option value="10" class="level-0">20,000 &ndash; 40,000</option>
									<option value="11" class="level-0">40,000 &ndash; 60,000</option>
									<option value="12" class="level-0">60,000 &ndash; 80,000</option>
									<option value="13" class="level-0">80,000 &ndash; 100,000</option>
									<option value="14" class="level-0">100,000 and above</option>
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
									<input type="text" class="span12" name="email" placeholder="">
									<span class="help-block">Enter contact email address for this job posting</span>
								</div>
							</div>
						</div>
						
						<div class="span6">
							<div class="control-group">
								<label class="control-label">Contact Phone</label>
								<div class="controls">
									<input type="text" class="span12" name="phoneNo" placeholder="">
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
				
				<a class="btn btn-success btn-large pull-right" href="post-job.html">Post job</a><br /><br />
				
				
			</form>
			
		</div>
		
		<div class="span4 sidebar">	
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
	
<!-- </div><footer> -->
<!-- 	<div class="container-fluid"> -->
<!-- 		<div class="row-fluid footer_section_pre"> -->
			
<!-- 			<div class="span12"> -->
<!-- 				<p class="copy center"><a href="typography.html">Terms</a> | <a href="typography.html">Privacy</a> | <a href="typography.html">Typography</a> | <a href="typography.html">About</a></p> -->
<!-- 				<p class="copy center">All content &copy; 2013 <a href="http://appsarea.com/">AppsArea</a></p> -->
<!-- 				<br /> -->
<!-- 			</div> -->
<!-- 		</div> -->
    	
<!-- 	</div> -->
<!-- </footer> -->

<script type="text/javascript" src="http://www.google.com/jsapi"></script>
<script src="http://maps.google.com/maps/api/js?sensor=false"></script>

<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/jquery.flot.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
<script src="js/global.js" type="text/javascript"></script>
<script src="js/stylesheetToggle.js" type="text/javascript"></script>


<script>
	$(function() {
		$.stylesheetInit();
// 		$('#theme_switcher').val('job_blue');
		$('#theme_switcher_btn').bind('click',
		function(e) {
			$.stylesheetSwitch($('#theme_switcher').val());
			return false;
		}
		);
	});
	
</script>

</body>
</html>