package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
    	
    	// get topic
    	int topID = Integer.parseInt(request.getParameter("topID"));
    	
    	String topName = "";
    	
    	List<Post> posts = new ArrayList<Post>();
    	
		Connection c = null;
    	
		try 
		{
				String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu73?useSSL=false&allowPublicKeyRetrieval=true";
				
				String username = "cs3220stu73";
				
				String password = "tHBnsQpc29Gt";
			
				c = DriverManager.getConnection(url, username, password);
				
				Statement stmt = c.createStatement();
				
				ResultSet rs = stmt.executeQuery("select * from posts where topic_id = '"+ topID +"';");
				
				while(rs.next())
				{
					posts.add(new Post(rs.getString("author"), rs.getString("content"), rs.getString("time_stamp")));
				}
				
				Statement stmt2 = c.createStatement();
				
				ResultSet rs2 = stmt2.executeQuery("select name from topics where id = '"+ topID +"';");
				
				if(rs.next())
					topName = rs2.getString("name");
				
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
		
		getServletContext().setAttribute("topName", topName);
		
		getServletContext().setAttribute("posts", posts);
		
		getServletContext().setAttribute("topID", topID);
		
    	request.getRequestDispatcher( "/WEB-INF/DisplayPosts.jsp" )
        .forward( request, response );
        	
	}

    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		int  topID = (int) getServletContext().getAttribute("topID");
		

		java.text.SimpleDateFormat formatter;
    	
    	formatter = new SimpleDateFormat("M/d/yyyy h:mmaa");
    	
    	Date  time = new Date();
    	

    	Calendar cal = Calendar.getInstance();
    	
    	cal.setTime(time);
    	
    	String date = formatter.format(time);
    	

		String author = request.getParameter("postAuthor").trim();
		
		String content = request.getParameter("postContent").trim();
		
		Connection c = null;
    	
		try 
		{
				String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu73?useSSL=false&allowPublicKeyRetrieval=true";
				
				String username = "cs3220stu73";
				
				String password = "tHBnsQpc29Gt";
			
				c = DriverManager.getConnection(url, username, password);
				
				String sql = "insert into posts (author, content, time_stamp, topic_id) values (?, ?, ?, ?);";
				
				PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				
				stmt.setString(1, author);
				
				stmt.setString(2, content);
				
				stmt.setString(3, date);
				
				stmt.setInt(4, topID);
				
				stmt.executeUpdate();
				
				Statement  stmt2 = c.createStatement();
				
				stmt2.executeUpdate("update topics set num_replies = num_replies + 1 where id = '"+ topID +"';");
				
				Statement  stmt3 = c.createStatement();
				
				stmt3.executeUpdate("update topics set time_stamp = '"+ date +"' where id = '"+ topID +"';");
				
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
		

		response.sendRedirect("DisplayPosts?topID=" + topID);
	}
}
