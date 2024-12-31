<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="nav.html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% 
	int a= Integer.parseInt(request.getParameter("num1"));
	int b= Integer.parseInt(request.getParameter("num2"));
	int c=a-b;
	out.println("subtraction of two numbers id :"+c);
	
	%>       
</body>
</html>