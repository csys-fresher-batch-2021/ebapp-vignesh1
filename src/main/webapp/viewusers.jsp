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

<form >
<br>
<label>Search</label>
  <input type="text" name="userId">
</form>
<br>

	<table class="table table-bordered">
			<caption></caption>
			<thead class="thead-dark">
		
	<tr>
	<th>User Id</th>
	<th>Name</th>
	<th>Email</th>
	<th>Phone no</th>
	<th>Consumer no</th>
	<th>Address</th>
	<th>Action</th></tr>
	<tr>
	<%
Connection con = ConnectionUtil.getConnection();
Statement statement=con.createStatement();
String id=request.getParameter("userId");
String sql=null;
if(id!=null)
{
	sql="SELECT * FROM E_USER WHERE USERID='"+id+"'";
}
else
{
	sql="SELECT * from E_USER WHERE ROLEID=2";
}
ResultSet rs=statement.executeQuery(sql);
while(rs.next())
{
	%>
	<td><%=rs.getInt(1) %></td>
	<td><%=rs.getString(2) %></td>
	<td><%=rs.getString(3) %></td>
	<td><%=rs.getString(4) %></td>
	<td><%=rs.getString(5) %></td>
	<td><%=rs.getString(6) %></td>
	<td><a  href="edituser.jsp?id=<%=rs.getInt(1)%>" class="btn btn-success" >Edit</a>
	<a  href="deleteuser.jsp?id=<%=rs.getInt(1)%>" class="btn btn-danger">Delete</a></td>
	</tr>
	
<%}
%>
</table>
</main>
</body>
</html>