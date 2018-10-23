package ffse1704.jsfstaff.controller;

import java.io.IOException;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ffse1704.jsfstaff.dao.LoGinDAO;

@ManagedBean
@SessionScoped
public class LoginController {
	
	LoGinDAO loginDAO = new LoGinDAO();
	public String checkLogin(String userName, String passWord) {
		int test = loginDAO.checkLogin(userName,passWord);
		FacesContext context = FacesContext.getCurrentInstance();
		if(test ==1) {
			context.getExternalContext().getSessionMap().put("admin", userName);
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