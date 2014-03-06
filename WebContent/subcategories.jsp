<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="uprm.icom5016.dtos.Product"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="layout.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">
		<div id="topcontent"><jsp:include page="./topcontent.jsp"></jsp:include></div>


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
			<%
				String subcat = request.getParameter("subcat");
				ArrayList<String> att = new ArrayList<String>();
				ArrayList<String> toPrint = new ArrayList<String>();

				Product p = list.get(0);
				att = p.getSpecificAttributes();

				for (String a : att) {
					for (Product e : list) {
						String x = e.getAtt(a);
						x = x.toLowerCase();
						x = x + "*" + a;
						if (!(toPrint.contains(x))) {
							toPrint.add(x);
						}
					}
				}
			%>
			<table>
				<form name="filterform" method="get" action="./FilterServlet">
					<%
						int i = 1;
						session.setAttribute("filterlist", toPrint);
						for (String u : att) {
					%><tr>
						<td><b><%=u%></b></td>
						<td align="right"><select name="<%="p"+i%>">
								<option value="null">---</option>
								<%
									for (String y : toPrint) {
											String value = y.substring(0, y.indexOf('*'));
											String attribute = y.substring(y.indexOf('*') + 1,
													y.length());
											if (u.equals(attribute)) {
								%>
								<option align=value="<%=value%>"><%=value%></option>
								<%
											}
									}
								%>
						</select></td>
					</tr>
					<%
							i++;
						}
					%>

					<tr>
						<td></td>
						<td><input type="submit" value="Filter" /></td>
					</tr>

				</form>
			</table>

			<div id="footer"></div>
		</div>
</body>
</html>