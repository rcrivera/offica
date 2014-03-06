<html>
<head>
<style type="text/css">
* {
	margin: 0;
	padding: 0
}
table{border-collapse: collapse;}

tr.productRow{
	border-bottom: 1px;
	border-bottom-style: dashed;
	border-top:1px;
	border-top-style: dashed;
}
</style>
</head>
<body>
	<table class="cartTable">
		<tr style="font-size:15px; ;color: #333333"><td>Items to buy now</td><td></td><td >Price</td><td style="text-align:center; ;">Quantity</td></tr>
		<tr class="productRow">
			<td width="100px" height="100px"><a
				href="./cleaning_supplies/trashbags.jsp" target="mainFrame"> <img
					src=".\images\cleaning_supplies\trashbags.jpg" border=0
					width="100px" height="100px">
			</a></td>
			<td style="padding-left: 30px; width: 440px"><a
				href="./cleaning_supplies/trashbags.jsp" target="mainFrame"
				style="margin-bottom: 5px;text-decoration: none;font-size:20px;font-weight:600 ;color: #666666">
				Hefty CinchSak Fresh Trash Bags<br />	
			</a> <a href="./delete.jsp">Delete</a></td>

			<td style="width: 100px;color: #5c8910;font-weight: bold;">
				<p>$11.24</p>
			</td>
			<td style="width: 100px;">
				<p style="width:25px; margin-left: auto; margin-right: auto; border-style:solid;border-width: 1px;text-align:center; ;">
				1</p>
			</td>
		</tr>
		
		<tr class="productRow">
			<td width="100px" height="100px"><a
				href="./stationary/envelopes.jsp" target="mainFrame"> <img
					src=".\images\stationary\envelope.jpg" border=0
					width="100px" height="100px">
			</a></td>
			<td style="padding-left: 30px; width: 440px"><a
				href="./stationary/envelopes.jsp" target="mainFrame"
				style="margin-bottom: 5px;text-decoration: none;font-size:20px;font-weight:600 ;color: #666666">
				Stride, Inc. 100% Recycled Business Envelopes<br />	
			</a> <a href="./delete.jsp">Delete</a></td>

			<td style="width: 100px;color: #5c8910;font-weight: bold;">
				<p>$22.99</p>
			</td>
			<td style="width: 100px;">
				<p style="width:25px; margin-left: auto; margin-right: auto; border-style:solid;border-width: 1px;text-align:center; ;">
				1</p>
			</td>
		</tr>
		
		<tr class="productRow">
			<td width="100px" height="100px"><a
				href="./electronics/laptops.jsp" target="mainFrame"> <img
					src=".\images\electronics\laptops.jpg" border=0
					width="100px" height="100px">
			</a></td>
			<td style="padding-left: 30px; width: 440px"><a
				href="./electronics/laptops.jsp" target="mainFrame"
				style="margin-bottom: 5px;text-decoration: none;font-size:20px;font-weight:600 ;color: #666666">
				Lenovo G570 (4334-5VU)<br />	
			</a> <a href="./delete.jsp">Delete</a></td>

			<td style="width: 100px;color: #5c8910;font-weight: bold;">
				<p>$499.99</p>
			</td>
			<td style="width: 100px;">
				<p style="width:25px; margin-left: auto; margin-right: auto; border-style:solid;border-width: 1px;text-align:center; ;">
				1</p>
			</td>
		</tr>
		
		<tr class="productRow">
			<td width="100px" height="100px"><a
				href="./office_supplies/pencils.jsp" target="mainFrame"> <img
					src=".\images\office_supplies\pencil.jpg" border=0
					width="100px" height="100px">
			</a></td>
			<td style="padding-left: 30px; width: 440px"><a
				href="./office_supplies/pencils.jsp" target="mainFrame"
				style="margin-bottom: 5px;text-decoration: none;font-size:20px;font-weight:600 ;color: #666666">
				Office Depot Brand Wood #2 Pencils<br />	
			</a> <a href="./delete.jsp">Delete</a></td>

			<td style="width: 100px;color: #5c8910;font-weight: bold;">
				<p>$1.29</p>
			</td>
			<td style="width: 100px;">
				<p style="width:25px; margin-left: auto; margin-right: auto; border-style:solid;border-width: 1px;text-align:center; ;">
				1</p>
			</td>
		</tr>
		
		<tr class="productRow">
			<td width="100px" height="100px"><a
				href="./furniture/chairs.jsp" target="mainFrame"> <img
					src=".\images\furniture\chair.jpg" border=0
					width="100px" height="100px">
			</a></td>
			<td style="padding-left: 30px; width: 440px"><a
				href="./furniture/chairs.jsp" target="mainFrame"
				style="margin-bottom: 5px;text-decoration: none;font-size:20px;font-weight:600 ;color: #666666">
				basyx by HON VL531 High-Back Mesh Fabric
							Task Chair<br />	
			</a> <a href="./delete.jsp">Delete</a></td>

			<td style="width: 100px;color: #5c8910;font-weight: bold;">
				<p>$179.99</p>
			</td>
			<td style="width: 100px;">
				<p style="width:25px; margin-left: auto; margin-right: auto; border-style:solid;border-width: 1px;text-align:center; ;">
				1</p>
			</td>
		</tr>
	</table>
	<br>
	<div id="subtotal" align="right" style="margin-right: 80px; color: red;"> <strong>SubTotal: $715.50 </strong><br><br></div>
	<form name="proceedToCheckout" action="./CheckoutS" method="get">
	<input id="submit" type="submit" value="Proceed To Checkout">
	</form>
</body>
</html>
