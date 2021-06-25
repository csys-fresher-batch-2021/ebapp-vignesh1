<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="in.vignesh.util.ConnectionUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="in.vignesh.model.UserBean"%>
<%@page import="in.vignesh.model.Unit"%>
<%@page import="in.vignesh.service.BillManager"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>payment history</title>
</head>
<body>
	<jsp:include page="header1.jsp"></jsp:include>
	<main class="container-fluid">
		<h2>payment history</h2>

	<table class="table table-bordered">
			<caption></caption>
			<thead class="thead-dark">
				<tr>
					<th scope="col">USERID</th>
					<th scope="col">NAME</th>
					<th scope="col">MONTH</th>
					<th scope="col">YEAR</th>
				     <th scope="col">AMOUNT PAID</th> 
				    <th scope="col">DATE TIME</th>
				</tr>
			</thead>
<%
String user=(String)session.getAttribute("user");
UserBean bean=new UserBean();
bean.getUserid();
System.out.print(bean.getUserid());
String sql="SELECT * FROM E_CALBILL where CUSTOMERID=? AND STATUS=?";
Connection con = ConnectionUtil.getConnection();
PreparedStatement statement=con.prepareStatement(sql);
statement.setString(1, user);
statement.setString(2, "PAID");
ResultSet resultSet=statement.executeQuery();
while(resultSet.next())
{
	%>


	<tr>
	<td><%=resultSet.getInt("USERID") %></td>
	<td><%=resultSet.getString("NAME") %></td>
	<td><%=resultSet.getString("MONTH") %></td>
	<td><%=resultSet.getString("YEAR") %></td>	
	<td><%=resultSet.getDouble("AMTPAID") %></td>
	<td><%=resultSet.getTimestamp("MODIFIED") %></td>







	<%
}
%>


	</table>
</main>	
</body>
</html> 