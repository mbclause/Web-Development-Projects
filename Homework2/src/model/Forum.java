package model;

import java.util.ArrayList;
import java.util.List;

/*
 * Forum class
 */
public class Forum extends Topic {
	
	// private data members
	private final int     forumID;
	
	private String        forumName;
	
	private int           numTopics;
	
	private List<Topic>   topics;
	
	// constructors
	public Forum() {
		
		forumID = 0;
		
		forumName = "";
		
		numTopics = 0;
		
		topics = new ArrayList<Topic>();
	}
	
	public Forum(int forumID, String forumName) {
		
		this.forumID = forumID;
		
		this.forumName = forumName;
		
		numTopics = 0;
		
		topics = new ArrayList<Topic>();
	}

	// accessor methods
	public String getForumName() {
		return forumName;
	}

	public void setForumName(String forumName) {
		this.forumName = forumName;
	}

	public int getNumTopics() {
		return numTopics;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public int getForumID() {
		return forumID;
	}
	
	public void addTopic(Topic newTopic) {
		
		topics.add(newTopic);
		
		numTopics++;
	}
	
	public Topic getTopic(int id) {
		
		for(Topic topic : topics) {
			
			if(id == topic.getTopicID()) {
				return topic;
			}
		}
		
		return null;
	}
	
	// methods
	public int generateTopicID() {
		
		int id = 0;
		
		for(Topic forumTopic : topics) {
			if(forumTopic.getTopicID() > id) {
				id = forumTopic.getTopicID();
			}
		}
		
		return id + 1;
	}
	
	
}
