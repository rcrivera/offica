<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="layout.css">
<%
	String name = (String) session.getAttribute("username");
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Invalid Id or Password</title>
</head>
<body>
	<div id="wrapper">
		<div id="header"><jsp:include page="./topcontent.jsp"></jsp:include></div>

		<div id="content">

			<br>
			<br>
			<div id="simpletext" align="center">
				<b>Invalid username or password</b> <br>
				<br> Please try again<br>
				<br>
				<br> Not a member?<a href="./Register.jsp"> <font
					color=#5c8910><b>Register</b></font></a>
			</div>

		</div>
	</div>



</body>
</html>