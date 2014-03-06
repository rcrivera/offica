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
 * Servlet implementation class SortServlet
 */
@WebServlet("/SortServlet")
public class SortServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SortServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

        /**
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                HttpSession session = request.getSession();
                String forwardURL = null;
                ArrayList<Product> sortedList = new ArrayList<Product>();
                String sortBy = (String) request.getParameter("sortOp");
                ArrayList<Product> toSort = (ArrayList<Product>) session.getAttribute("list");
                
                if (sortBy.equalsIgnoreCase("Price")){
                        int size = toSort.size();
                        for(int y=0;y<size;y++){
                                Product min = toSort.get(0);
                                int index=0;
                                for(int i=1;i<toSort.size();i++){
                                        if(toSort.get(i).getPrice().compareTo(min.getPrice())<0){
                                                min = toSort.get(i);
                                                index=i;
                                        }
                                }
                                sortedList.add(min);
                                toSort.remove(index);
                        }
                }
                else if (sortBy.equalsIgnoreCase("Name")){
                        int size = toSort.size();
                        for(int y=0;y<size;y++){
                                Product min = toSort.get(0);
                                int index=0;
                                for(int i=1;i<toSort.size();i++){
                                        if(toSort.get(i).getPname().compareTo(min.getPname())<0){
                                                min = toSort.get(i);
                                                index=i;
                                        }
                                }
                                sortedList.add(min);
                                toSort.remove(index);
                        }
                }
                else{
                        int size = toSort.size();
                        for(int y=0;y<size;y++){
                                Product min = toSort.get(0);
                                int index=0;
                                for(int i=1;i<toSort.size();i++){
                                        if(toSort.get(i).getBrand().compareTo(min.getBrand())<0){
                                                min = toSort.get(i);
                                                index=i;
                                        }
                                }
                                sortedList.add(min);
                                toSort.remove(index);
                        }
                }
                
                session.setAttribute("list", sortedList);
                forwardURL = "./SortedResults.jsp";
                
                RequestDispatcher dispatcher= request.getRequestDispatcher(forwardURL);
                dispatcher.forward(request, response);
        }

        /**
         * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                doGet(request, response);
        }

}