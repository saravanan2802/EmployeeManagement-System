<%@page import="com.project.employee.EmployeeDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>
<style>
table {
	text-align: center;
	margin-top: 30px;
	width: 100%;
}
td, th, tr {
	border: 1px solid black;
	padding: 5px;
}
th{
border-radius: 5px;
background-color: #0080FF;
color: white;
}
td{
background-color: rgb(173,217,230);
}
#logout{
	background-color: #0172B4;
	color: white;
	display: flex;
	justify-content: center;
	gap: 70px;
}
#aa{
text-decoration: none;
color: white;
padding-right: 10px;
margin-right: 0px;
position: absolute;
right: 10px; 	
}
thead{
height: 40px;
}
td{
border-radius: 3px;
}
</style>
</head>
<body>
	<%
	List<EmployeeDto> emp = (List) request.getAttribute("employee");
	%>
   <div id="logout">
   <h3 style="margin-left: -900px;">Home</h3>
   <h3>Gallery</h3>
   <h3>About</h3>
   <h3>More</h3>
    <a id="aa"  href="logout"><h4>Logout</h4></a></div>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Dept</th>
				<th>Contact</th>
				<th>City</th>
				<th>Pass</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
		<%
		for (EmployeeDto dto : emp) {
		%>
		<tbody>
			<tr>
				<td><%=dto.getId()%></td>
				<td><%=dto.getName()%></td>
				<td><%=dto.getDept()%></td>
				<td><%=dto.getContact()%></td>
				<td><%=dto.getCity()%></td>
				<td><%=dto.getPassword()%></td>
				<td><a href="edit?id=<%=dto.getId()%>">Edit</a></td>
				<td><a href="delete?id=<%=dto.getId()%>">Delete</a></td>
			</tr>
		</tbody>
		<%
		}
		%>
	</table>
</body>
</html>