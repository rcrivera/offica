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
import uprm.icom5016.dtos.User;
import uprm.icom5016.services.UserService;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String forwardURL = null;
		Integer checkedIn=0;
		String username = request.getParameter("username");
		String pass = request.getParameter("pass");
		UserService service = UserService.newInstance();
		User user = new User();
		
		try {
			user=service.getUser(username);
			if(user.getUserName()==null){
				checkedIn = 0;
				forwardURL="./usernotfound.jsp";
			}
			else if(pass.equals(user.getPass())){
				checkedIn=1;
				forwardURL="./loginsuccess.jsp";
				session.setAttribute("user", user);
			}
			else{
				checkedIn=-1;
				forwardURL="./loginfailed.jsp";
			}
		} catch (DataSourceException e) {
			response.sendError(500, "Internal Server Error");
			return;
		}
		
		session.setAttribute("checkedIn", checkedIn);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
		dispatcher.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet( request,  response) ;
	}

}
