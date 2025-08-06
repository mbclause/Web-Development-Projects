package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Members
 */
@WebServlet("/Members")
public class Members extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Members() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String user = (String) request.getSession().getAttribute("user");
		
		if(user != null) {
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			out.println("<!DOCTYPE html>");
			out.println("<html><head><title>Members</title></head><body>");
			out.println("<h2>Hi, " + user + ". Welcome to the Members Area</h2>");
			out.println("<a href='Logout'>Logout</a>");	
			out.println("</body></html>");
		}
		
		else {
			
			response.sendRedirect("Login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
