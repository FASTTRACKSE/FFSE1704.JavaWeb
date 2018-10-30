package giangvien.entity;

public class GiangVien {
	public String hoTenGiangVien;
	public String email;

	public String getHoTenGiangVien() {
		return hoTenGiangVien;
	}

	public void setHoTenGiangVien(String hoTenGiangVien) {
		this.hoTenGiangVien = hoTenGiangVien;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public GiangVien(String hoTenGiangVien, String email) {
		super();
		this.hoTenGiangVien = hoTenGiangVien;
		this.email = email;
	}

	public GiangVien() {
		super();
		// TODO Auto-generated constructor stub
	}

}
