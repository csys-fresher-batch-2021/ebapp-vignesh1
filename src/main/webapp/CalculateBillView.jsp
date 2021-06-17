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
<title>AdminLogin</title>
</head>

<body>

<jsp:include page="header2.jsp"></jsp:include>
	<main class="container-fluid">
					<h3><strong>Enter Bill Information</strong></h3>
				
					
						 <form action="CalcBillCtrl" method="post" > 
                         <span style="color: #00e676; font-style: inherit;" ><%=(request.getAttribute("msg") == null) ? "" : request.getAttribute("msg")%></span>
                                 <br>
								<label for="">UserId</label><br>
								<input class="form-control" type="text" placeholder="Search.." name="userid" pattern="\d*"  required><br>
								 <input  type="submit" name="Action" value="Search" class="btn btn-info"> <br>
								</form>	
								
	
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
            

							<form action="CalcBillCtrl" method="post" >
						
								<label for="">UserId</label>
								<input class="form-control" type="text" value="<%=pList.get(0) %>" name="userid" >
							
								
								<label for="exampleInputPassword1">Name</label> <input
									type="text" class="form-control" id="exampleInputPassword1"
							      placeholder="Enter name" name="name" value="<%=pList.get(1) %>">
							        
							
								<label for="exampleInputPassword1">Zone name</label> <input
									type="text" class="form-control" id="exampleInputPassword1"
									placeholder="Enter Zone name" name="zonename" value="<%=pList.get(2) %>">
									
									
								<label for="exampleInputPassword1">Type</label> <input
									type="text" class="form-control" id="exampleInputPassword1"
									placeholder="Enter Type" name="type" id="type" required>
						
						
								<label for="exampleInputPassword1">Unit Consumed</label> <input
									type="number" class="form-control" id="exampleInputPassword1"
									placeholder="Enter Unit" name="unit" pattern="\d*" id="unitconsumed" required>
						
						
								<label for="exampleInputPassword1">Fine/Dues</label> <input
									type="text" class="form-control" 
									placeholder="Enter Dues" name="dues" pattern="\d*" required>
							
								<label for="exampleInputPassword1">Year</label>
									<select name="year" class="form-control">
									<option value="2020">2022</option>
									<option value="2019">2021</option>
									
									<option value="2018">2020</option>
									<option value="2017" >2019</option>
									
									</select>
									
								<label for="exampleInputPassword1">Month</label>
									<select name="month" class="form-control">
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
									</select>
									
							
								<span style="color: #00e676; font-style: inherit;"><%=(request.getAttribute("msg") == null) ? "" : request.getAttribute("msg")%></span>
						 
							
							<button type="submit" class="btn btn-primary" name="Action" value="Calculate Bill">Calculate Bill</button>
						
            			<%
                    }
                }
                 if (count == 0) {
            %>
            
                <b>Enter valid Record</b>
                		       
             
            <%           
            }
                 %>
						
					
						 </form> 
					

</main>
</body>
</html>