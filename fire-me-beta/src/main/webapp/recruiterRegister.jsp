<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ page session="true" %> --%>
<html>
<head>
</head>
<body>

<div class="modal fade" id="recruiterRegisterDiv" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Recruiter Registration</h4>
      </div>
      <div class="modal-body">
      	<form action="registerRecruiter" name="registerRecruiterForm" id="registerRecruiterForm" method="POST">
        	<label class="lbl" for="firstName">Representative Name :</label> <input type="text" placeholder="First Name" id="firstName" name="firstName"  class="noEnterSubmit"/>
        	<input type="text" placeholder="Last Name" id="lastName" name="lastName"  class="noEnterSubmit"/><br/><br/>
        	<label class="lbl" for="companyName">Organization :</label> <input type="text" placeholder="Organisation" id="companyName" name="companyName"  class="noEnterSubmit"/><br/><br/>
            <label class="lbl" for="userName">User Name :</label> <input type="text" placeholder="User Name" id="userName" name="userName"  class="noEnterSubmit"/><br/><br/>
            <label class="lbl" for="emailID">Company Email ID :</label> <input type="text" placeholder="Company Email ID" id="email" name="email"  class="noEnterSubmit"/><br/><br/>
            <label class="lbl" for="password1">Password :</label> <input type="password" placeholder="Password" id="password1" name="password"  class="noEnterSubmit"/><br/><br/>
            <label class="lbl" for="password2">Repeat Password :</label> <input type="password" placeholder="Repeat Password" id="password2" name="password2"  class="noEnterSubmit"/><br/><br/>
            <input type="hidden" id="type" name="type" class="noEnterSubmit" value="recruiter"/>
         </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" id="registerRecruiter">Save changes</button>
      </div>
    </div>
  </div>
</div>
</body>
</html>