<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AddItem</title>
</head>
<body>
	<form action="AddItem" method="post">
		Item: <input type="text" name="itemName"><br><br>
		<label for="store">Store: </label>
		<select name="store">
			<option disabled selected value></option>
			<c:forEach items="${stores}" var="store">
				<option value="${store}">${store}</option>
			</c:forEach>
		</select>
		or <input type="text" name="store"><br><br>
		<input type="submit" name="add" value="Add" />
	</form>
</body>
</html>