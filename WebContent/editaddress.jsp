<%@page import="uprm.icom5016.dtos.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="layout.css">
<%User user = (User) session.getAttribute("user");
String address= user.getAddress();
String city = user.getCity();
String state = user.getState();
String zipcode = user.getZipcode();
String country = user.getCountry();
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Change Address</title>

<style>

td.txt{
	font-size:15px;
	color:#666666;
}
center{
	color:#666666;
}
span{
	color:#5c8910;
}

</style>
</head>
<body>
<div id="header" align="center"><jsp:include page="./topcontent.jsp"></jsp:include></div>
		<br><br>
		
		<center><b>Change Address</b></center><br><br>
		<table align="center">
		<tr><td class="txt"><b>Current Address</b></td><td align="left"><span><%=address %></span></td></tr>
		<tr><td></td><td align="left"><span><%=city %></span></td></tr>
		<tr><td></td><td align="left"><span><%=state %></span></td></tr>
		<tr><td></td><td align="left"><span><%=zipcode %></span></td></tr>
		<tr><td></td><td align="left"><span><%=country %></span></td></tr>
		</table>
		<br><br>
		<form name="changeAddressForm" action="./ChangeAddressServlet" method="post">
			<table align="center">
				<tr><td align="left" class="txt">Address</td><td><input type="text" name="newaddress"/></td></tr>
				<tr><td align="left" class="txt">City</td><td><input name="newcity" type="text" /></td></tr>
				<tr><td align="left" class="txt">State</td><td><input type="text" name="newstate" /></td></tr>
				<tr><td align="left" class="txt">Zipcode</td><td><input type="text" name="newzipcode" /></td></tr>
				<tr><td align="left" class="txt">Country</td><td><input type="text" name="newcountry" /></td></tr>
				<tr><td></td><td><input type="submit" value="Submit"/></td></tr>
				</table>
		</form>
</body>
</html>