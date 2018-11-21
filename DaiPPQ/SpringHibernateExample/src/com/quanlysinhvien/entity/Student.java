package com.quanlysinhvien.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="sinhvien")
public class Student {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="masv")
	@NotEmpty(message = "Mã Sinh Viên không được để trống")
	private String masv;
	
	@Column(name="tensv")
	@NotEmpty(message = "Tên Sinh Viên không được để trống")
	private String tensv;
	
	@Column(name="namsinh")
	@Range(min = 1970, max = 2000, message = "Tuổi Sinh Viên không được để trống và chỉ từ 1970 đến 2000")
	private int namsinh;
	
	@Column(name="email")
	@NotEmpty(message = "Email không được để trống")
	private String email;
	
	@Column(name="diachi")
	@NotEmpty(message = "Địa chỉ không được để trống")
	private String diachi;
	
	@Column(name="lop")
	@NotEmpty(message = "Lớp học không được để trống")
	private String lop;
	
	@Column(name="image")
	private String image;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student(int id, String masv, String tensv, int namsinh, String email, String diachi,
			String lop, String image) {
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

	public Student(String masv, String tensv, int namsinh, String email, String diachi,
			String lop, String image) {
		super();
		this.masv = masv;
		this.tensv = tensv;
		this.namsinh = namsinh;
		this.email = email;
		this.diachi = diachi;
		this.lop = lop;
		this.image = image;
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
