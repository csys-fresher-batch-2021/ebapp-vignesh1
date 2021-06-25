<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>user home page</title>
<style>
body {
	background-image: url("https://www.planete-energies.com/sites/default/files/styles/media_full_width_940px/public/thumbnails/image/477399765_0.jpg?itok=b002NPuR");
	background-repeat: no-repeat;
	background-size: cover;
}
p{
	color: #F1043A;
	}

.marquee p {
 position: absolute;
 width: 100%;
 height: 100%;
 margin: 0;
 line-height: 50px;
 text-align: center;
 -moz-transform:translateX(100%);
 -webkit-transform:translateX(100%);	
 transform:translateX(100%);
 -moz-animation: scroll-left 15s linear infinite;
 -webkit-animation: scroll-left 15s linear infinite;
 animation: scroll-left 15s linear infinite;
}
@-moz-keyframes scroll-left {
 0%   { -moz-transform: translateX(100%); }
 100% { -moz-transform: translateX(-100%); }
}
@-webkit-keyframes scroll-left {
 0%   { -webkit-transform: translateX(100%); }
 100% { -webkit-transform: translateX(-100%); }
}
@keyframes scroll-left {
 0%   { 
 -moz-transform: translateX(100%); 
 -webkit-transform: translateX(100%);
 transform: translateX(100%); 		
 }
 100% { 
 -moz-transform: translateX(-100%); 
 -webkit-transform: translateX(-100%);
 transform: translateX(-100%); 
 }
}
</style>

</head>
<body>
	<jsp:include page="header1.jsp"></jsp:include>
	<main class="container-fluid">


<br><br><br><br><br><br><br>

<div class="marquee">
<p>WELCOME AND PAY BILLS HERE!! </p>
</div>
	
</main>
</body>
</html>