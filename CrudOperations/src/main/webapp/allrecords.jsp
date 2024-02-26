<%@page import="crud.backend.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1" style="width: 100%">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Age</th>
			<th>Email ID</th>
			<th>Password</th>
			<th>
				<a href="newRegister.jsp">
				<button>Add User</button>
				</a>
			</th>
		</tr>

		<%
		List<User> userList = (List<User>) request.getAttribute("userList");
		%>
		<%
		for (User user : userList) {
		%>
		<tr>
			<td><%=user.getId()%></td>
			<td><%=user.getName()%></td>
			<td><%=user.getAge()%></td>
			<td><%=user.getEmail()%></td>
			<td><%=user.getPassword()%></td>
			<td>
				<form action="UpdateUser" method="post">
					<!-- Include a hidden input field to send the user ID to the servlet -->
					<input type="hidden" name="id" value="<%=user.getId()%>">
					<input type="submit" value="Update">
				</form>
			</td> 
			<td>
				<form action="deleteUser" method="post">
					<!-- Include a hidden input field to send the user ID to the servlet -->
					<input type="hidden" name="id" value="<%=user.getId()%>">
					<input type="submit" value="Delete">
				</form>
			</td>
		</tr>
		<%
		}
		%>
		
	</table>

</body>
</html>