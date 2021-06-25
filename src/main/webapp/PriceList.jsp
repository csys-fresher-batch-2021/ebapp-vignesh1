<%@page import="java.util.Set"%>
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
<title>PerUnitPrice List</title>
</head>
<body>
	<jsp:include page="header1.jsp"></jsp:include>
	<main class="container-fluid">
	
		<%
		Map<String, List<Unit>> map = BillManager.getList();
		for (String key : map.keySet()) {
			List<Unit> numberOfList = map.get(key);
		%>
		<h3><%=key%></h3>
		<table class="table table-bordered">
			<caption></caption>
			<thead class="thead-dark">
				<tr>
					<th scope="col">Units</th>
					<th scope="col">Per Unit Price</th>
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
		}
		%>
	</main>
</body>
</html>