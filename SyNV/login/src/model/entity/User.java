package model.entity;

public class User {
	private String id;
	private String username;
	private String password;
	private String fullname;
	private String old;
	
	public User(String username, String password, String fullname, String old) {
		super();
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.old = old;
	}
	public User(String id, String username, String password, String fullname, String old) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.old = old;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fulname) {
		this.fullname = fulname;
	}
	public String getOld() {
		return old;
	}
	public void setOld(String old) {
		this.old = old;
	}
}
