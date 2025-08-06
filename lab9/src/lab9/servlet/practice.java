package lab9.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class practice
 */
@WebServlet("/practice")
public class practice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public practice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	Random rand = new Random();
    	int int1 = rand.nextInt(9) + 1;
    	int int2 = rand.nextInt(9) + 1;
    	
		ServletContext servletContext = getServletContext();
		servletContext.setAttribute("a", int1);
		servletContext.setAttribute("b", int2);
		
		response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html><head><title>practice</title></head><body>" );
        out.println( "<form action='practice' method='post'>" );
        out.println( "<p>" + int1 + " + " + int2 + " = <input type='text' name='answer' /> <input type='submit' value='Check Answer' /></p>" );
        out.println( "</form></body></html>" );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext servletContext = getServletContext();
		
    	int a = (int) servletContext.getAttribute("a");
        int b = (int) servletContext.getAttribute("b");
        
        int correctAnswer = a + b;
        
        int userAnswer = Integer.parseInt(request.getParameter("answer"));
        
        boolean isCorrect = (correctAnswer == userAnswer);
        
        String correct;
        
        if (isCorrect) {
        	correct = "correct";
        }
        
        else {
        	correct = "incorrect";
        }

        response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html><head><title>Addition</title></head><body>" );
        out.println( "<p>" + a + " + " + b + " = " + correctAnswer + "</p>" );
        out.println("<p> Your answer " + userAnswer + " is " + correct + "</p>");
        out.println( "<a href='practice'>Try Again</a>");
        out.println( "</body></html>" );
	}

}
