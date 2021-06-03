<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<link rel="stylesheet" href="assets/css/style3.css">

</head>
<body>
<div class="reg">
<jsp:include page="header.jsp"></jsp:include>

	<main class="container-fluid">
	
	<%
		String errorMessage = request.getParameter("errorMessage");
		if(errorMessage != null){
			out.println("<font color='red'>" + errorMessage + "</font>");
		}
	%>
	<%
		String existsMessage=request.getParameter("existsMessage");
		if(existsMessage != null){
			out.println("<font color='red'>" + existsMessage + "</font>");
		}
	%>
		<h2>Registration</h2>
		<div class="register">
		
	<form action="RegistrationAction" method="post">
	<label for="name"><strong>Name:</strong></label><br>
	<input type="text" name="name" placeholder="Enter your name" required autofocus><br>
	 
	<label for="mobileNumber"><strong>Mobile Number:</strong></label><br>
	<input type="number" name="mobileNumber" placeholder="Enter your mobileNo" required><br>
	
	<label for="ConsumerNumber"><strong>Consumer Number:</strong></label><br>
	<input type="number" name="ConsumerNumber" placeholder="Enter your consumerNo" required><br>
	
	<label for="customerId"><strong>CustomerId:</strong></label><br>
	<input type="text" name="customerId" placeholder="Enter your Customer Id" required><br>
	  
	<label for="password"><strong>Set Password:</strong></label><br>
	<input type="password" name="password" placeholder="Enter your password" required><br>
	
	<label for="retypepassword"><strong>Confirm password:</strong></label><br>
	<input type="password" name="confirmpassword" placeholder="Confirm your password" required><br>
	<br>
	<button type="submit" class="btn btn-success">Submit</button>
	<button  type="reset" class="btn btn-warning">Reset</button>
	</form>
	</div>
</main>
</div>
</body>
</html>