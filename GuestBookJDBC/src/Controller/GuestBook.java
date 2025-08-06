package Controller;

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

import Model.GuestBookEntry;

@WebServlet(urlPatterns = "/GuestBook", loadOnStartup = 1)
public class GuestBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GuestBook() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// guest book entries
		List<GuestBookEntry> gbEntries = new ArrayList<GuestBookEntry>();

		// get data from DB
		Connection c = null;
		
		try 
		{
				String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu73?useSSL=false&allowPublicKeyRetrieval=true";
				String username = "cs3220stu73";
				String password = "tHBnsQpc29Gt";
			
				c = DriverManager.getConnection(url, username, password);
				Statement stmt = c.createStatement();
				ResultSet rs = stmt.executeQuery("select * from guestbooks;");

				while (rs.next()) 
				{
					gbEntries.add(new GuestBookEntry(rs.getInt("id"), rs.getString("name"), rs.getString("comment")));
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

		// send data to view
		request.setAttribute("gbEntries", gbEntries);
		request.getRequestDispatcher("/WEB-INF/GuestBook.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
