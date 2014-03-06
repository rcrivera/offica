package uprm.icom5016.services;

import java.util.ArrayList;

import uprm.icom5016.daos.DataSourceException;
import uprm.icom5016.daos.ProductDAO;
import uprm.icom5016.dtos.Product;

public class BrowseService {
	
private BrowseService(){
		
	}
	public static BrowseService newInstance(){
		return new BrowseService();
	}
	
	public ArrayList<Product> browse(String cat, String subcat) throws DataSourceException{
		ProductDAO dao = new ProductDAO();
		return dao.browse(cat,subcat);
	}

}
