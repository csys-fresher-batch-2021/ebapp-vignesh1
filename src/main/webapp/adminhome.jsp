<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="in.vignesh.util.ConnectionUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Admin Profile</title>
<style>
tr {
  display: table-row;
  vertical-align: inherit;
  border-color: inherit;
}
</style>
</head>

<body>
<jsp:include page="header2.jsp"></jsp:include>

	<main class="container-fluid">
   <h2>Admin Profile</h2>
    
<%
Connection con = ConnectionUtil.getConnection();
Statement statement=con.createStatement();
String sql="SELECT * FROM E_USER WHERE ROLEID=1";
ResultSet rs=statement.executeQuery(sql);
while(rs.next())
{
	%>
	
	
	<table>
	<tr ><td>Name:</td><td><%=rs.getString(2) %></td></tr>
	<tr><td>Email:</td><td><%=rs.getString(3) %></td></tr>
	<tr><td>Contact:</td><td><%=rs.getString(4) %></td></tr>
	<tr><td>Address:</td><td><%=rs.getString(6) %></td></tr>
	</table> 
	

<%
}
%>


</main>

</body>
</html>