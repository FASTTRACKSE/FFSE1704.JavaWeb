package model.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class SinhVien {

	protected String id;
	protected String user, password, fullname, image;

	public SinhVien(String id, String user, String password, String fullname ,String image) {

		this.id = id;
		this.user = user;
		this.password = password;
		this.fullname = fullname;
		this.image = image;
	}

	public SinhVien(String user, String password, String fullname ,String image) {

		this.user = user;
		this.password = password;
		this.fullname = fullname;
		this.image = image;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	

	
}
