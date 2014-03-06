<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="layout.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Offica: office like you mean it</title>
<%String query = request.getParameter("searchQuery");%>
</head>
<body>
	<div id="wrapper">
		<div id="header"><jsp:include page="./topcontent.jsp"></jsp:include></div>
		<div id="content">
			<div id="simpletext" align="center">
			<br>
				<b> Your search "<span style="font-size: 18px;color: red;font-weight: bold;"><%=query%></span>" did not match any products.</b> <br> <br>Please try
				for a different keyword<br>
			</div>
		</div>
	</div>

</body>
</html>