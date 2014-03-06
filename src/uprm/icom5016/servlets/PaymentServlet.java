package uprm.icom5016.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PaymentServlet
 */
@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String forwardURL = null;
		String payment = request.getParameter("ccard");
		String address = request.getParameter("address");
		
		
		int index=address.indexOf("*");
		String addr1 = address.substring(0,index);
		String temp = address.substring(index+1, address.length());
		session.setAttribute("addr1", addr1);
		
		index=temp.indexOf("*");
		String addr2 = temp.substring(0, index);
		session.setAttribute("addr2", addr2);
		
		String addr3 = temp.substring(index+1, temp.length());
		session.setAttribute("addr3", addr3);
		
		session.setAttribute("payment", payment);
		
		forwardURL="./invoice.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
		dispatcher.forward(request, response);
	}

}
