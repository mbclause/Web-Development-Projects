package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		String  forumName = "";
		
		List<Topic> topics = new ArrayList<Topic>();
		
		Connection c = null;
    	
		try 
		{
				String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu73?useSSL=false&allowPublicKeyRetrieval=true";
				
				String username = "cs3220stu73";
				
				String password = "tHBnsQpc29Gt";
			
				c = DriverManager.getConnection(url, username, password);
				
				Statement stmt = c.createStatement();
				
				Statement stmt2 = c.createStatement();
				
				ResultSet rs = stmt.executeQuery("select * from topics where forum_id = '"+ id +"';");
				
				ResultSet rs2 = stmt2.executeQuery("select name from forums where id = '"+ id +"';");
				
				if(rs2.next())
					forumName = rs2.getString("name");
				
				while(rs.next())
				{
					topics.add(new Topic(rs.getInt("id"), rs.getString("name"), rs.getString("author"), 
							rs.getInt("num_replies"), rs.getString("time_stamp")));
				}
				
		}
		
		catch (SQLException e)	
		{
			e.printStackTrace();
		} 
		
		finally 
		{
			try 
			{
				if (c != null)
					c.close();
			}
			
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
			
			// store forum in application scope
			getServletContext().setAttribute("forumName", forumName);
			
			getServletContext().setAttribute("forumID", id);
			
			getServletContext().setAttribute("topics", topics);
			
	    	request.getRequestDispatcher( "/WEB-INF/DisplayTopics.jsp" )
	        .forward( request, response );
		
	}

    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	// getForum function
	/*@SuppressWarnings("unchecked")
	Forum  getForum(int id) {
		
		// get forum list from application scope
		List<Forum> forums = (List<Forum>) getServletContext().getAttribute("forums");
		
		// find corresponding forum
		for (Forum forum : forums) {
			if (forum.getForumID() == id)
				return forum;
		}

		return null;
	}*/

}
