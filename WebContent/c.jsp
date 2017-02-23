<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>

<html>
<head>
<title>CAPTCHA in Java using reCAPTCHA</title>
</head>
<body>
<h2>CAPTCHA in Java Application using reCAPTCHA</h2>
<form action="./validate.jsp" method="post">
<p>Username: <input type="text" name="user"></p>
<p>Password: <input type="password" name="password"></p>
<p>
<%
	ReCaptcha c = ReCaptchaFactory.newReCaptcha(
       		  	"6LfrshYUAAAAAJXmR5X9QCS1vQ3bsIw7Jh-4CV39", 
        		"6LfrshYUAAAAAHTrNqufhWI336J_p-E9tYDg7xM-", false);
	out.print(c.createRecaptchaHtml(null, null));
%>
   <input type="submit" value="submit" />
</p>        
        </form>
</body>
</html>