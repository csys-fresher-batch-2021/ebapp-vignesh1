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
			<form action="GenerateBill" method="post">
				<h3>Bill Calculator</h3>
				<br> <label for="type">Type:</label> <select name="type"
					id="selectType" required>
					<option disabled>Select Type</option>
					<option id="selectType" value="HOME">HOME</option>
					<option id="selectType" value="COMMERCIAL">COMMERCIAL</option>
					<option id="selectType" value="AGRICULTURE">AGRICULTURE</option>
				</select><br> <label for="units">Units: </label> 
				<input type="number" id="units" name="units" min="1.0" max="1000.0" size="16"  step="0.01" required>
				<br>
				<button type="submit" class="btn btn-primary">Calculate</button>

			</form>
	</main>
</body>
</html>