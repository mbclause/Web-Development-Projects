package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteComment")
public class DeleteComment extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public DeleteComment() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get id of entry to be deleted
		int id = Integer.parseInt(request.getParameter("id"));

		// delete from DB
		Connection c = null;
		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu73?useSSL=false&allowPublicKeyRetrieval=true";
			String username = "cs3220stu73";
			String password = "tHBnsQpc29Gt";
			
			c = DriverManager.getConnection(url, username, password);			
			Statement stmt = c.createStatement();
			String sql = "delete from guestbooks where id = " + id + ";";
			stmt.executeUpdate(sql);
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

		response.sendRedirect("GuestBook");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
