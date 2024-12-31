<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
    <%@ include file="nav.html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
 int square= (int)session.getAttribute("square");
int divide = square/0;
out.println("quotient is:"+ divide);

%>
	
</body>
</html>