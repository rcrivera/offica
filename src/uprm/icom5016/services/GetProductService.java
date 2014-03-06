package uprm.icom5016.services;

import uprm.icom5016.daos.DataSourceException;
import uprm.icom5016.daos.ProductDAO;
import uprm.icom5016.dtos.Product;

public class GetProductService {


	private GetProductService(){

	}
	public static GetProductService newInstance(){
		return new GetProductService();
	}

	public Product getProduct(String pid) throws DataSourceException{
		ProductDAO dao = new ProductDAO();
		return dao.getProduct(pid);
	}
}
