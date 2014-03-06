package uprm.icom5016.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import uprm.icom5016.dtos.Labels;
import uprm.icom5016.dtos.Product;
import uprm.icom5016.dtos.Report;

public class ReportDAO {

	private static final String GEN_REP_TOTAL_SALES="SELECT y.year , y.month, y.day, y.resetweek, y.week, sum(y.total) AS total "+
			"FROM (SELECT x.year, x.month, x.week, x.resetweek, x.day, x.dayofweek, x.total "+
			"FROM(SELECT EXTRACT(year FROM dateorder) AS year, EXTRACT(month FROM dateorder) AS month, EXTRACT(week FROM dateorder) as week, EXTRACT(day FROM dateorder) AS day, CAST ((EXTRACT(day FROM dateorder)) AS numeric)%7+1 AS dayofweek, total, "+
			"CASE WHEN EXTRACT(month FROM dateorder)=1 and EXTRACT(week FROM dateorder) >45 THEN 0 "+
			"ELSE EXTRACT(week FROM dateorder) "+
			"END AS resetweek "+
			"FROM addtoorder natural join orders "+
			"GROUP BY EXTRACT(year FROM dateorder), EXTRACT(month FROM dateorder),EXTRACT(week FROM dateorder), EXTRACT(day FROM dateorder), CAST ((EXTRACT(day FROM dateorder)) AS numeric)%7+1, total,dateorder "+
			"ORDER BY(EXTRACT(year FROM dateorder), EXTRACT(month FROM dateorder), EXTRACT(day FROM dateorder))) AS x ) as y "+
			"WHERE y.month=replace1 and y.year=replace2 "+
			"GROUP BY y.year , y.month, y.day,y.week, y.resetweek "+
			"ORDER BY (y.year , y.month, y.day, y.resetweek)  ASC";



	private static final String GEN_REP_TOTAL_RETURNS="SELECT y.year , y.month, y.day, y.resetweek, y.week, sum(y.total) AS total "+
			"FROM (SELECT x.year, x.month, x.week, x.resetweek, x.day, x.dayofweek, x.total "+
			"FROM(SELECT EXTRACT(year FROM rdate) AS year, EXTRACT(month FROM rdate) AS month, EXTRACT(week FROM rdate) as week, EXTRACT(day FROM rdate) AS day, CAST ((EXTRACT(day FROM rdate)) AS numeric)%7+1 AS dayofweek, productsreturned.rquantity*price AS total, "+
			"CASE WHEN EXTRACT(month FROM rdate)=1 and EXTRACT(week FROM rdate) >45 THEN 0 "+
			"ELSE EXTRACT(week FROM rdate) "+
			"END AS resetweek "+
			"FROM refunds natural join addtoorder natural join productsreturned "+
			"GROUP BY EXTRACT(year FROM rdate), EXTRACT(month FROM rdate),EXTRACT(week FROM rdate), EXTRACT(day FROM rdate), CAST ((EXTRACT(day FROM rdate)) AS numeric)%7+1, total,rdate "+
			"ORDER BY(EXTRACT(year FROM rdate), EXTRACT(month FROM rdate), EXTRACT(day FROM rdate))) AS x ) as y "+
			"WHERE y.month=replace1 and y.year=replace2 "+
			"GROUP BY y.year , y.month, y.day,y.week, y.resetweek "+
			"ORDER BY (y.year , y.month, y.day, y.resetweek)  ASC";

	private static final String PROD_REP_TOTAL_SALES_DAY="SELECT EXTRACT(year FROM dateorder) AS year , EXTRACT(month FROM dateorder) AS month, EXTRACT(day FROM dateorder) AS day, pid, sum(pquantity*price) AS total "+
			"FROM addtoorder natural join orders "+ 
			"WHERE EXTRACT(year FROM dateorder) = repyear and EXTRACT(month FROM dateorder) = repmonth and EXTRACT(day FROM dateorder) = repday "+ 
			"GROUP BY EXTRACT(year FROM dateorder), EXTRACT(month FROM dateorder),EXTRACT(day FROM dateorder),pid "+
			"ORDER BY (EXTRACT(year FROM dateorder), EXTRACT(month FROM dateorder),EXTRACT(day FROM dateorder),pid)  ASC";

