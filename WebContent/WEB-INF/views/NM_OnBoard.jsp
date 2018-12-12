<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>CSS Template</title>
<!-- <link rel="stylesheet" type="text/css" href="login_style.css">
<link rel="stylesheet" href="WebContent/resources/css/login_style.css"/> -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/login_style.css"/>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<header>
		<h2>Welcome to NorthwestMutual</h2>
	</header>
	<section>
		<div id="menu">
		<a href="#">Home</a>	
		<a href="#">On-Boarding</a>	
		<a href="#">Transfer</a>	
		<a href="#">Termination</a>	
		</div>
	</section>
	<section>	
	<aside>
		<div id="wrapper">
			<h1>Welcome to NorthwestMutual On-boarding</h1>
			<form id="form1" method="post" action="" onsubmit="return check_form();">
				<table>
					<tr>
						<td><input type="text" id="employeeId" placeholder="Enter Employee Id"> 
							<br> 
							<input type="text" id="name" placeholder="Enter Employee Name">
							<br> 
							<input type="text" id="email" placeholder="Enter Employee Email"> 
							<br> 
							<input type="text" id="doj" placeholder="Enter Date of joining">
							<br> 
							<input type="text" id="exp" placeholder="Enter Employee Experience"> 
							<br> 
							<select>
								<option value="1" >Non Billable </option>
								<option value="1" >FC </option>
								<option value="1" >FB </option>
								<option value="1" >T&M </option>
							</select> 
							<br>
							<input type="text" id="location" placeholder="Enter Location">
							<br> 
							<input type="text" id="location" placeholder="Unit"> 
							<br>
							<input type="text" id="location" placeholder="Sub-Unit"> 
							<br> 
							<br>
						</td>
						<td><input type="text" id="employeeId" placeholder="Directors"> 
							<br>
							<input type="text" id="employeeId" placeholder="Anchors"> 
							<br>							
							<input type="text" id="employeeId" placeholder="NM Lan Id"> 
							<br> 
							<input type="text" id="name" placeholder="NM Email ID">
							<br> 
							<input type="text" id="email" placeholder="NM Project Type"> 
							<br> 
							<input type="text" id="doj" placeholder="NM DL Update">
							<br> 
							<input type="text" id="exp" placeholder="NM Join Date"> 
							<br> 
							<input type="text" id="team" placeholder="NM SOW"> 
							<br>
							<input type="text" id="location" placeholder="Extn/Cubie">
							<br>							 
							<br>
						</td>
						<td><input type="text" id="location" placeholder="NM Induction Training"> 
							<br>
							<input type="text" id="employeeId" placeholder="NM Lan Id"> 
							<br> 
							<input type="text" id="name" placeholder="NM Email ID">
							<br> 
							<input type="text" id="email" placeholder="NM Project Type"> 
							<br> 
							<input type="text" id="doj" placeholder="NM DL Update">
							<br> 
							<input type="text" id="exp" placeholder="NM Join Date"> 
							<br> 
							<input type="text" id="team" placeholder="Enter Team"> 
							<br>
							<input type="text" id="location" placeholder="Extn/Cubie">
							<br> 
							<input type="text" id="location" placeholder="NM Induction Training"> 
							<br> 
							<br>
						</td>
						<td><input type="text" id="employeeId" placeholder="SignOn Form"> 
							<br> 
							<input type="text" id="name" placeholder="New Machine Request">
							<br> 
							<input type="text" id="email" placeholder="PPm Form"> 
							<br> 
							<input type="text" id="email" placeholder="NDA Form">
							<br> 
							<input type="text" id="email" placeholder="Privacy Basics">
							<br>
							<input type="text" id="doj"	placeholder="Drug Test Exception"> 
							<br> 
							<input type="text" id="exp" placeholder="Mutual Code of Conduct">
							<br> 
							<input type="text" id="team" placeholder="Building Access Request">
							<br>
							<input type="submit" value="SUBMIT"> 
							<br> 
							<br>
						</td>
					</tr>
					<tr>
				</table>
			</form>
			</p>
			</p>
			</p>
		</div>
	</aside>
</section>

	<footer>
		<p>Footer</p>
	</footer>

</body>
</html>
