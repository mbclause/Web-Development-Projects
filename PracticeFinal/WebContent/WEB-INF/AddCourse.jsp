
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AddCourse</title>
</head>
<body>
<p>
	Course: <form action="AddCourse" method="post"> 
				<input type="text" name="name" />
				<select name="courseType">
					<option value="quarter">Quarter</option>
					<option value="semester">Semester</option>
				</select>
				 <input type="submit" name="add" value="Add" />
			</form>
</p>
</body>
</html>