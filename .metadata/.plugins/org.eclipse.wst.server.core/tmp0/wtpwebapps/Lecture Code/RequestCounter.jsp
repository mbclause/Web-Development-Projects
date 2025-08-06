<%! int counter = 1; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request Counter</title>
</head>
<body>
	<h2>This is also the WRONG way to use JSP!!! (Just use this example to understand/explain JSP Scripting Elements)</h2>
	<p>
		You are visitor #<%= counter %>.
		<% ++counter; %>
	</p>
</body>
</html>