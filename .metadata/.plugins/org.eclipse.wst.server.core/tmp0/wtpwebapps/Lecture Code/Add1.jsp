<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add1</title>
</head>
<body>
	<h2>This is the WRONG way to use JSP!!! (see Add2.jsp for the correct way)</h2>
	<p>
		The sum of
		<%= request.getParameter("a") %>
		and
		<%= request.getParameter("b") %>
		is
		<%= Integer.parseInt(request.getParameter("a")) + Integer.parseInt(request.getParameter("b")) %>
	</p>
</body>
</html>
