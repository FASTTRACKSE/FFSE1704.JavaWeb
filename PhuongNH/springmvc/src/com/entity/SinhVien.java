package com.entity;

public class SinhVien {  
private int id;  
private String maSV;  
private String ten;  
private int namSinh;  
private String email;  
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
private String diaChi;  
private String lopHoc;  

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTen() {
	return ten;
}
public void setTen(String ten) {
	this.ten = ten;
}
public int getNamSinh() {
	return namSinh;
}
public void setNamSinh(int namSinh) {
	this.namSinh = namSinh;
}
public String getMaSV() {
	return maSV;
}
public void setMaSV(String maSV) {
	this.maSV = maSV;
}
public String getDiaChi() {
	return diaChi;
}
public void setDiaChi(String diaChi) {
	this.diaChi = diaChi;
}
public String getLopHoc() {
	return lopHoc;
}
public void setLopHoc(String lopHoc) {
	this.lopHoc = lopHoc;
}
public SinhVien() {
	super();
	// TODO Auto-generated constructor stub
}
public SinhVien(int id, String maSV, String ten, int namSinh, String email, String diaChi, String lopHoc) {
	super();
	this.id = id;
	this.maSV = maSV;
	this.ten = ten;
	this.namSinh = namSinh;
	this.email = email;
	this.diaChi = diaChi;
	this.lopHoc = lopHoc;
}

}
