<%@page import="java.util.Base64"%>
<%@page import="java.sql.Blob"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Image Execute</title>
<style>
th,td{
	border:  1px solid black;
	border-collapse: collapse;
}
td{
text-align:center; 
padding: 10px;
}
table {
	width: 100%;
	text-align: center;
}
</style>
</head>
<body>
	<%ResultSet rs = (ResultSet)request.getAttribute("dats"); %>
	
	<table>
	   <thead>
	     <tr>
	       <th>Name</th>
	       <th>Picture</th>
	     </tr>
	   </thead>
	   <%while(rs.next()){ %>
	   <tbody>
	     <tr>
	     	<td> <%= rs.getString(1) %> </td>
	    
	     	<% Blob img =rs.getBlob(2); %>
	     	<% byte[] photoBytes = img.getBytes(1, (int)img.length()); %>
	     	<% String finImg = new String(Base64.getEncoder().encode(photoBytes)); %>
	     	
	     	<td> <img alt="Student Image" src="data:image/jpeg;base64, <%= finImg %>" width="200px" height="200px" "> </td>
	     </tr>
	   </tbody>
	   <% } %>
	</table>
	<a href="imginsert.jsp">Add More</a>
</body>
</html>