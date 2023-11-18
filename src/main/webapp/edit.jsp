<%@page import="com.project.employee.EmployeeDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Employee</title>
<style>
#label1{
padding : 20px;
width: 100%;
border-radius : 5px;
margin-top: 90px;
color: white;
background-color: #0BBABA;
position : relative;
}
#didi{
width : 100%;
height : 100vh;
background-color: #4D4EFF;
}
</style>
</head>
<body>
	<%EmployeeDto dto = (EmployeeDto)request.getAttribute("employee"); %>
	<div id="didi">	
	 <form style=" text-align: center; display: inline-block; margin-left: 36%; padding: 20px;" action="update" method="post">
	
    <div id="label1" >
    <h1>Employee Updation</h1>
		<label  for="empid">Employee Id:</label>
		<input type="num" name="id" id="empid" readonly="true" value="<%=dto.getId()%>"> <br> <br>
		<label for="empnam">Employee name:</label>
		<input type="text" name="name" id="empnam" value="<%=dto.getName() %>"> <br> <br>
		<label for="empdept">Employee Dept:</label>
		<input type="text" name="dept" id="empdept" value="<%=dto.getDept() %>"> <br> <br>
		<label for="empcon">Employee Contact:</label>
		<input type="tel" name="contact" id="empcon" value="<%=dto.getContact()%>"> <br> <br>
		<label for="empcity">Employee City:</label>
		<input type="text" name="city" id="empcity" value="<%=dto.getCity() %>"> <br> <br>
		<label for="emppass">Employee Password:</label>
		<input type="text" name="password" id="emppass"  value="<%=dto.getPassword() %>"> <br> <br>
    <input style="text-align: center;" type="submit">
  </div>
  </div>
  </form>
</body>
</html>