	private static final String PROD_REP_TOTAL_SALES_MONTH = "SELECT EXTRACT(year FROM dateorder) AS year , EXTRACT(month FROM dateorder) AS month, pid, sum(pquantity*price) AS total "+
			"FROM addtoorder natural join orders "+
			"WHERE EXTRACT(year FROM dateorder) = repyear and EXTRACT(month FROM dateorder) = repmonth "+ 
			"GROUP BY EXTRACT(year FROM dateorder), EXTRACT(month FROM dateorder),pid "+
			"ORDER BY (EXTRACT(year FROM dateorder), EXTRACT(month FROM dateorder),pid)  ASC";

	private static final String PROD_REP_TOTAL_SALES_WEEK="SELECT EXTRACT(year FROM dateorder) AS year , EXTRACT(week FROM dateorder) AS week, pid, sum(pquantity*price) AS total "+
			"FROM addtoorder natural join orders "+
			"WHERE EXTRACT(year FROM dateorder) = repyear and EXTRACT(week FROM dateorder) = repweek "+
			"GROUP BY EXTRACT(year FROM dateorder), EXTRACT(week FROM dateorder),pid "+ 
			"ORDER BY (EXTRACT(year FROM dateorder), EXTRACT(week FROM dateorder),pid)  ASC";

	private static final String PROD_REP_TOTAL_RETURNS_DAY = "SELECT EXTRACT(year FROM rdate) AS year , EXTRACT(month FROM rdate) AS month, EXTRACT(day FROM rdate) AS day, pid, sum(rquantity*price) AS total "+
			"FROM refunds natural join productsreturned natural join addtoorder "+
			"WHERE EXTRACT(year FROM rdate) = repyear and EXTRACT(month FROM rdate) = repmonth and EXTRACT(day FROM rdate) = repday "+
			"GROUP BY EXTRACT(year FROM rdate), EXTRACT(month FROM rdate),EXTRACT(day FROM rdate),pid "+
			"ORDER BY (EXTRACT(year FROM rdate), EXTRACT(month FROM rdate),EXTRACT(day FROM rdate),pid)  ASC";

	private static final String PROD_REP_TOTAL_RETURNS_MONTH = "SELECT EXTRACT(year FROM rdate) AS year , EXTRACT(month FROM rdate) AS month, pid, sum(rquantity*price) AS total "+
			"FROM refunds natural join productsreturned natural join addtoorder "+
			"WHERE EXTRACT(year FROM rdate) = repyear and EXTRACT(month FROM rdate) = repmonth "+
			"GROUP BY EXTRACT(year FROM rdate), EXTRACT(month FROM rdate),pid "+
			"ORDER BY (EXTRACT(year FROM rdate), EXTRACT(month FROM rdate)) ASC";

	private static final String PROD_REP_TOTAL_RETURNS_WEEK = "SELECT EXTRACT(year FROM rdate) AS year , EXTRACT(week FROM rdate) AS week, pid, sum(rquantity*price) AS total "+
			"FROM refunds natural join productsreturned natural join addtoorder "+
			"WHERE EXTRACT(year FROM rdate) = repyear and EXTRACT(week FROM rdate) = repweek "+
			"GROUP BY EXTRACT(year FROM rdate), EXTRACT(week FROM rdate),pid "+
			"ORDER BY (EXTRACT(year FROM rdate), EXTRACT(week FROM rdate)) ASC";






	public ReportDAO() {
	}

