package ffse1704.JSFStaff.controller;

import ffse1704.JSFStaff.dao.LoGinDAO;

public class LoginController {
	
	LoGinDAO loginDAO = new LoGinDAO();
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
