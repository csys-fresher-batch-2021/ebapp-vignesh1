
<%@page import="in.vignesh.dao.RegDAO"%>
<%@page import="in.vignesh.model.UserBean"%>
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
	<jsp:include page="header2.jsp"></jsp:include>
	<main class="container-fluid">

	<%
	String id=request.getParameter("id");
	UserBean bean=RegDAO.getRecordById(Integer.parseInt(id));
	%>
		
						<form action="EditSevlet" method="post">			
						<h3>Edit the user</h3>

								<span style="color: #00e676; font-style: inherit;"><%=(request.getAttribute("msg") == null) ? "" : request.getAttribute("msg")%></span>
						
						  	    <input type="hidden" name="id" value="<%=bean.getUserid()%>"><br> 
									
								<label for="address">Name</label> <input
									type="text" class="form-control" id="address"
									placeholder="Another input" name="uname"
									value="<%=bean.getName()%>">
									
								<label for="email">Email</label> <input
									type="text" class="form-control" id="email"
									placeholder="Another input" name="email"
									value="<%=bean.getUseremail()%>">
									
							
								<label for="phone">Phone</label> <input
									type="text" class="form-control" id="phone"
									placeholder="Another input" name="phone"
									value="<%=bean.getUserphone()%>">
									
						
								<label for="address">Address</label> <input
									type="text" class="form-control" id="address"
									placeholder="Another input" name="address"
									value="<%=bean.getUseraddress()%>"><br>
						
						  	<button type="submit" class="btn btn-success">Edit profile</button>
						
							
	</form>
	</main>
</body>
</html>