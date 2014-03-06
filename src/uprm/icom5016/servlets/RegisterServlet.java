package uprm.icom5016.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uprm.icom5016.dtos.User;
import uprm.icom5016.services.UserService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
	String forwardURL = "./RegisterSuccess.jsp";
	
	boolean check = false;
	String username = request.getParameter("regUsername");
	String pass = request.getParameter("regPass");
	String first = request.getParameter("regFirstName");
	String last = request.getParameter("regLastName");
	String email = request.getParameter("regEmail");
	String phone = request.getParameter("regPhone");
	String address = request.getParameter("regAdd");
	String city = request.getParameter("regCity");
	String state = request.getParameter("regState");
	String zipcode = request.getParameter("regZip");
	String country = request.getParameter("regCountry");
	
	User user = new User(username, pass, first, last, email, phone, address, city, state, zipcode, country, "false");
	UserService service = UserService.newInstance();
	
	try{
		service.addUser(user);
		check=true;
	}
	catch(Exception e){
		check=false;
	}
	
	session.setAttribute("newuser", user);
	session.setAttribute("newusercheck", check);
	RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
	dispatcher.forward(request, response);
	}

}
