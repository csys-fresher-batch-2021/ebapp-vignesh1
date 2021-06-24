<%@page import="java.sql.PreparedStatement"%>
<%@page import="in.vignesh.util.ConnectionUtil"%>
<%@page import="in.vignesh.model.UserBean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>ViewBill</title>
</head>
<body>
	<jsp:include page="header1.jsp"></jsp:include>
	<main class="container-fluid">
<h3>ViewBill</h3>
<br>
<%
String user=(String)session.getAttribute("user");
UserBean bean=new UserBean();
Connection connection = null;
PreparedStatement pst = null;
System.out.println(user);
connection  = ConnectionUtil.getConnection();
String sql="SELECT ID,USERID,NAME,UNIT,YEAR,MONTH,TAMT,DUES,STATUS FROM E_CALBILL  WHERE CUSTOMERID='"+user+"'";
pst=connection.prepareStatement(sql);
ResultSet resultSet=pst.executeQuery();
%>


<table class="table table-bordered">
			<caption></caption>
			<thead class="thead-dark">
				<tr>
				    <th scope="col">ID</th>
					<th scope="col">USERID</th>
					<th scope="col">NAME</th>
					<th scope="col">UNIT</th>
					<th scope="col">YEAR</th>
					<th scope="col">MONTH</th>
				    <th scope="col">Bill</th>
					<th scope="col">Due</th>
					<th scope="col">STATUS</th>
					<th scope="col">ACTION</th>
				</tr>
			</thead>

<% 
while(resultSet.next())
{
	
	%>


		<tbody>
	<tr>
	<td><%=resultSet.getInt("ID") %></td>
	<td><%=resultSet.getInt("USERID") %></td>
	<td><%=resultSet.getString("NAME") %></td>
	<td><%=resultSet.getDouble("UNIT") %></td>
	<td><%=resultSet.getString("YEAR") %></td>
	<td><%=resultSet.getString("MONTH") %></td>
	<td><%=resultSet.getDouble("TAMT") %></td>
	<td><%=resultSet.getDouble("DUES") %></td>
	<td><%=resultSet.getString("STATUS") %></td>
	<%String a=resultSet.getString("STATUS");
	System.out.print("value of a is "+a);
	if(a.equals("PAID"))
	{%>
	<td><a  onclick="return false" class="btn btn-warning" >Pay</a></td>
	
	<%}
	else{%>
	<td><a class="btn btn-primary" href="paybill.jsp?id=<%=resultSet.getInt("ID")%>" onclick="return true">Pay</a></td>
	</tr>
	<%}%>

	
	<%
}
%>
</tbody>

	</table>

	</main>

</body>
</html> 
