<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View All Employees</title>
<style>
table {
	border-collapse: collapse;
	width: 100;
}

th, td {
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #D6EEEE;
}
</style>

</head>
<body>
<div align="center">
	<jsp:include page="index.jsp"></jsp:include>
	</div>
	<h1 style="text-align: center;">List of Employees</h1>

	<table border="1" align="center">
		<tr>
			<th>Employee Id</th>
			<th>Employee Name</th>
			<th>Email-id</th>
			<th>Date-Of-Birth</th>
			<th>Age</th>
			<th>Salary</th>
			<th>Employee Status</th>
			<th colspan="2">Action</th>
		</tr>


		<c:forEach var="allEmployee" items="${ employee }">
			<tr>
				<td>${ allEmployee.employeeId}</td>
				<td>${ allEmployee.name }</td>
				<td>${ allEmployee.emailId }</td>
				<td>${ allEmployee.dateOfBirth }</td>
				<td>${ allEmployee.age }</td>
				<td>${ allEmployee.salary }</td>
				<td>${ allEmployee.employeeStatus }</td>
				<td><a href='./edit/${ allEmployee.employeeId }'>EDIT</a></td>
				<td><a href='./delete/${ allEmployee.employeeId }'>DELETE</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>