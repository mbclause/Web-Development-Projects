<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CreateMapping</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>Quarter Course</th>
			<th>Semester Course</th>
		</tr>
		<tr>
			<form action="CreateMapping" method="post">
				<td>
					<ul>
					<c:forEach items="${quarterCourses}" var="course">
						<li><input type="radio" name="quarter"> ${course.getName()}</li>
					</c:forEach>
					</ul>
				</td>
				<td>
					<ul>
					<c:forEach items="${semesterCourses}" var="course">
						<li><input type="radio" name="semester"> ${course.getName()}</li>
					</c:forEach>
					</ul>
				</td>
		</tr>
	</table>
	<br>
	<input type="submit" name="add" value="Create Mapping" />
	</form>
</body>
</html>