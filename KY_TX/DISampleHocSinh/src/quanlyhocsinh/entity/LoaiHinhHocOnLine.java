package quanlyhocsinh.entity;

public class LoaiHinhHocOnLine implements LoaiHinhHoc {
	String thongTinLoaiHinhHoc = "Học online tại google";
	public LoaiHinhHocOnLine() {
		super();
	}
	public LoaiHinhHocOnLine(String thongTinLoaiHinhHoc) {
		this.thongTinLoaiHinhHoc = thongTinLoaiHinhHoc;
	}
	public String getThongTinLoaiHinhHoc() {
		return thongTinLoaiHinhHoc;
	}
	public void setThongTinLoaiHinhHoc(String thongTinLoaiHinhHoc) {
		this.thongTinLoaiHinhHoc = thongTinLoaiHinhHoc;
	}
}
