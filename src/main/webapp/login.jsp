<%@page import="in.vignesh.dao.RegDAO"%>
<%@page import="in.vignesh.model.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="assets/css/style1.css">

</head>
<body>

<jsp:include page="loginheader.jsp"></jsp:include>
	<main class="container-fluid">
	   <h3>Login</h3>
	   
			
	    			<div class="login">
	    
					<span style="color: red; font-style: inherit;"><%=(request.getAttribute("msg") == null) ? "" : request.getAttribute("msg")%></span>
					<span style="color: red"><%=(request.getAttribute("ermsg") == null) ? "" : request.getAttribute("ermsg")%></span>
					
						<form action="LoginCtrl" method="post">
					
						 
		       <label for="customerId"><strong>Customer Id:</strong></label><br>
		       <input type="text" name="customerid" placeholder="Enter Customer Id" autofocus required><br>
		       <label for="password" ><strong>Password:</strong></label><br>
	       	  <input type="password" name="password" placeholder="Enter your password" required><br>
		       <br>
		       <button type="submit" class="btn btn-success">Login</button>
							         
					
							</form>
							</div>
	</main>	
</body>

</html>