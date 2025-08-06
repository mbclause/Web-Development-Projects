package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Forum;
import data.Topic;
import data.Post;

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
    		
    		// generate posts page
    		response.setContentType("text/html");
    		PrintWriter out = response.getWriter();
    		out.println("<!DOCTYPE html>");
    		out.println("<html><head><title>DisplayPosts</title></head><body>");
		
    		out.println("<h2><a href='DisplayForums'>All Forums</a> &gt; <a href='DisplayTopics?id=" + forum.getForumID() + 
    					"'>" + forum.getForumName() + "</a> &gt; " + topic.getTopicName() + "</h2>");
    		
			out.println("<table border='1'>");
			out.println("<tr><th>Author</th><th>Content</th><th>Posted On</th></tr>");
			
			// list posts
			for(Post post : posts) {
				
				out.println("<tr><td>" + post.getPostAuthor() + "</td><td>" + post.getContent() + "</td><td>"+ post.getPostDate() +"</td></tr>");
			}
    		
			out.println("</table><br><table border='1'><form action='DisplayPosts' method='post'>");
			
			out.println("<tr><th>Your Name</th><td><input type='text' name='postAuthor'></td></tr>");
			out.println("<tr><th>Content</th><td><textarea name='postContent' rows='5' cols='40'></textarea></td></tr>");
			out.println("<tr><td colspan='2'><input type='submit' name='add' value='Post'></td></tr>");
    		
			out.println("</form></table>");
    		out.println("</body></html>");
		
		
    	}
	}

    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	// get topic from application scope
		Topic topic = (Topic) getServletContext().getAttribute("topic");
		
		// set date format
		java.text.SimpleDateFormat formatter;
    	
    	formatter = new SimpleDateFormat("M/d/yyyy h:mmaa");
    	
    	Date  time = new Date();
    	
    	// get current date
    	Calendar c = Calendar.getInstance();
    	
    	c.setTime(time);
    	
    	String date = formatter.format(time);
    	
    	// get form data from request parameters
		String author = request.getParameter("postAuthor").trim();
		
		String content = request.getParameter("postContent").trim();
		
		// create new post and add to list
		Post newPost = new Post(author, content, date);
		
		topic.addPost(newPost);
		
		// return to posts page
		response.sendRedirect("DisplayPosts?topID=" + topic.getTopicID());
	}
}
