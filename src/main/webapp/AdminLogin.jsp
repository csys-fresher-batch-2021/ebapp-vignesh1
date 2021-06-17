<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>AdminLogin</title>
<link rel="stylesheet" href="assets/css/style2.css">

</head>

<body>
<div class="admin">

<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	
	<%
		String errorMessage = request.getParameter("errorMessage");
		if(errorMessage != null){
			out.println("<font color='red'>" + errorMessage + "</font>");
		}
	%>
	<h2>Login</h2>
	<div class="Adminlogin">
	
	<form  action="AdminLoginAction" method="post">
		<label for="customerId"><strong>Customer Id:</strong></label><br>
		<input type="text" name="customerId" placeholder="Enter Customer Id" autofocus required><br>
		<label for="password" ><strong>Password:</strong></label><br>
		<input type="password" name="password" placeholder="Enter your password" required><br>
		<br>
		<button type="submit" class="btn btn-success">Submit</button>
		<button  type="reset" class="btn btn-info">Reset</button>
	</form>
	</div>
</main>
</div>
</body>


</html>