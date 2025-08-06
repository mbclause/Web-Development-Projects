package controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import model.Question;

/**
 * Servlet implementation class DrivingTestBrowser
 */
@WebServlet("/DrivingTestBrowser")
public class DrivingTestBrowser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DrivingTestBrowser() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	
		super.init(config);
		
		String description = "";
		
		String answerA = "";
		
		String answerB = "";
		
		String answerC = "";
		
		@SuppressWarnings("unused")
		String blank = "";
		
		int    correctAnswer = 0;
		
		List<Question> questions = new ArrayList<Question>();
		
		String path = getServletContext().getRealPath("/WEB-INF/DrivingTest.txt");
		
		try {
			
			Scanner in = new Scanner(new File(path));
		
			while(in.hasNextLine()) {
				
				description = in.nextLine();
				
				answerA = in.nextLine();
				
				answerB = in.nextLine();
				
				answerC = in.nextLine();
				
				correctAnswer = Integer.parseInt(in.nextLine());
				
				blank = in.nextLine();
				
				questions.add(new Question(description, answerA, answerB, answerC, correctAnswer));
			}
			
			in.close();
		}
        
        
        catch( IOException e )
        {
        	throw new ServletException(e);
        }
		
		getServletContext().setAttribute("questions", questions);
		
		getServletContext().setAttribute("size", questions.size());
    }

    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String index = request.getParameter("index");
    	
    	if(index == null)
    		index = "0";
    	
    	int intIndex = Integer.parseInt(index);
    	
    	int size = (int) getServletContext().getAttribute("size");
    	
    	if(intIndex == size)
    		intIndex = 0;
    	
    	request.setAttribute("index", intIndex);
    	
    	request.getRequestDispatcher( "/WEB-INF/DisplayQuestion.jsp" )
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
