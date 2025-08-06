<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Comment</title>
</head>
<body>
	<h2>Edit Comment</h2>


	<form action='EditComment' method='post'>
		<input type='hidden' name='id' value='${gbEntry.id}' />
		<table border='1'>
			<tr>
				<td style='padding: 3px;'>Name:</td>
				<td style='padding: 3px;'><input type='text' name='name' value='${gbEntry.name}' /></td>
			</tr>
			<tr>
				<td style='padding: 3px;'>Comments:</td>
				<td style='padding: 3px;'><textarea name='comment' rows='5' cols='40'>${gbEntry.comment}</textarea></td>
			</tr>
			<tr>
				<td style='padding: 3px;'><input type='submit' name='save' value='Save' /></td>
				<td style='padding: 3px;'><input type='reset' value='Reset' /></td>
			</tr>
		</table>
	</form>
	<p>
		<a href="GuestBook">Go Back</a>
	</p>
</body>
</html>