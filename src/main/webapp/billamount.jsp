<%@page import="java.sql.ResultSet"%>
<%@page import="in.vignesh.util.ConnectionUtil"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page import="in.vignesh.model.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
<jsp:include page="header2.jsp"></jsp:include>

	<main class="container-fluid">
	
<form class="example" action="" style="margin:auto;max-width:300px; float:inherit;" >

<strong><label style="color: red;"> User Id</label></strong>
  <input type="search" class="form-control rounded" placeholder="Search By Id" name="userid" >
</form>
<br>
<form class="example" action="" style="margin:auto;max-width:300px; float:inherit;" >


<strong><label style="color: red;">Zone Name</label></strong>
  <input type="search" class="form-control rounded" placeholder="Search By Zone Name" name="zone" aria-label="Search"
    aria-describedby="search-addon" />
  <br>
</form>
	<% 
	int index=1;
	String id=request.getParameter("userid");
	String zone=request.getParameter("zone");
	Connection con = ConnectionUtil.getConnection();
Statement statement=con.createStatement();
String sql=null;
if(id!=null )
{
	sql="SELECT * FROM E_CALBILL WHERE STATUS= 'NOT PAID' AND USERID='"+id+"'";
}
else if(zone!=null)
{
	sql="SELECT * FROM E_CALBILL WHERE STATUS= 'NOT PAID' AND ZONE='"+zone+"'";
}
else
{
	sql="SELECT * FROM E_CALBILL WHERE STATUS= 'NOT PAID'  ORDER BY ID DESC ";
}
ResultSet resultSet=statement.executeQuery(sql);
%>


	
	
	<table class="table table-bordered">
			<caption></caption>
			<thead class="thead-dark">
				<tr>
					<th scope="col">USER ID</th>
				   <th scope="col">NAME</th>
				   <th scope="col">ZONE</th>
				 <th scope="col">CONSUMED UNIT</th>
				<th scope="col">BILL AMOUNT</th>
				</tr>
			</thead>
		<tbody>
		<%
		while(resultSet.next())
		{
		%>
	<tr>
	<td><%=resultSet.getInt(2) %></td>
	
	<td><%=resultSet.getString(8) %></td>
	<td><%=resultSet.getString(3) %></td>	
		<td><%=resultSet.getDouble(4) %></td>
	
	<td><%=resultSet.getDouble(6) %></td>
	
     </tr>
                <%
				}
				%>
</tbody>
		</table>


	</main>
</body>
</html>