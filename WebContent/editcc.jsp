<%@page import="uprm.icom5016.dtos.User"%>
<%@page import="uprm.icom5016.dtos.CreditCard"%>
<%@page import="java.util.ArrayList"%>
<%@page import="uprm.icom5016.daos.CreditCardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="layout.css">
<%User user = (User) session.getAttribute("user");
String email = user.getEmail();
CreditCardDAO dao = new CreditCardDAO();
ArrayList<CreditCard> cards = dao.getCards(user.getUserName());
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add/Delete Credit Cards</title>

<style>

td.txt{
	font-size:15px;
	color:#666666;
}

td.key{
	font-size:15px;
	color:#5c8910;
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
		
		<center><b>Add/Delete Credit Cards</b></center><br><br><br>
		
		<%Boolean check = (Boolean)session.getAttribute("deletecardcheck");
			String cardremoved = request.getParameter("cardtoremove");
			if(check!=null){ %>
			<%if(check){ %>
				<center><font color="#666666"><b>Card <font color=#5c8910><%=cardremoved %></font> was deleted</font></center><br><br>
			<%} else{%>
				<center><font color="red"><b>Card <font color=#5c8910><%=cardremoved %></font> could not be deleted due to internal errors.</font></center><br><br>
			<%} %>
		<%} %>
		<center><font color="#666666">Current Cards</font></center>
		
		<form name="deletecards" action="./DeleteCardServlet"method="post">
		<center><table>
		<%for(CreditCard c : cards){ %>
		<tr><td></td><td class="key" align="right"><input value="<%=c.getCcnumber()%>" type="radio" name="cardtoremove"/><%=c.getCcnumber()%></td>
		</tr>
		<%} %>
		<tr><td></td><td><input type="submit" value="Delete"/></td></tr>
		</table>
		</center>
		</form>
		<br><br>
		
		<form name="addCreditCard" action="./AddCCServlet" method="post">
			<center>Add Credit Card</center><br>
			<table align="center">
				<tr><td align="left" class="txt">Card Number</td><td><input name="newcardNumber" type="text" /></td></tr>
				<tr><td align="left" class="txt">Name on Card</td><td><input name="newcardHolder" type="text" /></td></tr>
				<tr><td align="left" class="txt">Type</td><td><input type="text" name="newcardType" /></td></tr>
				<tr><td align="left" class="txt">Exp.Month</td><td><input type="text" name="newcardExpM" /></td></tr>
				<tr><td align="left" class="txt">Exp.Year</td><td><input type="text" name="newcardExpY" /></td></tr>
				<tr><td align="left" class="txt">CVV</td><td><input type="text" name="newcardCVV" /></td></tr>
				<tr><td></td><td><input type="submit" value="Submit"/></td></tr>
			</table>
		</form>
</body>
</html>