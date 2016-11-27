<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ page session="true" %> --%>
<html>
<head>
<%@include file="resources.jsp" %>
</head>
<body>

<div class="modal fade" id="jobPostProfileConfirm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Confirm Job Post</h4>
      </div>
      <div class="modal-body">
			Job Successfully Posted! What's next?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" id="redirectDashboard">Take me to Dashboard</button>
        <button type="button" class="btn btn-primary" id="redirectJobListings">List Active Jobs</button>
      </div>
    </div>
  </div>
</div>
</body>
<script>
$(function(){
	$("#jobPostProfileConfirm").modal("show");
	
	$("#redirectDashboard").click(function(){
		window.parent.document.getElementById("dframe").src="jobSeekerDashboard.jsp"
	});
	
	$("#redirectJobListings").click(function(){
		window.parent.document.getElementById("dframe").src="jobListings.jsp"
	});
})
</script>
</html>