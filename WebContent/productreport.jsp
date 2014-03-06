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
</style>
<link rel="stylesheet" type="text/css" href="layout.css">
<script type='text/javascript' src='http://www.google.com/jsapi'></script>
<script type='text/javascript'>
	
<%ArrayList<Report> replist = (ArrayList<Report>) session.getAttribute("report");
			String reporttype = (String) session.getAttribute("reporttype");
			String term = (String) session.getAttribute("term");%>

	google.load("visualization", "1", {
		packages : [ "corechart" ]
	});
	google.setOnLoadCallback(drawChart);
	function drawChart() {
		var data = new google.visualization.DataTable();
		data.addColumn('string', 'Pid');
		data.addColumn('number', 'Total: $');
		data.addRows(<%=replist.size()%>);
   <%for (int i = 0; i < replist.size(
	); i++) {%>
		data.setValue(<%=i%>,0,'<%=replist.get(i).getPid()%>');
		data.setValue(<%=i%>,1,<%=replist.get(i).getTotal().substring(1)%>);

		  
	<%}%>

		var options = {
			width : 400,
			height : 240,
			title : '',
			vAxis : {
				title : 'Product ID',
				titleTextStyle : {
					color : 'red'
				}
			}
		};

		var chart = new google.visualization.BarChart(document
				.getElementById('chart_div'));
		chart.draw(data, options);
    }
		  
</script>
</head>


<body>
	<div id="wrapper">
		<div id="header"><jsp:include page="./topcontent.jsp"></jsp:include></div>
		<div id="reportcontent">
			<div>
			<br>
				<center>
					<b>Report: <%=reporttype%></b><br><br> <b>Date: <%=term%></b>
				</center>
				<br>

			</div>

			<div id='chart_div' style='width: 700px; height: 240px; margin-left: auto;margin-right: auto'></div>
			<div class="reportlist">
				<br>


				<table id="reporttable" style=" margin-left: auto;margin-right: auto;width: 200px">
					<tr>
						<th>PID</th>
						<th>Total</th>
					</tr>
					<%
						for (int i = 0; i < replist.size(); i++) {
					%>
					<tr>
						<td><%=replist.get(i).getPid()%></td>
						<td><%=replist.get(i).getTotal()%></td>
					</tr>
					<%
						}
					%>
				</table>

			</div>
		</div>
	</div>

</body>
</html>




