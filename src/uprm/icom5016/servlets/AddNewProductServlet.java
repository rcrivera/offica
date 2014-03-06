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

import uprm.icom5016.daos.ProductStatus;
import uprm.icom5016.dtos.*;
import uprm.icom5016.services.ProductService;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Servlet implementation class AddNewProductServlet
 */
@WebServlet("/AddNewProductServlet")
public class AddNewProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddNewProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String forwardURL = null;
		Integer addnewproduct = Integer.parseInt((String)session.getAttribute(("addnewproduct")));//if =0, you're fetching for product parameters, else you're adding a new product
		String subcat = request.getParameter("subcat");
		String pid = null,pname = null,picLink = null,brand = null,model = null,description = null,price = null;
		Integer stock = null;
		if(addnewproduct==1){
			pid = request.getParameter("pid");
			pname = request.getParameter("pname");
			picLink = "";
			brand = request.getParameter("brand");
			model = request.getParameter("model");
			stock = Integer.parseInt(request.getParameter("stock"));
			description = request.getParameter("description");
			price = request.getParameter("price");
			session.setAttribute("addnewproduct", "0");

		}
		if(subcat.equals("binders")){
			if(addnewproduct==0){
				session.setAttribute("addnewproduct", "1");
				Binders p = new Binders();
				ArrayList<String> att = p.getSpecificAttributes();
				att.add("binders");
				ArrayList<String> attNames = p.getSpecificAttributesNames();
				session.setAttribute("att", att);
				session.setAttribute("attNames", attNames);
				forwardURL = "./addnewproduct.jsp";
				RequestDispatcher dispatcher= request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
			else{
				session.setAttribute("addnewproduct", "0");
				String size = request.getParameter("size");
				String color = request.getParameter("color");
				String capacity = request.getParameter("capacity");
				Binders p = new Binders(pid, "stationary", subcat, pname, price,picLink, brand, stock, description, model, size, color, capacity);

				ProductService service = ProductService.newInstance();
				ProductStatus result = ProductStatus.UnexpectedError;
				try {
					result = service.addNewProduct(p);
				}
				catch(Exception e){
					response.sendError(500, "Internal Server Error");
				}
				if (result == ProductStatus.OK){
					session.setAttribute("pname",p.getPname());
					session.setAttribute("pid",p.getPid());
					forwardURL = "./productadded.jsp";
				}
				else{
					forwardURL = "./addnewproduct.jsp";
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);


			}
		}

		else if(subcat.equals("bookshelves")){
			if(addnewproduct==0){
				session.setAttribute("addnewproduct", "1");
				Bookshelves p = new Bookshelves();
				ArrayList<String> att = p.getSpecificAttributes();
				att.add("bookshelves");
				ArrayList<String> attNames = p.getSpecificAttributesNames();
				session.setAttribute("att", att);
				session.setAttribute("attNames", attNames);
				forwardURL = "./addnewproduct.jsp";
				RequestDispatcher dispatcher= request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
			else{
				session.setAttribute("addnewproduct", "0");
				String size = request.getParameter("size");
				String nshelves = request.getParameter("nshelves");
				String material = request.getParameter("material");
				String color = request.getParameter("color");
				Bookshelves p = new Bookshelves(pid, "furniture", subcat, pname, price, picLink, brand, stock, description, model, color, nshelves, material, size);
				ProductService service = ProductService.newInstance();
				ProductStatus result = ProductStatus.UnexpectedError;
				try {
					 result = service.addNewProduct(p);
				}
				catch(Exception e){
					response.sendError(500, "Internal Server Error");
				}
				if (result == ProductStatus.OK){
					session.setAttribute("pname",p.getPname());
					session.setAttribute("pid",p.getPid());
					forwardURL = "./productadded.jsp";
				}
				else{
					forwardURL = "./addnewproduct.jsp";
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
		}

		else if(subcat.equals("boxes")){
			
			if(addnewproduct==0){
				session.setAttribute("addnewproduct", "1");
				Boxes b = new Boxes();
				ArrayList<String> att = b.getSpecificAttributes();
				att.add("boxes");
				ArrayList<String> attNames = b.getSpecificAttributesNames();
				session.setAttribute("att", att);
				session.setAttribute("attNames", attNames);
				forwardURL = "./addnewproduct.jsp";
				RequestDispatcher dispatcher= request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
			else{
				session.setAttribute("addnewproduct", "0");
				String size = request.getParameter("size");
				String quantity = request.getParameter("quantity");
				String color = request.getParameter("color");
				Boxes p = new Boxes(pid, "stationary", subcat, pname, price, picLink, brand, stock, description, model, size, color, quantity);
				ProductService service = ProductService.newInstance();
				ProductStatus result = ProductStatus.UnexpectedError;
				try {
					 result = service.addNewProduct(p);
				}
				catch(Exception e){
					response.sendError(500, "Internal Server Error");
				}
				if (result == ProductStatus.OK){
					session.setAttribute("pname",p.getPname());
					session.setAttribute("pid",p.getPid());
					forwardURL = "./productadded.jsp";
				}
				else{
					forwardURL = "./addnewproduct.jsp";
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}

		}
		else if(subcat.equals("businesspaper")){
			if(addnewproduct==0){
				session.setAttribute("addnewproduct", "1");
				BusinessPaper b = new BusinessPaper();
				ArrayList<String> att = b.getSpecificAttributes();
				att.add("businesspaper");
				ArrayList<String> attNames = b.getSpecificAttributesNames();
				session.setAttribute("att", att);
				session.setAttribute("attNames", attNames);
				forwardURL = "./addnewproduct.jsp";
				RequestDispatcher dispatcher= request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
			else{
				session.setAttribute("addnewproduct", "0");
				String size = request.getParameter("size");
				String nsheets = request.getParameter("nsheets");
				String quantity = request.getParameter("quantity");
				BusinessPaper p = new BusinessPaper(pid, "paper", subcat, pname, price, picLink, brand, stock, description, model, size, nsheets, quantity);
				ProductService service = ProductService.newInstance();
				ProductStatus result = ProductStatus.UnexpectedError;
				try {
					 result = service.addNewProduct(p);
				}
				catch(Exception e){
					response.sendError(500, "Internal Server Error");
				}
				if (result == ProductStatus.OK){
					session.setAttribute("pname",p.getPname());
					session.setAttribute("pid",p.getPid());
					forwardURL = "./productadded.jsp";
				}
				else{
					forwardURL = "./addnewproduct.jsp";
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}

		}
		else if(subcat.equals("calculators")){
			if(addnewproduct==0){
				session.setAttribute("addnewproduct", "1");
				Calculators b = new Calculators();
				ArrayList<String> att = b.getSpecificAttributes();
				att.add("calculators");
				ArrayList<String> attNames = b.getSpecificAttributesNames();
				session.setAttribute("att", att);
				session.setAttribute("attNames", attNames);
				forwardURL = "./addnewproduct.jsp";
				RequestDispatcher dispatcher= request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
			else{
				session.setAttribute("addnewproduct", "0");
				String type = request.getParameter("type");
				Calculators p = new Calculators(pid, "electronics", subcat, pname, price, picLink, brand, stock, description, model, type);
				ProductService service = ProductService.newInstance();
				ProductStatus result = ProductStatus.UnexpectedError;
				try {
					 result = service.addNewProduct(p);
				}
				catch(Exception e){
					response.sendError(500, "Internal Server Error");
				}
				if (result == ProductStatus.OK){
					session.setAttribute("pname",p.getPname());
					session.setAttribute("pid",p.getPid());
					forwardURL = "./productadded.jsp";
				}
				else{
					forwardURL = "./addnewproduct.jsp";
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
			

		}
		else if(subcat.equals("cameras")){
			
			if(addnewproduct==0){
				session.setAttribute("addnewproduct", "1");
				Cameras b = new Cameras();
				ArrayList<String> att = b.getSpecificAttributes();
				att.add("cameras");
				ArrayList<String> attNames = b.getSpecificAttributesNames();
				session.setAttribute("att", att);
				session.setAttribute("attNames", attNames);
				forwardURL = "./addnewproduct.jsp";
				RequestDispatcher dispatcher= request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
			else{
				session.setAttribute("addnewproduct", "0");
				String type = request.getParameter("type");
				String megapixels = request.getParameter("megapixels");
				String opticalzoom = request.getParameter("opticalzoom");
				Cameras p = new Cameras(pid, "electronics", subcat, pname, price, picLink, brand, stock, description, model, type, megapixels, opticalzoom);
				ProductService service = ProductService.newInstance();
				ProductStatus result = ProductStatus.UnexpectedError;
				try {
					 result = service.addNewProduct(p);
				}
				catch(Exception e){
					response.sendError(500, "Internal Server Error");
				}
				if (result == ProductStatus.OK){
					session.setAttribute("pname",p.getPname());
					session.setAttribute("pid",p.getPid());
					forwardURL = "./productadded.jsp";
				}
				else{
					forwardURL = "./addnewproduct.jsp";
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
			

		}
		else if(subcat.equals("chairs")){

			if(addnewproduct==0){
				session.setAttribute("addnewproduct", "1");
				Chairs b = new Chairs();
				ArrayList<String> att = b.getSpecificAttributes();
				att.add("chairs");
				ArrayList<String> attNames = b.getSpecificAttributesNames();
				session.setAttribute("att", att);
				session.setAttribute("attNames", attNames);
				forwardURL = "./addnewproduct.jsp";
				RequestDispatcher dispatcher= request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
			else{
				session.setAttribute("addnewproduct", "0");
				String color = request.getParameter("color");
				String arms = request.getParameter("arms");
				String material = request.getParameter("material");
				Chairs p = new Chairs(pid, "furniture", subcat, pname, price, picLink, brand, stock, description, model, color, arms, material);
				ProductService service = ProductService.newInstance();
				ProductStatus result = ProductStatus.UnexpectedError;
				try {
					 result = service.addNewProduct(p);
				}
				catch(Exception e){
					response.sendError(500, "Internal Server Error");
				}
				if (result == ProductStatus.OK){
					session.setAttribute("pname",p.getPname());
					session.setAttribute("pid",p.getPid());
					forwardURL = "./productadded.jsp";
				}
				else{
					forwardURL = "./addnewproduct.jsp";
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
		}
		else if(subcat.equals("copypaper")){
			if(addnewproduct==0){
				session.setAttribute("addnewproduct", "1");
				CopyPaper b = new CopyPaper();
				ArrayList<String> att = b.getSpecificAttributes();
				att.add("copypaper");
				ArrayList<String> attNames = b.getSpecificAttributesNames();
				session.setAttribute("att", att);
				session.setAttribute("attNames", attNames);
				forwardURL = "./addnewproduct.jsp";
				RequestDispatcher dispatcher= request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
			else{
				session.setAttribute("addnewproduct", "0");
				String size = request.getParameter("size");
				String nsheets = request.getParameter("nsheets");
				String quantity = request.getParameter("quantity");
				CopyPaper p = new CopyPaper(pid, "paper", subcat, pname, price, picLink, brand, stock, description, model, size, nsheets, quantity);

				ProductService service = ProductService.newInstance();
				ProductStatus result = ProductStatus.UnexpectedError;
				try {
					 result = service.addNewProduct(p);
				}
				catch(Exception e){
					response.sendError(500, "Internal Server Error");
				}
				if (result == ProductStatus.OK){
					session.setAttribute("pname",p.getPname());
					session.setAttribute("pid",p.getPid());
					forwardURL = "./productadded.jsp";
				}
				else{
					forwardURL = "./addnewproduct.jsp";
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}

		}
		else if(subcat.equals("desks")){
			if(addnewproduct==0){
				session.setAttribute("addnewproduct", "1");
				Desks b = new Desks();
				ArrayList<String> att = b.getSpecificAttributes();
				att.add("desks");
				ArrayList<String> attNames = b.getSpecificAttributesNames();
				session.setAttribute("att", att);
				session.setAttribute("attNames", attNames);
				forwardURL = "./addnewproduct.jsp";
				RequestDispatcher dispatcher= request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
			else{
				session.setAttribute("addnewproduct", "0");
				String material = request.getParameter("material");
				String color = request.getParameter("color");
				String size = request.getParameter("size");
				Desks p = new Desks(pid, "furniture", subcat, pname, price, picLink, brand, stock, description, model, size, material, color);
				ProductService service = ProductService.newInstance();
				ProductStatus result = ProductStatus.UnexpectedError;
				try {
					 result = service.addNewProduct(p);
				}
				catch(Exception e){
					response.sendError(500, "Internal Server Error");
				}
				if (result == ProductStatus.OK){
					session.setAttribute("pname",p.getPname());
					session.setAttribute("pid",p.getPid());
					forwardURL = "./productadded.jsp";
				}
				else{
					forwardURL = "./addnewproduct.jsp";
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}

			

		}
		else if(subcat.equals("desktops")){
			
			if(addnewproduct==0){
				session.setAttribute("addnewproduct", "1");
				Desktops b = new Desktops();
				ArrayList<String> att = b.getSpecificAttributes();
				att.add("desktops");
				ArrayList<String> attNames = b.getSpecificAttributesNames();
				session.setAttribute("att", att);
				session.setAttribute("attNames", attNames);
				forwardURL = "./addnewproduct.jsp";
				RequestDispatcher dispatcher= request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
			else{
				session.setAttribute("addnewproduct", "0");
				String memory = request.getParameter("memory");
				String os = request.getParameter("os");
				String processor = request.getParameter("processor");
				String harddrive = request.getParameter("harddrive");
				Desktops p = new Desktops(pid, "electronics", subcat, pname, price, picLink, brand, stock, description, model, memory, os, processor, harddrive);
				ProductService service = ProductService.newInstance();
				ProductStatus result = ProductStatus.UnexpectedError;
				try {
					 result = service.addNewProduct(p);
				}
				catch(Exception e){
					response.sendError(500, "Internal Server Error");
				}
				if (result == ProductStatus.OK){
					session.setAttribute("pname",p.getPname());
					session.setAttribute("pid",p.getPid());
					forwardURL = "./productadded.jsp";
				}
				else{
					forwardURL = "./addnewproduct.jsp";
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}


		}
		else if(subcat.equals("disinfectant")){

			if(addnewproduct==0){
				session.setAttribute("addnewproduct", "1");
				Disinfectant b = new Disinfectant();
				ArrayList<String> att = b.getSpecificAttributes();
				att.add("disinfectant");
				ArrayList<String> attNames = b.getSpecificAttributesNames();
				session.setAttribute("att", att);
				session.setAttribute("attNames", attNames);
				forwardURL = "./addnewproduct.jsp";
				RequestDispatcher dispatcher= request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
			else{
				session.setAttribute("addnewproduct", "0");
				String quantity = request.getParameter("quantity");
				String volume = request.getParameter("volume");
				Disinfectant p = new Disinfectant(pid, "cleaningsupplies", subcat, pname, price, picLink, brand, stock, description, model, quantity, volume);
				ProductService service = ProductService.newInstance();
				ProductStatus result = ProductStatus.UnexpectedError;
				try {
					 result = service.addNewProduct(p);
				}
				catch(Exception e){
					response.sendError(500, "Internal Server Error");
				}
				if (result == ProductStatus.OK){
					session.setAttribute("pname",p.getPname());
					session.setAttribute("pid",p.getPid());
					forwardURL = "./productadded.jsp";
				}
				else{
					forwardURL = "./addnewproduct.jsp";
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
		}
		else if(subcat.equals("envelopes")){
			if(addnewproduct==0){
				session.setAttribute("addnewproduct", "1");
				Envelopes b = new Envelopes();
				ArrayList<String> att = b.getSpecificAttributes();
				att.add("envelopes");
				ArrayList<String> attNames = b.getSpecificAttributesNames();
				session.setAttribute("att", att);
				session.setAttribute("attNames", attNames);
				forwardURL = "./addnewproduct.jsp";
				RequestDispatcher dispatcher= request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
			else{
				session.setAttribute("addnewproduct", "0");
				String quantity = request.getParameter("quantity");
				String size = request.getParameter("size");
				String color = request.getParameter("color");
				Envelopes p = new Envelopes(pid, "stationary", subcat, pname, price, picLink, brand, stock, description, model, size, quantity, color);
				ProductService service = ProductService.newInstance();
				ProductStatus result = ProductStatus.UnexpectedError;
				try {
					 result = service.addNewProduct(p);
				}
				catch(Exception e){
					response.sendError(500, "Internal Server Error");
				}
				if (result == ProductStatus.OK){
					session.setAttribute("pname",p.getPname());
					session.setAttribute("pid",p.getPid());
					forwardURL = "./productadded.jsp";
				}
				else{
					forwardURL = "./addnewproduct.jsp";
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}

		}
		else if(subcat.equals("erasers")){
			if(addnewproduct==0){
				session.setAttribute("addnewproduct", "1");
				Erasers b = new Erasers();
				ArrayList<String> att = b.getSpecificAttributes();
				att.add("erasers");
				ArrayList<String> attNames = b.getSpecificAttributesNames();
				session.setAttribute("att", att);
				session.setAttribute("attNames", attNames);
				forwardURL = "./addnewproduct.jsp";
				RequestDispatcher dispatcher= request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
			else{
				session.setAttribute("addnewproduct", "0");
				String quantity = request.getParameter("quantity");
				Erasers p = new Erasers(pid,"officesupplies", subcat, pname, price, picLink, brand, stock, description, model, quantity);
				ProductService service = ProductService.newInstance();
				ProductStatus result = ProductStatus.UnexpectedError;
				try {
					 result = service.addNewProduct(p);
				}
				catch(Exception e){
					response.sendError(500, "Internal Server Error");
				}
				if (result == ProductStatus.OK){
					session.setAttribute("pname",p.getPname());
					session.setAttribute("pid",p.getPid());
					forwardURL = "./productadded.jsp";
				}
				else{
					forwardURL = "./addnewproduct.jsp";
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}

		}
		else if(subcat.equals("externaldisks")){

			if(addnewproduct==0){
				session.setAttribute("addnewproduct", "1");
				ExternalDisks b = new ExternalDisks();
				ArrayList<String> att = b.getSpecificAttributes();
				att.add("externaldisks");
				ArrayList<String> attNames = b.getSpecificAttributesNames();
				session.setAttribute("att", att);
				session.setAttribute("attNames", attNames);
				forwardURL = "./addnewproduct.jsp";
				RequestDispatcher dispatcher= request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
			else{
				session.setAttribute("addnewproduct", "0");
				String capacity = request.getParameter("capacity");
				String rpm = request.getParameter("rpm");
				ExternalDisks p = new ExternalDisks(pid, "electronicsupplies", subcat, pname, price, picLink, brand, stock, description, model, capacity, rpm);
				ProductService service = ProductService.newInstance();
				ProductStatus result = ProductStatus.UnexpectedError;
				try {
					 result = service.addNewProduct(p);
				}
				catch(Exception e){
					response.sendError(500, "Internal Server Error");
				}
				if (result == ProductStatus.OK){
					session.setAttribute("pname",p.getPname());
					session.setAttribute("pid",p.getPid());
					forwardURL = "./productadded.jsp";
				}
				else{
					forwardURL = "./addnewproduct.jsp";
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
		}
		else if(subcat.equals("filecabinets")){
			if(addnewproduct==0){
				session.setAttribute("addnewproduct", "1");
				FileCabinets b = new FileCabinets();
				ArrayList<String> att = b.getSpecificAttributes();
				att.add("filecabinets");
				ArrayList<String> attNames = b.getSpecificAttributesNames();
				session.setAttribute("att", att);
				session.setAttribute("attNames", attNames);
				forwardURL = "./addnewproduct.jsp";
				RequestDispatcher dispatcher= request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
			else{
				session.setAttribute("addnewproduct", "0");
				String type = request.getParameter("type");
				String size = request.getParameter("size");
				String material = request.getParameter("material");
				String color = request.getParameter("color");
				FileCabinets p = new FileCabinets(pid, "furniture", subcat, pname, price, picLink, brand, stock, description, model, type, size, material, color);
				ProductService service = ProductService.newInstance();
				ProductStatus result = ProductStatus.UnexpectedError;
				try {
					 result = service.addNewProduct(p);
				}
				catch(Exception e){
					response.sendError(500, "Internal Server Error");
				}
				if (result == ProductStatus.OK){
					session.setAttribute("pname",p.getPname());
					session.setAttribute("pid",p.getPid());
					forwardURL = "./productadded.jsp";
				}
				else{
					forwardURL = "./addnewproduct.jsp";
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}

		}
		else if(subcat.equals("filefolders")){
			if(addnewproduct==0){
				session.setAttribute("addnewproduct", "1");
				FileFolders b = new FileFolders();
				ArrayList<String> att = b.getSpecificAttributes();
				att.add("filefolders");
				ArrayList<String> attNames = b.getSpecificAttributesNames();
				session.setAttribute("att", att);
				session.setAttribute("attNames", attNames);
				forwardURL = "./addnewproduct.jsp";
				RequestDispatcher dispatcher= request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
			else{
				session.setAttribute("addnewproduct", "0");
				String quantity = request.getParameter("quantity");
				String size = request.getParameter("size");
				String color = request.getParameter("color");

				FileFolders p = new FileFolders(pid, "stationary", subcat, pname, price, picLink, brand, stock, description, model, size, color, quantity);
				ProductService service = ProductService.newInstance();
				ProductStatus result = ProductStatus.UnexpectedError;
				try {
					 result = service.addNewProduct(p);
				}
				catch(Exception e){
					response.sendError(500, "Internal Server Error");
				}
				if (result == ProductStatus.OK){
					session.setAttribute("pname",p.getPname());
					session.setAttribute("pid",p.getPid());
					forwardURL = "./productadded.jsp";
				}
				else{
					forwardURL = "./addnewproduct.jsp";
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}

		}
		else if(subcat.equals("inkcartridges")){
			if(addnewproduct==0){
				session.setAttribute("addnewproduct", "1");
				InkCartridges b = new InkCartridges();
				ArrayList<String> att = b.getSpecificAttributes();
				att.add("inkcartridges");
				ArrayList<String> attNames = b.getSpecificAttributesNames();
				session.setAttribute("att", att);
				session.setAttribute("attNames", attNames);
				forwardURL = "./addnewproduct.jsp";
				RequestDispatcher dispatcher= request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
			else{
				session.setAttribute("addnewproduct", "0");
				String quantity = request.getParameter("quantity");
				String color = request.getParameter("color");
				String maxyield = request.getParameter("maxyield");
				InkCartridges p =new InkCartridges(pid, "electronicsupplies", subcat, pname, price, picLink, brand, stock, description, model, color, maxyield);
				ProductService service = ProductService.newInstance();
				ProductStatus result = ProductStatus.UnexpectedError;
				try {
					 result = service.addNewProduct(p);
				}
				catch(Exception e){
					response.sendError(500, "Internal Server Error");
				}
				if (result == ProductStatus.OK){
					session.setAttribute("pname",p.getPname());
					session.setAttribute("pid",p.getPid());
					forwardURL = "./productadded.jsp";
				}
				else{
					forwardURL = "./addnewproduct.jsp";
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}

		}
		else if(subcat.equals("internaldisks")){
			if(addnewproduct==0){
				session.setAttribute("addnewproduct", "1");
				InternalDisks b = new InternalDisks();
				ArrayList<String> att = b.getSpecificAttributes();
				att.add("internaldisks");
				ArrayList<String> attNames = b.getSpecificAttributesNames();
				session.setAttribute("att", att);
				session.setAttribute("attNames", attNames);
				forwardURL = "./addnewproduct.jsp";
				RequestDispatcher dispatcher= request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
			else{
				session.setAttribute("addnewproduct", "0");
				String capacity = request.getParameter("capacity");
				String rpm = request.getParameter("rpm");
				InternalDisks p = new InternalDisks(pid, "electronicsupplies", subcat, pname, price, picLink, brand, stock, description, model, capacity, rpm);
				ProductService service = ProductService.newInstance();
				ProductStatus result = ProductStatus.UnexpectedError;
				try {
					 result = service.addNewProduct(p);
				}
				catch(Exception e){
					response.sendError(500, "Internal Server Error");
				}
				if (result == ProductStatus.OK){
					session.setAttribute("pname",p.getPname());
					session.setAttribute("pid",p.getPid());
					forwardURL = "./productadded.jsp";
				}
				else{
					forwardURL = "./addnewproduct.jsp";
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}

		}
		else if(subcat.equals("labels")){
			if(addnewproduct==0){
				session.setAttribute("addnewproduct", "1");
				Labels b = new Labels();
				ArrayList<String> att = b.getSpecificAttributes();
				att.add("labels");
				ArrayList<String> attNames = b.getSpecificAttributesNames();
				session.setAttribute("att", att);
				session.setAttribute("attNames", attNames);
				forwardURL = "./addnewproduct.jsp";
				RequestDispatcher dispatcher= request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
			else{
				session.setAttribute("addnewproduct", "0");
				String quantity = request.getParameter("quantity");
				String size = request.getParameter("size");
				String color = request.getParameter("color");
				String type = request.getParameter("type");

				Labels p = new Labels(pid, "stationary", subcat, pname, price, picLink, brand, stock, description, model, size, color, quantity, type);
				ProductService service = ProductService.newInstance();
				ProductStatus result = ProductStatus.UnexpectedError;
				try {
					 result = service.addNewProduct(p);
				}
				catch(Exception e){
					response.sendError(500, "Internal Server Error");
				}
				if (result == ProductStatus.OK){
					session.setAttribute("pname",p.getPname());
					session.setAttribute("pid",p.getPid());
					forwardURL = "./productadded.jsp";
				}
				else{
					forwardURL = "./addnewproduct.jsp";
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}

		}
		else if(subcat.equals("lamps")){
			if(addnewproduct==0){
				session.setAttribute("addnewproduct", "1");
				Lamps b = new Lamps();
				ArrayList<String> att = b.getSpecificAttributes();
				att.add("lamps");
				ArrayList<String> attNames = b.getSpecificAttributesNames();
				session.setAttribute("att", att);
				session.setAttribute("attNames", attNames);
				forwardURL = "./addnewproduct.jsp";
				RequestDispatcher dispatcher= request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
			else{
				session.setAttribute("addnewproduct", "0");
				String type = request.getParameter("type");
				String lightbulbtype = request.getParameter("lightbulbtype");

				Lamps p = new Lamps(pid, "furniture", subcat, pname, price, picLink, brand, stock, description, model, type, lightbulbtype);
				ProductService service = ProductService.newInstance();
				ProductStatus result = ProductStatus.UnexpectedError;
				try {
					 result = service.addNewProduct(p);
				}
				catch(Exception e){
					response.sendError(500, "Internal Server Error");
				}
				if (result == ProductStatus.OK){
					session.setAttribute("pname",p.getPname());
					session.setAttribute("pid",p.getPid());
					forwardURL = "./productadded.jsp";
				}
				else{
					forwardURL = "./addnewproduct.jsp";
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}

		}
		else if(subcat.equals("laptops")){
			if(addnewproduct==0){
				session.setAttribute("addnewproduct", "1");
				Laptops b = new Laptops();
				ArrayList<String> att = b.getSpecificAttributes();
				att.add("laptops");
				ArrayList<String> attNames = b.getSpecificAttributesNames();
				session.setAttribute("att", att);
				session.setAttribute("attNames", attNames);
				forwardURL = "./addnewproduct.jsp";
				RequestDispatcher dispatcher= request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
			else{
				session.setAttribute("addnewproduct", "0");
				String os = request.getParameter("os");
				String memory = request.getParameter("memory");
				String screensize = request.getParameter("screensize");
				String processor = request.getParameter("processor");
				String harddrive = request.getParameter("harddrive");

				Laptops p = new Laptops(pid, "electronics", subcat, pname, price, picLink, brand, stock, description, model, memory, screensize, os, processor, harddrive);
				ProductService service = ProductService.newInstance();
				ProductStatus result = ProductStatus.UnexpectedError;
				try {
					 result = service.addNewProduct(p);
				}
				catch(Exception e){
					response.sendError(500, "Internal Server Error");
				}
				if (result == ProductStatus.OK){
					session.setAttribute("pname",p.getPname());
					session.setAttribute("pid",p.getPid());
					forwardURL = "./productadded.jsp";
				}
				else{
					forwardURL = "./addnewproduct.jsp";
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}

		}
		else if(subcat.equals("markers")){
			if(addnewproduct==0){
				session.setAttribute("addnewproduct", "1");
				Markers b = new Markers();
				ArrayList<String> att = b.getSpecificAttributes();
				att.add("markers");
				ArrayList<String> attNames = b.getSpecificAttributesNames();
				session.setAttribute("att", att);
				session.setAttribute("attNames", attNames);
				forwardURL = "./addnewproduct.jsp";
				RequestDispatcher dispatcher= request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
			else{
				session.setAttribute("addnewproduct", "0");
				String quantity = request.getParameter("quantity");
				String point = request.getParameter("point");
				String color = request.getParameter("color");
				Markers p = new Markers(pid, "officesupplies", subcat, pname, price, picLink, brand, stock, description, model, point, color, quantity);
				ProductService service = ProductService.newInstance();
				ProductStatus result = ProductStatus.UnexpectedError;
				try {
					 result = service.addNewProduct(p);
				}
				catch(Exception e){
					response.sendError(500, "Internal Server Error");
				}
				if (result == ProductStatus.OK){
					session.setAttribute("pname",p.getPname());
					session.setAttribute("pid",p.getPid());
					forwardURL = "./productadded.jsp";
				}
				else{
					forwardURL = "./addnewproduct.jsp";
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}

		}
		else if(subcat.equals("mats")){
			if(addnewproduct==0){
				session.setAttribute("addnewproduct", "1");
				Mats b = new Mats();
				ArrayList<String> att = b.getSpecificAttributes();
				att.add("mats");
				ArrayList<String> attNames = b.getSpecificAttributesNames();
				session.setAttribute("att", att);
				session.setAttribute("attNames", attNames);
				forwardURL = "./addnewproduct.jsp";
				RequestDispatcher dispatcher= request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
			else{
				session.setAttribute("addnewproduct", "0");
				String material = request.getParameter("material");
				String color = request.getParameter("color");
				String use = request.getParameter("use");
				Mats p =new Mats(pid, "furniture", subcat, pname, price, picLink, brand, stock, description, model, material, color, use);
				ProductService service = ProductService.newInstance();
				ProductStatus result = ProductStatus.UnexpectedError;
				try {
					 result = service.addNewProduct(p);
				}
				catch(Exception e){
					response.sendError(500, "Internal Server Error");
				}
				if (result == ProductStatus.OK){
					session.setAttribute("pname",p.getPname());
					session.setAttribute("pid",p.getPid());
					forwardURL = "./productadded.jsp";
				}
				else{
					forwardURL = "./addnewproduct.jsp";
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}

		}
		else if(subcat.equals("memory")){
			if(addnewproduct==0){
				session.setAttribute("addnewproduct", "1");
				Memory b = new Memory();
				ArrayList<String> att = b.getSpecificAttributes();
				att.add("memory");
				ArrayList<String> attNames = b.getSpecificAttributesNames();
				session.setAttribute("att", att);
				session.setAttribute("attNames", attNames);
				forwardURL = "./addnewproduct.jsp";
				RequestDispatcher dispatcher= request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
			else{
				session.setAttribute("addnewproduct", "0");
				String capacity = request.getParameter("capacity");
				String type = request.getParameter("type");
				Memory p = new Memory(pid, "electronicsupplies", subcat, pname, price, picLink, brand, stock, description, model, capacity, type);
				ProductService service = ProductService.newInstance();
				ProductStatus result = ProductStatus.UnexpectedError;
				try {
					 result = service.addNewProduct(p);
				}
				catch(Exception e){
					response.sendError(500, "Internal Server Error");
				}
				if (result == ProductStatus.OK){
					session.setAttribute("pname",p.getPname());
					session.setAttribute("pid",p.getPid());
					forwardURL = "./productadded.jsp";
				}
				else{
					forwardURL = "./addnewproduct.jsp";
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}

		}
		else if(subcat.equals("paperclips")){
			if(addnewproduct==0){
				session.setAttribute("addnewproduct", "1");
				PaperClips b = new PaperClips();
				ArrayList<String> att = b.getSpecificAttributes();
				att.add("paperclips");
				ArrayList<String> attNames = b.getSpecificAttributesNames();
				session.setAttribute("att", att);
				session.setAttribute("attNames", attNames);
				forwardURL = "./addnewproduct.jsp";
				RequestDispatcher dispatcher= request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
			else{
				session.setAttribute("addnewproduct", "0");
				String quantity = request.getParameter("quantity");
				PaperClips p = new PaperClips(pid, "offivesupplies", subcat, pname, price, picLink, brand, stock, description, model, quantity);
				ProductService service = ProductService.newInstance();
				ProductStatus result = ProductStatus.UnexpectedError;
				try {
					 result = service.addNewProduct(p);
				}
				catch(Exception e){
					response.sendError(500, "Internal Server Error");
				}
				if (result == ProductStatus.OK){
					session.setAttribute("pname",p.getPname());
					session.setAttribute("pid",p.getPid());
					forwardURL = "./productadded.jsp";
				}
				else{
					forwardURL = "./addnewproduct.jsp";
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}

		}
		else if(subcat.equals("papertowels")){

			if(addnewproduct==0){
				session.setAttribute("addnewproduct", "1");
				PaperTowels b = new PaperTowels();
				ArrayList<String> att = b.getSpecificAttributes();
				att.add("papertowels");
				ArrayList<String> attNames = b.getSpecificAttributesNames();
				session.setAttribute("att", att);
				session.setAttribute("attNames", attNames);
				forwardURL = "./addnewproduct.jsp";
				RequestDispatcher dispatcher= request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
			else{
				session.setAttribute("addnewproduct", "0");
				String quantity = request.getParameter("quantity");
				String size = request.getParameter("size");
				String nsheets = request.getParameter("nsheets");
				PaperTowels p= new PaperTowels(pid, "cleaningsupplies", subcat, pname, price, picLink, brand, stock, description, model, size, nsheets, quantity);
				ProductService service = ProductService.newInstance();
				ProductStatus result = ProductStatus.UnexpectedError;
				try {
					 result = service.addNewProduct(p);
				}
				catch(Exception e){
					response.sendError(500, "Internal Server Error");
				}
				if (result == ProductStatus.OK){
					session.setAttribute("pname",p.getPname());
					session.setAttribute("pid",p.getPid());
					forwardURL = "./productadded.jsp";
				}
				else{
					forwardURL = "./addnewproduct.jsp";
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
		}
		else if(subcat.equals("pencils")){

			if(addnewproduct==0){
				session.setAttribute("addnewproduct", "1");
				Pencils b = new Pencils();
				ArrayList<String> att = b.getSpecificAttributes();
				att.add("pencils");
				ArrayList<String> attNames = b.getSpecificAttributesNames();
				session.setAttribute("att", att);
				session.setAttribute("attNames", attNames);
				forwardURL = "./addnewproduct.jsp";
				RequestDispatcher dispatcher= request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
			else{
				session.setAttribute("addnewproduct", "0");
				String quantity = request.getParameter("quantity");
				String point = request.getParameter("point");
				String type = request.getParameter("type");
				Pencils p = new Pencils(pid, "officesupplies", subcat, pname, price, picLink, brand, stock, description, model, point, quantity, type);
				ProductService service = ProductService.newInstance();
				ProductStatus result = ProductStatus.UnexpectedError;
				try {
					 result = service.addNewProduct(p);
				}
				catch(Exception e){
					response.sendError(500, "Internal Server Error");
				}
				if (result == ProductStatus.OK){
					session.setAttribute("pname",p.getPname());
					session.setAttribute("pid",p.getPid());
					forwardURL = "./productadded.jsp";
				}
				else{
					forwardURL = "./addnewproduct.jsp";
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
		}
		else if(subcat.equals("pens")){
			
			if(addnewproduct==0){
				session.setAttribute("addnewproduct", "1");
				Pens b = new Pens();
				ArrayList<String> att = b.getSpecificAttributes();
				att.add("pens");
				ArrayList<String> attNames = b.getSpecificAttributesNames();
				session.setAttribute("att", att);
				session.setAttribute("attNames", attNames);
				forwardURL = "./addnewproduct.jsp";
				RequestDispatcher dispatcher= request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
			else{
				session.setAttribute("addnewproduct", "0");
				String quantity = request.getParameter("quantity");
				String point = request.getParameter("point");
				String color = request.getParameter("color");
				Pens p = new Pens(pid, "officesupplies", subcat, pname, price, picLink, brand, stock, description, model, point, color, quantity);
				ProductService service = ProductService.newInstance();
				ProductStatus result = ProductStatus.UnexpectedError;
				try {
					 result = service.addNewProduct(p);
				}
				catch(Exception e){
					response.sendError(500, "Internal Server Error");
				}
				if (result == ProductStatus.OK){
					session.setAttribute("pname",p.getPname());
					session.setAttribute("pid",p.getPid());
					forwardURL = "./productadded.jsp";
				}
				else{
					forwardURL = "./addnewproduct.jsp";
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}

		}
		else if(subcat.equals("photopaper")){
			if(addnewproduct==0){
				session.setAttribute("addnewproduct", "1");
				PhotoPaper b = new PhotoPaper();
				ArrayList<String> att = b.getSpecificAttributes();
				att.add("photopaper");
				ArrayList<String> attNames = b.getSpecificAttributesNames();
				session.setAttribute("att", att);
				session.setAttribute("attNames", attNames);
				forwardURL = "./addnewproduct.jsp";
				RequestDispatcher dispatcher= request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
			else{
				session.setAttribute("addnewproduct", "0");
				String quantity = request.getParameter("quantity");
				String size = request.getParameter("size");
				String nsheets = request.getParameter("nsheets");
				PhotoPaper p=new PhotoPaper(pid, "paper", subcat, pname, price, picLink, brand, stock, description, model, size, nsheets, quantity);
				ProductService service = ProductService.newInstance();
				ProductStatus result = ProductStatus.UnexpectedError;
				try {
					 result = service.addNewProduct(p);
				}
				catch(Exception e){
					response.sendError(500, "Internal Server Error");
				}
				if (result == ProductStatus.OK){
					session.setAttribute("pname",p.getPname());
					session.setAttribute("pid",p.getPid());
					forwardURL = "./productadded.jsp";
				}
				else{
					forwardURL = "./addnewproduct.jsp";
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}

		}
		else if(subcat.equals("printers")){
			if(addnewproduct==0){
				session.setAttribute("addnewproduct", "1");
				Printers b = new Printers();
				ArrayList<String> att = b.getSpecificAttributes();
				att.add("printers");
				ArrayList<String> attNames = b.getSpecificAttributesNames();
				session.setAttribute("att", att);
				session.setAttribute("attNames", attNames);
				forwardURL = "./addnewproduct.jsp";
				RequestDispatcher dispatcher= request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
			else{
				session.setAttribute("addnewproduct", "0");
				String type = request.getParameter("type");
				Printers p =new Printers(pid, "electronics", subcat, pname, price, picLink, brand, stock, description, model, type);
				ProductService service = ProductService.newInstance();
				ProductStatus result = ProductStatus.UnexpectedError;
				try {
					 result = service.addNewProduct(p);
				}
				catch(Exception e){
					response.sendError(500, "Internal Server Error");
				}
				if (result == ProductStatus.OK){
					session.setAttribute("pname",p.getPname());
					session.setAttribute("pid",p.getPid());
					forwardURL = "./productadded.jsp";
				}
				else{
					forwardURL = "./addnewproduct.jsp";
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}

		}
		else if(subcat.equals("resumepaper")){
			if(addnewproduct==0){
				session.setAttribute("addnewproduct", "1");
				ResumePaper b = new ResumePaper();
				ArrayList<String> att = b.getSpecificAttributes();
				att.add("resumepaper");
				ArrayList<String> attNames = b.getSpecificAttributesNames();
				session.setAttribute("att", att);
				session.setAttribute("attNames", attNames);
				forwardURL = "./addnewproduct.jsp";
				RequestDispatcher dispatcher= request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
			else{
				session.setAttribute("addnewproduct", "0");
				String quantity = request.getParameter("quantity");
				String size = request.getParameter("size");
				String nsheets = request.getParameter("nsheets");
				ResumePaper p =new ResumePaper(pid, "paper", subcat, pname, price, picLink, brand, stock, description, model, size, nsheets, quantity);
				ProductService service = ProductService.newInstance();
				ProductStatus result = ProductStatus.UnexpectedError;
				try {
					 result = service.addNewProduct(p);
				}
				catch(Exception e){
					response.sendError(500, "Internal Server Error");
				}
				if (result == ProductStatus.OK){
					session.setAttribute("pname",p.getPname());
					session.setAttribute("pid",p.getPid());
					forwardURL = "./productadded.jsp";
				}
				else{
					forwardURL = "./addnewproduct.jsp";
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}

		}
		else if(subcat.equals("rubberbands")){
			if(addnewproduct==0){
				session.setAttribute("addnewproduct", "1");
				RubberBands b = new RubberBands();
				ArrayList<String> att = b.getSpecificAttributes();
				att.add("rubberbands");
				ArrayList<String> attNames = b.getSpecificAttributesNames();
				session.setAttribute("att", att);
				session.setAttribute("attNames", attNames);
				forwardURL = "./addnewproduct.jsp";
				RequestDispatcher dispatcher= request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
			else{
				session.setAttribute("addnewproduct", "0");
				String quantity = request.getParameter("quantity");
				String size = request.getParameter("size");
				String color = request.getParameter("color");
				RubberBands p = new RubberBands(pid, "officesupplies", subcat, pname, price, picLink, brand, stock, description, model, size, color, quantity);
				ProductService service = ProductService.newInstance();
				ProductStatus result = ProductStatus.UnexpectedError;
				try {
					 result = service.addNewProduct(p);
				}
				catch(Exception e){
					response.sendError(500, "Internal Server Error");
				}
				if (result == ProductStatus.OK){
					session.setAttribute("pname",p.getPname());
					session.setAttribute("pid",p.getPid());
					forwardURL = "./productadded.jsp";
				}
				else{
					forwardURL = "./addnewproduct.jsp";
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}

		}
		else if(subcat.equals("sanitizer")){
			if(addnewproduct==0){
				session.setAttribute("addnewproduct", "1");
				Sanitizer b = new Sanitizer();
				ArrayList<String> att = b.getSpecificAttributes();
				att.add("sanitizer");
				ArrayList<String> attNames = b.getSpecificAttributesNames();
				session.setAttribute("att", att);
				session.setAttribute("attNames", attNames);
				forwardURL = "./addnewproduct.jsp";
				RequestDispatcher dispatcher= request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
			else{
				session.setAttribute("addnewproduct", "0");
				String volume = request.getParameter("volume");
				Sanitizer p = new Sanitizer(pid, "cleaningsupples", subcat, pname, price, picLink, brand, stock, description, model, volume);
				ProductService service = ProductService.newInstance();
				ProductStatus result = ProductStatus.UnexpectedError;
				try {
					 result = service.addNewProduct(p);
				}
				catch(Exception e){
					response.sendError(500, "Internal Server Error");
				}
				if (result == ProductStatus.OK){
					session.setAttribute("pname",p.getPname());
					session.setAttribute("pid",p.getPid());
					forwardURL = "./productadded.jsp";
				}
				else{
					forwardURL = "./addnewproduct.jsp";
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}

		}
		else if(subcat.equals("soap")){
			if(addnewproduct==0){
				session.setAttribute("addnewproduct", "1");
				Soap b = new Soap();
				ArrayList<String> att = b.getSpecificAttributes();
				att.add("soap");
				ArrayList<String> attNames = b.getSpecificAttributesNames();
				session.setAttribute("att", att);
				session.setAttribute("attNames", attNames);
				forwardURL = "./addnewproduct.jsp";
				RequestDispatcher dispatcher= request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
			else{
				session.setAttribute("addnewproduct", "0");
				String quantity = request.getParameter("quantity");
				String volume = request.getParameter("volume");
				Soap p = new Soap(pid, "cleaningsupplies", subcat, pname, price, picLink, brand, stock, description, model, quantity, volume);
				ProductService service = ProductService.newInstance();
				ProductStatus result = ProductStatus.UnexpectedError;
				try {
					 result = service.addNewProduct(p);
				}
				catch(Exception e){
					response.sendError(500, "Internal Server Error");
				}
				if (result == ProductStatus.OK){
					session.setAttribute("pname",p.getPname());
					session.setAttribute("pid",p.getPid());
					forwardURL = "./productadded.jsp";
				}
				else{
					forwardURL = "./addnewproduct.jsp";
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}

		}
		else if(subcat.equals("staplemachines")){
			if(addnewproduct==0){
				session.setAttribute("addnewproduct", "1");
				StapleMachines b = new StapleMachines();
				ArrayList<String> att = b.getSpecificAttributes();
				att.add("staplemachines");
				ArrayList<String> attNames = b.getSpecificAttributesNames();
				session.setAttribute("att", att);
				session.setAttribute("attNames", attNames);
				forwardURL = "./addnewproduct.jsp";
				RequestDispatcher dispatcher= request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
			else{
				session.setAttribute("addnewproduct", "0");
				String staplesize = request.getParameter("staplesize");
				String color = request.getParameter("color");
				String type = request.getParameter("type");
				String nsheets = request.getParameter("nsheets");
				StapleMachines p=new StapleMachines(pid, "officesupplies", subcat, pname, price, picLink, brand, stock, description, model, staplesize, color, type, nsheets);
				ProductService service = ProductService.newInstance();
				ProductStatus result = ProductStatus.UnexpectedError;
				try {
					 result = service.addNewProduct(p);
				}
				catch(Exception e){
					response.sendError(500, "Internal Server Error");
				}
				if (result == ProductStatus.OK){
					session.setAttribute("pname",p.getPname());
					session.setAttribute("pid",p.getPid());
					forwardURL = "./productadded.jsp";
				}
				else{
					forwardURL = "./addnewproduct.jsp";
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}

		}
		else if(subcat.equals("staples")){
			if(addnewproduct==0){
				session.setAttribute("addnewproduct", "1");
				Staples b = new Staples();
				ArrayList<String> att = b.getSpecificAttributes();
				att.add("staples");
				ArrayList<String> attNames = b.getSpecificAttributesNames();
				session.setAttribute("att", att);
				session.setAttribute("attNames", attNames);
				forwardURL = "./addnewproduct.jsp";
				RequestDispatcher dispatcher= request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
			else{
				session.setAttribute("addnewproduct", "0");
				String quantity = request.getParameter("quantity");
				String size = request.getParameter("size");
				Staples p = new Staples(pid, "officesupplies", subcat, pname, price, picLink, brand, stock, description, model, size, quantity);
				ProductService service = ProductService.newInstance();
				ProductStatus result = ProductStatus.UnexpectedError;
				try {
					 result = service.addNewProduct(p);
				}
				catch(Exception e){
					response.sendError(500, "Internal Server Error");
				}
				if (result == ProductStatus.OK){
					session.setAttribute("pname",p.getPname());
					session.setAttribute("pid",p.getPid());
					forwardURL = "./productadded.jsp";
				}
				else{
					forwardURL = "./addnewproduct.jsp";
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}

		}
		else if(subcat.equals("tablets")){
			if(addnewproduct==0){
				session.setAttribute("addnewproduct", "1");
				Tablets b = new Tablets();
				ArrayList<String> att = b.getSpecificAttributes();
				att.add("tablets");
				ArrayList<String> attNames = b.getSpecificAttributesNames();
				session.setAttribute("att", att);
				session.setAttribute("attNames", attNames);
				forwardURL = "./addnewproduct.jsp";
				RequestDispatcher dispatcher= request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
			else{
				session.setAttribute("addnewproduct", "0");
				String memory = request.getParameter("memory");
				String screensize = request.getParameter("screensize");
				String os = request.getParameter("os");
				Tablets p = new Tablets(pid, "electronics", subcat, pname, price, picLink, brand, stock, description, model, memory, screensize, os);
				ProductService service = ProductService.newInstance();
				ProductStatus result = ProductStatus.UnexpectedError;
				try {
					 result = service.addNewProduct(p);
				}
				catch(Exception e){
					response.sendError(500, "Internal Server Error");
				}
				if (result == ProductStatus.OK){
					session.setAttribute("pname",p.getPname());
					session.setAttribute("pid",p.getPid());
					forwardURL = "./productadded.jsp";
				}
				else{
					forwardURL = "./addnewproduct.jsp";
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}

		}
		else if(subcat.equals("tissuepaper")){
			if(addnewproduct==0){
				session.setAttribute("addnewproduct", "1");
				TissuePaper b = new TissuePaper();
				ArrayList<String> att = b.getSpecificAttributes();
				att.add("tissuepaper");
				ArrayList<String> attNames = b.getSpecificAttributesNames();
				session.setAttribute("att", att);
				session.setAttribute("attNames", attNames);
				forwardURL = "./addnewproduct.jsp";
				RequestDispatcher dispatcher= request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
			else{
				session.setAttribute("addnewproduct", "0");
				String quantity = request.getParameter("quantity");
				String nsheets = request.getParameter("nsheets");
				TissuePaper p=new TissuePaper(pid, "cleaningsupplies", subcat, pname, price, picLink, brand, stock, description, model, quantity, nsheets);
				ProductService service = ProductService.newInstance();
				ProductStatus result = ProductStatus.UnexpectedError;
				try {
					 result = service.addNewProduct(p);
				}
				catch(Exception e){
					response.sendError(500, "Internal Server Error");
				}
				if (result == ProductStatus.OK){
					session.setAttribute("pname",p.getPname());
					session.setAttribute("pid",p.getPid());
					forwardURL = "./productadded.jsp";
				}
				else{
					forwardURL = "./addnewproduct.jsp";
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}

		}
		else if(subcat.equals("toner")){
			if(addnewproduct==0){
				session.setAttribute("addnewproduct", "1");
				Toner b = new Toner();
				ArrayList<String> att = b.getSpecificAttributes();
				att.add("toner");
				ArrayList<String> attNames = b.getSpecificAttributesNames();
				session.setAttribute("att", att);
				session.setAttribute("attNames", attNames);
				forwardURL = "./addnewproduct.jsp";
				RequestDispatcher dispatcher= request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
			else{
				session.setAttribute("addnewproduct", "0");
				String color = request.getParameter("color");
				String maxyield = request.getParameter("maxyield");
				Toner p =new Toner(pid, "electronicsupplies", subcat, pname, price, picLink, brand, stock, description, model, color, maxyield);
				ProductService service = ProductService.newInstance();
				ProductStatus result = ProductStatus.UnexpectedError;
				try {
					 result = service.addNewProduct(p);
				}
				catch(Exception e){
					response.sendError(500, "Internal Server Error");
				}
				if (result == ProductStatus.OK){
					session.setAttribute("pname",p.getPname());
					session.setAttribute("pid",p.getPid());
					forwardURL = "./productadded.jsp";
				}
				else{
					forwardURL = "./addnewproduct.jsp";
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}

		}
		else if(subcat.equals("trashbags")){
			if(addnewproduct==0){
				session.setAttribute("addnewproduct", "1");
				TrashBags b = new TrashBags();
				ArrayList<String> att = b.getSpecificAttributes();
				att.add("trashbags");
				ArrayList<String> attNames = b.getSpecificAttributesNames();
				session.setAttribute("att", att);
				session.setAttribute("attNames", attNames);
				forwardURL = "./addnewproduct.jsp";
				RequestDispatcher dispatcher= request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}
			else{
				session.setAttribute("addnewproduct", "0");
				String quantity = request.getParameter("quantity");
				String capacity = request.getParameter("capacity");
				String color = request.getParameter("color");
				TrashBags p =new TrashBags(pid, "cleaningsupplies", subcat, pname, price, picLink, brand, stock, description, model, capacity, color, quantity);
				ProductService service = ProductService.newInstance();
				ProductStatus result = ProductStatus.UnexpectedError;
				try {
					 result = service.addNewProduct(p);
				}
				catch(Exception e){
					response.sendError(500, "Internal Server Error");
				}
				if (result == ProductStatus.OK){
					session.setAttribute("pname",p.getPname());
					session.setAttribute("pid",p.getPid());
					forwardURL = "./productadded.jsp";
				}
				else{
					forwardURL = "./addnewproduct.jsp";
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
				dispatcher.forward(request, response);
			}

		}

	}

}
