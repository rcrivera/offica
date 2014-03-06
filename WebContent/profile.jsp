<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="uprm.icom5016.dtos.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	User user = (User) session.getAttribute("user");
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profile Settings</title>

<style>
div.main{
	margin:50px;	
}
td.setting{
	font-size:15px;
	color:#666666;
}
center{
	color:#666666;
}
span.arrow{
	color:#97d330;
	font-weight:bold;
}
a{
	color:#333333;
	text-decoration:none;
}
</style>

</head>
<body>

<div id="header" align="center"><jsp:include page="./topcontent.jsp"></jsp:include></div>

	<div class="main">
		<center><b>Profile Settings</b></center>
	</div>
	
	<center>
	<table>
	<tr><td><b><span class="arrow">></span></b></td><td align="left" class="setting"><a href="./editpass.jsp"> Change Password </a><br></td></tr>
	<tr><td><br></td></tr><tr><td><b><span class="arrow">></span></b></td><td align="left" class="setting"><a href="./editemail.jsp"> Change Email </a><br></td></tr>
	<tr><td><br></td></tr><tr><td><b><span class="arrow">></span></b></td><td align="left" class="setting"><a href="./editcc.jsp"> Add/Delete Credit Card </a><br></td></tr>
	<tr><td><br></td></tr><tr><td><b><span class="arrow">></span></b></td><td align="left" class="setting"><a href="./editaddress.jsp"> Change Address </a><br></td></tr>
	<tr><td><br></td></tr><tr><td><b><span class="arrow">></span></b></td><td align="left" class="setting"><a href="./editnumber.jsp"> Change Phone Number </a><br></td></tr>
	<% if(user.getIsAdmin().equalsIgnoreCase("t")){%>
	<tr><td><br></td></tr><tr><td><b><span class="arrow">></span></b></td><td align="left" class="setting"><a href="./editadmin.jsp"> Administrator Options</a><br></td></tr>
	<%} %> 
	</table>
	</center>
	
</body>
</html>