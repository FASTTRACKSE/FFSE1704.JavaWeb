package myJSF;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import model.dao.UserDAO;

@ManagedBean
public class UserBean {
	private int id;
	private String username = "abc";
	
	@ManagedProperty(value="#{userDAO}")
	private UserDAO userDAO;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	/*public void sayHelloUser() {
		System.out.println(username);
	}*/
	public String sayHelloUser() {
		username = userDAO.getNameUser(id);
		return "xinChao";
	}
}
