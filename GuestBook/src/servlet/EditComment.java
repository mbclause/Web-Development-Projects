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

@WebServlet("/EditComment")
public class EditComment extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public EditComment() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get the entry to be edited
		int id = Integer.parseInt(request.getParameter("id"));
		GuestBookEntry gbEntry = getGuestBookEntry(id);

		// the input id is invalid, go to display GuestBook
		if (gbEntry == null) {
			// send the user back to the guest book page
			response.sendRedirect("Display");
		} else {
			// display form
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>");
			out.println("<html><head><title>Edit Comment</title></head><body>");
			out.println("<h2>Edit Comment</h2>");

			out.println("<form action='EditComment' method='post'>");
			// hidden form field for id
			out.println("<input type='hidden' name='id' value='" + id + "' />");
			out.println("<table border='1'>");
			out.println(
					"<tr><td style='padding:3px;'>Name:</td> <td style='padding:3px;'><input type='text' name='name' value='"
							+ gbEntry.getName() + "'/></td></tr>");
			out.println("<tr><td style='padding:3px;'>Comments:</td> <td style='padding:3px;'><textarea name='comment'>"
					+ gbEntry.getComment() + "</textarea></td></tr>");
			out.println(
					"<tr><td style='padding:3px;'><input type='submit' name='save' value='Save'/></td><td style='padding:3px;'><input type='reset' value='Reset'/></td></tr>");
			out.println("</table>");
			out.println("</form>");

			out.println("<p><a href='Display'>Go Back</a></p>");
			out.println("</body></html>");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get the entry to be edited
		int id = Integer.parseInt(request.getParameter("id"));
		GuestBookEntry gbEntry = getGuestBookEntry(id);

		// change the entry based on user input
		gbEntry.setName(request.getParameter("name"));
		gbEntry.setComment(request.getParameter("comment"));

		// send the user back to the guest book page
		response.sendRedirect("Display");
	}

	/**
	 * Given an id, retrieve the GuestBookEntry.
	 */
	@SuppressWarnings("unchecked")
	private GuestBookEntry getGuestBookEntry(int id) {
		List<GuestBookEntry> gbEntries = (List<GuestBookEntry>) getServletContext().getAttribute("gbEntries");

		for (GuestBookEntry gbEntry : gbEntries) {
			if (gbEntry.getId() == id)
				return gbEntry;
		}

		return null;
	}

}
