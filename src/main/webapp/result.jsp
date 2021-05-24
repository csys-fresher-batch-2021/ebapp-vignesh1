<%@page import="in.vignesh.service.BillManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>calculation</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">

		<%
		Double totalBillAmount = Double.parseDouble(request.getParameter("totalBillAmount"));
		%>

		Your Total Bill Amount Rs.<%=totalBillAmount%>


	</main>
</body>
</html>