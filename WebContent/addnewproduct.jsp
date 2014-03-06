<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.ArrayList"%>
<html>
<head>
<style type="text/css">
center{
	color:#666666;
}
div{
	margin:50px;	
}
td{
	color:#666666;	
}
center{
	color:#666666;
}
td.text{
	color:#97d330;
}
a{
	color:#333333;
	text-decoration:none;
}
p.description{
	color:#666666;	
}

</style>
<link rel="stylesheet" type="text/css" href="layout.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Product</title>
<%ArrayList<String> attNames = (ArrayList<String>) session.getAttribute("attNames");
ArrayList<String> att = (ArrayList<String>) session.getAttribute("att");
Integer addnewproduct;
String s = (String)session.getAttribute("addnewproduct");
if(s!=null){
addnewproduct=Integer.parseInt(s);}
else{
	session.setAttribute("addnewproduct", "0");
	addnewproduct=0;
}
%>

</head>
<body>
<div id="wrapper">
		<div id="topcontent"><jsp:include page="./topcontent.jsp"></jsp:include></div>
		<div id ="content"align="center">
		<form action="./AddNewProductServlet?addnewproduct=0" method="post">
		<select name="subcat">
			<option value="">Select Category</option>
			<option value="binders">Binder</option>
			<option value="bookshelves">Bookshelves</option>
			<option value="boxes">Box</option>
			<option value="businesspaper">Business Card Paper</option>
			<option value="calculators">Calculator</option>
			<option value="cameras">Camera</option>
			<option value="chairs">Chair</option>
			<option value="copypaper">Copy Paper</option>
			<option value="desks">Desks</option>
			<option value="desktops">Desktop</option>
			<option value="disinfectant">Disinfectant</option>
			<option value="envelopes">Envelope</option>
			<option value="erasers">Eraser</option>
			<option value="externaldisks">External Disk</option>
			<option value="filecabinets">File Cabinet</option>
			<option value="filefolders">File Folder</option>
			<option value="inkcartridges">Ink Cartridge</option>
			<option value="internaldisks">Internal Disk</option>
			<option value="labels">Label</option>
			<option value="lamps">Lamp</option>
			<option value="laptops">Laptop</option>
			<option value="markers">Marker</option>
			<option value="mats">Mats</option>
			<option value="memory">Memory</option>
			<option value="paperclips">Paper Clips</option>
			<option value="papertowels">Paper Towel</option>
			<option value="pencils">Pencils</option>
			<option value="pens">Pens</option>
			<option value="photopaper">Photo Paper</option>
			<option value="printers">Printer</option>
			<option value="resumepaper">Resume Paper</option>
			<option value="rubberbands">Rubberband</option>
			<option value="sanitizer">Sanitizer</option>
			<option value="soap">Soap</option>
			<option value="staplemachines">Staple Machine</option>
			<option value="staples">Staples</option>
			<option value="tablets">Tablet</option>
			<option value="tissuepaper">Tissue Paper</option>
			<option value="toner">Toner</option>
			<option value="trashbags">Trash Bag</option>
		</select>
		<input type="submit" value="Proceed To Add Product" />
		</form>
		<%if(addnewproduct==1){%>
		<form>
		<table align="left">
				<tr><td class="text"><b>Add Item</b></td></tr>
				<tr><td><br></td></tr>
				<tr><td>Item Id</td><td><input type="text" name="pid"/></td></tr>
				<tr><td>Item Name</td><td><input type="text" name="pname"/></td></tr>
				<tr><td>Item Price</td><td><input type="text" name="price"/></td></tr>
				<tr><td>Brand</td><td><input type="text" name="brand"/></td></tr>
				<tr><td>Model</td><td><input type="text" name="model"/></td></tr>
				<tr><td>Stock Quantity</td><td><input type="text" name="stock"/></td></tr>
				<tr><td>Picture</td><td><input type="file" name="picturefile" size="40"></td></tr>
				<tr><td>Description</td><td><input type="text" name="description"></td></tr>
				<tr><td>Category</td><td><input type="text" name="cat"/></td></tr>
				<%for(int i=0;i<att.size()-1;i++){%>
				<tr><td><%=attNames.get(i)%></td><td><input type="text" name=<%=att.get(i)%> /></td></tr>	
				<%}%>
			</table>
			<input type="hidden" name="subcat" value=<%=att.get(att.size()-1) %>>
			<input type="submit" value="Add Product">
		</form>
		<%}%>
	</div>
</div>


</body>
</html>