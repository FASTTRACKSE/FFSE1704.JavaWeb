package model.bo;

import model.dao.UserDao;

public class UserBO {
	UserDao userdao = new UserDao();
	public boolean checkloGin(String username,String pass) {
		return userdao.getUser(username,pass)!=null;
		
	}
}
