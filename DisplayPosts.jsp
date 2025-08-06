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
	<title>Display Posts</title>
</head>
<body>
	<h2>
		<a href="DisplayForums">All Forums</a> &gt; 
		<a href="DisplayTopics?id=${forumID}">${forumName}</a> &gt; ${topName}
	</h2>
	<br>
	
	<table class="table table-bordered w-auto">
		<thead>
			<tr>
				<th scope="col">Author</th>
				<th scope="col">Content</th>
				<th scope="col">Posted On</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${posts}" var="post">
				<tr>
					<td>${post.getPostAuthor()}</td>
					<td>${post.getContent()}</td>
					<td>${post.getPostDate()}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	
	<table class="table table-bordered w-auto">
		<form action="DisplayPosts" method="post">
			<tr>
				<th scope="row">Your Name</th>
				<td>
					<div class="form-group">
						<input type="text" class="form-control" name="postAuthor">
					</div>
				</td>
			</tr>
			<tr>
				<th scope="row">Content</th>
				<td>
					<div class="form-group">
						<textarea class="form-control" name="postContent" rows="5" cols="40"></textarea>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<div class="form-group">
						<button type="submit" class="btn btn-primary">Post</button>
					</div>
				</td>
			</tr>
		</form>
	</table>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" 
    	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" 
    	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" 
    	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>