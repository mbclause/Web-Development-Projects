package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.GuestBookEntry;

@WebServlet("/AddComment")
public class AddComment extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public AddComment() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// display form
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html><head><title>Add Comment</title></head><body>");
		out.println("<h2>Add Comment</h2>");

		out.println("<form action='AddComment' method='post'>");
		out.println("<table border='1'>");
		out.println(
				"<tr><td style='padding:3px;'>Name:</td> <td style='padding:3px;'><input type='text' name='name'/></td></tr>");
		out.println(
	"<tr><td style='padding:3px;'>Comments:</td> <td style='padding:3px;'><textarea name='comment' rows='5' cols='40'></textarea></td></tr>");
		out.println(
"<tr><td style='padding:3px;'><input type='submit' name='add' value='Add'/></td><td style='padding:3px;'><input type='reset' value='Reset'/></td></tr>");
		out.println("</table>");
		out.println("</form>");

		out.println("<p><a href='Display'>Go Back</a></p>");
		out.println("</body></html>");
	}

	@Override
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get the user input
		String name = request.getParameter("name").trim();
		String comment = request.getParameter("comment").trim();

		// get guest book entries from application scope
		List<GuestBookEntry> gbEntries = (List<GuestBookEntry>) getServletContext().getAttribute("gbEntries");

		// create a new guest book entry
		int id = generateGuestBookEntryId();
		GuestBookEntry gbEntry = new GuestBookEntry(id, name, comment);

		// add the new entry to the guest book
		gbEntries.add(gbEntry);

		// send the user back to the guest book page
		response.sendRedirect("Display");
	}

	/**
	 * Generate an id for the new GuestBookEntry to be added new id = existing max
	 * id + 1
	 */
	@SuppressWarnings("unchecked")
	private int generateGuestBookEntryId() {
		List<GuestBookEntry> gbEntries = (List<GuestBookEntry>) getServletContext().getAttribute("gbEntries");
		int id = 0;

		// get max id of existing guest book entries
		for (GuestBookEntry gbEntry : gbEntries) {
			if (gbEntry.getId() > id)
				id = gbEntry.getId();
		}

		return id+1;
	}

}
