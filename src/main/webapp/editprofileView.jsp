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
<title>Edit List</title>

</head>
<body>
	<jsp:include page="header1.jsp"></jsp:include>
	<main class="container-fluid">
					<h3>Edit profile</h3>
<%
String id=request.getParameter("id");
UserBean bean=RegDAO.getRecordById(Integer.parseInt(id));
%>


<form action="EditMyServlet" method="post">
<span style="color: #00e676; font-style: inherit;"><%=(request.getAttribute("msg") == null) ? "" : request.getAttribute("msg")%></span>

<input  type="hidden" name="id" value="<%=bean.getUserid()%>">


    <label for="uname">Name</label>
    <input type="text" class="form-control" id="uname" placeholder="Another input" name="uname" value="<%=bean.getName()%>">
  
  
    <label for="email">Email</label>
    <input type="text" class="form-control" id="email" placeholder="Another input" name="email" value="<%=bean.getUseremail()%>">
  
    <label for="email">Phone</label>
    <input type="text" class="form-control" id="email" placeholder="Another input" name="phone" value="<%=bean.getUserphone()%>">
  
  
    <label for="address">Address</label>
    <input type="text" class="form-control" id="address" placeholder="Another input" name="address" value="<%=bean.getUseraddress()%>">
    <br>
  
  	<button type="submit" class="btn btn-success">Edit profile</button>
    
</form>
</main>
</body>
</html>