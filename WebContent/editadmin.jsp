<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="uprm.icom5016.dtos.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="layout.css">
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
	<br><br>
	<span class="main">
		<center><b>Administrator Options</b></center><br>
	</span>
	
	<center>
	<table>
	<tr><td><br></td></tr><tr><td><b><span class="arrow">></span></b></td><td align="left" class="setting"><a href="./reports.jsp"> Generate Reports </a><br></td></tr>
	<tr><td><br></td></tr><tr><td><b><span class="arrow">></span></b></td><td align="left" class="setting"><a href="./ViewReturnsServlet"> View Return Requests </a><br></td></tr>
	<tr><td><br></td></tr><tr><td><b><span class="arrow">></span></b></td><td align="left" class="setting"><a href="./viewaccounts.jsp"> View All Accounts </a><br></td></tr>
	<tr><td><br></td></tr><tr><td><b><span class="arrow">></span></b></td><td align="left" class="setting"><a href="./addnewproduct.jsp"> Add Products </a><br></td></tr>
	</table>
	</center>
	
</body>
</html>