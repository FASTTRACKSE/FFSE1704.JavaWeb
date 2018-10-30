package quanlysinhvien.entity;

public class SinhVien {
	String id;
	String tenHocSinh;
	String tuoiHocSinh;
	String diaChi;
	String email;

	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SinhVien(String id, String tenHocSinh, String tuoiHocSinh, String diaChi, String email) {
		super();
		this.id = id;
		this.tenHocSinh = tenHocSinh;
		this.tuoiHocSinh = tuoiHocSinh;
		this.diaChi = diaChi;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTenHocSinh() {
		return tenHocSinh;
	}

	public void setTenHocSinh(String tenHocSinh) {
		this.tenHocSinh = tenHocSinh;
	}

	public String getTuoiHocSinh() {
		return tuoiHocSinh;
	}

	public void setTuoiHocSinh(String tuoiHocSinh) {
		this.tuoiHocSinh = tuoiHocSinh;
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

}
