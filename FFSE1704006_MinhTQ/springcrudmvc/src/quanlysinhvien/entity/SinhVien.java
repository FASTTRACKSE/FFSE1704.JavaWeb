package quanlysinhvien.entity;

public class SinhVien {
	String id;
	String tenSinhVien;
	String tuoiSinhVien;
	String diaChi;
	String email;
	String avatar;
	

	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SinhVien(String id, String tenSinhVien, String tuoiSinhVien, String diaChi,String avatar, String email) {
		super();
		this.id = id;
		this.tenSinhVien = tenSinhVien;
		this.tuoiSinhVien = tuoiSinhVien;
		this.diaChi = diaChi;
		this.avatar = avatar;
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

	public String getTuoiSinhVien() {
		return tuoiSinhVien;
	}

	public void setTuoiSinhVien(String tuoiSinhVien) {
		this.tuoiSinhVien = tuoiSinhVien;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

}
