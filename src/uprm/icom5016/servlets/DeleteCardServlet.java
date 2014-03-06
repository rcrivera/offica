package uprm.icom5016.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uprm.icom5016.daos.CreditCardStatus;
import uprm.icom5016.daos.DataSourceException;
import uprm.icom5016.services.CreditCardService;

/**
 * Servlet implementation class DeleteCardServlet
 */
@WebServlet("/DeleteCardServlet")
public class DeleteCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCardServlet() {
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
		String cardtoremove = request.getParameter("cardtoremove");
		String forwardURL = "./editcc.jsp";
		boolean deletecardcheck = false;
		
		CreditCardService service  = CreditCardService.newInstance();
		try {
			CreditCardStatus status = service.deleteCard(cardtoremove);
			deletecardcheck = true;
		} catch (DataSourceException e) {
			deletecardcheck = false;
		}
		
		session.setAttribute("deletecardcheck", deletecardcheck);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
		dispatcher.forward(request, response);
	}

}
