package quanlyhocsinh.entity;

public class GiangVienTiengAnh implements GiangVien {
	String thongTinGiangVien = "Giảng viên môn tiêng Anh";
	String tenGiangVien = "Lê Thị Mỹ Hồng";
	public GiangVienTiengAnh() {
		super();
	}
	public GiangVienTiengAnh(String tenGiangVien, String thongTinGiangVien) {
		this.tenGiangVien = tenGiangVien;
		this.thongTinGiangVien = thongTinGiangVien;
	}
	public String getThongTinGiangVien() {
		return thongTinGiangVien;
	}
	public void setThongTinGiangVien(String thongTinGiangVien) {
		this.thongTinGiangVien = thongTinGiangVien;
	}
	public String getTenGiangVien() {
		return tenGiangVien;
	}
	public void setTenGiangVien(String tenGiangVien) {
		this.tenGiangVien = tenGiangVien;
	}
}
