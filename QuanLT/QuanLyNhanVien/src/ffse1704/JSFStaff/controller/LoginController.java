package ffse1704.JSFStaff.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ffse1704.JSFStaff.dao.LoGinDAO;

@ManagedBean
@SessionScoped
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
