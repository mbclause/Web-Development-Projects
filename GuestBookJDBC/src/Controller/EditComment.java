package Controller;

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

import Model.GuestBookEntry;

@WebServlet("/EditComment")
public class EditComment extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public EditComment() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get id
		int id = Integer.parseInt(request.getParameter("id"));

		// guest book entry
		GuestBookEntry gbEntry = null;

		// get data from DB
		Connection c = null;
		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu73?useSSL=false&allowPublicKeyRetrieval=true";
			String username = "cs3220stu73";
			String password = "tHBnsQpc29Gt";

			c = DriverManager.getConnection(url, username, password);
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("select * from guestbooks where id = " + id + ";");

			if (rs.next()) {
				gbEntry = new GuestBookEntry(rs.getInt("id"), rs.getString("name"), rs.getString("comment"));
			}
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

		// the input id is invalid, go to display GuestBook
		if (gbEntry == null) {
			request.getRequestDispatcher("/WEB-INF/GuestBook.jsp").forward(request, response);
		} else {
			request.setAttribute("gbEntry", gbEntry);
			request.getRequestDispatcher("/WEB-INF/EditComment.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get the user input
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name").trim();
		String comment = request.getParameter("comment").trim();

		// update into DB
		Connection c = null;
		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu73?useSSL=false&allowPublicKeyRetrieval=true";
			String username = "cs3220stu73";
			String password = "tHBnsQpc29Gt";
			c = DriverManager.getConnection(url, username, password);

			// Prepared Statements: prevent SQL injection attack
			String sql = "update guestbooks set name = ?, comment = ? where id = " + id + ";";
			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, comment);
			pstmt.executeUpdate();
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
