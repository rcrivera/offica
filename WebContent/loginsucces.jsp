<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@page import="uprm.icom5016.dtos.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="layout.css">
<%User user = (User)session.getAttribute("user");
String name = user.getFirstName();

%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome <%=name %></title>
</head>
<body>

<div id="wrapper">
<div id="header"><jsp:include page="./topcontent.jsp"></jsp:include></div>
</div>

<br>
<div id="simpletext" align="center">
Welcome <div id="keyword"><%=name %></div>
<br>
Continue to <div id="keyword"><a href="./index.jsp">home</a></div>
</div> 

</body>
</html>