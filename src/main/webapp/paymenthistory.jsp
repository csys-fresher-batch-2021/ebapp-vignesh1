<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="in.vignesh.util.ConnectionUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="in.vignesh.model.UserBean"%>
<%@page import="in.vignesh.model.UnitPrice"%>
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
					<th scope="col">Name</th>
				     <th scope="col">Amount Paid</th> 
				    <th scope="col">Date Time</th>
				</tr>
			</thead>
	<%int index=1; %>
<%
String user=(String)session.getAttribute("user");
UserBean bean=new UserBean();
bean.getUserid();
System.out.print(bean.getUserid());
Connection con = ConnectionUtil.getConnection();
Statement statement=con.createStatement();
ResultSet resultSet=statement.executeQuery("SELECT * FROM E_CALBILL where CUSTOMERID='"+user+"' AND STATUS='PAID'");
while(resultSet.next())
{
	%>


	<tr>
	<td><%=index++ %></td>
	<td><%=resultSet.getInt(2) %></td>
	<td><%=resultSet.getString(8) %></td>
	<td><%=resultSet.getInt(13) %></td>







	<td><%=resultSet.getTimestamp(15) %></td>







	<%
}
%>


	</table>
</main>	
</body>
</html> 