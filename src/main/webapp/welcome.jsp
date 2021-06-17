<%@page import="in.vignesh.util.ConnectionUtil"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>User List</title>
</head>
<body>
	<main class="container-fluid">
      	<jsp:include page="loginheader.jsp"></jsp:include>
      
			<br><br><br><br>
				<h1 class="display-4">Welcome To E-Bill</h1>
				<p>Login to Pay your Bills</p>
				<p class="lead">
					<a class="btn btn-primary btn-lg" href="login.jsp" role="button"><span
						class="fa fa-sign-in"></span> Login</a>
				</p>
	</main>
</body>
</html>