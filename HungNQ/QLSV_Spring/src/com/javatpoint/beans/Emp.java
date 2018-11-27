package com.javatpoint.beans;

public class Emp {
	private int id;
	private String masv;
	private String tensv;
	private int namsinh;
	private String email;
	private String diachi;
	private String lophoc;

	public Emp(int id, String masv, String tensv, int namsinh, String email, String diachi, String lophoc) {
		super();
		this.id = id;
		this.masv = masv;
		this.tensv = tensv;
		this.namsinh = namsinh;
		this.email = email;
		this.diachi = diachi;
		this.lophoc = lophoc;
	}

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMasv() {
		return masv;
	}

	public void setMasv(String masv) {
		this.masv = masv;
	}

	public String getTensv() {
		return tensv;
	}

	public void setTensv(String tensv) {
		this.tensv = tensv;
	}

	public int getNamsinh() {
		return namsinh;
	}

	public void setNamsinh(int namsinh) {
		this.namsinh = namsinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getLophoc() {
		return lophoc;
	}

	public void setLophoc(String lophoc) {
		this.lophoc = lophoc;
	}

}