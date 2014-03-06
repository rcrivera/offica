<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="uprm.icom5016.dtos.User"%>
<%@page import="uprm.icom5016.dtos.Return"%>
<%@page import="java.util.ArrayList"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.key{
	font-size:15px;
	border:1px solid;
	border-color:#97d330;
    text-align: left;
	color:#5c8910;
	text-decoration:bold;
	padding: 5px;
}

.minikey{
	font-size: 12px;
    text-align: left;
	color:#5c8910;
	text-decoration:bold;
	
}

a{
	color:#5c8910;
	text-decoration:bold;
}

#pret td{
padding: 10px;
}

.normal{

	font-size:15px;
	color:#666666;
	border:1px solid;
	border-color:#97d330;
    padding: 5px;
}
.mini{
	font-size:12px;
	color:#666666;
    text-align: left;
}

#main{
	border-collapse:collapse;
	border: thin;
	border-color:#97d330;
}
</style>
<link rel="stylesheet" type="text/css" href="layout.css">
<%
	Integer checkedIn = (Integer) session.getAttribute("checkedIn");
	User user = (User) session.getAttribute("user");
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Returns Requested</title>
</head>
<body>

<div id="wrapper">
<div id="header"><jsp:include page="./topcontent.jsp"></jsp:include></div>
</div>

<%
	if(checkedIn == null || checkedIn == 0 || checkedIn == -1 && user.getIsAdmin().equalsIgnoreCase("f")){
%>

<center>
<b> You do not have access to this page</b>
</center>

<%} else{ 
	ArrayList<Return> returns = (ArrayList<Return>)session.getAttribute("returnsReqList");
%>
<center><br><br>

<b><font color="#666666">Returns Requested</font></b><br><br>
<table>
<tr><td id="normal">ID</td><td id="normal">Username</td><td id="normal">Date</td>
<%
	for(Return r : returns){
%>
	<tr><td id="key" align="left"><a href="./ReturnServlet?returnid=<%=r.getReturnno()%>"><%=r.getReturnno()%></a></td><td class="normal" align="left"><%=r.getUser().getUserName() %></td><td class="normal" align="left"><%=r.getDate()%></td></tr>

<%}%>
</table></center>
	<%} %>
</body>
</html>