<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="uprm.icom5016.dtos.User"%>
<%@page import="uprm.icom5016.dtos.CreditCard"%>
<%@page import="java.util.ArrayList"%>
<%@page import="uprm.icom5016.daos.CreditCardDAO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% 
	User user = (User) session.getAttribute("newuser");
	Boolean check = (Boolean) session.getAttribute("newusercheck");
%>
<link rel="stylesheet" type="text/css" href="layout.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register Success</title>
</head>
<body>
<div id="header" align="center"><jsp:include page="./topcontent.jsp"></jsp:include></div>
<br><br>
<%if(!check){ %>
<center>Registration <font color="red">Failed</font><br>Please contact an administrator</center>
<%}else{ %>
<center><font color="#666666">Welcome, <font color="#5c8910"><%=user.getFirstName()%></font><br>

You've been registered with email <font color="#5c8910"><%=user.getEmail()%></font>
</font>
</center>
<%} %>
</body>
</html>