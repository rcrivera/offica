package uprm.icom5016.services;

import java.util.ArrayList;


import uprm.icom5016.daos.DataSourceException;
import uprm.icom5016.daos.ProductDAO;
import uprm.icom5016.daos.ProductStatus;
import uprm.icom5016.dtos.*;

public class ProductService {
	private ProductService(){
		
	}
	public static ProductService newInstance(){
		return new ProductService();
	}
	
	public ArrayList<Product> getSearch(String searchQuery) throws DataSourceException{
		ProductDAO dao = new ProductDAO();
		return dao.getSearch(searchQuery);
	}
	
	public ProductStatus addNewProduct(Product product) throws DataSourceException{
		ProductDAO dao=new ProductDAO();
		return dao.addProduct(product);
	}
}

