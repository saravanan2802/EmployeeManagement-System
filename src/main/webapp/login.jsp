<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log In Page</title>
<style>
* {
	margin: 0px;
}

#main1 {
	border: 1px solid blue;
	height: 100vh;
	background-color: #5287C3;
}

#main2 {
	margin: 120px;
	height: 400px;
	margin-left: 150px;
	width: 80%;
	display: flex;
	background-color: #39BDF7;
	border-radius: 10px;
	color: white;
	text-shadow: black;
}

img {
	height: 400px;
	width: 450px;
	display: inline-block;
}

#aside2 {
	margin-left: 150px;
	margin-top: 90px;
	border-radius: 20px;
}

</style>
</head>
<body>
	<%
	String name = (String) request.getAttribute("name");
	%>

	<%
	if (name != null) {
	%>
	<h1 style="text-align: center; color: orange;">
		Hello
		<%=name%>
	</h1>
	<%
	}
	%>

	<%
	String err = (String) request.getAttribute("message");
	%>

	<%
	if (err != null) {
	%>
	<h1 style="text-align: center; color: orange;">
		Sorry...
		<%=err%>
		<br> Please Try Again
	</h1>
	<%
	}
	%>


	<div id="main1">
		<div id="main2">
			<div id="aside1">
				<img alt=""
					src="https://img.freepik.com/free-vector/mobile-login-concept-illustration_114360-83.jpg?w=2000">
			</div>
			<div id="aside2">
				<h1 style="text-align: center;">Welcome to Employee Log in</h1>
				<h4 style="text-align: center;">Enter your Username & Password</h4>
				<form
					style="border: 7px double white; color: black; text-shadow: 0px 0px; border-bottom-right-radius: 20px; border-top-left-radius: 20px; text-align: center; display: inline-block; margin-left: 50px; margin-top: 30px; padding: 20px;"
					action="employeein" method="post">
					<label for="empname">User name:</label> <input type="text"
						name="name" id="empname"> <br> <br> <label
						for="emppas">Password:</label> <input type="password" name="pass"
						id="emppas"> <br> <br> <input
						style="text-align: center;" type="submit"> <br> <br>
						<a style="text-decoration: none;" href="adminlogin.jsp">adminlogin</a>
				</form>
			</div>
		</div>
	</div>
</body>
</html>