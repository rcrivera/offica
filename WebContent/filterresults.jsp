<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="uprm.icom5016.dtos.Product"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="layout.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Filtered Results</title>
</head>
<body>
	<div id="wrapper">
		<div id="topcontent"><jsp:include page="./topcontent.jsp"></jsp:include></div>


		<div id="rightcol">


			<table>
				<%
					ArrayList<Product> list = (ArrayList<Product>) session.getAttribute("filterresultslist");
					for (Product p: list) {
						String prid = p.getPid();
						String subc = p.getSubcat();
						String pic = p.getPicLink();
						String name = p.getPname();
						String price = p.getPrice();
				%>
				<tr>
					<td class="image"><a
						href="./ProductServlet?pid=<%=prid%>&subcat=<%=subc%>"> <img
							src=<%=pic%> border=0 width="125px" align="left">
					</a></td>
					<td class="productinfo"><table>
							<tr>
								<td class="productname" align="left"><a
									href="./ProductServlet?pid=<%=prid%>&subcat=<%=subc%>"><%=name%></a></td>
							</tr>
							<tr>
								<td class="productprice" align="left"><%=price%></td>
							</tr>
						</table></td>
				</tr>
				<%
					}
				%>
			</table>

		</div>
		<div id="leftcol">
		<a href="./subcategories.jsp"><font color=#5c8910><b>Filter Again?</b></font></a></div>
		<div id="footer"></div>
</body>
</html>