package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;


import model.dao.UserDao;
import model.entity.Admin;
import model.service.UserService;

@ManagedBean
@SessionScoped
public class UserController {
	private String userName;
	private String passWord;


	@ManagedProperty(value = "#{userDao}")
	private UserDao userDao;

	private Admin admin;

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public String action() {
		admin = userDao.loginAdmin(userName, passWord);
		if(admin != null) {
			userName = admin.getUserName();
			return "hello?faces-redirect=true";
		}else {
			return "index";
		}
		
		
	}
	

}
