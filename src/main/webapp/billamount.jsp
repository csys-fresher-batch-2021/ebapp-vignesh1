<%@page import="java.sql.PreparedStatement"%>
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
<title>bill amount</title>
</head>
<body>
<jsp:include page="header2.jsp"></jsp:include>

	<main class="container-fluid">
	
<form class="example" action="" style="margin:auto;max-width:300px; float:inherit;" >

<strong><label style="color: red;"> User Id</label></strong>
  <input type="search" class="form-control rounded" placeholder="Search By Id" name="userid" >
</form>
<br>

	<% 
	String id=request.getParameter("userid");
String sql=null;
PreparedStatement statement=null;
if(id!=null )
{
	Connection con = ConnectionUtil.getConnection();
	sql="SELECT * FROM E_CALBILL WHERE STATUS= 'Not Paid' AND USERID='"+id+"'";
    statement=con.prepareStatement(sql);
    }


else
{
	Connection con = ConnectionUtil.getConnection();
	sql="SELECT USERID,NAME,ZONE,UNIT,TAMT FROM E_CALBILL WHERE STATUS= 'Not Paid'  ORDER BY ID DESC ";
    statement=con.prepareStatement(sql);
}
     ResultSet resultSet=statement.executeQuery();
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
	<td><%=resultSet.getInt("USERID") %></td>
	
	<td><%=resultSet.getString("NAME") %></td>
	<td><%=resultSet.getString("ZONE") %></td>	
		<td><%=resultSet.getDouble("UNIT") %></td>
	
	<td><%=resultSet.getDouble("TAMT") %></td>
	
     </tr>
                <%
				}
				%>
</tbody>
		</table>


	</main>
</body>
</html>