package model.entity;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class NhanVien {
	private String id;
	private String name;
	private String date;
	private String gender;
	private String address;
	private String images;

	public NhanVien(String id, String name, String date, String gender, String address, String images) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.gender = gender;
		this.address = address;
		this.images = images;
	}

	public NhanVien(String name, String date, String gender, String address, String images) {
		super();
		this.name = name;
		this.date = date;
		this.gender = gender;
		this.address = address;
		this.images = images;
	}

	public NhanVien() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}
}
