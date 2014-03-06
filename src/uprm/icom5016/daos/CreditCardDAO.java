package uprm.icom5016.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import uprm.icom5016.dtos.CreditCard;

public class CreditCardDAO {

	private static final String GET_CARD = "SELECT ccnumber, cardholder, ctype, expyear, expmonth, cvv, username FROM creditcards WHERE lower(ccnumber) LIKE ? or lower(ctype) LIKE ? or lower(username) LIKE ?";
	private static final String ADD_CARD = "INSERT INTO creditcards values(?,?,?,?,?,?,?) RETURNING ccnumber";
	private static final String REMOVE_CARD="DELETE FROM creditcards WHERE ccnumber = ? RETURNING ccnumber";


	public ArrayList<CreditCard> getCards(String searchQuery) {
		Connection conn = null;
		ArrayList<CreditCard> cards = new ArrayList<CreditCard>();
		String param = "%"+searchQuery.toLowerCase()+"%";
		try {
			conn = DataSource.getInstance().getJDBCConnection();
			PreparedStatement stmt = conn.prepareStatement(GET_CARD);
			stmt.setString(1, param);
			stmt.setString(2, param);
			stmt.setString(3, param);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				CreditCard card = new CreditCard();
				card.setCcnumber(rs.getString(1));
				card.setcType(rs.getString(3));
				card.setCvv(rs.getString(6));
				card.setExpMonth(rs.getString(5));
				card.setExpYear(rs.getString(4));
				card.setCardHolder(rs.getString(2));

				cards.add(card);
			}
			return cards;
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



	public CreditCardStatus addCard(CreditCard card) throws DataSourceException{
		Connection conn = null;
		try{
			CreditCardDAO dao = new CreditCardDAO();
			CreditCard c = dao.getCard(card.getCcnumber());
			if(c.getCcnumber()!=null){
				return CreditCardStatus.CreditCardAlreadyAdded;
			}
			conn = DataSource.getInstance().getJDBCConnection();
			PreparedStatement stmt = conn.prepareStatement(ADD_CARD);

			stmt.setString(1, card.getCcnumber());
			stmt.setString(2, card.getCardHolder());
			stmt.setString(3, card.getcType());
			stmt.setString(4, card.getExpYear());
			stmt.setString(5, card.getExpMonth());
			stmt.setString(6, card.getCvv());
			stmt.setString(7, card.getUsername());
			ResultSet rs = stmt.executeQuery();
			if (!rs.next()){
				throw new SQLException("Insert row count was not one.");
			}
		}
		catch(Exception e){
			throw new DataSourceException("Unable to insert data from data source. ", e);
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
		return CreditCardStatus.OK;
	}



	public CreditCardStatus deleteCard(String cardno) throws DataSourceException{

		Connection conn = null;
		try{
			conn = DataSource.getInstance().getJDBCConnection();
			PreparedStatement stmt = conn.prepareStatement(REMOVE_CARD);
			stmt.setString(1, cardno);
			ResultSet rs = stmt.executeQuery();
			if(!rs.next()){
				throw new SQLException("Did not remove correctly.");
			}
		}
		catch(Exception e){
			throw new DataSourceException("Unable to remove data from data source. ", e);
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
		return CreditCardStatus.RemovalSuccesful;
	}


	public CreditCard getCard(String searchQuery) {
		Connection conn = null;
		CreditCard card = new CreditCard();
		String param = "%"+searchQuery.toLowerCase()+"%";
		try {
			conn = DataSource.getInstance().getJDBCConnection();
			PreparedStatement stmt = conn.prepareStatement(GET_CARD);
			stmt.setString(1, param);
			stmt.setString(2, param);
			stmt.setString(3, param);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				card.setCcnumber(rs.getString(1));
				card.setcType(rs.getString(3));
				card.setCvv(rs.getString(6));
				card.setExpMonth(rs.getString(5));
				card.setExpYear(rs.getString(4));
				card.setCardHolder(rs.getString(2));
			}
			return card;
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
