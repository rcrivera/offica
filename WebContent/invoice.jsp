<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
h3{
	text-decoration:none;
	color:#5c8910;
	font-size:20px;
	text-align:center;
	
	
}

h4{
	color:#666666;
	font-size:15px;
	text-decoration:bold;
}
</style>

</head>
<body>
	<%
		String payment = (String) session.getAttribute("payment");
		String addr1 = (String) session.getAttribute("addr1");
		String addr2 = (String) session.getAttribute("addr2");
		String addr3 = (String) session.getAttribute("addr3");
	%>
	<h1>INVOICE</h1>
	
	<table class="cartTable">
		<tr style="font-size: 15px;; color: #333333">
			<td>Your Purchase</td>
			<td></td>
			<td>Price</td>
			<td style="text-align: center;">Quantity</td>
		</tr>
		<tr class="productRow">
			<td width="100px" height="100px"><a
				href="./cleaning_supplies/trashbags.jsp" target="mainFrame"> <img
					src=".\images\cleaning_supplies\trashbags.jpg" border=0
					width="100px" height="100px"> </a>
			</td>
			<td style="padding-left: 30px; width: 440px"><a
				href="./cleaning_supplies/trashbags.jsp" target="mainFrame"
				style="margin-bottom: 5px; text-decoration: none; font-size: 20px; font-weight: 600; color: #666666">
					Hefty CinchSak Fresh Trash Bags<br /> </a> <a href="./delete.jsp">Delete</a>
			</td>

			<td style="width: 100px; color: #5c8910; font-weight: bold;">
				<p>$11.24</p></td>
			<td style="width: 100px;">
				<p
					style="width: 25px; margin-left: auto; margin-right: auto; border-style: solid; border-width: 1px; text-align: center;">
					1</p></td>
		</tr>

		<tr class="productRow">
			<td width="100px" height="100px"><a
				href="./stationary/envelopes.jsp" target="mainFrame"> <img
					src=".\images\stationary\envelope.jpg" border=0 width="100px"
					height="100px"> </a>
			</td>
			<td style="padding-left: 30px; width: 440px"><a
				href="./stationary/envelopes.jsp" target="mainFrame"
				style="margin-bottom: 5px; text-decoration: none; font-size: 20px; font-weight: 600; color: #666666">
					Stride, Inc. 100% Recycled Business Envelopes<br /> </a> <a
				href="./delete.jsp">Delete</a>
			</td>

			<td style="width: 100px; color: #5c8910; font-weight: bold;">
				<p>$22.99</p></td>
			<td style="width: 100px;">
				<p
					style="width: 25px; margin-left: auto; margin-right: auto; border-style: solid; border-width: 1px; text-align: center;">
					1</p></td>
		</tr>

		<tr class="productRow">
			<td width="100px" height="100px"><a
				href="./electronics/laptops.jsp" target="mainFrame"> <img
					src=".\images\electronics\laptops.jpg" border=0 width="100px"
					height="100px"> </a>
			</td>
			<td style="padding-left: 30px; width: 440px"><a
				href="./electronics/laptops.jsp" target="mainFrame"
				style="margin-bottom: 5px; text-decoration: none; font-size: 20px; font-weight: 600; color: #666666">
					Lenovo G570 (4334-5VU)<br /> </a> <a href="./delete.jsp">Delete</a>
			</td>

			<td style="width: 100px; color: #5c8910; font-weight: bold;">
				<p>$499.99</p></td>
			<td style="width: 100px;">
				<p
					style="width: 25px; margin-left: auto; margin-right: auto; border-style: solid; border-width: 1px; text-align: center;">
					1</p></td>
		</tr>

		<tr class="productRow">
			<td width="100px" height="100px"><a
				href="./office_supplies/pencils.jsp" target="mainFrame"> <img
					src=".\images\office_supplies\pencil.jpg" border=0 width="100px"
					height="100px"> </a>
			</td>
			<td style="padding-left: 30px; width: 440px"><a
				href="./office_supplies/pencils.jsp" target="mainFrame"
				style="margin-bottom: 5px; text-decoration: none; font-size: 20px; font-weight: 600; color: #666666">
					Office Depot Brand Wood #2 Pencils<br /> </a> <a href="./delete.jsp">Delete</a>
			</td>

			<td style="width: 100px; color: #5c8910; font-weight: bold;">
				<p>$1.29</p></td>
			<td style="width: 100px;">
				<p
					style="width: 25px; margin-left: auto; margin-right: auto; border-style: solid; border-width: 1px; text-align: center;">
					1</p></td>
		</tr>

		<tr class="productRow">
			<td width="100px" height="100px"><a
				href="./furniture/chairs.jsp" target="mainFrame"> <img
					src=".\images\furniture\chair.jpg" border=0 width="100px"
					height="100px"> </a>
			</td>
			<td style="padding-left: 30px; width: 440px"><a
				href="./furniture/chairs.jsp" target="mainFrame"
				style="margin-bottom: 5px; text-decoration: none; font-size: 20px; font-weight: 600; color: #666666">
					basyx by HON VL531 High-Back Mesh Fabric Task Chair<br /> </a> <a
				href="./delete.jsp">Delete</a>
			</td>

			<td style="width: 100px; color: #5c8910; font-weight: bold;">
				<p>$179.99</p></td>
			<td style="width: 100px;">
				<p
					style="width: 25px; margin-left: auto; margin-right: auto; border-style: solid; border-width: 1px; text-align: center;">
					1</p></td>
		</tr>
	</table>
	<br>
	<div id="total" align="right" style="margin-right: 80px; color: red;">
		<strong>Total: $715.50 </strong><br>
		<br>
	</div>
	
	<h4> Total amount charged to credit card(<%=payment%>):</h4> <h3>$715.50</h3>
	<h4> Ship to:</h4>
	<table style="margin-left: 50px; margin-top: 0px">
	<tr><td><%=addr1%></td></tr>
	<tr><td><%=addr2%></td></tr>
	<tr><td><%=addr3%></td></tr>
	</table>
	<br>
	
	<a href="./index.jsp" target="_parent"> <h3> Return Home</h3></a>
	
</body>
</html>
