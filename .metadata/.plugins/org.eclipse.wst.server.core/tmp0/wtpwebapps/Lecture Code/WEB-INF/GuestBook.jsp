<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guest Book</title>
</head>
<body>
	<h2>My Guest Book</h2>
	<table border='1'>
		<c:forEach items="${gbEntries}" var="gbEntry">
			<tr>
				<td style='padding: 3px;'>${gbEntry.name} says:</td>
				<td style='padding: 3px;'>${gbEntry.comment}</td>
				<td style='padding: 3px;'>
					<a href="EditComment?id=${gbEntry.id}">Edit</a>
					&nbsp; | &nbsp;
					<a href="DeleteComment?id=${gbEntry.id}">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<p><a href="AddComment">Add Comment</a></p>
</body>
</html>