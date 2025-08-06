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

import data.Forum;

/**
 * Servlet implementation class DisplayForums
*/
@WebServlet(urlPatterns = "/DisplayForums", loadOnStartup = 1)
public class DisplayForums extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayForums() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    // init method
    @Override
    public void init(ServletConfig config) throws ServletException {
		super.init(config);

		// create the default forums
		List<Forum> forums = new ArrayList<Forum>();
		forums.add(new Forum(1, "General Discussion"));
		forums.add(new Forum(2, "CS3220 Web Programming"));
		
		// store list in application scope
		getServletContext().setAttribute("forums", forums);
	}
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	*/
	@Override
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get list of forums forums from application scope
		List<Forum> forums = (List<Forum>) getServletContext().getAttribute("forums");
		
		// generate forums web page
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html><head><title>DisplayForums</title></head><body>");
		out.println("<h2>All Forums</h2>");

		out.println("<table border='1'>");
		out.println("<tr><th>Forum</th><th>Topics</th></tr>");
		
		// display forums
		for(Forum forum : forums) {
			
			out.println("<tr><td><a href='DisplayTopics?id=" + forum.getForumID() + "'>" + forum.getForumName() + "</a></td><td>" 
			+ forum.getNumTopics() + "</td></tr>");
		}
		
		out.println("</table>");
		out.println("</body></html>");
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
