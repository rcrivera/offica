<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="uprm.icom5016.dtos.User"%>
<%@page import="uprm.icom5016.dtos.Return"%>
<%@page import="uprm.icom5016.dtos.CreditCard"%>
<%@page import="uprm.icom5016.dtos.ReturnedProduct"%>
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
	Return returnObject = (Return) session.getAttribute("returnObject");
	User user = returnObject.getUser();
	CreditCard card = returnObject.getCard();
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Request No:<%=returnObject.getReturnno()%></title>
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
%>
<center><br><br><table id="main" width=500px>

<tr><td class="normal" align="left">Date Issued</td><td class="normal" align="left"><%=returnObject.getDate() %></td></tr>
<tr><td class="normal" align="left">Return No</td><td class="key" align="left"><%=returnObject.getReturnno() %></td></tr>
<tr><td class="normal" align="left">Order No</td><td class="key" align="left"><%=returnObject.getOrderno() %></td></tr>
<tr><td class="normal" align="left">Username</td><td class="key" align="left"><%=user.getUserName() %></td></tr>
<tr><td class="normal" align="left">Address</td><td class="normal" align="left"><table><tr><td class="mini" align="left"><%=user.getAddress() %></td></tr>
								<tr><td class="mini" align="left"><%=user.getCity() %></td></tr>
								<tr><td class="mini" align="left"><%=user.getZipcode() %></td></tr>
								<tr><td class="mini" align="left"><%=user.getCountry() %></td></tr>
						</table></td></tr>
<tr><td class="normal" align="left">Credit Card No</td><td class="key" align="left"><%=card.getCcnumber() %></td></tr>
<tr><td class="normal" align="left">Reason for Return</td><td class="normal" align="left"><%=returnObject.getReason() %></td></tr>
<tr><td class="normal" align="left">Items to Return</td><td class="normal" align="center">
								<table id="pret"><tr>
									<td class="mini" align="center">Product ID</td>
									<td class="mini" align="center">QTY</td>
									<td class="mini" align="center">Purchase Price</td></tr>
						<%	ArrayList<ReturnedProduct> list = returnObject.getItems();
							for (ReturnedProduct p : list) {%>
								<tr><td class="minikey" align="center"><%=p.getPid() %></td>
								<td class="mini" align="center"><%=p.getQuantity2Return()%></td>
								<td class="minikey" align="center"><%=p.getPurchasedPrice() %></td></tr>
						<%} %>
								</table>
		</td></tr>
</table>
</center>
	<%} %>
</body>
</html>