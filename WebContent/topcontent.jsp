<%@page import="uprm.icom5016.dtos.User"%>
<html>
<head>
<style>
#navbar tr td {
	background: #97d330;
	width: = 110px;
}

td.banner {
	background-color: transparent;
}

td.txt {
	font-family: Helvetica;
	font-size: 13px;
	color: gray;
	background-color: transparent;
}

table.login {
	background: transparent;
}

a.register {
	font-family: Helvetica;
	font-size: 13px;
	color: gray;
	font-weight: 5px;
}

a.register:hover {
	color: #97d330;
}

body {
	font-family: arial;
	margin: 0px;
}

table {
	font-size: 80%;
	background: "white";
	text-align: center;
}

#navbar a {
	text-indent: 5px;
	color: #FFFFFF;
	text-decoration: none;
	font: bold;
	width: 110px;
	font-weight: 900;
	display: block;
	a .main{text-indent: 0px;
}

}
#navbar a:hover {
	color: #666666;
}
/* 
td {
	background: #97d330;
	width: = 110px;
} */
table.menu {
	font-size: :100%;
	position: absolute;
	visibility: hidden;
	width: = 110px;
	text-align: left;
}
</style>

<script type="text/javascript">
	function showmenu(elmnt) {
		document.getElementById(elmnt).style.visibility = "visible";
	}
	function hidemenu(elmnt) {
		document.getElementById(elmnt).style.visibility = "hidden";
	}

	function changeurl(url) {
		document.all.content.src = url;
		document.getElementById(mainFrame).height = "100%";
	}
</script>
</head>

