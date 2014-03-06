<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
center{
	color:#666666;
}
</style>
<link rel="stylesheet" type="text/css" href="layout.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script language="javascript" type="text/javascript"
	src="datetimepicker.js"></script>
</head>
<body>
<div id="wrapper">
		<div id="topcontent"><jsp:include page="./topcontent.jsp"></jsp:include></div>
		<div align="center">
	<form name="generalform" action="./ReportServlet" method="post">
	<br>
		
			<center><b>General Reports</b></center>
			<select name="general">
				<option value="">Report Type</option>
				<option value="sales">Total Sales</option>
				<option value="returns">Returns</option>
				<option value="revenue">Total Revenue</option>
			</select>
			
			<input name="year" type="text" value="2011" size="4px"/>
			<select name="months">
				<option value="">Month</option>
				<option value="1">January</option>
				<option value="2">February</option>
				<option value="3">March</option>
				<option value="4">April</option>
				<option value="5">May</option>
				<option value="6">June</option>
				<option value="7">July</option>
				<option value="8">August</option>
				<option value="9">September</option>
				<option value="10">October</option>
				<option value="11">November</option>
				<option value="12">December</option>
			</select> 
			<input type="submit" value="Get Report!">
	</form>
	
	<form name="product" action="./ReportServlet" method="post">
		
			<br> 
			<center><b>Reports Grouped By Products</b></center>
			<select name="groupreport">
				<option value="">Report Type</option>
				<option value="sales">Total Sales</option>
				<option value="revenue">Total Revenue</option>
			</select>
			<select name="term">
				<option value="">Term</option>
				<option value="day">Day</option>
				<option value="week">Week</option>
				<option value="month">Month</option>
			</select> 
	  		<input name="calendar" type="Text" id="demo1" maxlength="25" size="25"><a href="javascript:NewCal('demo1','MMDDYYYY')"><img src="images/cal.gif" width="16" height="16" border="0" alt="Pick a date"></a>
			<input type="submit" value="Get Report!">
		
	</form>
	</div>
</div>


</body>
</html>