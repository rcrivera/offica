<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="uprm.icom5016.dtos.Product" %>
<%@ page import="uprm.icom5016.dtos.Labels" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Filter Form</title>
</head>
<body>
<%
	String subcat = "labels"; 
	ArrayList<String> att = new ArrayList<String>();
	ArrayList<String> toPrint = new ArrayList<String>();
	ArrayList<Product> list = new ArrayList<Product>();
	Labels l = new Labels("big", "red","100","new");
	Labels la = new Labels("small", "blue","50","new");
	Labels lb = new Labels("regular", "green","100","old");
	Labels lc = new Labels("medium", "yellow","25","clear");
	list.add(l);
	list.add(la);
	list.add(lb);
	list.add(lc);
	Product p = list.get(0);
	att = p.getSpecificAttributes();
	
	for (String a : att){
		for(Product e : list){
			String x = e.getAtt(a);
			x = x.toLowerCase();
			x=x+"*"+a;
			if(!(toPrint.contains(x))){
				toPrint.add(x);
			}
		}
	}
%>
<table>
<form name="filterform" method="get" action="./filterservlet">
<%
	for (String u : att){
%><tr>
	<td><b><%=u %></b></td>
	<td><select name="<%=u %>">
	<%
	for (String y : toPrint){
		String value = y.substring(0, y.indexOf('*'));
		String attribute = y.substring(y.indexOf('*')+1, y.length());
		if(u.equals(attribute)){
	%>
	<option value="<%=value %>"><%=value %></option>
	<%
		}
	}
	%>
	</select></td>
	</tr>
<%
	}
%>

<tr><td align="center"><input type="submit" value="Filter"/></td></tr>
	
</form>
</table>

</body>
</html>