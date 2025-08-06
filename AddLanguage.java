package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Language;

/**
 * Servlet implementation class AddLanguage
 */
@WebServlet("/AddLanguage")
public class AddLanguage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLanguage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	request.getRequestDispatcher( "/WEB-INF/AddLanguage.jsp" )
        .forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name").trim();
		
		List<Language> languages = (List<Language>) getServletContext().getAttribute("languages");
		
		languages.add(new Language(name));
		
		getServletContext().setAttribute("languages", languages);
		
		response.sendRedirect("DisplayPoll");
	}

}
