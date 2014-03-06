package uprm.icom5016.servlets;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uprm.icom5016.dtos.Product;
import uprm.icom5016.dtos.Report;
import uprm.icom5016.dtos.User;
import uprm.icom5016.services.GetProductService;
import uprm.icom5016.services.ReportService;
import uprm.icom5016.services.UserService;

/**
 * Servlet implementation class ReportServlet
 */
@WebServlet("/ReportServlet")
public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReportServlet() {
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
		String forwardURL = null;
		String[] monthName = {"January", "February","March", "April", "May", "June", "July","August", "September", "October", "November","December"};

		String generaltype = request.getParameter("general");
		String generalmonth = request.getParameter("months");
		String generalyear = request.getParameter("year");


		String groupreport = request.getParameter("groupreport");
		String term = request.getParameter("term");
		String calendar = request.getParameter("calendar");
		ReportService service = ReportService.newInstance();
		ArrayList<Report> result = null;

		if(groupreport!=null){
			String month="";
			String day="";
			String year="";
			int i=0;
			while(calendar.charAt(i)!='-'){
				month=month+calendar.charAt(i);
				i++;
			}
			if(month.length()==1)
				month="0"+month;
			i++;
			while(calendar.charAt(i)!='-'){
				day=day+calendar.charAt(i);
				i++;
			}
			if(day.length()==1)
				day="0"+day;
			i++;
			for(int y=i;y<calendar.length();y++)
				year=year+calendar.charAt(y);

			
			Calendar cal = new GregorianCalendar(Integer.parseInt(year), Integer.parseInt(month)-1,Integer.parseInt(day));
			
			try {
				result = service.getProductReport(groupreport, term, cal);
			}
			catch(Exception e){
				//throw new ServletException("Internal Error", e);
				response.sendError(500, "Internal Server Error");
				return;
			}
			
			day = ""+cal.get(Calendar.DAY_OF_MONTH);
			int month1 = cal.get(Calendar.MONTH);
			year = ""+cal.get(Calendar.YEAR);
			String week = ""+(cal.get(Calendar.WEEK_OF_YEAR)-1);
			
			if(term.equals("day"))
				session.setAttribute("term", ""+monthName[month1]+"-"+day+"-"+year);
			else if(term.equals("week"))
				session.setAttribute("term", "Week# "+week+"-"+year);
			else
				session.setAttribute("term", monthName[month1]+"-"+year);
			
			if(groupreport.equals("sales")){
				session.setAttribute("reporttype", "Total Sales By Products");
			}
			else
				session.setAttribute("reporttype","Total Revenue By Product");
			session.setAttribute("report", result);
			forwardURL = "./productreport.jsp";
			
		}
		else{//General Report
			Calendar cal;
			try {
				result = service.getGeneralReport(generaltype, generalmonth, generalyear);
			}
			catch(Exception e){
				//throw new ServletException("Internal Error", e);
				response.sendError(500, "Internal Server Error");
				return;
			}

			if (result==null){
				forwardURL = "./noreport.jsp"; //hacer esta pagina
			}
			
			else {
				cal = new GregorianCalendar(Integer.parseInt(generalyear), Integer.parseInt(generalmonth)-1, 1);
				int maxdays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
				ArrayList<Report> temp = new ArrayList<Report>();
				for(int i=1;i<=maxdays;i++){
					try{
						if(result.isEmpty()){
							Calendar cal2 = new GregorianCalendar(Integer.parseInt(generalyear), Integer.parseInt(generalmonth)-1, i);
							int week = cal2.get(Calendar.WEEK_OF_YEAR)-1;
							temp.add(new Report(generalyear, generalmonth, ""+i, ""+week , ""+week, null, "$0.00"));
						}
						else if(Integer.parseInt(result.get(0).getDay())==i){
							Calendar cal2 = new GregorianCalendar(Integer.parseInt(generalyear), Integer.parseInt(generalmonth)-1, i);
							int week = cal2.get(Calendar.WEEK_OF_YEAR)-1;
							result.get(0).setWeek(""+week);
							temp.add(result.get(0));
							result.remove(0);

						}
						else{
							Calendar cal2 = new GregorianCalendar(Integer.parseInt(generalyear), Integer.parseInt(generalmonth)-1, i);
							int week = cal2.get(Calendar.WEEK_OF_YEAR)-1;
							temp.add(new Report(generalyear, generalmonth, ""+i, ""+week , ""+week, null, "$0.00"));
						}
					}
					catch (Exception e) {
						break;
					}
				}
				result = temp;
				int currentweek = Integer.parseInt(result.get(0).getWeek());
				double weeksum=0.00;
				double monthsum=0.00;
				DecimalFormat twoDForm = new DecimalFormat("#.##");
				for(int i=0;i<result.size();i++){
					if(Integer.parseInt(result.get(i).getWeek())==currentweek){
						weeksum = weeksum + Double.parseDouble(result.get(i).getTotal().substring(1));
						if(i==result.size()-1){
							
					        weeksum =  Double.valueOf(twoDForm.format(weeksum));
							result.get(result.size()-1).setResetweek("$"+weeksum);
							monthsum=monthsum+weeksum;
							monthsum =  Double.valueOf(twoDForm.format(monthsum));
						}
					}
					else{
						currentweek++;
						weeksum =  Double.valueOf(twoDForm.format(weeksum));
						result.get(i-1).setResetweek("$"+weeksum);
						monthsum=monthsum+weeksum;
						monthsum =  Double.valueOf(twoDForm.format(monthsum));
						weeksum =0.00;
						weeksum = weeksum + Double.parseDouble(result.get(i).getTotal().substring(1));
					}
				}
				
				if(generaltype.equals("sales"))
					session.setAttribute("reporttype", "Total Sales Report");
				else if(generaltype.equals("returns"))
					session.setAttribute("reporttype", "Total Returns Report");
				else
					session.setAttribute("reporttype", "Total Revenue Report");
				
				session.setAttribute("monthsum", "$"+monthsum);
				session.setAttribute("generaldate",monthName[Integer.parseInt(generalmonth)-1] +"-"+generalyear);
				session.setAttribute("report", result);
				forwardURL = "./generalreport.jsp";
			}

		}
		

		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
		dispatcher.forward(request, response);
	}
}
