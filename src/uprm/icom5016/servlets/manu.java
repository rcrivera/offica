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
 * Servlet implementation class manu
 */
@WebServlet("/manu")
public class manu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public manu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String forwardURL = "";
		String tochange = "";
		User u = (User)session.getAttribute("user");
		UserService service = UserService.newInstance();
		boolean x = false;
		String y = request.getParameter("caller");
		
		if(y.equals("phone")){
			forwardURL = "./editnumber.jsp";
			tochange = request.getParameter("newphone");
			x = service.editPhone(tochange, u);
		}
		else if(y.equals("email")){
			forwardURL = "./editemail.jsp";
			tochange = request.getParameter("newemail");
			x = service.editEmail(tochange, u);
		}

		session.setAttribute("editcheck", x);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
		dispatcher.forward(request, response);
	}

}
