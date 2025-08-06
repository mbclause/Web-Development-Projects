package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.GuestBookEntry;

@WebServlet("/DeleteComment")
public class DeleteComment extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public DeleteComment() {
		super();
	}

	@Override
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get id of entry to be deleted
		int id = Integer.parseInt(request.getParameter("id"));

		// delete the entry
		List<GuestBookEntry> gbEntries = (List<GuestBookEntry>) getServletContext().getAttribute("gbEntries");
		for (GuestBookEntry gbEntry : gbEntries) {
			if (gbEntry.getId() == id) {
				gbEntries.remove(gbEntry);
				break;
			}
		}

		response.sendRedirect("Display");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
