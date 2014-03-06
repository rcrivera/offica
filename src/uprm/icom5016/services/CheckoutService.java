package uprm.icom5016.services;

import uprm.icom5016.daos.CheckoutDAO;
import uprm.icom5016.daos.CheckoutStatus;
import uprm.icom5016.daos.DataSourceException;
import uprm.icom5016.dtos.Checkout;


public class CheckoutService {


	private CheckoutService(){

	}
	public static CheckoutService newInstance(){
		return new CheckoutService();
	}

	public CheckoutStatus processCheckout(Checkout checkout) throws DataSourceException{
		CheckoutDAO dao = new CheckoutDAO();
		return dao.processCheckout(checkout);
	}
}
