package model.service;

import model.dao.UserDao;

public class UserService {
	private UserDao userDao = new UserDao();
	public boolean checkExistAdmin(String userName, String passWord) {
		return userDao.loginAdmin(userName, passWord) != null;
	}
}
