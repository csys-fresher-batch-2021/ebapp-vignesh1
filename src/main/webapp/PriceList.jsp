<%@page import="in.vignesh.model.UnitPrice"%>
<%@page import="in.vignesh.service.BillManager"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>

<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html  lang="en">
<head>
<meta charset="ISO-8859-1">
<title>PerUnitPrice List</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h2>PerUnitPrice List</h2>

		<%
		Map<String, List<UnitPrice>> map = BillManager.getList();
		for (String key : map.keySet()) {
			List<UnitPrice> numberOfList = map.get(key);
		%>
		<h3><%=key%></h3>
		<table class="table table-bordered">
		
			<thead>
				<tr>

					<th scope="col">Units</th>
					<th scope="col">Per Unit Price</th>
				</tr>
			</thead>
			<tbody>
				<%
				int i = 0;
				for (UnitPrice up : numberOfList) {
					i++;
				%>

				<tr>
					<td><%=up.minUnit%> - <%=up.maxUnit%>
					<td>Rs. <%=up.price%>
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