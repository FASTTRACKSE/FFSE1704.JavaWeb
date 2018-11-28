package model.bo;

import model.dao.UserDAO;

public class UserBo {

	private UserDAO userDao = new UserDAO();
	public boolean checkExistUser(String userName, String passWord) {
		return userDao.getUser(userName, passWord) != null;
	}
	public boolean checkExistUser(String id) {
		return userDao.searchUser(id) != null;
	}
}
