package model.entity;


public class SinhVien {
	private String id;
	private String tenSinhVien;
	private String maSinhVien;
	private String lopHoc;
	private String tuoiSinhVien;
	private String gioiTinh;
	private String diaChi;
	private String soDT;
	private String email;

	public SinhVien(String id, String tenSinhVien, String maSinhVien, String lopHoc, String tuoiSinhVien,
			String gioiTinh, String diaChi, String soDT, String email) {
		super();
		this.id = id;
		this.tenSinhVien = tenSinhVien;
		this.maSinhVien = maSinhVien;
		this.lopHoc = lopHoc;
		this.tuoiSinhVien = tuoiSinhVien;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.soDT = soDT;
		this.email = email;
	}
	
	public SinhVien( String maSinhVien, String tenSinhVien, String lopHoc, String tuoiSinhVien,
			String gioiTinh, String diaChi, String soDT, String email) {
		super();
		this.maSinhVien = maSinhVien;
		this.tenSinhVien = tenSinhVien;
		this.lopHoc = lopHoc;
		this.tuoiSinhVien = tuoiSinhVien;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.soDT = soDT;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTenSinhVien() {
		return tenSinhVien;
	}

	public void setTenSinhVien(String tenSinhVien) {
		this.tenSinhVien = tenSinhVien;
	}

	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public String getLopHoc() {
		return lopHoc;
	}

	public void setLopHoc(String lopHoc) {
		this.lopHoc = lopHoc;
	}

	public String getTuoiSinhVien() {
		return tuoiSinhVien;
	}

	public void setTuoiSinhVien(String tuoiSinhVien) {
		this.tuoiSinhVien = tuoiSinhVien;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDT() {
		return soDT;
	}

	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
