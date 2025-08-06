package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    	int      forumID = (int) getServletContext().getAttribute("forumID");
    	
    	int      topicID = 0;
    	
    	// set date format
    	java.text.SimpleDateFormat formatter;
    	
    	formatter = new SimpleDateFormat("M/d/yyyy h:mmaa");
    	
    	Date  time = new Date();
    	
    	// get current date
    	Calendar cal = Calendar.getInstance();
    	
    	// set the date
    	cal.setTime(time);
    	
    	String date = formatter.format(time);
    	
    	// get form data from request parameters
		String name = request.getParameter("name").trim();
		
		String subject = request.getParameter("subject").trim();
		
		String content = request.getParameter("content").trim();
		
		Connection c = null;
		
		try 
		{
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu73?useSSL=false&allowPublicKeyRetrieval=true";
			
			String username = "cs3220stu73";
			
			String password = "tHBnsQpc29Gt";	
			
			c = DriverManager.getConnection(url, username, password);
			
			String sql = "insert into topics (name, author, num_replies, time_stamp, forum_id) values (?, ?, ?, ?, ?);";
			
			PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, subject);
			
			stmt.setString(2, name);
			
			stmt.setInt(3, 0);
			
			stmt.setString(4, date);
			
			stmt.setInt(5, forumID);
			
			stmt.executeUpdate();	
			
			Statement stmt3 = c.createStatement();
			
			ResultSet rs = stmt3.executeQuery("SELECT id FROM topics WHERE id=(SELECT max(id) FROM topics);");
			
			if(rs.next())
				topicID = rs.getInt("id");
			
			String sql2 = "insert into posts (author, content, time_stamp, topic_id) values (?, ?, ?, ?);";
			
			PreparedStatement stmt2 = c.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
			
			stmt2.setString(1, name);
			
			stmt2.setString(2, content);
			
			stmt2.setString(3, date);
			
			stmt2.setInt(4, topicID);
			
			stmt2.executeUpdate();
			
			Statement  stmt4 = c.createStatement();
			
			stmt4.executeUpdate("update forums set num_topics = num_topics + 1 where id = '"+ forumID +"';");
			
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
		
		// go back to topics page
		response.sendRedirect("DisplayTopics?id=" + forumID);
	}

}
