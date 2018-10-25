package quanlyhocsinh.entity;

public class GiangVienTin implements GiangVien {
	String tenGiangVien = "Cao Lê Thành ";

	public GiangVienTin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GiangVienTin(String tenGiangVien) {
		super();
		this.tenGiangVien = tenGiangVien;
	}

	public String getTenGiangVien() {
		return tenGiangVien;
	}

	public void setTenGiangVien(String tenGiangVien) {
		this.tenGiangVien = tenGiangVien;
	}

}
