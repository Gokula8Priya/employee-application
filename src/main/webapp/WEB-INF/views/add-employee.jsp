<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Page</title>
<style>
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

input[type=submit]:hover {
	background-color: #45a049;
}

.add {
	border: 5px;
	background-color: #f2f2f2;
	padding: 10px;
	display: inline-block;
	width: 50%;
	margin-left:250px;
}


</style>
</head>
<body>
	<header><jsp:include page="index.jsp"></jsp:include></header>

	<hr>
	<div class="main" >
		<div class="add" >
			<form action="employee" method="post">
				<label>Employee Name</label> <input type="text" name="name">
				<br>
				<br> <label>Mail Id</label> <input type="email" name="emailId">
				<br>
				<br> <label>Date Of Birth</label> <input type="date"
					name="dateOfBirth"> <br>
				<br> <label>Salary</label> <input type="text" name="salary">
				<br>
				<br> <label>Employee Status :</label> <label for="Active">Active</label><input
					type="radio" name="employeeStatus" value="Active" id="Active">
				<label for="Inactive">InActive</label><input type="radio"
					name="employeeStatus" value="Inactive" id="Inactive"> <br>
				<br> <input type="submit" value="Add">
			</form>
		</div>
	</div>
</body>
</html>