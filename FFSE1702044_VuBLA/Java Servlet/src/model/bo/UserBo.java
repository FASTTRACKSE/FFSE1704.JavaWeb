package model.bo;

import model.dao.UserDao;

public class UserBo {
	private UserDao userDAO = new UserDao();
	public boolean checkExitUser(String user,String pass) {
		return userDAO.getUser(user, pass) != null;
	}
	
}
