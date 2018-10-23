package model.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.dao.LoginDAO;

@ManagedBean
@SessionScoped
public class LoginController {
	
	LoginDAO loginDAO = new LoginDAO();
	public String checkLogin(String userName, String passWord) {
		int test = loginDAO.checkLogin(userName,passWord);
		if(test ==1) {
			return "index?faces-redirect=true";
		}
		else {
			return "login?faces-redirect=true";
		}
		
	}
}