<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShoppingList</title>
</head>
<body>
	<a href="AddItem">Add Item</a><br><br>
	
	<table border="1">
		<thead>
			<th>Item</th>
			<th>Store</th>
			<th>Operation</th>
		</thead>
		<tbody>
			<c:forEach items="${items}" var="item">
				<tr>
					<td>${item.getName()}</td>
					<td>${item.getStore()}</td>
					<td><a href="DeleteItem?id=${item.getId()}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>