package model.entity;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class SinhVien {
	private String id;
	private String masv;
	private String ho;
	private String ten;
	private String gioiTinh;
	private String namsinh;
	private String lop;
	private String image;

	public SinhVien(String id, String masv, String ho, String ten, String gioiTinh, String namsinh, String lop,
			String image) {
		super();
		this.id = id;
		this.masv = masv;
		this.ho = ho;
		this.ten = ten;
		this.gioiTinh = gioiTinh;
		this.namsinh = namsinh;
		this.lop = lop;
		this.image = image;
	}

	public SinhVien(String masv, String ho, String ten, String gioiTinh, String namsinh, String lop, String image) {
		super();
		this.masv = masv;
		this.ho = ho;
		this.ten = ten;
		this.gioiTinh = gioiTinh;
		this.namsinh = namsinh;
		this.lop = lop;
		this.image = image;
	}

	public SinhVien() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMasv() {
		return masv;
	}

	public void setMasv(String masv) {
		this.masv = masv;
	}

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getNamsinh() {
		return namsinh;
	}

	public void setNamsinh(String namsinh) {
		this.namsinh = namsinh;
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
