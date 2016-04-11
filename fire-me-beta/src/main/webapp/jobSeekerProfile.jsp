<!doctype html>
<html lang="en-US">
<head>
<%@include file="resources.jsp" %>
  <meta charset="utf-8">
  <meta http-equiv="Content-Type" content="text/html">
  <link rel="shortcut icon" href="http://static.tmimgcdn.com/img/favicon.ico">
  <link rel="icon" href="http://static.tmimgcdn.com/img/favicon.ico">
  <link rel="stylesheet" type="text/css" media="all" href="css/styles.css">
  <link rel="stylesheet" type="text/css" media="all" href="css/switchery.min.css">
  <script type="text/javascript" src="js/switchery.min.js"></script>
</head>

<body>
  <div id="wrapper">
  <form action="jobSeekerprofile" enctype="multipart/form-data" name="registerJobSeekerForm" class="jobSeekerForm" onsubmit="return validateForm()" id="registerJobSeekerForm" method="POST">
  <input type="hidden" id="userName" name="userName"/>
  <div class="col-2">
    <label>
      Name
      <input placeholder="What is your full name?" id="fullName" name="fullName" tabindex="1">
    </label>
  </div>
  <div class="col-2">
    <label>
      Organization
      <input placeholder="Where do you currently work?" id="companyName" name="companyName" tabindex="2">
    </label>
  </div>
  
  <div class="col-3">
    <label>
      Phone Number
      <input placeholder="What is the best # to reach you?" id="phoneNo" name="phoneNo" tabindex="3">
    </label>
  </div>
  <div class="col-3">
    <label>
      Email
      <input placeholder="What is your e-mail address?" id="email" name="email" tabindex="4">
    </label>
  </div>
  <div class="col-3">
    <label>
      Availability
      <input placeholder="Availability" id="noticePeriod" name="noticePeriod" tabindex="4">
<!--       <select tabindex="5" id="noticePeriod" name="noticePeriod"> -->
<!--         <option> Less than a week </option> -->
<!--         <option> Less than a month </option> -->
<!--         <option> More than a month </option> -->
<!--       </select> -->
    </label>
  </div>
  <div class="col-4">
    <label>
      Title
	   <input placeholder="Current Designation" id="designation" name="designation" tabindex="4">
    </label>
  </div>
  <div class="col-4">
    <label>
      Primary Skills
        <select tabindex="5" id="skills" name="skills">
        <option> Java/JEE </option>
        <option> Dot Net </option>
        <option> Mainframe </option>
        <option> DWBI </option>
        <option> Testing </option>
        <option> Others </option>
      </select>
    </label>
  </div>
  <div class="col-4">
    <label>
      Secondary Skills
	   <input placeholder="Specializations if any" id="email" name="email" tabindex="4">
    </label>
  </div>
  <div class="col-4">
    <label>
      Yrs Experience
      <input placeholder="How many years of experience?" id="experience" name="experience" tabindex="7">
    </label>
  </div>
  <div class="col-3">
    <label>
      Current Salary
      <input placeholder="Monthly in RM" id="currentSalary" name="currentSalary" tabindex="3">
    </label>
  </div>
  <div class="col-3">
    <label>
      Expected Salary
      <input placeholder="Monthly in RM" id="expSalary" name="expSalary" tabindex="4">
    </label>
  </div>
  <div class="col-3 switch">
     <label>
      NOC
      <select tabindex="5" id="hasNoc" name="hasNoc">
        <option> True </option>
        <option> False </option>
      </select>
    </label>
  </div>
  
  <div class="col-2">
    <label>
      Upload Resume
      <input type="file" name="resume">
      <input type="hidden" name="resumename">
    </label>
  </div>
  <div class="col-2">
  	<label>Visibility</label>
    <center style="position:relative;margin-bottom:8px;"><input type="checkbox" class="js-switch"></center>
  </div>
  
  <div class="col-submit">
    <button class="submitbtn">Submit Form</button>
  </div>
  <input type="hidden" id="type" name="type" class="noEnterSubmit" value="recruiter"/>
  </form>
  </div>
<script type="text/javascript">
var elems = Array.prototype.slice.call(document.querySelectorAll('.js-switch'));

elems.forEach(function(html) {
  var switchery = new Switchery(html);
});

$(function(){
	 var usernamefrommenu = window.parent.document.getElementById('menuusername').value;
	 $("#userName").val(usernamefrommenu);
});

function validateForm() {
    document.forms["registerJobSeekerForm"]["resumename"].value = document.forms["registerJobSeekerForm"]["resume"].value;
}
</script>
</body>
</html>