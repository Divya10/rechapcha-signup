<%@ page import="net.tanesha.recaptcha.ReCaptchaImpl"%>
<%@ page import="net.tanesha.recaptcha.ReCaptchaResponse"%>

<html>
<head>
<title>CAPTCHA in Java using reCAPTCHA</title>
</head>
<body>
<form  action="./student" method=post >
<input type="hidden" name="Username" id="Username" value="<%=request.getParameter("Username")%>" />
<input type="hidden" name="E-mail" id="E-mail" value="<%=request.getParameter("E-mail")%>" />
<input type="hidden" name="Password" id="Password" value="<%=request.getParameter("Password")%>" />
<input type="hidden" name="Pass1" id="Pass1" value="<%=request.getParameter("Pass1")%>" />
<h2>CAPTCHA in Java Application using reCAPTCHA</h2>
<p>
	<%
		String remoteAddr = request.getRemoteAddr();
		ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
		reCaptcha.setPrivateKey("6LfrshYUAAAAAHTrNqufhWI336J_p-E9tYDg7xM-");

		String challenge = request
				.getParameter("recaptcha_challenge_field");
		String uresponse = request.getParameter("recaptcha_response_field");
		ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(
				remoteAddr, challenge, uresponse);

		if (reCaptchaResponse.isValid()) {%>
			<div onLoad= documnt.form.submit()></div>
			
			
	  <%} else {
			out.print("CAPTCHA Validation Failed! Try Again.");
		}
	%>
</p>
<a href=".">Home</a>	
</body>
</html>