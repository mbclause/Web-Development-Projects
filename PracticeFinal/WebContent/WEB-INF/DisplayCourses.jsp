<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DisplayCourses</title>
</head>
<body>
	<p><a href="AddCourse">Add Course</a> | <a href="CreateMapping">Create Course Mapping</a></p>
	
	<table border="1">
		<thead>
			<tr>
				<th>Quarter Courses</th>
				<th>Semester Courses</th>
				<th>Course Mappings</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>
					<ul>
					<c:forEach items="${quarterCourses}" var="course">
						<li>${course.getName()}</li>
					</c:forEach>
					</ul>
				</td>
				<td>
					<ul>
						<c:forEach items="${semesterCourses}" var="course">
							<li>${course.getName()}</li>
						</c:forEach>
					</ul>
				</td>
				<td>
					<ul>
						<c:forEach items="${courseMappings}" var="mapping">
							<li>(${mapping.getQuarterName()}, ${mapping.getSemesterName()})</li>
						</c:forEach>
					</ul>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>