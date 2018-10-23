package model.controller;

import java.io.IOException;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.dao.LoginDAO;

@ManagedBean
@SessionScoped
public class LoginController {
	LoginDAO loginDAO = new LoginDAO();

	public String checkLogin(String username, String password) {
		int test = loginDAO.checkLogin(username, password);
		FacesContext context = FacesContext.getCurrentInstance();
		if (test == 1) {
			context.getExternalContext().getSessionMap().put("admin", username);
			try {
				context.getExternalContext().redirect("index.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			// báo mess thất bại
			context.addMessage(null, new FacesMessage("sai tài khoản mật khẩu."));
		}
		return null;

	}

	public void logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().invalidateSession();
		try {
			context.getExternalContext().redirect("login.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}