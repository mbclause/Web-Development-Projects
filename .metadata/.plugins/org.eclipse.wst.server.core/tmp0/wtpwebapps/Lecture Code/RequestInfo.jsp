<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request Info</title>
</head>
<body>
	<h2>Request Info</h2>
	The method of the request: ${pageContext.request.method} <br />
	Remote user: ${pageContext.request.remoteUser} <br />
	Remote address: ${pageContext.request.remoteAddr} (IP v4 address of localhost) <br />
	The value of parameter a: ${param.a} <br />
	The value of parameter b: ${param["b"]} <br />
	The value of cookie JSESSIONID: ${cookie["JSESSIONID"].value} <br />
</body>
</html>
