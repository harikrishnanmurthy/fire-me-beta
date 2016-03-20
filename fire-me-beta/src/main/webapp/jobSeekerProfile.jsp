<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PROFILE</title>

    <link href="css/profile.css" rel="stylesheet">
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">

</head>
<body>
<!--     <div class="row"> -->
   	 <div style="margin: 12px;">	
   	 <div id="jobSeekerProfileDiv" class="span12">
 		<form action="jobSeekerProfile" name="registerJobSeekerForm" class="jobSeekerForm" id="registerJobSeekerForm" method="POST">
			<fieldset>
				<label for="firstName">Your Name </label> 
				<div class="field"><input type="text" placeholder="Full Name" class="input-text" id="firstName" name="firstName"/></div>
			</fieldset>
		    <fieldset>
		    	<label for="emailID">Your Email </label>
		    	<div class="field"><input type="text" class="input-text"  placeholder="Email" id="emailID" name="emailID"/></div>
		    </fieldset>
		    <fieldset>
		    	<label for="emailID">Professional Title </label> 
		    	<div class="field"><input type="text" class="input-text"  placeholder="eg: Java Developer" id="emailID" name="emailID"/></div>
		    </fieldset>
		    <fieldset>
		    	<label for="emailID">Notice Period </label> 
		    	<div class="field"><input type="text" class="input-text"  placeholder="In days" id="emailID" name="emailID"/></div>
		    </fieldset>
		    <fieldset>
		    	<label for="emailID">Years of Experience </label> 
		    	<div class="field"><input type="text" class="input-text"  placeholder="Years of Experience" id="emailID" name="emailID"/></div>
		    </fieldset>
		    <fieldset class="fieldset">
		    	<label for="Photo">Photo</label>
		    	<div class="field">
		    		<input type="file" class="input-text" placeholder="Photo" id="photo" name="photo"/>
		    		<small class="description">Maximum file size: 16 MB. </small>
		    	</div>
		    </fieldset>
		    <fieldset>
		    	<label for="emailID">Video</label>
		    	<div class="field"><input type="text" class="input-text" placeholder="A link to a video about yourself" id="emailID" name="emailID"/></div>
		    </fieldset>
		    <fieldset>
		    	<label for="emailID">Skills</label>
		    	<div class="field"><input type="text" class="input-text"  placeholder="Separate using comma relevant skill set" id="emailID" name="emailID"/></div>
		    </fieldset>
		    <fieldset>
		    	<label for="emailID">Resume Upload</label> 
		    	<div class="field">
		    		<input type="file" class="input-text" placeholder="Resume Upload" id="emailID" name="emailID"/>
		    		<small class="description">Upload in word/pdf format</small>
		    	</div>
		    </fieldset>
		    <fieldset>
		    	<label for="emailID">Contact Number</label>
		    	<div class="field"><input type="text" class="input-text"  placeholder="Contact Number" id="emailID" name="emailID"/></div>
		    </fieldset>
		    <input type="hidden" id="type" name="type" class="noEnterSubmit" value="recruiter"/>
		</form>
	 </div>
	 </div>
<!-- 	</div> -->
</body>
</html>