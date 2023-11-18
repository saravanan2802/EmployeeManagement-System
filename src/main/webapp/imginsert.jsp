<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Image</title>
<style>
form {
	border : 2px solid black;
	text-align: center;
	margin-top: 250px;
	padding: 20px;
	width: 390px;
	margin-left: 350px;
	height: 100px;
	border-radius: 20px;
	border-bottom-color: orange;
	border-color: orange green;
}
</style>
</head>
<body>
	<form action="imgs" method="post" enctype="multipart/form-data">
		<label for="nam">Name :</label>
		<input type="text" name="name" id="nam"> <br> <br>
		<label style="margin-left: 40px;" for="img">Upload File :</label>
		<input type="file" name="image" id="img"> <br> <br>
		<input type="submit">
	</form>
</body>
</html>