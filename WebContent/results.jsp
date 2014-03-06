<%@page import="uprm.icom5016.dtos.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="layout.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search Results</title>
<%
String search = request.getParameter("searchQuery");
%>
</head>


<body>
	<div id="wrapper">
		<div id="topcontent"><jsp:include page="./topcontent.jsp"></jsp:include></div>
		<div>
			<form name="sortForm" action="./SortServlet" method="get">
				<p align="right">
					<font color=#666666>Sort By:</font><select name="sortOp">
						<option value="Price">Price</option>
						<option value="Name">Name</option>
						<option value="Brand">Brand</option>
					</select> <input type="submit" value="Sort" />
				</p>
			</form>
		</div>
		

		<div id="rightcol">


			<table>
				<%
					ArrayList<Product> list = (ArrayList<Product>) session.getAttribute("list");
					for (int i = 0; i < list.size(); i++) {
						String prid = list.get(i).getPid();
						String subc = list.get(i).getSubcat();
						String pic = list.get(i).getPicLink();
						String name = list.get(i).getPname();
						String price = list.get(i).getPrice();
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
		
		</div>
		<div id="footer"></div>
	</div>

</body>
</html>