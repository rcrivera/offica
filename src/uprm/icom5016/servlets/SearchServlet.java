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

import uprm.icom5016.dtos.Product;
import uprm.icom5016.services.ProductService;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String forwardURL = null;
		String searchQuery = request.getParameter("searchQuery");
		ProductService service = ProductService.newInstance();
		ArrayList<Product> searchResults = null;
		if(searchQuery.equals("")){
			forwardURL = "./nosearchmatch.jsp";
		}
		else{
			try {
				searchResults = service.getSearch(searchQuery);
			}
			catch(Exception e){
				//throw new ServletException("Internal Error", e);
				response.sendError(500, "Internal Server Error");
				return;
			}

			if (searchResults.isEmpty()){
				forwardURL = "./nosearchmatch.jsp"; //hacer esta pagina
			}
			else {
				session.setAttribute("list", searchResults);
				forwardURL = "./results.jsp";
			}
		}
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
