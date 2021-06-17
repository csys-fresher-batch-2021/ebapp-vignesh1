<%@page import="java.sql.PreparedStatement"%>
<%@page import="in.vignesh.util.ConnectionUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>AdminLogin</title>
</head>
<body>

		<jsp:include page="header1.jsp"></jsp:include>
		<main class="container-fluid">

<%
String id=request.getParameter("id");

if (id != null) {
	int userid = Integer.parseInt(id);

	Connection con = ConnectionUtil.getConnection();
	String sql = "DELETE FROM E_USER WHERE USERID=" + userid;
	PreparedStatement ps = con.prepareStatement(sql);
	int i = ps.executeUpdate();
	if (i > 0) {
%>
<jsp:forward page="/viewusers.jsp" />


<%
} else
%>
<jsp:forward page="/viewusers.jsp" />
<%
}
%>
</main>
</body>
</html>