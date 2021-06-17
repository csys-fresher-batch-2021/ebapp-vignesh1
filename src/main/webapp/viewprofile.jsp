<%@page import="in.vignesh.util.ConnectionUtil"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>PerUnitPrice List</title>

</head>
<body>
	<jsp:include page="header1.jsp"></jsp:include>
	<main class="container-fluid">

<%
String user=(String)session.getAttribute("user");
Connection con = ConnectionUtil.getConnection();
Statement statement=con.createStatement();
String sql="SELECT * FROM E_USER WHERE CUSTOMERID='"+user+"'";
ResultSet rs=statement.executeQuery(sql);
while(rs.next())
{
	%>

							<h4>User Profile </h4>
							<a href="editprofileView.jsp?id=<%=rs.getInt(1)%>">
							<span class="fa fa-edit" style="font-size: 20px; color: gray;">Edit</span></a>
	
								<h4 style="color: #00b1b1;"><%=rs.getString(2) %>
								</h4>
								 <p>
										User ID:
										<%=rs.getInt(1) %></p>
										
										
	<table >
	<tr><td>Name:</td><td><%=rs.getString(2) %></td></tr>
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