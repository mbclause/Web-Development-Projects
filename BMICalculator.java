package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DecimalFormat;

/**
 * Servlet implementation class BMICalculator
 */
@WebServlet("/BMICalculator")
public class BMICalculator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BMICalculator() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private static DecimalFormat df2 = new DecimalFormat("#.##");

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html><head><title>BMICalculator</title></head><body>");
		out.println("<html><head><title>Addition Practice</title></head><body>");
        out.println("<form action='BMICalculator' method='post'>");
        out.println("<p>Please enter your height: <input type='text' name='feet' value=''/> feet and "
        		+ "<input type='text' name='inches' value=''/> inches</p>");
        out.println("<p>Please enter your weight: <input type='text' name='weight' value=''/> pounds</p>");
        out.println("<input type='submit' value='Calculate BMI' />");
        out.println( "</form></body></html>" );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// height in inches
		double height = (Integer.parseInt(request.getParameter("feet")) * 12 ) + Integer.parseInt(request.getParameter("inches"));
		
		// weight in lbs
		double weight = Integer.parseInt(request.getParameter("weight"));
		
		// convert height to meters
		height = height * 0.0254;
		
		// convert weight to kilograms
		weight = weight * 0.4536;
		
		// BMI = weight / height ^ 2
		double BMI = weight / (height * height);
		
		String interpretation;
		
		if(BMI < 18.5) {
			interpretation = "underweight";
		}
		
		else if(BMI >= 18.5 && BMI < 25.0) {
			interpretation = "of normal weight";
		}
		
		else if(BMI >= 25.0 && BMI < 30.0) {
			interpretation = "overweight";
		}
		
		else {
			interpretation = "obese";
		}
		
		String bmi = df2.format(BMI);
		
		response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>BMICalculator</title></head><body>");
        out.println("<p> Your BMI is " + bmi + ". You are  " + interpretation + ".</p>");
        out.println("<a href='BMICalculator'>Back to BMI Calculator</a>");
		
		
	}

}
