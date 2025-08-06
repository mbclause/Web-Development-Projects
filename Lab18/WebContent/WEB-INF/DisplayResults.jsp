<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DisplayResults</title>
</head>
<body>
	<table border="1">
		<thead>
			<th>Language</th>
			<th># of People Who Know the Language</th>
		</thead>
		<tbody>
			<c:forEach items="${languages}" var="language">
				<tr>
					<td>${language.getName()}</td>
					<td>${language.getNumPeople()}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br><a href="DisplayPoll">Back to Poll</a>
</body>
</html>