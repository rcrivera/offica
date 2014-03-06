<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="uprm.icom5016.dtos.Product"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="layout.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%
	Product product = (Product) session.getAttribute("product");
	////pid, category, subcat, pname, price pic,model,description,stock
	String pid = product.getPid();
	String category = product.getCategory();
	String subcat = product.getSubcat();
	String pname = product.getPname();
	String brand = product.getBrand();
	String price = product.getPrice();
	String pic = product.getPicLink();
	String model = product.getModel();
	String description = product.getDescription();
	description = description.replace("*", "<br>");
	Integer stock = product.getStock();
%>
</head>
<body>
	<div id="wrapper">
		<div id="topcontent"><jsp:include page="./topcontent.jsp"></jsp:include></div>

		<div id="productcontent">
			<div id="productwrapper">
				<div id=producttop>
					<div id="pic" style="float: left; width: 330px; padding: 15px;">
						<div id="picture" style="margin-left: auto; margin-right: auto">
							<img src=<%=pic%> width="250px">
						</div>
					</div>
					<div id="generalinfo"
						style="margin-left: 360px; width: 410px; padding: 15px">
						<div id="pname"><%=pname%></div>
						<br>
						<div id="pid">
							Item #: <span><%=pid%></span>
						</div>
						<br>
						<div id="brand">
							Brand: <span><%=brand%></span>
						</div>
						<br>
						<div id="price">
							Price: <span style="color: red;"><%=price%></span>
						</div>
						<br>
						<div id="quantity">
							Quantity
							<form name="addtocart" action="./AddToCartServlet" method="post">
							<table><tr>
							<td><select name="productquantityshoppingcart">
								<%
									int i=1;
									if(stock>0){
									for (i =1; i <= stock; i++) {
								%>
								<option value="<%=i%>"><%=i%></option>
								<%
									}
									}
									else{
										%>
									<div id="price">NOT AVAILABLE</div>
									<%
									}
								%>
							</select>
							<input type="hidden" name="productidshoppingcart" value="<%=pid %>"/>
							</td>
							
							<td width="25px"><input type="image" src="./images/buttons/add2cart.png" alt="Add to cart"/></td>
							</tr></table>
							
							</form>
						</div>
						
						
					</div>
				</div>
				<div id="description" style="clear: both">
					Description:<br>
					<p><%=description%></p>
				</div>

			</div>
		</div>
		<div id="footer"></div>
	</div>

</body>
</html>