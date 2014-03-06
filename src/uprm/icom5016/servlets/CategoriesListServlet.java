package uprm.icom5016.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uprm.icom5016.dtos.Product;
import uprm.icom5016.services.BrowseService;

/**
 * Servlet implementation class CategoriesList
 */
@WebServlet("/CategoriesList")
public class CategoriesListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategoriesListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String forwardURL = null;
		String cat = request.getParameter("cat");
		String category;
		ArrayList<String> subcategories = new ArrayList<String>();
		if(cat.equals("paper")){
			String subcat []={"Copy Paper","copypaper","Resume Paper","resumepaper","Photo Paper","photopaper","Business Card Paper","businesspaper"};
			for (String s : subcat) {  
				subcategories.add(s);
			}  
			category = "Paper";
		}
		else if(cat.equalsIgnoreCase("stationary")){
			String subcat []={"Labels","labels","Envelopes","envelopes","Boxes","boxes","File Folders","filefolders","Binders","binders"};
			for (String s : subcat) {  
				subcategories.add(s);  
			}  
			category = "Stationary";
		}
		else if(cat.equalsIgnoreCase("officesupplies")){
			String subcat []={"Pencils","pencils","Pens","pens","Markers","markers","Erasers","erasers","Rubber Bands","rubberbands","Staples","staples","Staple Machines","staplemachines","Paper Clips","paperclips"};
			for (String s : subcat) {  
				subcategories.add(s);  
			}  
			category = "Office Supplies";
		}
		else if(cat.equalsIgnoreCase("electronics")){
			String subcat []={"Laptops","laptops","Desktops","desktops","Cameras","cameras","Tablets","tablets","Calculators","calculators","Printers","printers"};
			for (String s : subcat) {  
				subcategories.add(s);  
			}  
			category = "Electronics";
		}
		else if(cat.equalsIgnoreCase("electronicsupplies")){
			String subcat []={"Internal Disks","internaldisks","External Disks","externaldisks","Memory","memory","Ink Cartridges","inkcartridges","Toner","toner"};
			for (String s : subcat) {  
				subcategories.add(s);  
			}  
			category = "Electronic Supplies";
		}
		else if(cat.equalsIgnoreCase("furniture")){
			String subcat []={"Desks","desks","Chairs","chairs","Mats","mats","Lamps","lamps","Bookshelves","bookshelves","File Cabinets","filecabinets"};
			for (String s : subcat) {  
				subcategories.add(s);  
			}  
			category = "Furniture";
		}
		else{//cleaningsupplies
			String subcat []={"Hand Sanitizer","handsanitizer","Soap","soap","Paper Towel","papertowel","Tissue Paper","tissuepaper","Trash Bags","trashbags","Disinfectant","disinfectant"};
			for (String s : subcat) {  
				subcategories.add(s);  
			}
			category = "Cleaning Supplies";
		}
		session.setAttribute("category", cat);
		session.setAttribute("cat", category);
		session.setAttribute("subcategories", subcategories);
		forwardURL = "./categories.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
		dispatcher.forward(request, response);
	}

/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
}

}
