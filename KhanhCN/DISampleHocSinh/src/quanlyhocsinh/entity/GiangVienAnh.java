package quanlyhocsinh.entity;

public class GiangVienAnh implements GiangVien {

	String tenGiangVien = "Lê Thị Diệu Quyên";

	public GiangVienAnh() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GiangVienAnh(String tenGiangVien) {
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
