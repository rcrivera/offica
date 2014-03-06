<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@page import="uprm.icom5016.dtos.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="layout.css">
<%String name = (String) request.getParameter("username");
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User "<%=name %>" not found</title>
</head>
<body>

<div id="wrapper">
<div id="header"><jsp:include page="./topcontent.jsp"></jsp:include></div>
</div>

<br><br>
<div id="simpletext" align="center">
Could not find user <div id="keyword"><%=name %></div>
<br><br><br><br>

	Not a member?<a href="./Register.jsp"> <font color=#5c8910><b>Register</b></font></a>
</div> 

</body>
</html>