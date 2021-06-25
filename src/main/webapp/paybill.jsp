<%@page import="java.sql.PreparedStatement"%>
<%@page import="in.vignesh.dao.CalcDAO"%>
<%@page import="in.vignesh.model.CalcBill"%>
<%@page import="in.vignesh.util.ConnectionUtil"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>bill payment</title>
<style>
.bill {
		width: 600px;
	overflow: hidden;
	margin: auto;
	margin: 20 0 0 450px;
	padding: 70px;
	background-image: url("https://wallpaperaccess.com/full/4597119.jpg");
	background-size: cover;
	background-repeat: no-repeat;
	border-radius: 25px;
}
h2
{
	text-align: center;

}
body
{
	background-image: url("https://www.pymnts.com/wp-content/uploads/2016/03/Global-Payments.jpg");

}
</style>
</head>
<body>
	<jsp:include page="header1.jsp"></jsp:include>
	<main class="container-fluid">
	    <br><br>
		
<%
String id=request.getParameter("id");
CalcBill bean=CalcDAO.getRecordById(Integer.parseInt(id));
int id2=bean.getCid();
System.out.print("ID2 IS "+id2);
%>
 <%
double result=0;
     Connection con = ConnectionUtil.getConnection();
     String sql="SELECT*FROM E_CALBILL where id=?";
     PreparedStatement statement=con.prepareStatement(sql);
     statement.setInt(1, id2);
    ResultSet resultSet=statement.executeQuery();
    while(resultSet.next())
    {
    	result=resultSet.getDouble("TAMT");
    	System.out.println(result);
    }
    %> 
    <div class="bill">
<form action="CalcBillCtrl" method="post">

<input  type="hidden" name="id" value="<%=bean.getCid()%>">
<h2>Bill Payment</h2>
<h4>card details:</h4>
<span style="color: #00e676; font-style: inherit;"><%=(request.getAttribute("msg") == null) ? "" : request.getAttribute("msg")%></span>
<table >
<tr><td><label>Card Number:</label></td>
<td><input type="text" name="card" placeholder="Valid Card Number" maxlength="12" required></td></tr>
<tr><td><label>Expiry Date:</label></td>
<td><input type="text" name="ex" placeholder="MM/YY" maxlength="5" required></td></tr>
<tr><td><label>CVV Code:</label></td>
<td><input type="password" name="ex" placeholder="***" maxlength="3" required></td></tr>
<tr><td><label>Bill Amount:</label></td>
<td><input type="number" name="bamt" value="<%=result%>" ></td></tr>
<tr>
							
</table>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<button type="submit" class="btn btn-primary" action="/ebapp-vignesh/src/servler/CalcBillCtrl" name="Action" value="Pay Bill">Pay Bill</button>

</form>
</div>
</main>

</body>