<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>User Details</h2>
	<h2>Id : ${Id} </h2> <br /> <br />
	<form action="UpdateOk" method="post">
		<input type="hidden" name="id" value="${Id}">
		<input type="text" name="new_name" value="${Name}" /> <br /> <br />
		<input type="number" name="new_age" value="${Age}" /> <br /> <br />
		<input type="text" name="new_email" value="${Email}" /> <br /> <br />
		<input type="text" name="new_pass" value="${Password}" /> <br /> <br />	
		<button>Update</button>	<br /> <br />
	</form>
</body>
</html>