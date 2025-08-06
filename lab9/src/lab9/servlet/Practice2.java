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
 * Servlet implementation class Practice2
 */
@WebServlet("/Practice2")
public class Practice2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	int a;
	
	int b;
	
	public void setRand() {
		Random rand = new Random();
		a = rand.nextInt(9) + 1;
		b = rand.nextInt(9) + 1;
	}
	
    public Practice2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Practice2 one = new Practice2();
		
		one.setRand();
		
		response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html><head><title>practice</title></head><body>" );
        out.println( "<form action='practice' method='post'>" );
        out.println( "<p>" + one.a + " + " + one.b + " = <input type='text' name='answer' /> <input type='submit' value='Check Answer' /></p>" );
        out.println( "</form></body></html>" );
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
	}

}
