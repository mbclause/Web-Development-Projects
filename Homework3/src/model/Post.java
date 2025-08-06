package model;

/*
 * Post class
 */
public class Post {
	
	// private data members
	
	private String      postAuthor;
	
	private String      content;
	
	private String      postDate;
	
	// constructors
	public Post() {
		
		
		postAuthor = "";
		
		content = "";
		
		postDate = "";
	}
	
	public Post(String postAuthor, String content, String postDate) {
		
		
		this.postAuthor = postAuthor;
		
		this.content = content;
		
		this.postDate = postDate;
	}

	public String getPostAuthor() {
		return postAuthor;
	}

	public void setPostAuthor(String postAuthor) {
		this.postAuthor = postAuthor;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}



}
