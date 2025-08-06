package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CurrencyConverter")
public class CurrencyConverter extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public CurrencyConverter()
    {
        super();
    }

    
    
    public void init( ServletConfig config ) throws ServletException
    {
        super.init( config );

        Map<String, Double> data = new HashMap<String, Double>();

        try
        {
            // read file
            Scanner in;
            in = new Scanner( new File(
                getServletContext().getRealPath( "/WEB-INF/rates.txt" ) ) );
            while( in.hasNextLine() )
            {
                String line = in.nextLine();
                String tokens[] = line.split( " " );
                data.put( tokens[0], Double.valueOf( tokens[1] ) );
            }
            in.close();
        }
        catch( FileNotFoundException e )
        {
            throw new ServletException( e );
        }

        getServletContext().setAttribute( "data", data );
    }

    
    
    
    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	
    	request.getRequestDispatcher( "/WEB-INF/CurrencyGet.jsp" )
        .forward( request, response );
    }
    
    
    
    

    @SuppressWarnings("unchecked")
    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        Map<String, Double> data = (Map<String, Double>) getServletContext()
            .getAttribute( "data" );

        String c1 = request.getParameter( "c1" );
        String c2 = request.getParameter( "c2" );
        double amount = Double.parseDouble( request.getParameter( "amount" ) );
        double result = amount * data.get( c2 ) / data.get( c1 );
        
        getServletContext().setAttribute("result", result);
        
    	request.getRequestDispatcher( "/WEB-INF/CurrencyPost.jsp" )
        .forward( request, response );
    }

}
