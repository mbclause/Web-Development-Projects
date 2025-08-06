package midterm.controller;

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

import midterm.model.Department;
import midterm.model.Faculty;

@WebServlet(urlPatterns = "/DisplayFaculty", loadOnStartup = 1)
public class DisplayFaculty extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public DisplayFaculty()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	
    	List<Department> departments = new ArrayList<Department>();
    	
    	Faculty    facultyMem;
    	
    	Department department;
    	
    	int id = 0;
    	
    	Connection c = null;
    	

		
		try 
		{
				String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu73?useSSL=false&allowPublicKeyRetrieval=true";
				
				String username = "cs3220stu73";
				
				String password = "tHBnsQpc29Gt";
			
				c = DriverManager.getConnection(url, username, password);
				
				Statement stmt = c.createStatement();
				
				Statement stmt2 = c.createStatement();
				
				ResultSet rs = stmt.executeQuery("select * from departments;");
				
				ResultSet rs2;

				while (rs.next()) 
				{
					List<Faculty> faculty = new ArrayList<Faculty>();
					
					department = new Department(rs.getString("name"));
					
					id = rs.getInt("id");
					
					rs2 = stmt2.executeQuery("select * from faculty where department_id = " + id + ";");
					
					while(rs2.next())
					{	
						facultyMem = new Faculty(rs2.getString("name"));
						
						if(rs2.getInt("is_chair") == 1)
							facultyMem.setChair(true);
						
						else
							facultyMem.setChair(false);
						
						faculty.add(facultyMem);	
					}
					
					if(!faculty.isEmpty())
						department.setFaculty(faculty);
					
					departments.add(department);
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
		

		
		getServletContext().setAttribute("departments", departments);
    	
        request.getRequestDispatcher( "/WEB-INF/midterm/DisplayFaculty.jsp" )
            .forward( request, response );
    }

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        doGet( request, response );
    }

}
