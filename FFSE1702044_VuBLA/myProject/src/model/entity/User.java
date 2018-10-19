package model.entity;

public class User {
	private String id_user, user, pass, fullname, old;

	public User(String id_user, String user, String pass, String fullname, String old) {
		this.id_user = id_user;
		this.user = user;
		this.pass = pass;
		this.fullname = fullname;
		this.old = old;
	}

	public User(String id_user, String user, String pass) {
		this.id_user = id_user;
		this.user = user;
		this.pass = pass;
	}

	public String getId_user() {
		return id_user;
	}

	public void setId_user(String id_user) {
		this.id_user = id_user;
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

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getOld() {
		return old;
	}

	public void setOld(String old) {
		this.old = old;
	}

}
