<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" href="assets/css/style3.css">

</head>
<body>
	<div class="reg">

		<jsp:include page="loginheader.jsp"></jsp:include>
		<main class="container-fluid">

			<%
			String errorMessage = request.getParameter("errorMessage");
			if (errorMessage != null) {
				out.println("<font color='red'>" + errorMessage + "</font>");
			}
			%>
			<%
			String errormsg = "";
			if (session.getAttribute("ERROR") != null) {
				errormsg = (String) session.getAttribute("ERROR");
			}
			%>


			<h2>REGISTERATION</h2>
			<div class="register">
				<span style="color: red; font-style: inherit;"><%=(request.getAttribute("nmsg") == null) ? "" : request.getAttribute("nmsg")%></span>
				<span style="color: red; font-style: inherit;"><%=(request.getAttribute("emsg") == null) ? "" : request.getAttribute("emsg")%></span>
				<span style="color: red; font-style: inherit;"><%=(request.getAttribute("mmsg") == null) ? "" : request.getAttribute("mmsg")%></span>
				<span style="color: red; font-style: inherit;"><%=(request.getAttribute("cnmsg") == null) ? "" : request.getAttribute("cnmsg")%></span>
				<span style="color: red; font-style: inherit;"><%=(request.getAttribute("amsg") == null) ? "" : request.getAttribute("amsg")%></span>
				<span style="color: red; font-style: inherit;"><%=(request.getAttribute("cmsg") == null) ? "" : request.getAttribute("cmsg")%></span>
				<span style="color: red; font-style: inherit;"><%=(request.getAttribute("pmsg") == null) ? "" : request.getAttribute("pmsg")%></span>
				<span style="color: red; font-style: inherit;"><%=(request.getAttribute("umsg") == null) ? "" : request.getAttribute("umsg")%></span>

				<form action="RegisterServlet" method="post">

					<label for="name"><strong>Name:</strong></label><br> <input
						type="text" name="name" placeholder="Enter your name" required
						autofocus><br> <label for="email"><strong>Email
							Id:</strong></label><br> <input type="text" name="email"
						placeholder="Enter your Email Id" required autofocus><br>



					<label for="mobileNumber"><strong>Mobile Number:</strong></label><br>
					<input type="number" name="mobileNumber"
						placeholder="Enter your mobileNo" required><br> <label
						for="ConsumerNumber"><strong>Consumer Number:</strong></label><br>
					<input type="number" name="ConsumerNumber"
						placeholder="Eg:033418033424" required><br> <label
						for="address"><strong>Address:</strong></label><br> <input
						type="text" name="address" placeholder="Enter your Address"
						required autofocus><br> <label for="customerId"><strong>CustomerId:</strong></label><br>
					<input type="text" name="customerId"
						placeholder="Enter your Customer Id" required><br> <label
						for="password"><strong>Set Password:</strong></label><br> <input
						type="password" name="password" placeholder="Example@123" required><br>

					<label for="confirmpassword"><strong>Confirm
							password:</strong></label><br> <input type="password" name="confirmpassword"
						placeholder="Example@123" required><br> <br>
					<button type="submit" class="btn btn-success">Submit</button>
					<button type="reset" class="btn btn-warning">Reset</button>
				</form>
			</div>

		</main>

	</div>
</body>
</html>