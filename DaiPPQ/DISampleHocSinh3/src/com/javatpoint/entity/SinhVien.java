package com.javatpoint.entity;


import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Range;

public class SinhVien {
	private int id;
	
	@NotEmpty
	private String masv;
	
	@NotEmpty(message = " Ten SV not null")
	private String tensv;
	
	@Range
	private int namsinh;
	
	@NotEmpty
	private String email;
	
	@NotEmpty
	private String diachi;
	
	@NotEmpty
	private String lop;
	
	@NotEmpty(message = " image not null")
	private String image;
/*
	public SinhVien() {
		super();
	}
	
	public SinhVien(String masv, String tensv, int namsinh, String email, String diachi, String lop, String image) {
		super();
		this.masv = masv;
		this.tensv = tensv;
		this.namsinh = namsinh;
		this.email = email;
		this.diachi = diachi;
		this.lop = lop;
		this.image = image;
	}
	
	public SinhVien(int id, String masv, String tensv, int namsinh, String email, String diachi, String lop, String image) {
		super();
		this.id = id;
		this.masv = masv;
		this.tensv = tensv;
		this.namsinh = namsinh;
		this.email = email;
		this.diachi = diachi;
		this.lop = lop;
		this.image = image;
	}
*/
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

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
