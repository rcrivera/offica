<%@page import="uprm.icom5016.dtos.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="layout.css">
<style type="text/css">
#subcatLink.register{
font: menu;
font-size: 20px;
text-decoration: none;
}
h1{
font-family: Helvetica;
font-size: 25px;
color: gray;

</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<% ArrayList<String> arl = (ArrayList<String>)session.getAttribute("subcategories");
String category = (String)session.getAttribute("cat");
String cat = (String)session.getAttribute("category");
%>


</head>
<body>
	<div id="wrapper">
		<div id="header"><jsp:include page="./topcontent.jsp"></jsp:include></div>
		<div id="content"></div>
		<h1>Browse <%=category%> by Category:</h1>
		<table align="center">
		
		<%for (int i=0;i<arl.size();i=i+2){%>
		<tr><td><a id="subcatImageLink" href="./SubCatServlet?cat=<%=cat%>&subcat=<%=arl.get(i+1)%>">
		<img id=subCatPic src="./images/subcategories/<%=arl.get(i+1)%>.png" width="95px" alt="<%=arl.get(i)%>"></a>
		</td>
		<td> <a class="register" id="subcatLink" href="./SubCatServlet?cat=<%=cat%>&subcat=<%=arl.get(i+1)%>"><%=arl.get(i)%></a></td>
		</tr>
		<%}%>
		
		
		
		</table>
	</div>
</body>

</html>