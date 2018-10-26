package quanlyhocsinh.entity;

public class GiangVienIT implements GiangVien {
	String tenGiangVien = "Cao Lê Thành";
	String thongTinGiangVien = " Giảng viên môn công nghệ";

	public GiangVienIT() {
		super();
	}
	public GiangVienIT(String tenGiangVien, String thongTinGiangVien) {
		this.tenGiangVien = tenGiangVien;
		this.thongTinGiangVien = thongTinGiangVien;
	}

	public String getTenGiangVien() {
		return tenGiangVien;
	}

	public void setTenGiangVien(String tenGiangVien) {
		this.tenGiangVien = tenGiangVien;
	}

	public String getThongTinGiangVien() {
		return thongTinGiangVien;
	}

	public void setThongTinGiangVien(String thongTinGiangVien) {
		this.thongTinGiangVien = thongTinGiangVien;
	}
	
}
