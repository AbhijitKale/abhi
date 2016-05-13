<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Added</title>
</head>
<body>

<%@ include file = "InsertBook.jsp" %>

<c:if test="${not empty param.bookid and not empty param.bookname and not empty param.bookauthor}">

	<sql:update var="result" dataSource="${data}">
			insert into book values(?,?,?)
			<sql:param value="${param.bookid}"></sql:param>
			<sql:param value="${param.bookname}"></sql:param>
			<sql:param value="${param.bookauthor}"></sql:param> 
	</sql:update>
</c:if>

	<c:if test="${result>=1}">
		<h3 align="center"><font size="5" color="green">Book Added Successfully</font></h3>
	</c:if>
	
	
</body>
</html>