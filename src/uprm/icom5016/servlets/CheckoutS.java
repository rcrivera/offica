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

import uprm.icom5016.daos.CreditCardDAO;
import uprm.icom5016.dtos.Checkout;
import uprm.icom5016.dtos.CreditCard;
import uprm.icom5016.dtos.Product;
import uprm.icom5016.dtos.User;
import uprm.icom5016.services.CheckoutService;

/**
 * Servlet implementation class CheckoutS
 */
@WebServlet("/CheckoutS")
public class CheckoutS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckoutS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String forwardURL = null;
		Integer checkedIn = (Integer) session.getAttribute("checkedIn");
		if(checkedIn!=null && checkedIn!=0){//user logged in
			String card = (String)request.getParameter("ccard");
			User user = (User)session.getAttribute("user");
			CreditCardDAO dao = new CreditCardDAO();
			ArrayList<Product> products = (ArrayList<Product>) session.getAttribute("shoppingcart");
			ArrayList<String> quantityList = (ArrayList<String>) session.getAttribute("itemQuantity");
			if(card==null){
				ArrayList<CreditCard> cards = dao.getCards(user.getUserName());
				forwardURL = "./cart.jsp";
				session.setAttribute("cards", cards);
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
			
			else{
		
				CreditCard ccard=dao.getCard(card);
				ArrayList<Integer> quantity = new ArrayList<Integer>();
				for(int i=0;i<quantityList.size();i++){
					quantity.add(Integer.parseInt(quantityList.get(i).substring(quantityList.get(i).indexOf('*')+1)));
				}
				CheckoutService service =CheckoutService.newInstance();
				Checkout checkout = new Checkout(user, ccard, quantity, products);
				try{
					service.processCheckout(checkout);					
				}
				catch(Exception e){
				}
				forwardURL = "./invoice.jsp";
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
				
				
			}
		}
		else{
			forwardURL = "./pleaselogin.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

