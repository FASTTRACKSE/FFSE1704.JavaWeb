package com.entity;

public class TinhThanhPho {
	int id;
	String tenTinhThanh;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenTinhThanh() {
		return tenTinhThanh;
	}

	public void setTenTinhThanh(String tenTinhThanh) {
		this.tenTinhThanh = tenTinhThanh;
	}

	public TinhThanhPho(int id, String tenTinhThanh) {
		super();
		this.id = id;
		this.tenTinhThanh = tenTinhThanh;
	}

	public TinhThanhPho() {
		super();
		// TODO Auto-generated constructor stub
	}

}
