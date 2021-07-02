<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="in.vignesh.util.ConnectionUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>calculate Bill</title>
<style >
.cal {
	width: 1000px;
	overflow: hidden;
	margin: auto;
	margin: 20 0 0 600px;
	padding: 70px;
	background-image: url("https://lookaftermybills.com/wp-content/uploads/2019/05/Pre-payment-01-2-768x402.png");
	background-size: cover;
	background-repeat: no-repeat;
	
	border-radius: 25px;
}
.id {
		text-align: center;
	}
h3{
	text-align: center;

}
p{
	text-align: center;

}
</style>
</head>

<body>
<jsp:include page="header2.jsp"></jsp:include>
	<main class="container-fluid">
					<h3><strong>Enter Bill Information</strong></h3>
				        	    <div class="id">
					
							
					
						 <form action="CalcBillCtrl" method="post" > 
                         <span style="color: #00e676; font-style: inherit;" ><%=(request.getAttribute("msg") == null) ? "" : request.getAttribute("msg")%></span>
                         
                         
                                 <br>
								<label for="">UserId</label><br>
								<input  type="text" placeholder="Search.." name="userid" pattern="\d*"  required>
								 <input  type="submit" name="Action" value="Search" class="btn btn-info"> <br>
								</form>	
								<br>
								</div>
								
								
	
							<%
							 int count = 0;
			                if (request.getAttribute("UList") != null) {
			                    ArrayList al = (ArrayList) request.getAttribute("UList");
			                    System.out.println(al);
			                    Iterator itr = al.iterator();
			                    while (itr.hasNext()) {
		
			                        count++;
			                        ArrayList pList = (ArrayList) itr.next();
                        
            %>
            				        	    <div class="cal">
            

							<form action="CalcBillCtrl" method="post" >
							
						
								<label for="">UserId</label><br>
								<input type="text" value="<%=pList.get(0) %>" name="userid" ><br>
							
								
								<label for="name">Name</label><br> <input
									type="text" id="name"
							       name="name" value="<%=pList.get(1) %>"><br>
							      
							      <label for="consumerno">Consumer No</label><br> <input
									type="text"  id="consumerno"
							     name="consumerno" value="<%=pList.get(2) %>"><br>
							      
							      <label for="customerid">Customer id</label><br> <input
									type="text"  id="exampleInputPassword1"
							       name="customerid" value="<%=pList.get(3) %>"><br>
							        
							        
							        
							
								<label for="zonename">Zone name</label><br> <input
									type="text"  id="zonename"
									 name="zonename" value="<%=pList.get(4) %>"><br>
									
							     <label for="type">Type</label><br>
									
								<select name="type"	id="selectType" required>
				                <option disabled>Select Type</option>
				                <option id="selectType" value="HOME">HOME</option>
				               <option id="selectType" value="COMMERCIAL">COMMERCIAL</option>
			                	<option id="selectType" value="AGRICULTURE">AGRICULTURE</option>
		                       	</select><br> 
						
						
								<label for="unitconsumed">Unit Consumed</label> <br><input
									type="number" id="unitconsumed"
									placeholder="Enter Unit" name="unit" pattern="\d*" id="unitconsumed" min="1.0" max="1000.0" step="0.01" required><br>
						
						
								<label for="dues">Fine/Dues</label> <br><input
									type="text" 
									placeholder="Enter Fine/Dues" name="dues" pattern="\d*" required><br>
							
								<label for="year">Year</label><br>
									<input
									type="number" 
									placeholder="yyyy" name="year" pattern="\d*" id="year" required><br>
									
						
									
								<label for="month">Month</label><br>
									<select name="month">
									<option value="January">January</option>
									<option value="February">February</option>
									<option value="March">March</option>
									<option value="April">April</option>
									<option value="May">May</option>
									<option value="June">June</option>
									<option value="July">July</option>
									<option value="August">August</option>
									<option value="September">September</option>
									<option value="October">October</option>
									<option value="November">November</option>
									<option value="Decemeber">December</option>
									</select><br>
									
							
								<span style="color: #00e676; font-style: inherit;"><%=(request.getAttribute("msg") == null) ? "" : request.getAttribute("msg")%></span>
						 
							<br>
							<button type="submit" class="btn btn-primary" name="Action" value="Calculate Bill">Calculate Bill</button>
						
            			<%
                    }
                }
                 if (count == 0) {
            %>
            
                <p>Enter valid Record</p>
                		       
             
            <%           
            }
                 %>
						
					
						 </form> 
					
</div>
</main>
</body>
</html>