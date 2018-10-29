package model.bean;

public class User {
	private String username;
	private String password;
	private String fullName;
	private String old;

	public User() {
	}

	public User(String username, String password, String fullName, String old) {
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.old = old;
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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getOld() {
		return old;
	}

	public void setOld(String old) {
		this.old = old;
	}

}
