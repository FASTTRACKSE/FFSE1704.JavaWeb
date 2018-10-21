package model.entity;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class SinhVien {
	private String id;
	private String name;
	private String age;
	private String diaChi;
	private String sdt;
	private String images;
	
	public SinhVien(String id, String name, String age, String diaChi, String sdt,String images) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.images = images;
	}
	public SinhVien( String name, String age, String diaChi, String sdt,String images) {
		
		
		this.name = name;
		this.age = age;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.images = images;
	}
	public SinhVien() {
		
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
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}

}
