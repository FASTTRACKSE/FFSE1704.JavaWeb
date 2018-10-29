package quanlyhocsinh.entity;

public class GiangVien1 implements GiangVien {
	String tenGiangVien = "Trần Minh Thắng";
	String email = "thangtm@fasttrack.edu.vn";

	public String getTenGiangVien() {
		return tenGiangVien;
	}

	public void setTenGiangVien(String tenGiangVien) {
		this.tenGiangVien = tenGiangVien;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public GiangVien1(String tenGiangVien, String email) {
		super();
		this.tenGiangVien = tenGiangVien;
		this.email = email;
	}

	public GiangVien1() {
		super();
		// TODO Auto-generated constructor stub
	}

}
