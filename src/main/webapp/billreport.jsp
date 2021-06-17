<%@page import="in.vignesh.validator.Validation"%>
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


<form class="example" action="billreport.jsp" style="margin:auto;max-width:300px; float:inherit;" >

<strong><label style="color: red;"> User Id</label></strong><br>
  <input type="search" placeholder="Search By Id" name="userid" required>
    <button type="submit">search</button>
  
</form>
<br>
<form class="example" action="" style="margin:auto;max-width:300px; float:inherit;" >

 
 <strong ><label style="color: red;"> Date</label></strong><br>
  <input type="date"  placeholder="Search.." name="dor"  id="myInput">  
  <button type="submit">search</button>
  <br>
  <br>
</form>

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
Statement statement=con.createStatement();
String sql=null;
if(id!=null )
{
	sql="SELECT * FROM E_CALBILL WHERE STATUS= 'PAID' AND USERID='"+id+"'";
}

else
{
	sql="SELECT * FROM E_CALBILL WHERE STATUS= 'PAID' ORDER BY ID DESC ";
}
ResultSet resultSet=statement.executeQuery(sql);
while(resultSet.next())
{
	%>
	
	<tbody >
	<tr>
	<td><%=resultSet.getInt(2) %></td>
	
	<td><%=resultSet.getString(8) %></td>
	<td><%=resultSet.getDouble(4) %></td>
	
	
	<td><%=resultSet.getInt(7) %></td>
	

	<%-- <td><%=resultSet.getString(5) %></td> --%>
	
	<td><%=resultSet.getInt(12) %></td>
	<td><%=resultSet.getTimestamp(14)%></td>
	
	<%
}
%>

</tr>
</tbody>
	</table>
	</main>
</body>
</html>