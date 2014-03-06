package uprm.icom5016.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uprm.icom5016.daos.DataSourceException;
import uprm.icom5016.daos.ProductDAO;
import uprm.icom5016.dtos.Product;
import uprm.icom5016.services.GetProductService;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddToCartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String forwardURL = "./cart.jsp";
		Product p = new Product();
		ArrayList<Product> shoppingcart;
		ArrayList<String> itemQuantity;
		String productToCart = request.getParameter("productidshoppingcart");
		String productQuantity = ""+request.getParameter("productquantityshoppingcart");

		if(session.getAttribute("shoppingcart")==null){
			shoppingcart = new ArrayList<Product>();
			itemQuantity = new ArrayList<String>();
		}
		else{
			shoppingcart = (ArrayList<Product>)session.getAttribute("shoppingcart");
			itemQuantity = (ArrayList<String>)session.getAttribute("itemQuantity");
		}

		GetProductService service = GetProductService.newInstance();

		try {
			p = service.getProduct(productToCart);
		} catch (DataSourceException e) {

		}
		
		boolean check = true;
		String y = productToCart+"*"+productQuantity;

		for(Product e : shoppingcart){
			if(e.getPid().equals(productToCart)){
				check=false;
				for (String o : itemQuantity){
					if(o.substring(0, o.indexOf('*')).equals(productToCart)){
						int x = Integer.parseInt(o.substring(o.indexOf('*')+1)) + Integer.parseInt(productQuantity);
						String l = o.substring(0, o.indexOf('*'))+"*"+x;
						itemQuantity.remove(o);
						itemQuantity.add(l);
						break;
					}
				}
			}
		}
		if(check){
			shoppingcart.add(p);
			itemQuantity.add(y);
		}
		session.setAttribute("shoppingcart", shoppingcart);
		session.setAttribute("itemQuantity", itemQuantity);

		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
		dispatcher.forward(request, response);
	}

}
