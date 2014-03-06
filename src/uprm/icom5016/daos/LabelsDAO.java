package uprm.icom5016.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



import uprm.icom5016.dtos.Labels;

public class LabelsDAO {
	
	private static final String LABELS_BY_ID = "select pId, pName, price, picLink, brand, stock, description, model, size, color, quantity, type from labels where pId = ?;";
	private static final String INSERT_LABELS = "insert into labels(pId, pName, price, picLink, brand, stock, description, model, size, color, quantity, type) values (?, ?, ? , ? , ?);";
	
	public LabelsDAO(){
		
	}
	
	public Labels getLabels(Integer id) throws DataSourceException{
		
		Connection conn = null;
		Labels result = null;
		
		try {
			conn = DataSource.getInstance().getJDBCConnection();
			PreparedStatement stmt = conn.prepareStatement(LABELS_BY_ID);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()){
				result = new Labels();
				result.setPid(rs.getString(1));
				result.setPname(rs.getString(2));
				result.setPrice(rs.getString(3));
				result.setPicLink(rs.getString(4));
				result.setBrand(rs.getString(5));
				result.setStock(rs.getInt(6));
				result.setDescription(rs.getString(7));
				result.setModel(rs.getString(8));
				result.setSize(rs.getString(9));
				result.setColor(rs.getString(10));
				result.setQuantity(rs.getString(11));
				result.setType(rs.getString(12));
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
	
	
}
