<%@page import="in.vignesh.util.ConnectionUtil"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>welcome page</title>
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/fontawesome.min.css">
<style>
body {
	background-image: url("D:/EB/ebapp-vignesh1/src/main/webapp/image/save-energy.jpg");
	background-repeat: no-repeat;
	background-size: cover;
}
h5 {
	color: #51EC09;
}
</style>
</head>
<body>
	<main class="container-fluid">
      	<jsp:include page="loginheader.jsp"></jsp:include>
      
			<br><br><br><br>
				
				<h5 class="display-4">Welcome To EB-Bill</h5>
		
				<p style="color:#F5F900;">Login to Pay your Bills</p>
				<p class="lead">
					<a class="btn btn-primary btn-lg" href="login.jsp" role="button">Login</a>
				</p>
	</main>
</body>
</html>