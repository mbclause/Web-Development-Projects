package Controller;

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

@WebServlet("/AddComment")
public class AddComment extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public AddComment() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/AddComment.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get the user input
		String name = request.getParameter("name").trim();
		String comment = request.getParameter("comment").trim();

		// insert into DB
		Connection c = null;
		
		try 
		{
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu73?useSSL=false&allowPublicKeyRetrieval=true";
			
			String username = "cs3220stu73";
			
			String password = "tHBnsQpc29Gt";	
			
			c = DriverManager.getConnection(url, username, password);
			
			// Regular Statement: suffer SQL Injection Attack
			/*
			Statement stmt = c.createStatement();
			String sql = "insert into guestbooks (name, comment) values ('" + name + "', '" + comment +"');";
			System.out.println(sql);
			stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			*/
			
			// Prepared Statements: prevent SQL injection attack
			String sql = "insert into guestbooks (name, comment) values (?, ?);";
			
			PreparedStatement stmt =c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, name);
			
			stmt.setString(2, comment);
			
			stmt.executeUpdate();
			
			/*
			// print auto-generated key in Console
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next())
				System.out.println(rs.getInt(1));
			*/
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (c != null)
					c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// send the user back to the guest book page
		response.sendRedirect("GuestBook");
	}
}
