package myJSF;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import model.dao.UserDAO;

@ManagedBean
public class UserBean {
	private int id;
	
	private String username = "abc";

	@ManagedProperty(value="#{userDAO}")
	private UserDAO userdao;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserDAO getUserdao() {
		return userdao;
	}

	public void setUserdao(UserDAO userdao) {
		this.userdao = userdao;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String sayHelloUser() {
		username= userdao.getNameUser(id);
		return "xinchao";
	}
}
