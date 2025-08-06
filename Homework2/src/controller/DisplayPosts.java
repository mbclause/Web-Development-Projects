package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Forum;
import model.Topic;
import model.Post;

/**
 * Servlet implementation class DisplayPosts
 */
@WebServlet("/DisplayPosts")
public class DisplayPosts extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayPosts() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	// get forum from application scope
    	Forum forum = (Forum) getServletContext().getAttribute("forum");
    	
    	// get topic
    	int topID = Integer.parseInt(request.getParameter("topID"));
    	
    	Topic topic = forum.getTopic(topID);
    	
    	// check if topic is valid
    	if(topic == null) {
    		
    		response.sendRedirect("DisplayTopics");
    	}
		
    	else {
    		
    		List<Post> posts = topic.getPosts();
    		
    		// store post list in application scope
    		getServletContext().setAttribute("topic", topic);
    		
    		getServletContext().setAttribute("posts", posts);
		
        	request.getRequestDispatcher( "/WEB-INF/DisplayPosts.jsp" )
            .forward( request, response );
    	}
	}

    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		Topic topic = (Topic) getServletContext().getAttribute("topic");
		

		java.text.SimpleDateFormat formatter;
    	
    	formatter = new SimpleDateFormat("M/d/yyyy h:mmaa");
    	
    	Date  time = new Date();
    	

    	Calendar c = Calendar.getInstance();
    	
    	c.setTime(time);
    	
    	String date = formatter.format(time);
    	

		String author = request.getParameter("postAuthor").trim();
		
		String content = request.getParameter("postContent").trim();
		
		
		Post newPost = new Post(author, content, date);
		
		topic.addPost(newPost);
		

		response.sendRedirect("DisplayPosts?topID=" + topic.getTopicID());
	}
}
