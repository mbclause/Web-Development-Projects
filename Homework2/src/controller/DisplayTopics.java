package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Forum;
import model.Topic;

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
			
			getServletContext().setAttribute("topics", topics);
			
	    	request.getRequestDispatcher( "/WEB-INF/DisplayTopics.jsp" )
	        .forward( request, response );
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
