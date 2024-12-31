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
 int s= (int)session.getAttribute("sum");
int square = s*s;
out.println("square is:"+square);
session.setAttribute("square", square);

%>
<form action="divide.jsp">
		<button>divide</button>
	</form>
</body>
</html>