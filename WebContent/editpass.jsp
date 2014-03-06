<%@page import="uprm.icom5016.dtos.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="layout.css">
<%User user = (User) session.getAttribute("user");
String pass = user.getPass();%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Change Password</title>

<style>

td.txt{
	font-size:15px;
	color:#666666;
}
center{
	color:#666666;
}
p{
	color:#5c8910;
}

</style>
</head>
<body>
<div id="header" align="center"><jsp:include page="./topcontent.jsp"></jsp:include></div>
		<br><br>
		
		<center><b>Change Password</b></center><br><br>
		
		<form name="changePassForm" action="./ChangePasswordServlet" method="post">
			<table align="center">
				<tr><td align="left" class="txt">Old Password</td><td><input type="password" name="oldpass"/></td></tr>
				<tr><td align="left" class="txt">New Password</td><td><input name="newpass" type="password" /></td></tr>
				<tr><td align="left" class="txt">New Password (Again)</td><td><input type="password" name="newpassrepeat" /></td></tr>
				<tr><td></td><td><input type="submit" value="Submit"/></td></tr>
				</table>
		</form>
</body>
</html>