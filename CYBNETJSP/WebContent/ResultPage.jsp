<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file = "LoginPage.jsp" %>

<sql:setDataSource var="data" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/CybageNet" user="root" password="root"/>
	
	<sql:query var="result" dataSource="${data}">
		SELECT * from login;
	</sql:query>

<%
request.setAttribute("uname", request.getParameter("name"));
request.setAttribute("upass", request.getParameter("pass"));



%>




<c:forEach var="row" items="${result.rows}">

<c:if test="${row.name =='Admin' && row.password==upass}">
<% 
	request.getSession().setAttribute("key", "Admin");
%>
<%-- <jsp:forward page="AdminPage.jsp"/> --%>

<c:redirect url="AdminPage.jsp"></c:redirect>
</c:if>

<c:if test="${row.name ==uname && row.password==upass}">
<%
	request.getSession().setAttribute("key", request.getParameter("name"));
%>
<jsp:forward page="UserPage.jsp"/>
</c:if>

</c:forEach>

<h4 align="center"; style="color: red"><c:out value="Sorry Wrong user name or password "></c:out></h6>  


</body>
</html>