	public ArrayList<Report> getProductReport(String rtype, String param1, Calendar cal) throws DataSourceException{
		Connection conn = null;
		ArrayList<Report> result = new ArrayList<Report>();
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH)+1;
		int year = cal.get(Calendar.YEAR);
		int week = cal.get(Calendar.WEEK_OF_YEAR)-1;
		try{
			if(rtype.equals("sales")){
				if(param1.equals("day")){
					conn = DataSource.getInstance().getJDBCConnection();

					String statement=PROD_REP_TOTAL_SALES_DAY;
					statement=statement.replace("repyear", ""+year);
					statement=statement.replace("repmonth",""+month);
					statement=statement.replace("repday",""+day);
					PreparedStatement stmt = conn.prepareStatement(statement);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()){
						result.add(new Report(rs.getString("year"), rs.getString("month"), rs.getString("day"), null, null, rs.getString("pid"), rs.getString("total")));
					}
					return result;
				}
				else if(param1.equals("month")){
					conn = DataSource.getInstance().getJDBCConnection();
					String statement=PROD_REP_TOTAL_SALES_MONTH;
					statement=statement.replace("repyear", ""+year);
					statement=statement.replace("repmonth",""+month);
					PreparedStatement stmt = conn.prepareStatement(statement);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()){
						result.add(new Report(rs.getString("year"), rs.getString("month"), null, null, null, rs.getString("pid"), rs.getString("total")));
					}
					return result;

				}
				else{//if(param1.equals("week"))
					conn = DataSource.getInstance().getJDBCConnection();
					String statement=PROD_REP_TOTAL_SALES_WEEK;
					statement=statement.replace("repyear", ""+year);
					statement=statement.replace("repweek",""+week);
					PreparedStatement stmt = conn.prepareStatement(statement);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()){
						result.add(new Report(rs.getString("year"), null, null, rs.getString("week"), null, rs.getString("pid"), rs.getString("total")));
					}
					return result;
				}
			}

			else if(rtype.equals("returns")){
				if(param1.equals("day")){
					conn = DataSource.getInstance().getJDBCConnection();
					String statement=PROD_REP_TOTAL_RETURNS_DAY;
					statement=statement.replace("repyear", ""+year);
					statement=statement.replace("repmonth",""+month);
					statement=statement.replace("repday",""+day);
					PreparedStatement stmt = conn.prepareStatement(statement);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()){
						result.add(new Report(rs.getString("year"), rs.getString("month"), rs.getString("day"), null, null, rs.getString("pid"), rs.getString("total")));
					}
					return result;
				}
				else if(param1.equals("month")){
					conn = DataSource.getInstance().getJDBCConnection();
					String statement=PROD_REP_TOTAL_RETURNS_MONTH;
					statement=statement.replace("repyear", ""+year);
					statement=statement.replace("repmonth",""+month);
					PreparedStatement stmt = conn.prepareStatement(statement);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()){
						result.add(new Report(rs.getString("year"), rs.getString("month"), null, null, null, rs.getString("pid"), rs.getString("total")));
					}
					return result;

				}
				else{//if(param1.equals("week"))
					conn = DataSource.getInstance().getJDBCConnection();
					String statement=PROD_REP_TOTAL_RETURNS_WEEK;
					statement=statement.replace("repyear", ""+year);
					statement=statement.replace("repweek",""+week);
					PreparedStatement stmt = conn.prepareStatement(statement);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()){
						result.add(new Report(rs.getString("year"), null, null, rs.getString("week"), null, rs.getString("pid"), rs.getString("total")));
					}
					return result;
				}
			}

			else{ //rtype.equals("revenue")
				ArrayList<Report> sales = getProductReport("sales",param1,cal);
				ArrayList<Report> returns = getProductReport("returns",param1,cal);
				ArrayList<Report> temp = new ArrayList<Report>();


				if(!sales.isEmpty()&&!returns.isEmpty()){
					for(int i=0;i<sales.size();i++){
						for(int y=0;y<returns.size();y++){
							if(sales.get(i).getPid().equals(returns.get(y).getPid())){
								Double sale = Double.parseDouble(sales.get(i).getTotal().substring(1));
								Double ret = Double.parseDouble(returns.get(y).getTotal().substring(1));
								temp.add(sales.get(i));
								DecimalFormat twoDForm = new DecimalFormat("#.##");
								Double total= Double.valueOf(twoDForm.format(sale-ret));
								temp.get(temp.size()-1).setTotal("$"+total);
								returns.remove(y);
								sales.set(i, null);
								break;
							}
						}
					}

					for(int i=0;i<sales.size();i++)
						if(sales.get(i) != null)
							temp.add(sales.get(i));

					while(!returns.isEmpty()){
						temp.add(returns.get(0));
						temp.get(temp.size()-1).setTotal("$-"+ temp.get(temp.size()-1).getTotal().substring(1));
						returns.remove(0);
					}
				}
				else{
					while(!sales.isEmpty()){
						temp.add(sales.get(0));
						sales.remove(0);
					}
					while(!returns.isEmpty()){
						temp.add(returns.get(0));	
						temp.get(temp.size()-1).setTotal("$-"+ temp.get(temp.size()-1).getTotal().substring(1));
						returns.remove(0);
					}
				}
				return temp;
			}

		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}







	public ArrayList<Report> getGeneralReport(String rtype, String param1, String param2) throws DataSourceException {
		if(rtype.equals("sales")){
			Connection conn = null;
			ArrayList<Report> result = new ArrayList<Report>();
			try {
				conn = DataSource.getInstance().getJDBCConnection();
				String statement=GEN_REP_TOTAL_SALES;
				statement=statement.replace("replace1", param1);
				statement=statement.replace("replace2", param2);
				PreparedStatement stmt = conn.prepareStatement(statement);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()){
					result.add(new Report(rs.getString("year"), rs.getString("month"), rs.getString("day"), rs.getString("week"), rs.getString("resetweek"), null, rs.getString("total")));
				}
				return result;
			}
			catch(Exception e){
				throw new DataSourceException("Unable to read data from data source. ", e);
			}
			finally {
				if (conn != null){
					try {
						conn.close();
					}
					catch(Exception e2){

					}
				}
			}

		}

		else if(rtype.equals("returns")){
			Connection conn = null;
			ArrayList<Report> result = new ArrayList<Report>();
			try {
				conn = DataSource.getInstance().getJDBCConnection();
				String statement=GEN_REP_TOTAL_RETURNS;
				statement=statement.replace("replace1", param1);
				statement=statement.replace("replace2", param2);
				PreparedStatement stmt = conn.prepareStatement(statement);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()){
					result.add(new Report(rs.getString("year"), rs.getString("month"), rs.getString("day"), rs.getString("week"), rs.getString("resetweek"), null, rs.getString("total")));
				}
				return result;
			}
			catch(Exception e){
				throw new DataSourceException("Unable to read data from data source. ", e);
			}
			finally {
				if (conn != null){
					try {
						conn.close();
					}
					catch(Exception e2){

					}
				}
			}
		}

		else{
			ArrayList<Report> sales = getGeneralReport("sales",param1,param2);
			ArrayList<Report> returns = getGeneralReport("returns",param1,param2);
			ArrayList<Report> temp = new ArrayList<Report>();


			try{
				while(!sales.isEmpty()&&!returns.isEmpty()){
					Double sale = Double.parseDouble(sales.get(0).getTotal().substring(1));
					Double ret = Double.parseDouble(returns.get(0).getTotal().substring(1));
					if(Integer.parseInt(sales.get(0).getDay())==Integer.parseInt(returns.get(0).getDay())){
						temp.add(sales.get(0));
						DecimalFormat twoDForm = new DecimalFormat("#.##");
						Double d= Double.valueOf(twoDForm.format(sale-ret));
						temp.get(temp.size()-1).setTotal("$"+d);
						sales.remove(0);
						returns.remove(0);		
					}
					else if(Integer.parseInt(sales.get(0).getDay())>Integer.parseInt(returns.get(0).getDay())){//Return date before Sale date
						temp.add(returns.get(0));
						temp.get(temp.size()-1).setTotal("$"+(ret*(-1)));
						returns.remove(0);
					}
					else{//Sale date greater
						temp.add(sales.get(0));
						sales.remove(0);
					}
				}
				while(!sales.isEmpty()){
					temp.add(sales.get(0));
					sales.remove(0);
				}
				while(!returns.isEmpty()){
					temp.add(returns.get(0));	
					temp.get(temp.size()-1).setTotal("$-"+ temp.get(temp.size()-1).getTotal().substring(1));
					returns.remove(0);
				}
				return temp;
			}
			catch (Exception e) {
			}
		}
		return null;
	}
}

