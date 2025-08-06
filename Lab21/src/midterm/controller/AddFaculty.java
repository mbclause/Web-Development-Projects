package midterm.controller;

import java.io.IOException;
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

@WebServlet("/AddFaculty")
public class AddFaculty extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public AddFaculty()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        request.getRequestDispatcher( "/WEB-INF/midterm/AddFaculty.jsp" )
            .forward( request, response );
    }

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        String departmentName = request.getParameter( "department" );
        
        String name = request.getParameter( "faculty" );
        
        int id = 0;
        
        int isChair = 0;
        
        if( request.getParameter( "chair" ) != null )
        	isChair = 1;

        Connection c = null;
		
		try 
		{
				String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu73?useSSL=false&allowPublicKeyRetrieval=true";
				
				String username = "cs3220stu73";
				
				String password = "tHBnsQpc29Gt";
			
				c = DriverManager.getConnection(url, username, password);
				
				Statement stmt = c.createStatement();
				
				ResultSet rs = stmt.executeQuery("select id from departments where name = '" + departmentName + "';");
				
				if(rs.next())
					id = rs.getInt("id");
				
				String sql = "insert into faculty (name, department_id, is_chair) values (?, ?, ?);";
				
				PreparedStatement stmt2 = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				
				stmt2.setString(1, name);
				
				stmt2.setInt(2, id);
				
				stmt2.setInt(3, isChair);
				
				stmt2.executeUpdate();	
			
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

        response.sendRedirect( "DisplayFaculty" );
    }

}
