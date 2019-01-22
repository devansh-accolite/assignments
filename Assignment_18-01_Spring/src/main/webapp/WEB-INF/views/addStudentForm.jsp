<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>
</head>
<body>
	<h2>Add Student</h2>
	<form action="addStudent" method="post" modelAttribute="student">
		<input type="number" name="student_id" placeholder="Student ID" /><br /><br />
		<input type="text" name="student_name" placeholder="Student Name" /><br /><br />
		<input type="submit" value="Submit" />
	</form>
</body>
</html>