<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up Page</title>
<style>
	*{
    margin: 0px;
}
#main{
    border: 2px double white;
    background-color:rosybrown;
    height: 100vh;
    display: inline-block;
    width: 100%;
}
#head{
    color: white;
    margin-left: 0px;
    display: inline-block;
    position: relative;
    left: 100px;
}
form{
    border: 1px  solid blanchedalmond;
    margin-top: 100px;
    margin-bottom: 150px;
    color: white;
    border-radius: 20px;
    position: relative;
    right: 150px;
    display: inline-block;
    top: 40px;
}
#label1{
    color:black;
    margin-top: 20px;
}
img{
    width: 400px;
    margin-left: 40px;
}
</style>
</head>
<body>
	<div id="main">
    <section id="head">
      <img src="https://t3.ftcdn.net/jpg/02/49/05/82/360_F_249058233_0MIaTy9WXtKHF0eacUSg9c3hkV9ehIbX.jpg" alt="">
      <h1 style="text-align: center;">  Welcome to Employee Sign Up</h1>
	<h4 style="text-align: center;">Please enter your details</h4>
    </section>
  <form style=" text-align: center; display: inline-block; margin-left: 36%; padding: 20px;" action="signup" method="post">
    <h2 style="color: black;">Registration</h2>
    <div id="label1" >
		<label  for="empid">Employee Id:</label>
		<input type="num" name="id" id="empid"> <br> <br>
		<label for="empnam">Employee name:</label>
		<input type="text" name="name" id="empnam"> <br> <br>
		<label for="empdept">Employee Dept:</label>
		<input type="text" name="dept" id="empdept"> <br> <br>
		<label for="empcon">Employee Contact:</label>
		<input type="tel" name="contact" id="empcon"> <br> <br>
		<label for="empcity">Employee City:</label>
		<input type="text" name="city" id="empcity"> <br> <br>
		<label for="emppass">Employee Password:</label>
		<input type="text" name="password" id="emppass"> <br> <br>
    <input style="text-align: center;" type="submit">
  </div>
  </form>
</div>
</body>
</html>