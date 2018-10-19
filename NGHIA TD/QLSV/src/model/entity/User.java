package model.entity;

public class User {
	private String id;
	private String user;
	private String pass;
	public User(String id, String user, String pass) {
		super();
		this.id = id;
		this.user = user;
		this.pass = pass;
	}
	
	public User( String user, String pass) {
		super();
		
		this.user = user;
		this.pass = pass;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
}
