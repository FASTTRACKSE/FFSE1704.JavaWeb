package model.entity;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class SinhVien {
	private String maSinhVien;
	private String tenSinhVien;
	private String tuoiSinhVien;
	private String lopHoc;
	private String diaChi;

	public SinhVien(String maSinhVien, String tenSinhVien, String tuoiSinhVien, String lopHoc, String diaChi) {
	
		this.maSinhVien = maSinhVien;
		this.tenSinhVien = tenSinhVien;
		this.tuoiSinhVien = tuoiSinhVien;
		this.lopHoc = lopHoc;
		this.diaChi = diaChi;
	}

	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public String getTenSinhVien() {
		return tenSinhVien;
	}

	public void setTenSinhVien(String tenSinhVien) {
		this.tenSinhVien = tenSinhVien;
	}

	public String getTuoiSinhVien() {
		return tuoiSinhVien;
	}

	public void setTuoiSinhVien(String tuoiSinhVien) {
		this.tuoiSinhVien = tuoiSinhVien;
	}

	public String getLopHoc() {
		return lopHoc;
	}

	public void setLopHoc(String lopHoc) {
		this.lopHoc = lopHoc;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
}
