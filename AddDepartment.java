package midterm.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddDepartment")
public class AddDepartment extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public AddDepartment()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        request.getRequestDispatcher( "/WEB-INF/midterm/AddDepartment.jsp" )
            .forward( request, response );
    }

    //@SuppressWarnings("unchecked")
    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	String name = request.getParameter("name").trim();
    	
		Connection c = null;
		
		try 
		{
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu73?useSSL=false&allowPublicKeyRetrieval=true";
			
			String username = "cs3220stu73";
			
			String password = "tHBnsQpc29Gt";	
			
			c = DriverManager.getConnection(url, username, password);
			
			String sql = "insert into departments (name) values (?);";
			
			PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, name);
			
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
    	
        //Department department = new Department(request.getParameter( "name" ) );
        
        //((List<Department>) getServletContext().getAttribute( "departments" )).add( department );
        
        response.sendRedirect( "DisplayFaculty" );
    }

}
