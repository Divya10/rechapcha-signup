<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

          
<html>
<head>
<title>LOGIN PAGE</title>
<style >
.sidenav{
position:relative;
top:0;
bottom: 500px;
left:150px;
width:40%;
margin:auto;
text-align:center;
background-color:#f1f1f1;
}
.sidenav li a 
{
text-decoration: none;
display: block;
}
.sidenav li{
list-style-type:none;
padding:20px;
text-decoration: none;
}
.sidenav li a:hover{
background-color:black;
color: white;
}
</style>
<style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 70%;
      margin: auto;
  }
  </style>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">    
<img src="images.jpe" class="img-thumbnail" alt="Cinque Terre" width="50" height="50">
 <a class="navbar-brand" href="#"><span>RAVIONICS INNOVATION LABS</span></a> 
    </div>
     <ul class="nav navbar-nav navbar-right">
     <li class="active"><a href="signup.jsp">Home</a></li>
      <li><a href="signup.jsp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="c.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
  </div>
</nav>
<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
    <li data-target="#myCarousel" data-slide-to="3"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
      <img src="unnamed.jpg" alt="Chania">
    </div>

    <div class="item">
      <img src="light-1997896_340.jpg" alt="Chania">
    </div>

    <div class="item">
      <img src="unnamedr.jpg" alt="Flower">
    </div>

    <div class="item">
      <img src="light-1997896_340.jpg" alt="Flower">
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div><br><br>
<div  class="sidenav" style="float:left;">
      <ul >
        <li><a href="signup.jsp">STUDENT</a></li>
        <li><a href="signup1.jsp">FACULTY</a></li>
        <li><a href="signup2.jsp">ADMIN</a></li>
      </ul>
    </div>
 <div class=me style="float: right; margin-right:190px; display: inline-block;  ">
<form  action="./student" method=post>
USERNAME:<br>
<input type="text" name="Username" placeholder="name">
<br><br>
E-MAIL:<br>
<input type="e-mail" name="E-mail" placeholder="ABC@gmail.com">
<br><br>
PASSWORD:<br>
<input type="password" name="Password" placeholder="***">
<br><br>
RE-ENTER PASSWORD:<br>
<input type="password" name="Pass1" placeholder="***">
<br>
<br>
<center>
<p>
  <%
	ReCaptcha c = ReCaptchaFactory.newReCaptcha(
       		  	"6LfrshYUAAAAAJXmR5X9QCS1vQ3bsIw7Jh-4CV39", 
        		"6LfrshYUAAAAAHTrNqufhWI336J_p-E9tYDg7xM-", false);
	out.print(c.createRecaptchaHtml(null, null));
   %><br>
   <button type="submit" class="btn btn-primary btn-md">SIGNUP</button>
   <button type="button" class="btn btn-primary btn-md">FORGET</button>
</p>   
   </center>  
</form>
</div>
</body>
</html>