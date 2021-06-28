<%@page import="in.vignesh.util.ConnectionUtil"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>welcome page</title>
<style>
body {
	background-image: url("https://sowter.net/wp-content/uploads/2021/01/Ways-to-Save-Energy-this-Summer.jpg");
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