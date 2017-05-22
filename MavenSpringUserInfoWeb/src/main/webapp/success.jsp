<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
		String Fname = (String)request.getAttribute("Fname");
		String Lname = (String)request.getAttribute("Lname");
		String email = (String)request.getAttribute("email");
		String userName = (String)request.getAttribute("userName");
	%>
Welcome <%= userName %></br>
<h1>Your Details</h1>
First Name: <%= Fname %></br>
Last Name: <%= Lname %></br>
Email: <%= email %></br>
</br>
</br>
Please Login Here <a href='index.jsp'>Go to Login</a>
<a href='index.jsp'>Logout</a>
</body>
</html>