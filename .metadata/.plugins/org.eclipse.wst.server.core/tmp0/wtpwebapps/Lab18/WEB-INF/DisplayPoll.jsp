<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DisplayPoll</title>
</head>
<body>
	<p>Please select the programming language(s) you know:</p>
	
	<form action="DisplayPoll" method="post">
		<ul>
			<c:forEach items="${languages}" var="language">
				<li><input type="checkbox" name="${language.getName()}">${language.getName()}</li>
			</c:forEach>
		</ul>
		<input type="submit" name = "add" value="Submit"/>  
	</form>
	<br><a href="AddLanguage">Add New Language</a>
</body>
</html>