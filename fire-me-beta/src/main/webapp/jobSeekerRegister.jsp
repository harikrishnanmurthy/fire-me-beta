<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ page session="true" %> --%>
<html>
<head>
</head>
<body>

<div class="modal fade" id="jobSeekerRegisterDiv" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Job Seeker Registration</h4>
      </div>
      <div class="modal-body">
      		<form action="registerJobSeeker" name="registerJobSeekerForm" id="registerJobSeekerForm" method="GET">
	        	<label class="lbl" for="firstName">Your Name :</label> <input type="text" placeholder="First Name" id="firstName" name="firstName"  class="noEnterSubmit"/>
	        	<input type="text" placeholder="Last Name" id="lastName" name="lastName"  class="noEnterSubmit"/><br/><br/>
	            <label class="lbl" for="userName">User Name :</label> <input type="text" placeholder="User Name" id="userName" name="userName"  class="noEnterSubmit"/><br/><br/>
	            <label class="lbl" for="emailID">Your Email ID :</label> <input type="text" placeholder="Your Email ID" id="emailID" name="emailID"  class="noEnterSubmit"/><br/><br/>
	            <label class="lbl" for="password1">Password :</label> <input type="text" placeholder="Password" id="password1" name="password1"  class="noEnterSubmit"/><br/><br/>
	            <label class="lbl" for="password2">Repeat Password :</label> <input type="text" placeholder="Repeat Password" id="password2" name="password2"  class="noEnterSubmit"/><br/><br/>
	            <input type="hidden" id="type" name="type" class="noEnterSubmit" value="recruiter"/>
            </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" id="registerJobSeeker" >Save changes</button>
      </div>
    </div>
  </div>
</div>

</body>
</html>