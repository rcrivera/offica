package uprm.icom5016.services;

import uprm.icom5016.daos.DataSourceException;
import uprm.icom5016.daos.UserDAO;
import uprm.icom5016.daos.UserStatus;
import uprm.icom5016.dtos.User;

public class UserService {
	
	
	private UserService(){
			
		}
	
	
	
		public static UserService newInstance(){
			return new UserService();
		}
		
		
		public User getUser(String searchQuery) throws DataSourceException{
			UserDAO dao = new UserDAO();
			return dao.getUser(searchQuery);
		}
		
		public UserStatus addUser(User u) throws DataSourceException{
			UserDAO dao = new UserDAO();
			return dao.addUser(u);
		}
		
		
		public boolean editEmail(String newemail, User u){
			UserDAO dao = new UserDAO();
			return dao.editEmail(newemail, u);
		}



		public boolean editPhone(String tochange, User u) {
			UserDAO dao = new UserDAO();
			return dao.editPhone(tochange, u);
		}
		
}
