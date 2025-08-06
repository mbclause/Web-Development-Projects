<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" 
    	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
    	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
    	crossorigin="anonymous">
  	<link rel="stylesheet" 
    	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
    	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
    	crossorigin="anonymous">
	<title>Display Forums</title>
</head>
<body>

	<h2>All Forums</h2>
	<br>
	
	<table class="table table-bordered w-auto">
		<thead>
			<tr>
				<th scope="col">Forum</th>
				<th scope="col">Topics</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${forums}" var="forum">
				<tr>
					<td><a href="DisplayTopics?id=${forum.getForumID()}">${forum.getForumName()}</a></td>
					<td>${forum.getNumTopics()}</td>
				</tr>
			</c:forEach>
			<form action="DisplayForums" method="post">
				<tr>
					<th scope="row">Forum Name</th>
					<td>
						<div class="form-group">
							<input type="text" class="form-control" name="name">
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div class="form-group">
							<button type="submit" class="btn btn-primary">Add</button>
						</div>
					</td>
				</tr>
			</form>
		</tbody>
	</table>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" 
    	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" 
    	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" 
    	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>