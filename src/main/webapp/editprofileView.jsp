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


    <label for="formGroupExampleInput2">Name</label>
    <input type="text" class="form-control" id="formGroupExampleInput2" placeholder="Another input" name="uname" value="<%=bean.getName()%>">
  
  
    <label for="formGroupExampleInput2">Email</label>
    <input type="text" class="form-control" id="formGroupExampleInput2" placeholder="Another input" name="email" value="<%=bean.getUseremail()%>">
  
    <label for="formGroupExampleInput2">Phone</label>
    <input type="text" class="form-control" id="formGroupExampleInput2" placeholder="Another input" name="phone" value="<%=bean.getUserphone()%>">
  
  
    <label for="formGroupExampleInput2">Address</label>
    <input type="text" class="form-control" id="formGroupExampleInput2" placeholder="Another input" name="address" value="<%=bean.getUseraddress()%>">
  
  
  	<button type="submit" class="btn btn-success">Edit profile</button>
    
</form>
</main>
</body>
</html>