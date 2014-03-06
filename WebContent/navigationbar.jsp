<html>
<head>
<style>
body {
	font-family: arial
}

table {
	font-size: 80%;
	background: "white";
	text-align: center;
}

a {
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
a:hover {
	color: #666666;
}

td {
	background: #97d330;
	width: = 110px;
}

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
	
	function changeurl(url){
		document.all.content.src= url;
		document.getElementById(mainFrame).height = "100%";
	}
	
</script>
</head>

<body>
	<table width=750px>
		<tr bgcolor="ff9933">
			<td onmouseover="showmenu('paper')" onmouseout="hidemenu('paper')">
				<a class="main" href="javascript:changeurl('./paper.jsp')">Paper</a>
				<table class="menu" id="paper" width=110px>
					<tr>
						<td class="menu"><a href="javascript:changeurl('./paper/copypaper.jsp')"> Copy
								Paper</a></td>
					</tr>
					<tr>
						<td class="menu"><a href="javascript:changeurl('./paper/resumepaper.jsp')">Resume
								Papers</a></td>
					</tr>
					<tr>
						<td class="menu"><a href="javascript:changeurl('./paper/photopaper.jsp')">Photo
								Paper</a></td>
					</tr>
					<tr>
						<td class="menu"><a href="javascript:changeurl('./paper/businesscardpaper.jsp')">Business
								Paper</a></td>
					</tr>
				</table>
			</td>
			<td onmouseover="showmenu('stationary')"
				onmouseout="hidemenu('stationary')"><a class="main"
				href="javascript:changeurl('./stationary.jsp')">Stationary</a>
				<table class="menu" id="stationary" width=110px>
					<tr>
						<td class="menu"><a href="javascript:changeurl('./stationary/labels.jsp')">Labels</a></td>
					</tr>
					<tr>
						<td class="menu"><a href="javascript:changeurl('./stationary/envelopes.jsp')">Envelopes</a></td>
					</tr>
					<tr>
						<td class="menu"><a href="javascript:changeurl('./stationary/boxes.jsp')">Boxes</a></td>
					</tr>
					<tr>
						<td class="menu"><a href="javascript:changeurl('./stationary/filefolders.jsp')">File
								Folders</a></td>
					</tr>
					<tr>
						<td class="menu"><a href="javascript:changeurl('./stationary/binders.jsp')">Binders</a></td>
					</tr>
				</table></td>
			<td onmouseover="showmenu('officesupplies')"
				onmouseout="hidemenu('officesupplies')"><a class="main"
				href="javascript:changeurl('./officesupplies.jsp')">Office Supp</a>
				<table class="menu" id="officesupplies" width=110px>
					<tr>
						<td class="menu"><a href="javascript:changeurl('./office_supplies/pencils.jsp')">Pencils</a></td>
					</tr>
					<tr>
						<td class="menu"><a href="javascript:changeurl('./office_supplies/pens.jsp')">Pens</a></td>
					</tr>
					<tr>
						<td class="menu"><a href="javascript:changeurl('./office_supplies/markers.jsp')">Markers</a></td>
					</tr>
					<tr>
						<td class="menu"><a href="javascript:changeurl('./office_supplies/erasers.jsp')">Erasers</a></td>
					</tr>
					<tr>
						<td class="menu"><a href="javascript:changeurl('./office_supplies/rubberbands.jsp')">Rubber
								Bands</a></td>
					</tr>
					<tr>
						<td class="menu"><a href="javascript:changeurl('./office_supplies/staples.jsp')">Staples</a></td>
					</tr>
					<tr>
						<td class="menu"><a href="javascript:changeurl('./office_supplies/staplemachines.jsp')">Staple
								Machines</a></td>
					</tr>
					<tr>
						<td class="menu"><a href="javascript:changeurl('./office_supplies/paperclips.jsp')">Paper
								Clips</a></td>
					</tr>
				</table></td>
			<td onmouseover="showmenu('electronics')"
				onmouseout="hidemenu('electronics')"><a class="main"
				href="javascript:changeurl('./electronics.jsp')">Electronics</a>
				<table class="menu" id="electronics" width=110px>
					<tr>
						<td class="menu"><a href="javascript:changeurl('./electronics/laptops.jsp')">Laptops</a></td>
					</tr>
					<tr>
						<td class="menu"><a href="javascript:changeurl('./electronics/desktops.jsp')">Desktops</a></td>
					</tr>
					<tr>
						<td class="menu"><a href="javascript:changeurl('./electronics/cameras.jsp')">Cameras</a></td>
					</tr>
					<tr>
						<td class="menu"><a href="javascript:changeurl('./electronics/tablets.jsp')">Tablets</a></td>
					</tr>
					<tr>
						<td class="menu"><a href="javascript:changeurl('./electronics/calculators.jsp')">Calculators</a></td>
					</tr>
					<tr>
						<td class="menu"><a href="javascript:changeurl('./electronics/printers.jsp')">Printers</a></td>
					</tr>
				</table></td>
			<td onmouseover="showmenu('electronicsupplies')"
				onmouseout="hidemenu('electronicsupplies')"><a class="main"
				href="javascript:changeurl('./electronicsupplies.jsp')">Electric Supp</a>
				<table class="menu" id="electronicsupplies" width=110px>
					<tr>
						<td class="menu"><a href="javascript:changeurl('./electronic_supplies/internaldisks.jsp')">Internal
								Disks</a></td>
					</tr>
					<tr>
						<td class="menu"><a href="javascript:changeurl('./electronic_supplies/externaldisks.jsp')">External
								Disks</a></td>
					</tr>
					<tr>
						<td class="menu"><a href="javascript:changeurl('./electronic_supplies/memory.jsp')">Memory</a></td>
					</tr>
					<tr>
						<td class="menu"><a href="javascript:changeurl('./electronic_supplies/inkcartridges.jsp')">Ink
								Cartridges</a></td>
					</tr>
					<tr>
						<td class="menu"><a href="javascript:changeurl('./electronic_supplies/toner.jsp')">Toner</a></td>
					</tr>
				</table></td>
			<td onmouseover="showmenu('furniture')"
				onmouseout="hidemenu('furniture')"><a class="main"
				href="javascript:changeurl('./furniture.jsp')">Furniture</a>
				<table class="menu" id="furniture" width=110px>
					<tr>
						<td class="menu"><a href="javascript:changeurl('./furniture/desks.jsp')">Desks</a></td>
					</tr>
					<tr>
						<td class="menu"><a href="javascript:changeurl('./furniture/chairs.jsp')">Chairs</a></td>
					</tr>
					<tr>
						<td class="menu"><a href="javascript:changeurl('./furniture/mats.jsp')">Mats</a></td>
					</tr>
					<tr>
						<td class="menu"><a href="javascript:changeurl('./furniture/lamps.jsp')">Lamps</a></td>
					</tr>
					<tr>
						<td class="menu"><a href="javascript:changeurl('./furniture/bookshelves.jsp')">Bookshelves</a></td>
					</tr>
					<tr>
						<td class="menu"><a href="javascript:changeurl('./furniture/filecabinets.jsp')">File
								Cabinets</a></td>
					</tr>
				</table></td>
			</td>
			<td onmouseover="showmenu('cleaningsupplies')"
				onmouseout="hidemenu('cleaningsupplies')"><a class="main"
				href="javascript:changeurl('./cleaningsupplies.jsp')">Cleaning</a>
				<table class="menu" id="cleaningsupplies" width=110px>
					<tr>
						<td class="menu"><a href="javascript:changeurl('./cleaning_supplies/handsanitizer.jsp')">Hand
								Sanitizer</a></td>
					</tr>
					<tr>
						<td class="menu"><a href="javascript:changeurl('./cleaning_supplies/soap.jsp')">Soap</a></td>
					</tr>
					<tr>
						<td class="menu"><a href="javascript:changeurl('./cleaning_supplies/papertowel.jsp')">Paper
								Towel</a></td>
					</tr>
					<tr>
						<td class="menu"><a href="javascript:changeurl('./cleaning_supplies/tissuepaper.jsp')">Tissue
								Paper</a></td>
					</tr>
					<tr>
						<td class="menu"><a href="javascript:changeurl('./cleaning_supplies/trashbags.jsp')">Trash
								Bags</a></td>
					</tr>
					<tr>
						<td class="menu"><a href="javascript:changeurl('./cleaning_supplies/disinfectantcleaners.jsp')">Disinfectant</a></td>
					</tr>
				</table></td>
	</table>

	<iframe name="mainFrame" id="content" src="./paper/copypaper.jsp" width="770px" scrolling="no" height="1500px" frameborder="no"> </iframe>

</body>

</html>