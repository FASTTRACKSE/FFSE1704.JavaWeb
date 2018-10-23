package model.entity;

import javax.faces.bean.ManagedBean;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@ManagedBean
public class NhanVien {
	int id;
	
	@NotNull(message = "Tên không được để trống")
	@Size(min=1, message = "Tên không được để trống")
	String name;
	
	@NotNull(message = "Năm sinh không được để trống")
	@Range (min=1900, max=2000, message = "Năm sinh từ 1900 - 2000")
	int date;
	
	String gender;
	int address;
	String images;
	
	public NhanVien() {
		super();
	}

	public NhanVien(String name, int date, String gender, int address, String images) {
		super();
		this.name = name;
		this.date = date;
		this.gender = gender;
		this.address = address;
		this.images = images;
	}
	
	public NhanVien(int id, String name, int date, String gender, int address, String images) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.gender = gender;
		this.address = address;
		this.images = images;
	}

	public int  getId() {
		return id;
	}

	public void setId(int  id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAddress() {
		return address;
	}

	public void setAddress(int address) {
		this.address = address;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}
}
