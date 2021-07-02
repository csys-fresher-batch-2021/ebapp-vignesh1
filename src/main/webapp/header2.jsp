<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/fontawesome.min.css">

<%
if(request.getSession(false).getAttribute("admin")==null)
{
	%>
<jsp:forward page="login.jsp"></jsp:forward>
<% 
}
%>
<header>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
  <a class="navbar-brand" href="welcome.jsp">Electricity Bill Management</a>
  <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#collapsibleNavId" aria-controls="collapsibleNavId"
      aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavId">
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
   
      <li class="nav-item">
  <a class="nav-link" href="viewusers.jsp">ViewUsers</a>
  </li>
      <li class="nav-item">
 <a class="nav-link" href="CalculateBillView.jsp">CalculateBill</a>
 </li> 
      <li class="nav-item">
  <a class="nav-link" href="billamount.jsp">BillAmount</a>
  </li>
      <li class="nav-item">
  <a class="nav-link" href="billreport.jsp">BillReport</a>
  </li>
</ul>
<ul class="navbar-nav ml-auto mt-2 mt-lg-0">

   <li class="nav-item active" >
  <a class="nav-link" href="adminhome.jsp" style=color:yellow; >Welcome <%=session.getAttribute("admin") %>
  </a>  
  </li> 
  <li class="nav-item active">
  <a class="nav-link" href="logout.jsp">Logout</a>
  </li>

</ul> 
</div>
</nav>
</header>
