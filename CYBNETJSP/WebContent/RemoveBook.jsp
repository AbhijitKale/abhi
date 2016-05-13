<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Remove Book</title>
</head>
<body background="C:\Users\ajinkyaja\Desktop\wall3.jpg">

	<sql:setDataSource var="data" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/CybageNet" user="root" password="root"/>
	
	<sql:query var="result" dataSource="${data}">
		SELECT * from book;
	</sql:query>
	
	<table border="1" width="100%">
		<tr>
			<th>BOOKID</th>
			<th>NAME</th>
			<th>AUTHOR</th>			
		</tr>
		
		<c:forEach var="row" items="${result.rows}">
			<tr>
				<td><c:out value="${row.id}"/></td>
				<td><c:out value="${row.bookname}"/></td>
				<td><c:out value="${row.author}"/></td>
			</tr>
		</c:forEach>
	
	</table>
	
</body>
</html>