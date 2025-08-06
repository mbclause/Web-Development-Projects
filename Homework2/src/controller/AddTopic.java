package controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Forum;
import model.Topic;

/**
 * Servlet implementation class AddTopic
 */
@WebServlet("/AddTopic")
public class AddTopic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTopic() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	request.getRequestDispatcher( "/WEB-INF/AddTopic.jsp" )
        .forward( request, response );
	}

    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	// get forum from application scope
    	Forum forum = (Forum) getServletContext().getAttribute("forum");
    	
    	// set date format
    	java.text.SimpleDateFormat formatter;
    	
    	formatter = new SimpleDateFormat("M/d/yyyy h:mmaa");
    	
    	Date  time = new Date();
    	
    	// get current date
    	Calendar c = Calendar.getInstance();
    	
    	// set the date
    	c.setTime(time);
    	
    	String date = formatter.format(time);
    	
    	// get form data from request parameters
		String name = request.getParameter("name").trim();
		
		String subject = request.getParameter("subject").trim();
		
		String content = request.getParameter("content").trim();
		
		// set topic ID
		int id = forum.generateTopicID();
		
		// create new topic and add to list
		Topic newTopic = new Topic(id, subject, name, date, content);
		
		forum.addTopic(newTopic);
		
		// go back to topics page
		response.sendRedirect("DisplayTopics?id=" + forum.getForumID());
	}

}
