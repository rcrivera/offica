<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Administrator Settings</title>

<style>
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

</head>
<body>

	<div>
		<center><b>Administrator Settings</b></center>
		<br>
		<form>
			<table>
				<tr>
					<td class="text"><b>Add Item</b></td>
				</tr>
				<tr>
					<td><br>
					</td>
				</tr>
				<tr>
					<td>Item Id</td>
					<td><input type="text" /></td>
				</tr>
				<tr>
					<td>Item Name</td>
					<td><input type="text" /></td>
				</tr>
				<tr>
					<td>Item Price</td>
					<td><input type="text" /></td>
				</tr>
				<tr>
					<td>Brand</td>
					<td><input type="text" /></td>
				</tr>
				<tr>
					<td>Model</td>
					<td><input type="text" /></td>
				</tr>
				<tr>
					<td>Dimensions</td>
					<td><input type="text" /></td>
				</tr>
				<tr>
					<td>Description</td>
					<td><textarea cols="40" rows="5">Description...</textarea></td>
				</tr>
				<tr>
					<td></td>
					<td align="right"><input type="submit" value="Submit" /></td>
				</tr>
			</table>
		</form>
		<br>
		<br>
		
		<form>
			<table>
				<tr>
					<td class="text"><b>Add User</b></td>
				</tr>
				<tr>
					<td><br>
					</td>
				</tr>
				<tr>
					<td>User Id</td>
					<td><input type="text" /></td>
				</tr>
				<tr>
					<td>User First name</td>
					<td><input type="text" /></td>
				</tr>
				<tr>
					<td>User Last name</td>
					<td><input type="text" /></td>
				</tr>
				<tr>
					<td>User Password</td>
					<td><input type="password" /></td>
				</tr>
				<tr>
					<td>User Password (Again)</td>
					<td><input type="password"/></td>
				</tr>
				<tr>
					<td></td>
					<td align="right"><input type="submit" value="Submit" /></td>
				</tr>
			</table>
		</form>
		<br>
		<br>
		
			<form>
			<table>
				<tr>
					<td class="text"><b>Remove User</b></td>
				</tr>
				<tr>
					<td><br>
					</td>
				</tr>
				<tr>
					<td>User Id</td>
					<td><input type="text" /></td>
				</tr>
				<tr>
					<td></td>
					<td align="right"><input type="submit" value="Submit" /></td>
				</tr>
			</table>
		</form>
		
		

	</div>
</body>
</html>