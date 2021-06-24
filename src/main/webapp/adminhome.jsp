<%@page import="java.sql.PreparedStatement"%>
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
body {
	background-image: url("https://www.propmodo.com/wp-content/uploads/2020/07/remote-office-work.jpg");
	background-repeat: no-repeat;
	background-size: cover;
}
td,tr{
background-color: #f2f2f2;
}
h3{
color: #D5F605;

}
}
</style>
</head>

<body>
<jsp:include page="header2.jsp"></jsp:include>

	<main class="container-fluid">
   <h3>ADMIN PROFILE</h3>
    
<%
Connection con = ConnectionUtil.getConnection();
String sql="SELECT * FROM E_USER WHERE ROLEID=1";
PreparedStatement statement=con.prepareStatement(sql);
ResultSet rs=statement.executeQuery();
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