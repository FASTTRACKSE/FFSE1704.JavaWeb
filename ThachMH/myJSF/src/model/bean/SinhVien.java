package model.bean;

import java.util.List;

public class SinhVien {
	private int id;
	private String name;
	private String email;
	private String password;
	private String gender;
	private String address;

	public SinhVien(int id, String name, String email, String password, String gender, String address) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.address = address;
	}

	public SinhVien(String name, String email, String password, String gender, String address) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}

	public String getpassword() {
		return password;
	}

	public void setpassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	

}
