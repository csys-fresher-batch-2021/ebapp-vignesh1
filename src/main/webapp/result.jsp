<%@page import="in.vignesh.model.Unit"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="in.vignesh.service.BillManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>billAmount</title>
<style>
.rs {
	text-align: center;
}
</style>

</head>
<body>
	<jsp:include page="header1.jsp"></jsp:include>
	<main class="container-fluid">
		<br>
		<br>
		<br>
		<br>

		<div class="rs">

			<%
			String type= request.getParameter("type");
			Double totalBillAmount = Double.parseDouble(request.getParameter("totalBillAmount"));
			%>
			<table class="table table-bordered">
				<caption></caption>
				<thead class="table-primary">
					<tr>

						<th scope="col">Your Total Bill Amount for <%=type %></th>


					</tr>
				</thead>
				<tbody>
					<tr>



						<td>Rs.<%=totalBillAmount%></td>


					</tr>

				</tbody>
			</table>
		</div>
		<strong>NOTE:-</strong>

		<%
		Map<String, List<Unit>> map = BillManager.getList();
		//for (String key : map.keySet()) {
			List<Unit> numberOfList = map.get(type);
		%>
		<h5><%=type%></h5>
		<table border=1>
			<caption></caption>
			<thead class="thead-dark">
				<tr>
					<th scope="col">Unit Range</th>
					<th scope="col">Fixed PerUnitPrice</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (Unit up : numberOfList) {
				%>
				<tr>
					<td><%=up.getMinUnit()%> - <%=up.getMaxUnit()%></td>
					<td>Rs. <%=up.getPrice()%>
					</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		
		<%
		//}
		%>

		

	</main>
</body>
</html>