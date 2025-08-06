package midterm.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;

import midterm.model.Item;

/**
 * Servlet implementation class ShoppingList
 */
@WebServlet(urlPatterns = "/ShoppingList", loadOnStartup = 1)
public class ShoppingList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingList() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		List<String> stores = new ArrayList<String>();
		
		List<Item> items = new ArrayList<Item>();
		
		stores.add("Costco");
		
		stores.add("Ralphs");
		
		items.add(new Item("Bottled Water", "Costco", 1));
		
		items.add(new Item("Milk", "Costco", 2));
		
		items.add(new Item("Potato", "Ralphs", 3));
		
		getServletContext().setAttribute("items", items);
		
		getServletContext().setAttribute("stores", stores);
    }

    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	request.getRequestDispatcher( "/WEB-INF/ShoppingList.jsp" )
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
