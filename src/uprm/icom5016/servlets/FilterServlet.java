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

/**
 * Servlet implementation class FilterServlet
 */
@WebServlet("/FilterServlet")
public class FilterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FilterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String forwardURL = "./filterresults.jsp";
		ArrayList<String> toPrint = (ArrayList<String>) session.getAttribute("filterlist");
		ArrayList<Product> list = (ArrayList<Product>) session.getAttribute("list");
		ArrayList<Product> toReturn = new ArrayList<Product>();

		String p1 = (String) request.getParameter("p1");
		String p2 = (String) request.getParameter("p2");
		String p3 = (String) request.getParameter("p3");
		String p4 = (String) request.getParameter("p4");
		String p5 = (String) request.getParameter("p5");



		String filter1=null;
		String filter2=null;
		String filter3=null;
		String filter4=null;
		String filter5=null;

		String att1 = null;
		String att2 = null;
		String att3 = null;
		String att4 = null;
		String att5 = null;

		if(		p1.equalsIgnoreCase("null")&&p2==null&&p3==null&&p4==null&&p5==null ||
				p1.equalsIgnoreCase("null")&&p2.equalsIgnoreCase("null")&&p3==null&&p4==null&&p5==null ||
				p1.equalsIgnoreCase("null")&&p2.equalsIgnoreCase("null")&&p3.equalsIgnoreCase("null")&&p4==null&&p5==null ||
				p1.equalsIgnoreCase("null")&&p2.equalsIgnoreCase("null")&&p3.equalsIgnoreCase("null")&&p4.equalsIgnoreCase("null")&&p5==null ||
				p1.equalsIgnoreCase("null")&&p2.equalsIgnoreCase("null")&&p3.equalsIgnoreCase("null")&&p4.equalsIgnoreCase("null")&&p5.equalsIgnoreCase("null")){
			
					forwardURL = "./subcategories.jsp";
					RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
					dispatcher.forward(request, response);
		}
		else{
			for(String s: toPrint){
				String value = s.substring(0, s.indexOf('*'));
				String att = s.substring(s.indexOf('*')+1,s.length());

				if(p1.equalsIgnoreCase(value)){
					filter1=value;
					att1=att;
				}
				if(p2!=null && p2.equalsIgnoreCase(value)){
					filter2=value;
					att2=att;
				}
				if(p3!=null && p3.equalsIgnoreCase(value)){
					filter3=value;
					att3=att;
				}
				if(p4!=null && p4.equalsIgnoreCase(value)){
					filter4=value;
					att4=att;
				}
				if(p5!=null && p5.equalsIgnoreCase(value)){
					filter5=value;
					att5=att;
				}	
			}

			for(Product p : list){	
				if(!(toReturn.contains(p))){
					if(filter1!=null && att1!=null){
						if(p.getAtt(att1).equalsIgnoreCase(filter1)){
							toReturn.add(p);
						}
						if(filter2!=null && att2!=null){
							if(p2!=null && p.getAtt(att2).equalsIgnoreCase(filter2)){
								toReturn.add(p);
							}
						}
						if(filter3!=null && att3!=null){
							if(p3!=null && p.getAtt(att3).equalsIgnoreCase(filter3)){
								toReturn.add(p);
							}
						}
						if(filter4!=null && att4!=null){
							if(p4!=null && p.getAtt(att4).equalsIgnoreCase(filter4)){
								toReturn.add(p);
							}
						}
						if(filter5!=null && att5!=null){
							if(p5!=null && p.getAtt(att5).equalsIgnoreCase(filter5)){
								toReturn.add(p);
							}
						}
					}
				}

				session.setAttribute("filterresultslist", toReturn);

				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
