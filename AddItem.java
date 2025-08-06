package midterm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;

import midterm.model.Item;

/**
 * Servlet implementation class AddItem
 */
@WebServlet("/AddItem")
public class AddItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	request.getRequestDispatcher( "/WEB-INF/AddItem.jsp" )
        .forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Item> items = (List<Item>) getServletContext().getAttribute("items");
		
		List<String> stores = (List<String>) getServletContext().getAttribute("stores");
		
		int  id = generateItemId();
		
		String name = request.getParameter("itemName").trim();
		
		String store = request.getParameter("store").trim();
		
		if(!stores.contains(store))
			stores.add(store);
		
		items.add(new Item(name, store, id));
		
		Collections.sort(items);
		
		response.sendRedirect("ShoppingList");
	}
	
	
	@SuppressWarnings("unchecked")
	private int generateItemId() {
		
		List<Item> items = (List<Item>) getServletContext().getAttribute("items");
		
		int id = 0;

		// get max id of existing guest book entries
		for (Item item : items) 
		{
			if (item.getId() > id)
				id = item.getId();
		}

		return id+1;
	}

}
