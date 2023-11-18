<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
<style >
#adm{
	border: 1px solid black;
	text-align: center;
	width: 600px;
	text-align: center;
	margin-left: 350px;
	margin-top: 100px;
	background-color: #4682B4;
	height: 300px;
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
<div id="adm">
<h1 style="margin-top: 20px; position: relative; top:30px;">Admin login</h1>
 	<form
					style="border: 7px double white; color: black; text-shadow: 0px 0px; border-bottom-right-radius: 20px; border-top-left-radius: 20px; text-align: center; display: inline-block; margin-left: 50px; margin-top: 30px; padding: 20px;"
					action="admlogin" method="post">
					<label for="empname">admin user:</label> <input type="text"
						name="name" id="empname"> <br> <br> <label
						for="emppas">Password:</label> <input type="password" name="pass"
						id="emppas"> <br> <br> <input
						style="text-align: center;" type="submit">
				</form>
				</div>
</body>
</html>