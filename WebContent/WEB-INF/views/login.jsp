<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>NorthWestMutual Onboarding Login</title>

<script type="text/javascript">
	var login_attempts = 3;
	function check_form() {
		var userName = document.getElementById("userName").value;
		var password = document.getElementById("password").value;
		if (userName == "Admin" && password == "Admin") {
			alert("SuccessFully Logged In");
			document.getElementById("userName").value = "";
			document.getElementById("password").value = "";
		} else {
			if (login_attempts == 0) {
				alert('No Login Attempts Available');
			} else {
				login_attempts = login_attempts - 1;
				alert("Login Failed Now Only " + login_attempts
						+ " Login Attempts Available");
				if (login_attempts == 0) {
					document.getElementById("userName").disabled = true;
					document.getElementById("password").disabled = true;
					document.getElementById("loginForm").disabled = true;
				}
			}
		}

		return false;
	}
</script>
</head>
<body>
	<form id="loginForm" action="login" method="post">
		<div align="Center">
			<h1>Welcome to NorthwestMutual Insurance</h1>
			<h2>Please Identify yourself</h2>
		</div>
		<div align="Center">
			<table>
				<tbody><tr>
					<td>User Name</td>
					<td><input type="text" id="userName" name="userName"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" id="password" name="password"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Login"></td>
				</tr>
			</tbody></table>

		</div>
	</form>


</body></html>
