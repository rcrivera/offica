<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="java.util.ArrayList" %>
   <%@ page import="uprm.icom5016.dtos.Product" %>
   <%@ page import="uprm.icom5016.dtos.CreditCard" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="layout.css">
<style type="text/css">
tr.productRow{
	border-bottom: 1px;
	border-bottom-style: dashed;
	border-top: 1px;
	border-top-style: dashed;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Cart</title>

<%
	ArrayList<Product> checkout = (ArrayList<Product>) session.getAttribute("shoppingcart");
	ArrayList<String> quantityList = (ArrayList<String>) session.getAttribute("itemQuantity");
	ArrayList<CreditCard> creditCards = (ArrayList<CreditCard>) session.getAttribute("cards");
	
%>

</head>
<body>


<div id="wrapper">
<div id="header"><jsp:include page="./topcontent.jsp"></jsp:include></div>

	<table>
	<tr style="font-size: 15px; color: #333333">
			<td id="simpletext">Checkout</td>
			<td id="simpletext"></td>
			<td align="right" id="simpletext">Price</td>
			<td id="simpletext" style="text-align: center;">Quantity</td>
		</tr>
	<%
					for (Product p : checkout) {
						String prid = p.getPid();
						String subc = p.getSubcat();
						String pic = p.getPicLink();
						String name = p.getPname();
						String price = p.getPrice();
				%>
		<tr class="productRow">
			<td width="100px" height="100px">
			<a href="./ProductServlet?pid=<%=prid%>&subcat=<%p.getSubcat();%>">
			<img width="175px" src="<%=pic %>"/>
			</a>
			</td>
			<td style="padding-left: 30px; width: 440px">
				<div id="keyword"><%=name %></div>
				<form name="removefromshoppingcart" method="post" action="./RemoveItemCartServlet">
				<input type="hidden" name="itemtoremove" value="<%=p.getPid()%>"/>
				<input type="submit" value="Remove"/>
				</form>
			</td>

			<td style="width: 100px; color: red; font-weight: bold;">
				<div align="right" id="price"><%=price %></div>
			<td id="simpletext" style="width: 100px;">
				<%
					for(String s: quantityList){
						String id = s.substring(0, s.indexOf('*'));
						String q = s.substring(s.indexOf('*')+1,s.length());
						
						if(prid.equalsIgnoreCase(id)){
							%>
							<div align="center" id="simpletext"><%=q%></div>
				<%}
						}
					}
				%>
				<%if(checkout.size()>0){%>
				<a href="./CheckoutS">Checkout</a>
				<%}%>
							
				
			</td>
		</tr>
	</table>
		<%if(creditCards !=null){%>
				<form name="ccard" action="./CheckoutS" method="get">
				<center><table>
				<%for(CreditCard c : creditCards){ %>
				<tr><td></td><td class="key" align="right"><input value="<%=c.getCcnumber()%>" type="radio" name="ccard"/><%=c.getCcnumber()%></td></tr>
				<%}%>
				<tr><td></td><td><input type="submit" value="Checkout"/></td></tr>
				</table>
				</center>
				</form>
				<%}%>
</div>


</body>
</html>