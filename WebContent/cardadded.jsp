<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="uprm.icom5016.dtos.User"%>
<%@page import="uprm.icom5016.dtos.CreditCard"%>
<%@page import="java.util.ArrayList"%>
<%@page import="uprm.icom5016.daos.CreditCardDAO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="layout.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add new Credit Card</title>
<% Boolean check = (Boolean) session.getAttribute("addcardsuccess");
	CreditCard card = (CreditCard)session.getAttribute("cardsuccess");%>
</head>
<body>
<div id="wrapper">
		<div id="header"><jsp:include page="./topcontent.jsp"></jsp:include></div>
		<div id="content"><br><br>
<%if(check){ %>
	<center><font color=#666666>Credit Card <font color=#5c8910><%=card.getCcnumber()%></font> was added successfully</font></center>
<%}else{ %>
	<center><font color=#666666>Could not add credit card <font color=red><%=card.getCcnumber()%></font><br>Please contact an administrator</font></center>
<%} %>
<br><center><font color="#666666">Back to </font><a href="./profile.jsp"><font color="#5c89010">Settings</font></a></center>
</div>
</div>
</body>
</html>