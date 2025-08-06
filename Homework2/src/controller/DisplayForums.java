package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Forum;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	request.getRequestDispatcher( "/WEB-INF/DisplayForums.jsp" )
        .forward( request, response );
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
