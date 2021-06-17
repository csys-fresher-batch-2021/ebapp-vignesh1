<%@page import="in.vignesh.util.ConnectionUtil"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="in.vignesh.dao.CalcDAO"%>
<%@page import="in.vignesh.model.CalcBill"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>AdminLogin</title>
<style>
body {
		text-align: center;
	
}
</style>

</head>

<body>

<jsp:include page="header1.jsp"></jsp:include>
	<main class="container-fluid">
<%
String id=request.getParameter("id");
CalcBill bean=CalcDAO.getRecordById(Integer.parseInt(id));
int id2=bean.getCid();
System.out.print("ID2 IS "+id2);
%>

 <%
int result=0;
    Connection con = ConnectionUtil.getConnection();
    Statement statement=con.createStatement();
    ResultSet resultSet=statement.executeQuery("SELECT * FROM E_CALBILL where id='"+id2+"'");
    if(resultSet.next())
    {
    	result=resultSet.getInt(6);
    	System.out.print(result);
    }
    
    
    %> 
<form action="CalcBillCtrl" method="post">
<input  type="hidden" name="id" value="<%=bean.getCid()%>">
<h1>Pay Bill</h1>
<table>
<tr>
<td>
<label>Card Number</label><br>

<input type="text" name="card" placeholder="Valid Card Number" maxlength="12" required><br>
</td>
<td>
<label>Expiry  Date</label><br>

<input type="text" name="ex" placeholder="MM/YY" maxlength="5" required><br>
</td>
<td>
<label>CVV Code</label><br>

<input type="password" name="ex" placeholder="***" maxlength="3" required><br>
</td>
<td>
<label>Bill Amount</label><br>

<input type="text" name="bamt" ><br>
</td>
<td><br>
 <button type="submit" class="btn btn-primary" name="Action" value="Pay Bill">Pay Bill</button> 
</td>
</tr> 
</table>
</form>
</main>
</body>
</html>