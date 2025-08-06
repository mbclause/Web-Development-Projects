package lab9.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdditionPractice
 */
@WebServlet("/AdditionPractice")
public class AdditionPractice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdditionPractice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	Random rand = new Random();
    	int a = rand.nextInt(9) + 1;
    	int b = rand.nextInt(9) + 1;
        response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html><head><title>Addition Practice</title></head><body>" );
        out.println( "<form action='AdditionPractice' method='post'>" );
        out.println( "<input type='hidden' name='a' value='" + a +"'/>" );
        out.println( "<input type='hidden' name='b' value='" + b + "'/>" );
        out.println( "<p>" + a + " + " + b + " = <input type='text' name='answer' /> <input type='submit' value='Check Answer' /></p>" );
        out.println( "</form></body></html>" );
    }
    
    @Override
    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	int a = Integer.parseInt(request.getParameter("a"));
        int b = Integer.parseInt(request.getParameter("b"));
        
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
        out.println( "<a href='AdditionPractice'>Try Again</a>");
        out.println( "</body></html>" );
        
        Random rand = new Random();
        
        a = rand.nextInt(9) + 1;
        b = rand.nextInt(9) + 1;
    }

}