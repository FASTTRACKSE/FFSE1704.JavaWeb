package model.bo;

import model.dao.UserDao;

public class UserBO {

	private UserDao userDao = new UserDao();

	public boolean checkExistUser(String username, String password) {
		return userDao.getUser(username, password) != null;
	}
}
