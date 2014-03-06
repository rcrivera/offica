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
import uprm.icom5016.dtos.Return;
import uprm.icom5016.services.ReturnService;

/**
 * Servlet implementation class ViewReturnsServlet
 */
@WebServlet("/ViewReturnsServlet")
public class ViewReturnsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewReturnsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String forwardURL = "./returns.jsp";
		ArrayList<Return> returns = new ArrayList<Return>();
		
		ReturnService service = ReturnService.newInstance();
		
		try {
			returns = service.getReturnReqs();
		} catch (DataSourceException e) {
			response.sendError(500, "Internal Server Error");
			return;
		}
		
		session.setAttribute("returnsReqList", returns);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
