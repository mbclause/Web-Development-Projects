package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.GuestBookEntry;

@WebServlet(urlPatterns = "/Display", loadOnStartup = 1)
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Display() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		// create some test data for display
		List<GuestBookEntry> gbEntries = new ArrayList<GuestBookEntry>();
		gbEntries.add(new GuestBookEntry(1, "John", "Hello!"));
		gbEntries.add(new GuestBookEntry(2, "Jane", "Your website looks nice."));
		gbEntries.add(new GuestBookEntry(3, "Joe", "Nice to meet you. I'm from LA."));

		// stored the data in application scope
		getServletContext().setAttribute("gbEntries", gbEntries);
	}

	@Override
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get the data
		List<GuestBookEntry> gbEntries = (List<GuestBookEntry>) getServletContext().getAttribute("gbEntries");

		// display it
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html><head><title>Display</title></head><body>");
		out.println("<h2>My Guest Book</h2>");

		out.println("<table border='1'>");
		for (GuestBookEntry gbEntry : gbEntries) {
			out.println("<tr><td style='padding:3px;'>" + gbEntry.getName() + " says:</td><td style='padding:3px;'>"
					+ gbEntry.getComment() + "</td><td style='padding:3px;'><a href='EditComment?id=" + gbEntry.getId()
					+ "'>Edit</a>&nbsp; | &nbsp;<a href='DeleteComment?id=" + gbEntry.getId()
					+ "'>Delete</a></td></tr>");
		}
		out.println("</table>");

		out.println("<p><a href='AddComment'>Add Comment</a></p>");
		out.println("</body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
