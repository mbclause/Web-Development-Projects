package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet(urlPatterns = "/Login", loadOnStartup = 1)
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		String defaultUser = "cguo";
		
		String defaultPassword = "123456";
		
		getServletContext().setAttribute("defaultUser", defaultUser);
		
		getServletContext().setAttribute("defaultPassword", defaultPassword);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html><head><title>Login</title></head><body>");

		out.println("<form action='Login' method='post'>");
		out.println("<p>Username: <input type='text' name='user'/><br><br>");
		out.println("Password: <input type='password' name='password'/><br></p>");
		out.println("<input type='submit' name='submit' value='Login'/>");
		
		out.println("</form></body></html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("user");
		
		String password = request.getParameter("password");
		
		String correctUser = (String) getServletContext().getAttribute("defaultUser");
		
		String correctPassword = (String) getServletContext().getAttribute("defaultPassword");
		
		if(username.equals(correctUser) && password.equals(correctPassword)) {
			
			HttpSession session = request.getSession();
			
			session.setAttribute("user", username);
			
			response.sendRedirect("Members");
		}
		
		else {
			
			response.sendRedirect("Login");
		}
	}

}
