<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>UserLogin</title>
<link rel="stylesheet" href="assets/css/style1.css">

</head>
<body>
<jsp:include page="header1.jsp"></jsp:include>
	<main class="container-fluid">
<%


HttpSession session2=request.getSession(false);
if(session2!=null)
{
	
	session2.invalidate();
	//session2.removeAttribute("admin");
	request.setAttribute("ermsg","You have logged out");
	RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp");
	dispatcher.forward(request, response);
	
}

%>
</main>
</body>
</html>