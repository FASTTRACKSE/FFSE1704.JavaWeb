package model.bo;

import model.dao.UserDAO;

public class UserBO {
	private  UserDAO userDao = new UserDAO() {
		
	};
	
	public boolean checkExisUser(String username, String password) {
		return userDao.getUser(username, password) != null;
	}
}
