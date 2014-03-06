package uprm.icom5016.services;

import java.util.ArrayList;
import java.util.Calendar;

import uprm.icom5016.daos.DataSourceException;
import uprm.icom5016.daos.ReportDAO;
import uprm.icom5016.dtos.Report;

public class ReportService {


	private ReportService(){

	}
	public static ReportService newInstance(){
		return new ReportService();
	}

	public ArrayList<Report> getGeneralReport(String rtype,String param1,String param2) throws DataSourceException{
		ReportDAO dao = new ReportDAO();
		return dao.getGeneralReport(rtype,param1,param2);
	}
	
	public ArrayList<Report> getProductReport(String rtype,String param1,Calendar cal) throws DataSourceException{
		ReportDAO dao = new ReportDAO();
		return dao.getProductReport(rtype,param1,cal);
	}
	
	
}
