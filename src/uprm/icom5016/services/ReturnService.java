package uprm.icom5016.services;

import java.util.ArrayList;

import uprm.icom5016.daos.DataSourceException;
import uprm.icom5016.daos.ReturnDAO;
import uprm.icom5016.dtos.Return;

public class ReturnService {

	
	private ReturnService(){
		
	}
	
	public static ReturnService newInstance(){
		return new ReturnService();
	}
	
	
	public ArrayList<Return> getReturnReqs() throws DataSourceException{
		ReturnDAO dao = new ReturnDAO();
		return dao.getReturnReqs();
	}
	
}
