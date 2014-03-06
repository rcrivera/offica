<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>

<style>
#submit{
	float:right;
	display:block;
}
td.txt{
	font-family:Helvetica;
	font-size:13px;
	color:gray;
}
</style>


</head>
<body>

<div id="header" align="center"><jsp:include page="./topcontent.jsp"></jsp:include></div>
		<b><p align="center"> <font color="gray">SignUp</font></p></b>
		<br>
		<br>
	
		<form name="registerForm" action="./RegisterServlet" method="post">
			<table align="center">
				<tr><td align="left" class="txt">Desired Username</td><td><input type="text" name="regUsername" /></td></tr>
				<tr><td align="left" class="txt">Password</td><td><input type="password" name="regPass" /></td></tr>
				<tr><td align="left" class="txt">Confirm Password</td><td><input type="password" name="regPass2" /></td></tr>
				<tr><td align="left" class="txt">First Name</td><td><input name="regFirstName" type="text" /></td></tr>
				<tr><td align="left" class="txt">Last Name</td><td><input name="regLastName" type="text" /></td></tr>
				<tr><td align="left" class="txt">Email</td><td><input type="text" name="regEmail" /></td></tr>
				<tr><td align="left" class="txt">Phone No.</td><td><input type="text" name="regPhone" /></td></tr>
				<tr><td align="left" class="txt">Address</td><td><textarea name="regAdd" cols="20" rows="5"></textarea></td></tr>
				<tr><td></td><td>
									<table>
										<tr><td align="left" class="txt">City</td><td><input name="regCity" type="text" size="12"/></td></tr>
										<tr><td align="left" class="txt">State</td><td><input name="regState" type="text" size="12"/></td></tr>
										<tr><td align="left" class="txt">Zip Code</td><td><input name="regZip" type="text" size="12"/></td></tr>
										<tr><td align="left" class="txt">Country</td><td><input name="regCountry" type="text" size="12"/></td></tr>
									</table>
								</td> 
				</tr>
				<tr><td></td><td><input id="submit" type="submit"/></td></tr>
			</table>
		</form>
</body>
</html>