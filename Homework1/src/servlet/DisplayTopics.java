package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Forum;
import data.Topic;

/**
 * Servlet implementation class DisplayTopics
 */
@WebServlet("/DisplayTopics")
public class DisplayTopics extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayTopics() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	// get forum id from request parameter
		int id = Integer.parseInt(request.getParameter("id"));
		
		// get the corresponding forum
		Forum forum = getForum(id);
		
		// check if forum is valid
		if(forum == null) {
			response.sendRedirect("DisplayForums");
		}
		
		else {
			
			// get forum topics
			List<Topic> topics = forum.getTopics();
			
			// store forum in application scope
			getServletContext().setAttribute("forum", forum);
			
			// generate topics page
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>");
			out.println("<html><head><title>DisplayTopics</title></head><body>");
			
			out.println("<h2><a href='DisplayForums'>All Forums</a> &gt; " + forum.getForumName() + "</h2><br>");
			out.println("<table border='1'>");
			out.println("<tr><th>Topic</th><th>Author</th><th>Replies</th><th>Last Post</th></tr>");
			
			// list topics
			for(Topic topic : topics) {
				
				out.println("<tr><td><a href='DisplayPosts?topID=" + topic.getTopicID() + "'>" + topic.getTopicName() + "</a></td><td>" 
				+ topic.getTopicAuthor() + "</td><td>" + topic.getNumReplies() + "</td><td>" + topic.getLastPostDate() + "</td></tr>");
			}
			
			out.println("</table>");
			out.println("<br><a href='AddTopic'>Create Topic</a>");
			out.println("</body></html>");
		}
	}

    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	// getForum function
	@SuppressWarnings("unchecked")
	Forum  getForum(int id) {
		
		// get forum list from application scope
		List<Forum> forums = (List<Forum>) getServletContext().getAttribute("forums");
		
		// find corresponding forum
		for (Forum forum : forums) {
			if (forum.getForumID() == id)
				return forum;
		}

		return null;
	}

}
