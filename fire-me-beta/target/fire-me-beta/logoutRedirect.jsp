<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@page session="true"%>
<html>
<head>
<script src="jquery.min.js"></script>
<link rel="stylesheet" href="jquery-ui.css" />
<script src="jquery-ui.min.js"></script>
</head>

<body>
	<h1>Logout Redirect Page</h1>
	
<%-- 	<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver" --%>
<%--      url="jdbc:mysql://localhost:3306/hari" --%>
<%--      user="root"  password=""/> --%>

	<c:set var="empId" value="<%=session.getAttribute(\"LoginUser\") %>"/>
<%-- 	<sql:update dataSource="${snapshot}" var="count"> --%>
<!--   		update user set isloggedin= 'N' where user_id = ? -->
<%--   	<sql:param value="${empId}" /> --%>
<%-- 	</sql:update> --%>
	
	<%-- <a id="logout" href="<c:url value="j_spring_security_logout" />"> Logout</a> --%>
	<%
		session.invalidate();
		response.sendRedirect("j_spring_security_logout");
	%>

</body>

<script>
/* $("document").load(function(){
	$( "#logout" ).trigger("click");
}); */

</script>
</html>