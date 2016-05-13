<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body bgcolor="cyan" background="C:\Users\ajinkyaja\Desktop\wall.jpg">

<style>

table{

border-collapse: collapse;
margin: auto;
margin-top: 15%;

}

td{
border-collapse: collapse;
margin: auto;
margin-top: 15%;
padding: 5px;
}

#btnLogin, #btnExit
{
	width: 70px;
	height: 30px;
	color: Red;
	border: none;
	background-color: orange;
	text-decoration: none;
	
}
#btnLogin:HOVER {
	background-color: cyan;
}
#btnExit:HOVER {
	background-color: cyan;
}

</style>

<h1 align="center" style="font-family: sans-serif;font-style: oblique;font-size-adjust: none;color: navy;">Welcome to Cybage Book Review System</h1>



<form method="post" action="ResultPage.jsp" style="richness: " >

<table style="width:25%">
<tr>
 <td>UserName :  </td> <td><input type="text" name="name"></td><br>
 </tr>
 
 <tr>
 <td>Password : </td> <td><input type="password" name="pass"></td><br>
 </tr>
 
 <tr>
 <td>
 
 </td>
 
 
 
 <td>
 <input id="btnLogin" type="submit" value="Login">
 <input id="btnExit" type="submit" value="Exit">
 </td>
 </tr>
 
 
 </table> 
</form>


</body>
</html>