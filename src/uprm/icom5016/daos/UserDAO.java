package uprm.icom5016.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import uprm.icom5016.dtos.User;

public class UserDAO {

	private static final String GET_USER = "SELECT username, pass, isAdmin, firstName, lastName, address, city, state, zipcode, country, email, phone FROM Users WHERE lower(username) LIKE ? or lower(email) LIKE ? or lower(firstName) LIKE ? or lower(lastName) LIKE ?";
	private static final String ADD_USER = "INSERT INTO users (username,pass,isadmin,firstname,lastname,address,city,state,zipcode,country,email,phone) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING username";
	private static final String MODIFY_EMAIL = "UPDATE users SET email = ? WHERE username LIKE ?";
	private static final String MODIFY_PHONE = "UPDATE users SET phone = ? WHERE username LIKE ?";
	
	public UserDAO(){

	}

	
	public UserStatus addUser(User u) throws DataSourceException{
		Connection conn = null;

		try{
			UserDAO dao = new UserDAO();
			User user = dao.getUser(u.getUserName());
			if(user.getUserName()!=null){
				return UserStatus.UserAlreadyInSystem;
			}
			conn = DataSource.getInstance().getJDBCConnection();
			PreparedStatement stmt = conn.prepareStatement(ADD_USER);

			stmt.setString(1, u.getUserName());
			stmt.setString(2, u.getPass());
			stmt.setString(3, u.getIsAdmin());
			stmt.setString(4, u.getFirstName());
			stmt.setString(5, u.getLastName());
			stmt.setString(6, u.getAddress());
			stmt.setString(7, u.getCity());
			stmt.setString(8, u.getState());
			stmt.setString(9, u.getZipcode());
			stmt.setString(10, u.getCountry());
			stmt.setString(11, u.getEmail());
			stmt.setString(12, u.getPhone());
			

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
		return UserStatus.Ok;
	}



	
	
	public boolean editEmail(String newemail, User u){
		Connection conn = null;
		try{
			conn = DataSource.getInstance().getJDBCConnection();
			PreparedStatement stmt = conn.prepareStatement(MODIFY_EMAIL);
			
			stmt.setString(1, newemail);
			stmt.setString(2, u.getUserName());
			ResultSet rs = stmt.executeQuery();
			if(!rs.next())
				return true;
			else
				return false;
		}
		catch(Exception e){
			return false;
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
	
	
	public User getUser(String userID) throws DataSourceException{
		Connection conn = null;
		User userToReturn = new User();
		String param = "%"+userID.toLowerCase()+"%";
		try {
			conn = DataSource.getInstance().getJDBCConnection();
			PreparedStatement stmt = conn.prepareStatement(GET_USER);
			stmt.setString(1, param);
			stmt.setString(2, param);
			stmt.setString(3, param);
			stmt.setString(4, param);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				userToReturn.setUserName(rs.getString(1));
				userToReturn.setPass(rs.getString(2));
				userToReturn.setIsAdmin(rs.getString(3));
				userToReturn.setFirstName(rs.getString(4));
				userToReturn.setLastName(rs.getString(5));
				userToReturn.setAddress(rs.getString(6));
				userToReturn.setCity(rs.getString(7));
				userToReturn.setState(rs.getString(8));
				userToReturn.setZipcode(rs.getString(9));
				userToReturn.setCountry(rs.getString(10));
				userToReturn.setEmail(rs.getString(11));
				userToReturn.setPhone(rs.getString(12));
			}

			return userToReturn;
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


	public boolean editPhone(String tochange, User u) {
		Connection conn = null;
		try{
			conn = DataSource.getInstance().getJDBCConnection();
			PreparedStatement stmt = conn.prepareStatement(MODIFY_PHONE);
			
			stmt.setString(1, tochange);
			stmt.setString(2, u.getUserName());
			ResultSet rs = stmt.executeQuery();
			if(!rs.next())
				return true;
			else
				return false;
		}
		catch(Exception e){
			return false;
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
