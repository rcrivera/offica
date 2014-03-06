package uprm.icom5016.services;

import java.util.ArrayList;

import uprm.icom5016.daos.CreditCardDAO;
import uprm.icom5016.daos.CreditCardStatus;
import uprm.icom5016.daos.DataSourceException;
import uprm.icom5016.dtos.CreditCard;

public class CreditCardService {

	
	public CreditCardService(){
		
	}
	
	
	public static CreditCardService newInstance(){
		return new CreditCardService();
	}
	
	
	public CreditCard getCardByNo(String cardNo){
		CreditCardDAO dao = new CreditCardDAO();
		return dao.getCard(cardNo);
	}
	
	public ArrayList<CreditCard> getCardsByUser(String cardNo){
		CreditCardDAO dao = new CreditCardDAO();
		return dao.getCards(cardNo);
	}
	
	public ArrayList<CreditCard> getCardsByType(String cardNo){
		CreditCardDAO dao = new CreditCardDAO();
		return dao.getCards(cardNo);
	}
	
	public CreditCardStatus addCard(CreditCard c) throws DataSourceException{
		CreditCardDAO dao = new CreditCardDAO();
		return dao.addCard(c);
	}
	
	public CreditCardStatus deleteCard(String c) throws DataSourceException{
		CreditCardDAO dao = new CreditCardDAO();
		return dao.deleteCard(c);
	} 
	
}
