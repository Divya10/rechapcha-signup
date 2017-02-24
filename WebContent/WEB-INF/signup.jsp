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
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      
<img src="images.jpe" class="img-thumbnail" alt="Cinque Terre" width="50" height="50">
    </div>
    <ul class="nav navbar-nav">
     <a class="navbar-brand" href="#">RAVIONICS INNOVATION LABS</a>
    </ul>
    <ul class="nav navbar-nav navbar-right">
     <li class="active"><a href="#">Home</a></li>
      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>

</head>
<body>

<div class="container">
  <div class="row">
    <nav class="col-sm-3" id="myScrollspy" background-colour=#000000>
      <ul class="nav nav-pills nav-stacked" data-spy="affix" data-offset-top="205">
        <li><a href="#">STUDENT</a></li>
        <li><a href="#">FACULTY</a></li>
        <li><a href="#">ADMIN</a></li>
      </ul>
    </nav>
    
<form action="./validate.jsp" method="post">

<p>Username: <input type="text" name="user"></p>
<p>Email: <input type="text" name="user1"></p>
<p>Password: <input type="text" name="user2"></p>
<p>Reenter Password: <input type="password" name="password"></p>
<center>
<p>
  <%
	ReCaptcha c = ReCaptchaFactory.newReCaptcha(
       		  	"6LfrshYUAAAAAJXmR5X9QCS1vQ3bsIw7Jh-4CV39", 
        		"6LfrshYUAAAAAHTrNqufhWI336J_p-E9tYDg7xM-", false);
	out.print(c.createRecaptchaHtml(null, null));
   %>
   <button type="submit" class="btn btn-primary btn-md">LOGIN</button>
   <button type="button" class="btn btn-primary btn-md">FORGET</button>
</p>   
   </center>  
</form>
</div>
    </div>
</body>
</html>