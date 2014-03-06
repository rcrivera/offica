package uprm.icom5016.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import uprm.icom5016.dtos.CreditCard;
import uprm.icom5016.dtos.Product;
import uprm.icom5016.dtos.Return;
import uprm.icom5016.dtos.ReturnedProduct;
import uprm.icom5016.dtos.User;

public class ReturnDAO {

	private static final String GET_RETURN_ORDER = "SELECT returnid, pquantity, price, prid, pid, rquantity , orderid, rdate, reason, dateorder, ccnumber, username FROM productsreturned natural join refunds natural join orders natural join addtoorder GROUP BY returnid, pquantity, price, prid, pid, rquantity , orderid, rdate, reason, dateorder, ccnumber, username ORDER BY returnid, rdate, username ASC";

	public ReturnDAO(){

	}



	public ArrayList<Return> getReturnReqs() throws DataSourceException {
		Connection conn = null;
		ArrayList<Return> results = new ArrayList<Return>();

		try{
			conn = DataSource.getInstance().getJDBCConnection();
			PreparedStatement stmt = conn.prepareStatement(GET_RETURN_ORDER);
			ResultSet rs = stmt.executeQuery();

			while(rs.next()){
				Return r = new Return();
				User u = new UserDAO().getUser(rs.getString("username"));
				CreditCard cc = new CreditCardDAO().getCard((rs.getString("ccnumber")));
				String reason = rs.getString("reason");
				String date = rs.getString("rdate");
				String dateOrder = rs.getString("dateorder");
				String orderid = rs.getString("orderid");
				String rid = rs.getString("returnid");
				String pid = rs.getString("pid");
				String rquantity = rs.getString("rquantity");
				String pquantity = rs.getString("pquantity");
				String price = rs.getString("price");

				Product p = new ProductDAO().getProduct(pid);
				ReturnedProduct rp = new ReturnedProduct(p);
				rp.setQuantity2Return(rquantity);
				rp.setPurchasedPrice(price);
				rp.setQuantityPurchased(pquantity);

				if(!results.isEmpty()){



					if(results.get(results.size()-1).getReturnno().equals(rs.getString("returnid"))){
						results.get(results.size()-1).getItems().add(rp);
					}
					else{
						r.setCard(cc);
						r.setDate(date);
						r.setOrderdate(dateOrder);
						r.setReturnno(rid);
						r.setOrderno(orderid);
						r.setUser(u);
						r.setReason(reason);
						r.getItems().add(rp);
						results.add(r);
					}

				}
				else{
					r.setCard(cc);
					r.setDate(date);
					r.setOrderdate(dateOrder);
					r.setReturnno(rid);
					r.setOrderno(orderid);
					r.setUser(u);
					r.setReason(reason);
					r.getItems().add(rp);
					results.add(r);
				}
			}
			return results;
		}
		catch(Exception e){
			return null;
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
}