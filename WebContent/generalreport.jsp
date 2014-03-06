<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="uprm.icom5016.dtos.Report"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="layout.css">
<style type="text/css">
#reporttable{
border-collapse:collapse;
margin-left: auto;
margin-right: auto;
}

#reporttable tr td,th{
    border:1px solid black;
    text-align: center;
    padding: 2px;
}

center{
	color:#666666;
}
</style>
<link rel="stylesheet" type="text/css" href="layout.css">
<script type='text/javascript' src='http://www.google.com/jsapi'></script>
<script type='text/javascript'>
<%ArrayList<Report> replist = (ArrayList<Report>) session.getAttribute("report");
			String monthsum = (String) session.getAttribute("monthsum");
			String generaltype = (String) session.getAttribute("reporttype");
			String generaldate = (String) session.getAttribute("generaldate");%>
      google.load('visualization', '1', {'packages':['annotatedtimeline']});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = new google.visualization.DataTable();
       data.addColumn('date', 'Date');
       data.addColumn('number', 'Total: $');
       data.addRows(<%=replist.size()%>);     
      <%int size = replist.size();
			for (int i = 0; i < size; i++) {%>  
      	data.setValue(<%=i%>, 0, new Date(<%=Integer.parseInt(replist.get(i).getYear())%>,<%=Integer.parseInt(replist.get(i).getMonth()) - 1%>,<%=Integer.parseInt(replist.get(i).getDay())%>));
 	   data.setValue(<%=i%>,1, <%=Double.parseDouble(replist.get(i).getTotal().substring(1))%>);
		<%}%>

		var chart = new google.visualization.AnnotatedTimeLine(document
				.getElementById('chart_div'));
		chart.draw(data, {
			displayAnnotations: true});
    
      }
</script>
</head>


<body>
<div id="wrapper">
		<div id="header"><jsp:include page="./topcontent.jsp"></jsp:include></div>
		<div id="reportcontent">
		<div>
		<br>
			<center><b>Report: <%=generaltype%></b></center><br>
		</div>
		<div>
			<center><b>Date: <%=generaldate%></b></center><br>
		</div>
		<div id='chart_div' style='width: 700px; height: 240px; margin-left: auto;margin-right: auto'></div>
		<div class="reportlist">
		<br>


		<table id="reporttable">
		<tr><th>Date</th><th>Total By Day</th><th>Week #</th><th>Total By Week</th><th>Total By Month</th></tr>
		<%for(int i=0;i<replist.size();i++){
		String date = replist.get(i).getDay() +"-"+replist.get(i).getMonth()+"-"+replist.get(i).getYear();
		String month;
		if(replist.get(i).getResetweek().charAt(0)!='$')
			replist.get(i).setResetweek("*");
		if(i==replist.size()-1)
			month= monthsum;
		else
			month = "*";
		%>
		<tr><td><%=date%></td><td><%=replist.get(i).getTotal()%></td><td><%=replist.get(i).getWeek()%></td><td><%=replist.get(i).getResetweek()%></td><td><%=month%></td></tr>
		<%}%>
		</table>
		
		</div>
	</div>
	</div>
	

</body>
</html>