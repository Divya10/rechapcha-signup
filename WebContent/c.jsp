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
width:300px;
}
.sidenav li a:hover{
background-color:black;
color: white;
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
     <li class="active"><a href="#">Home</a></li>
      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
  </div>
</nav>
   <div  class="sidenav" style="float:left";>
      <ul class="nav nav-pills nav-stacked" data-spy="affix" data-offset-top="205">
        <li><a href="#">STUDENT</a></li>
        <li><a href="#">FACULTY</a></li>
        <li><a href="#">ADMIN</a></li>
      </ul>
    </div>
 <div class=me style="float: right; margin-right:190px; display: inline-block;  ">
<form  action="./validate.jsp" method=post>
E-MAIL:<br>
<input type="text" name="PASSWORD" placeholder="***">
<br><br>
PASSWORD:<br>
<input type="text" name="E-MAIL" placeholder="ABC@gmail.com">
<br><br>
<center>
<p>
  <%
	ReCaptcha c = ReCaptchaFactory.newReCaptcha(
       		  	"6LfrshYUAAAAAJXmR5X9QCS1vQ3bsIw7Jh-4CV39", 
        		"6LfrshYUAAAAAHTrNqufhWI336J_p-E9tYDg7xM-", false);
	out.print(c.createRecaptchaHtml(null, null));
   %><br>
   <button type="submit" class="btn btn-primary btn-md">LOGIN</button>
   <button type="button" class="btn btn-primary btn-md">FORGET</button>
</p>   
   </center>  
</form>
</div>
</body>
</html>