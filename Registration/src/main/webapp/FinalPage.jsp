<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List<String> students = (List)request.getAttribute("studentList");
	%>
	<table>
		<tr>
			<th>Date</th>
			<th>First Name</th>
			<th>Password</th>
		</tr>
<% 
	for(int i=0 ; i< students.size();i++) {
%>
	<tr>
			<td>Date</td>
			<td style=color:blue;><%=students.get(i)%></td>
			<td>Password</td>
		</tr>
<%
	}
%>		

	</table>

</body>
</html>