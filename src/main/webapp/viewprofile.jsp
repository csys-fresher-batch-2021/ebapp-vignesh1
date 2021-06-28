<%@page import="in.vignesh.util.ConnectionUtil"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>view profile</title>
<style>
body {
    background-image: url("https://img.freepik.com/free-vector/abstract-grey-background-with-dynamic-waves-technology-network_29865-1635.jpg?size=626&ext=jpg");
	background-repeat: no-repeat;
	background-size: cover;
}
td,tr{
background-color: #E5EFAC;
}


</style>

</head>
<body>
	<jsp:include page="header1.jsp"></jsp:include>
	<main class="container-fluid">

		<%
		String user = (String) session.getAttribute("user");
		Connection con = ConnectionUtil.getConnection();
		String sql = "SELECT * FROM E_USER WHERE CUSTOMERID=?";
		PreparedStatement statement = con.prepareStatement(sql);
	    statement.setString(1, user);
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
		%>
		<br>
		<h4 style="color: #1693EA">USER PROFILE</h4>
		<h5 style="color: #00b1b1; font-weight: bold; text-transform: uppercase;"><%=rs.getString(2)%></h5>
	    <a href="editprofileView.jsp?id=<%=rs.getInt(1)%>"> <span style="font-size: 12px; padding:5px; color: #DE514E;">Edit MyProfile</span></a>
		
		<table>
			<tr>
				<td>Name:</td>
				<td><%=rs.getString("NAME")%></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><%=rs.getString("USEREMAIL")%></td>
			</tr>
			<tr>
				<td>Contact:</td>
				<td><%=rs.getString("USERPHONE")%></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><%=rs.getString("USERADDRESS")%></td>
			</tr>
			
		</table>
			<%
		}
		%>
      
	</main>
</body>
</html>
		
	


