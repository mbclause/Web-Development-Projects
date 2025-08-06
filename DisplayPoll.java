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

import model.Language;

/**
 * Servlet implementation class DisplayPoll
 */
@WebServlet(urlPatterns = "/DisplayPoll", loadOnStartup = 1)
public class DisplayPoll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayPoll() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    @Override
    public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		List<Language> languages = new ArrayList<Language>();
		
		languages.add(new Language("Java"));
		
		languages.add(new Language("Python"));
		
		languages.add(new Language("JavaScript"));
		
		getServletContext().setAttribute("languages", languages);
    }
    
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	request.getRequestDispatcher( "/WEB-INF/DisplayPoll.jsp" )
        .forward( request, response );
	}

    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    @SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	List<Language> languages = (List<Language>) getServletContext().getAttribute("languages");
    	
    	for(Language language : languages)
    	{
    		if(request.getParameter(language.getName()) != null)
    			language.incNumPeople();
    	}
    	
    	
    	response.sendRedirect("DisplayResults");
	}

}
