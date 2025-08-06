<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Comment</title>
</head>
<body>
	<h2>Add Comment</h2>


	<form action='AddComment' method='post'>
		<table border='1'>
			<tr>
				<td style='padding: 3px;'>Name:</td>
				<td style='padding: 3px;'><input type='text' name='name' /></td>
			</tr>
			<tr>
				<td style='padding: 3px;'>Comments:</td>
				<td style='padding: 3px;'><textarea name='comment' rows='5' cols='40'></textarea></td>
			</tr>
			<tr>
				<td style='padding: 3px;'><input type='submit' name='add' value='Add' /></td>
				<td style='padding: 3px;'><input type='reset' value='Reset' /></td>
			</tr>
		</table>
	</form>
	<p>
		<a href="GuestBook">Go Back</a>
	</p>
</body>
</html>