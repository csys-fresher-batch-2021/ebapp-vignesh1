<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/fontawesome.min.css">
<%
if(request.getSession(false).getAttribute("user")==null)
{
	%>
<jsp:forward page="login.jsp"></jsp:forward>
<% 
}
%>

<header>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
  <a class="navbar-brand" href="index.jsp">Electricity Bill Calculation</a>
  <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#collapsibleNavId" aria-controls="collapsibleNavId"
      aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavId">
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
    
	    <li class="nav-item">
		<a class="nav-link" href="userhome.jsp">Home</a>
		</li>
	    <li class="nav-item">
		<a class="nav-link" href="viewprofile.jsp">View profile</a>
		</li>
	    <li class="nav-item">
		<a class="nav-link"  href="viewbill.jsp">View Bill</a>
		</li>
	    <li class="nav-item">
		<a  class="nav-link" href="paymenthistory.jsp">Payment History</a>
		</li>
        <li class="nav-item active" style=" color: white">
		<a>Welcome <%=session.getAttribute("user") %></a>
		</li>
		 <li class="nav-item active">
		<a class="nav-link" href="logout.jsp">Logout</a>
		</li>
	
		
	</ul>

  </div>
</nav>
</header>