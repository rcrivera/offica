<%@page import="uprm.icom5016.dtos.Product"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="uprm.icom5016.dtos.Report"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
#reporttable {
	border-collapse: collapse;
}
center{
	color:#666666;
}

#reporttable tr td,th {
	border: 1px solid black;
	text-align: center;
	padding: 2px;
}

.added{
color: #5c90;
}

</style>
<link rel="stylesheet" type="text/css" href="layout.css">
<%String pname = (String)session.getAttribute("pname");
String pid = (String)session.getAttribute("pid");
%>
</head>


<body>
	<div id="wrapper">
		<div id="header"><jsp:include page="./topcontent.jsp"></jsp:include></div>
		<div id="content">
			<div>
			<br>
				<center>
					<b><%=pname%></b><br> <b>PID: <%=pid%></b><br>
					<div class="added"><b>Successfully Added</b></div>
					<br>
					<a href="addnewproduct.jsp" style="color:#5c90"> Add more new products?</a>
				</center>
				<br>
				
			</div>
		</div>
	</div>

</body>
</html>




