package model.bean;

public class SinhVien {

	protected String id;
	protected String user, password, fullname;

	public SinhVien(String id, String user, String password, String fullname) {

		this.id = id;
		this.user = user;
		this.password = password;
		this.fullname = fullname;
	}

	public SinhVien(String user, String password, String fullname) {

		this.user = user;
		this.password = password;
		this.fullname = fullname;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

}
