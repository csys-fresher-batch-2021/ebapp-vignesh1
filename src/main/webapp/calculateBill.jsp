<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>calculation</title>
<style >
.cal {
	width: 430px;
	overflow: hidden;
	margin: auto;
	margin: 20 0 0 450px;
	padding: 70px;
	background-image: url("https://st3.depositphotos.com/12598558/31977/i/450/depositphotos_319772240-stock-photo-retro-gaming-background-with-calculator.jpg");
	background-size: cover;
	background-repeat: no-repeat;
	
	border-radius: 25px;
}

h3{
	text-align: center;

}
</style>

</head>
<body>
	<jsp:include page="header1.jsp"></jsp:include>
	<main class="container-fluid">
		<form action="GenerateBill" method="Post">
		<br><br><br>
			<h3>Bill Calculator</h3>	
			<div class="cal">
			<br> <label for="type">Type:</label> <select name="type"
				id="selectType" required>
				<option disabled>Select Type</option>
				<option id="selectType" value="HOME">HOME</option>
				<option id="selectType" value="COMMERCIAL">COMMERCIAL</option>
				<option id="selectType" value="AGRICULTURE">AGRICULTURE</option>
			</select><br> <label for="units">Units: </label> <input type="number"
				id="units" name="units" min="1.0" max="1000.0" size="15" step="0.01"
				required> <br>
			<button type="submit" class="btn btn-primary">Calculate</button>
			<button type="reset" class="btn btn-primary">Reset</button>
			
           </div>
		</form>
	</main>
</body>
</html>