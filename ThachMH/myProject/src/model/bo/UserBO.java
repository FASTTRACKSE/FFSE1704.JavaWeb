package model.bo;

import model.dao.UserDao;

public class UserBO {
	private UserDao userDao = new UserDao();
	public boolean checkExistUser(String user, String password) {
		return userDao.getUser(user, password) != null;
	}
		
}
