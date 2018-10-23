package ffse1704.jsf.controller;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import ffse1704.jsf.service.LoginBo;

@ManagedBean
@SessionScoped
public class LoginController {
	private String username;
	private String password;

	private LoginBo adminBo = new LoginBo();

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void login() {

		FacesContext context = FacesContext.getCurrentInstance();
		if (adminBo.checkExistAdmin(username, password)) {
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
