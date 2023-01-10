<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Page</title>
<style >
.editContainer{
border: 5px;
	background-color: #f2f2f2;
	padding: 10px;
	display: inline-block;
	width: 50%;
	margin-left:250px;
}

input[type=submit]:hover {
	background-color: #45a049;
}
input[type=text] {
	width: 50%;
	padding: 12px 20px 12px 40px;
	margin: 8px 0;
	display: inline-block;
	text-align: center;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=submit] {
	width: 100%;
	background-color: #4CAF50;
	color: white;
	display: inline-block;
	padding: 14px 20px 12px 40px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}
</style>

</head>
<body>
	<div class="editContainer" align="center">
		<form action="/employee-app/update-employee" method="POST">
			<label>Employee Number</label><br>
			<input type="text" name="employeeId" value="${ employee.employeeId }" readonly="readonly">
			<br><br>
			
			<label>Employee Name</label><br>
			<input type="text" name="name" value="${ employee.name }">
			<br><br>
			
			<label>Mail Id</label><br>
			<input type="email" name="emailId" value="${ employee.emailId }">
			<br><br>
			
			<label>Date Of Birth</label><br>
			<input type="date" name="dateOfBirth" value="${ employee.dateOfBirth }">
			<br><br>
			
			<label>Employee Status</label><br>
			<c:choose>
				<c:when test="${employee.employeeStatus.equals(\"Active\")}">
					<label for="Active">Active</label><input type="radio" name="employeeStatus" value="Active" id ="Active" checked="checked">
					<label for="Inactive">InActive</label><input type="radio" name="employeeStatus" value="Inactive" id="Inactive">
				</c:when>
			</c:choose>
			<br><br>	
			<input type="submit" value="UPDATE Employee">
	</form>
	</div>
</body>
</body>
</html>