<body>

	<table width="800px" height="200px"
		background="./images/officabanner.png">
		<tr>
			<td class="banner">
				<%
					Integer checkedIn = (Integer) session.getAttribute("checkedIn");
				%> <%
 	if (checkedIn == null || checkedIn == 0 || checkedIn == -1) {
 %>
				<form name="loginForm" action="./LoginServlet" method="post">
					<table class="login" align="right">
						<tr>
							<td class="txt">Username</td>
							<td class="banner"><input type="text" name="username" /></td>
						</tr>
						<tr>
							<td class="txt">Password</td>
							<td class="banner"><input type="password" name="pass" /></td>
						</tr>
						<tr>
							<td class="banner"></td>
							<td class="banner" align="right">
								<table>
									<tr>
										<td class="banner"><a class="register"
											href="./Register.jsp">SignUp</a></td>
										<td class="banner"><input type="submit" value="Login" />
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</form> <%
 	} else if (checkedIn == 1) {
 		User user = (User)session.getAttribute("user");
 		String name = user.getFirstName();
 %>
				<p align="right">
				<font color=#666666>Hi <font color=#5c8910><b><%=name %></b></font><br>
				Change <a href="./profile.jsp"><font color=#5c8910><b>Settings</b></font></a>?</font>
				<form align="right" action="./LogOutServlet" method="post">
					<input type="submit" value="Logout" />
				</form>
				</p> <br> <br> <%
 	}
 %>
			</td>
		</tr>
		<tr>
			<td class="banner" align="right"></td>
		</tr>
		<tr>
			<td class="banner" align="left">
				<form name="searchForm" action="./SearchServlet" method="get">
					<input type="text" name="searchQuery" /> <input type="submit"
						value="Search" />
				</form>
			</td>
		</tr>
	</table>

	<!--<a class="main" href="./SubCatServlet?id=1&sid=2">Paper</a>  -->
	<table id="navbar" width=750px>
		<tr bgcolor="ff9933">
			<td onmouseover="showmenu('paper')" onmouseout="hidemenu('paper')">
				<a class="main" href="./CategoriesList?cat=paper&subcat=paper">Paper</a>
				<table class="menu" id="paper" width=110px>
					<tr>
						<td class="menu"><a
							href="./SubCatServlet?cat=paper&subcat=copypaper">Copy
								Paper</a></td>
					</tr>
					<tr>
						<td class="menu"><a
							href="./SubCatServlet?cat=paper&subcat=resumepaper">Resume
								Paper</a></td>
					</tr>
					<tr>
						<td class="menu"><a
							href="./SubCatServlet?cat=paper&subcat=photopaper">Photo
								Paper</a></td>
					</tr>
					<tr>
						<td class="menu"><a
							href="./SubCatServlet?cat=paper&subcat=businesspaper">Business
								Paper</a></td>
					</tr>
				</table>
			</td>
			<td onmouseover="showmenu('stationary')"
				onmouseout="hidemenu('stationary')"><a class="main"
				href="./CategoriesList?cat=Stationary&subcat=Stationary">Stationary</a>
				<table class="menu" id="stationary" width=110px>
					<tr>
						<td class="menu"><a href="./SubCatServlet?cat=stationary&subcat=labels">Labels</a></td>
					</tr>
					<tr>
						<td class="menu"><a
							href="./SubCatServlet?cat=stationary&subcat=envelopes">Envelopes</a></td>
					</tr>
					<tr>
						<td class="menu"><a
							href="./SubCatServlet?cat=stationary&subcat=boxes">Boxes</a></td>
					</tr>
					<tr>
						<td class="menu"><a
							href="./SubCatServlet?cat=stationary&subcat=filefolders">File
								Folders</a></td>
					</tr>
					<tr>
						<td class="menu"><a
							href="./SubCatServlet?cat=stationary&subcat=binders">Binders</a></td>
					</tr>
				</table></td>
			<td onmouseover="showmenu('officesupplies')"
				onmouseout="hidemenu('officesupplies')"><a class="main"
				href="./CategoriesList?cat=officesupplies&subcat=officesupplies">Office
					Supp</a>
				<table class="menu" id="officesupplies" width=110px>
					<tr>
						<td class="menu"><a
							href="./SubCatServlet?cat=officesupplies&subcat=pencils">Pencils</a></td>
					</tr>
					<tr>
						<td class="menu"><a
							href="./SubCatServlet?cat=officesupplies&subcat=pens">Pens</a></td>
					</tr>
					<tr>
						<td class="menu"><a
							href="./SubCatServlet?cat=officesupplies&subcat=markers">Markers</a></td>
					</tr>
					<tr>
						<td class="menu"><a
							href="./SubCatServlet?cat=officesupplies&subcat=erasers">Erasers</a></td>
					</tr>
					<tr>
						<td class="menu"><a
							href="./SubCatServlet?cat=officesupplies&subcat=rubberbands">Rubber
								Bands</a></td>
					</tr>
					<tr>
						<td class="menu"><a
							href="./SubCatServlet?cat=officesupplies&subcat=staples">Staples</a></td>
					</tr>
					<tr>
						<td class="menu"><a
							href="./SubCatServlet?cat=officesupplies&subcat=staplemachines">Staple
								Machines</a></td>
					</tr>
					<tr>
						<td class="menu"><a
							href="./SubCatServlet?cat=officesupplies&subcat=paperclips">Paper
								Clips</a></td>
					</tr>
				</table></td>
			<td onmouseover="showmenu('electronics')"
				onmouseout="hidemenu('electronics')"><a class="main"
				href="./CategoriesList?cat=electronics&subcat=electronics">Electronics</a>
				<table class="menu" id="electronics" width=110px>
					<tr>
						<td class="menu"><a
							href="./SubCatServlet?cat=electronics&subcat=laptops">Laptops</a></td>
					</tr>
					<tr>
						<td class="menu"><a
							href="./SubCatServlet?cat=electronics&subcat=desktops">Desktops</a></td>
					</tr>
					<tr>
						<td class="menu"><a
							href="./SubCatServlet?cat=electronics&subcat=cameras">Cameras</a></td>
					</tr>
					<tr>
						<td class="menu"><a
							href="./SubCatServlet?cat=electronics&subcat=tablets">Tablets</a></td>
					</tr>
					<tr>
						<td class="menu"><a
							href="./SubCatServlet?cat=electronics&subcat=calculators">Calculators</a></td>
					</tr>
					<tr>
						<td class="menu"><a
							href="./SubCatServlet?cat=electronics&subcat=printers">Printers</a></td>
					</tr>
				</table></td>
			<td onmouseover="showmenu('electronicsupplies')"
				onmouseout="hidemenu('electronicsupplies')"><a class="main"
				href="./CategoriesList?cat=electronicsupplies&subcat=electronicsupplies">Electric
					Supp</a>
				<table class="menu" id="electronicsupplies" width=110px>
					<tr>
						<td class="menu"><a
							href="./SubCatServlet?cat=electronicsupplies&subcat=internaldisks">Internal
								Disks</a></td>
					</tr>
					<tr>
						<td class="menu"><a
							href="./SubCatServlet?cat=electronicsupplies&subcat=externaldisks">External
								Disks</a></td>
					</tr>
					<tr>
						<td class="menu"><a
							href="./SubCatServlet?cat=electronicsupplies&subcat=memory">Memory</a></td>
					</tr>
					<tr>
						<td class="menu"><a
							href="./SubCatServlet?cat=electronicsupplies&subcat=inkcartridges">Ink
								Cartridges</a></td>
					</tr>
					<tr>
						<td class="menu"><a
							href="./SubCatServlet?cat=electronicsupplies&subcat=toner">Toner</a></td>
					</tr>
				</table></td>
			<td onmouseover="showmenu('furniture')"
				onmouseout="hidemenu('furniture')"><a class="main"
				href="./CategoriesList?cat=furniture&subcat=furniture">Furniture</a>
				<table class="menu" id="furniture" width=110px>
					<tr>
						<td class="menu"><a
							href="./SubCatServlet?cat=furniture&subcat=desks">Desks</a></td>
					</tr>
					<tr>
						<td class="menu"><a
							href="./SubCatServlet?cat=furniture&subcat=chairs">Chairs</a></td>
					</tr>
					<tr>
						<td class="menu"><a
							href="./SubCatServlet?cat=furniture&subcat=mats">Mats</a></td>
					</tr>
					<tr>
						<td class="menu"><a
							href="./SubCatServlet?cat=furniture&subcat=lamps">Lamps</a></td>
					</tr>
					<tr>
						<td class="menu"><a
							href="./SubCatServlet?cat=furniture&subcat=bookshelves">Bookshelves</a></td>
					</tr>
					<tr>
						<td class="menu"><a
							href="./SubCatServlet?cat=furniture&subcat=filecabinets">File
								Cabinets</a></td>
					</tr>
				</table></td>

			<td onmouseover="showmenu('cleaningsupplies')"
				onmouseout="hidemenu('cleaningsupplies')"><a class="main"
				href="./CategoriesList?cat=cleaningsupplies&subcat=cleaningsupplies">Cleaning</a>
				<table class="menu" id="cleaningsupplies" width=110px>
					<tr>
						<td class="menu"><a
							href="./SubCatServlet?cat=cleaningsupplies&subcat=handsanitizer">Hand
								Sanitizer</a></td>
					</tr>
					<tr>
						<td class="menu"><a
							href="./SubCatServlet?cat=cleaningsupplies&subcat=soap">Soap</a></td>
					</tr>
					<tr>
						<td class="menu"><a
							href="./SubCatServlet?cat=cleaningsupplies&subcat=papertowel">Paper
								Towel</a></td>
					</tr>
					<tr>
						<td class="menu"><a
							href="./SubCatServlet?cat=cleaningsupplies&subcat=tissuepaper">Tissue
								Paper</a></td>
					</tr>
					<tr>
						<td class="menu"><a
							href="./SubCatServlet?cat=cleaningsupplies&subcat=trashbags">Trash
								Bags</a></td>
					</tr>
					<tr>
						<td class="menu"><a
							href="./SubCatServlet?cat=cleaningsupplies&subcat=disinfectant">Disinfectant</a></td>
					</tr>
				</table></td>
	</table>

</body>

</html>