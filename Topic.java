package model;

import java.util.ArrayList;
import java.util.List;

/*
 * Topic class
 */
public class Topic extends Post {
	
	// private data members
	private final int   topicID;
	
	private String      topicName;
	
	private String      topicAuthor;
	
	private int         numReplies;
	
	private String      lastPostDate;
	
	private List<Post>  posts;
	
	// constructors
	public Topic() {
		topicID = 0;
		
		topicName = "";
		
		topicAuthor = "";
		
		numReplies = 0;
		
		lastPostDate = "";
		
		posts = new ArrayList<Post>();
	}
	
	public Topic(int topicID, String topicName, String topicAuthor, int numReplies, String lastPostDate) {
		this.topicID = topicID;
		
		this.topicName = topicName;
		
		this.topicAuthor = topicAuthor;
		
		this.lastPostDate = lastPostDate;
		
		this.numReplies = numReplies;
		
		posts = new ArrayList<Post>();
	}

	// accessor methods
	public int getTopicID() {
		return topicID;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getTopicAuthor() {
		return topicAuthor;
	}

	public void setTopicAuthor(String topicAuthor) {
		this.topicAuthor = topicAuthor;
	}

	public int getNumReplies() {
		return numReplies;
	}

	public String getLastPostDate() {
		return lastPostDate;
	}

	public void setLastPostDate(String lastPostDate) {
		this.lastPostDate = lastPostDate;
	}

	public List<Post> getPosts() {
		return posts;
	}
	
	public void addPost(Post newPost) {
		posts.add(newPost);
		
		setLastPostDate(newPost.getPostDate());
		
		if(posts.size() > 1) {
			numReplies++;
		}
	}
}
