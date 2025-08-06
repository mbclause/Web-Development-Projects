package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DecimalFormat;

/**
 * Servlet implementation class CXCalculator
 */
@WebServlet("/CXCalculator")
public class CXCalculator extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private static DecimalFormat df2 = new DecimalFormat("#.##");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CXCalculator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	request.getRequestDispatcher("/WEB-INF/CXForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		double amount = Double.parseDouble(request.getParameter("amount"));
		
		String origAmount = request.getParameter("amount");
		
		String curr1 = request.getParameter("curr1");
		
		String curr2 = request.getParameter("curr2");
		
		double total = 0;
		
		if(!curr1.equals(curr2)) {
			// convert input amount to Euros
			if(!"EUR".equals(curr1)) {

				switch(curr1) {
			
				case "USD":
					amount = amount * 0.8385;
					break;
					
				case "JPY":
					amount = amount * 0.0077;
					break;
					
				case "GBP":
					amount = amount * 1.1635;
					break;
					
				default:
					break;
				}
			}
		
			// convert euros to curr2 to get final total
			switch(curr2) {
		
			case "USD":
				total = amount * 1.1926;
				break;
				
			case "JPY":
				total = amount * 129.8800;
				break;
				
			case "GBP":
				total = amount * 0.8595;
				break;
				
			case "EUR":
				total = amount;
				break;
				
			default:
				break;
			}
		}
		
		else {
			
			total = amount;
		}
		
		String finalAmount = df2.format(total);
		
		request.setAttribute("amount", origAmount);
		
		request.setAttribute("curr1", curr1);
		
		request.setAttribute("total", finalAmount);
		
		request.setAttribute("curr2", curr2);
		
		request.getRequestDispatcher("/WEB-INF/CXResult.jsp").forward(request, response);
	}

}
