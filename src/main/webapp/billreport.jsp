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
<title>bill report</title>
</head>
<body>

		<jsp:include page="header2.jsp"></jsp:include>
		<main class="container-fluid">


<form >

<strong><label style="color: red;"> User Id</label></strong><br>
  <input type="search" placeholder="Search By Id" name="userid" required>
    <button type="submit">search</button>

</form>
<br>

<table class="table table-bordered">
			<caption></caption>
			<thead class="thead-dark">
				<tr>
					<th scope="col">USERID</th>
					<th scope="col">NAME</th>
					<th scope="col">UNIT</th>
					<th scope="col">Bill Amount</th>
					<th scope="col">Amount Paid</th>
					<th scope="col">Date Time</th>

				</tr>
			</thead>
	<% 
	String id=request.getParameter("userid");
	
Connection con = ConnectionUtil.getConnection();
String sql=null;
PreparedStatement statement=null;
if(id!=null )
{
	con = ConnectionUtil.getConnection();
    sql=	"SELECT * FROM E_CALBILL WHERE STATUS= 'PAID' AND USERID=?";
    statement=con.prepareStatement(sql);
}
else
{
	 con = ConnectionUtil.getConnection();
	sql="SELECT * FROM E_CALBILL WHERE STATUS= 'PAID'  ORDER BY ID DESC ";
    statement=con.prepareStatement(sql);
}
ResultSet resultSet=statement.executeQuery();
while(resultSet.next())
{
	%>

	<tbody >
	<tr>
	<td><%=resultSet.getInt("USERID") %></td>
	<td><%=resultSet.getString("NAME") %></td>

	<td><%=resultSet.getDouble("UNIT") %></td>


	<td><%=resultSet.getDouble("TAMT") %></td>
	<td><%=resultSet.getDouble("AMTPAID") %></td>
		<td><%=resultSet.getTimestamp("DATEANDTIME") %></td>
	


	<%
}
%>

</tr>
</tbody>
	</table>
	</main>
</body>
</html> 