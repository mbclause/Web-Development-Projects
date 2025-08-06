package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Forum;

/**
 * Servlet implementation class DisplayForums
*/
@WebServlet(urlPatterns = "/DisplayForums", loadOnStartup = 1)
public class DisplayForums extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayForums() {
        super();
        // TODO Auto-generated constructor stub
    }
   
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	*/
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Forum> forums = new ArrayList<Forum>();
		
		Connection c = null;
    	
		try 
		{
				String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu73?useSSL=false&allowPublicKeyRetrieval=true";
				
				String username = "cs3220stu73";
				
				String password = "tHBnsQpc29Gt";
			
				c = DriverManager.getConnection(url, username, password);
				
				Statement stmt = c.createStatement();
				
				ResultSet rs = stmt.executeQuery("select * from forums;");
				
				while (rs.next()) 
				{
					forums.add(new Forum(rs.getInt("id"), rs.getString("name"), rs.getInt("num_topics")));
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
		
		getServletContext().setAttribute("forums", forums);
		
    	request.getRequestDispatcher( "/WEB-INF/DisplayForums.jsp" )
        .forward( request, response );
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String  name = request.getParameter( "name" );
		
        Connection c = null;
		
		try 
		{
				String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu73?useSSL=false&allowPublicKeyRetrieval=true";
				
				String username = "cs3220stu73";
				
				String password = "tHBnsQpc29Gt";
			
				c = DriverManager.getConnection(url, username, password);
				
				String sql = "insert into forums (name, num_topics) values (?, ?);";
				
				PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				
				stmt.setString(1, name);
				
				stmt.setInt(2, 0);
				
				stmt.executeUpdate();
				
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

        response.sendRedirect( "DisplayForums" );
	}

}
