package uprm.icom5016.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uprm.icom5016.daos.DataSourceException;
import uprm.icom5016.dtos.CreditCard;
import uprm.icom5016.dtos.User;
import uprm.icom5016.services.CreditCardService;

/**
 * Servlet implementation class AddCCServlet
 */
@WebServlet("/AddCCServlet")
public class AddCCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCCServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String forwardURL = null;

		User user = (User) session.getAttribute("user");

		String username = user.getUserName();
		String cardno = request.getParameter("newcardNumber"); 
		String cardholder = request.getParameter("newcardHolder"); 
		String type = request.getParameter("newcardType"); 
		String expmonth = request.getParameter("newcardExpM"); 
		String expyear = request.getParameter("newcardExpY"); 
		String cvv = request.getParameter("newcardCVV");
		boolean addcardsuccess = false;

		CreditCard card = new CreditCard(cardno, cardholder, type, expmonth, expyear, cvv, username);

		CreditCardService service = CreditCardService.newInstance();
		try{
			service.addCard(card);
			addcardsuccess = true;
		} 
		catch (DataSourceException e) {
			addcardsuccess = false;
		}
		forwardURL = "./cardadded.jsp";
		
		session.setAttribute("addcardsuccess", addcardsuccess);
		session.setAttribute("cardsuccess", card);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
		dispatcher.forward(request, response);
	}

}
