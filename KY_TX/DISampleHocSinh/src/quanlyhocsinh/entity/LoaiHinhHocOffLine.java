package quanlyhocsinh.entity;

public class LoaiHinhHocOffLine implements LoaiHinhHoc {
	String thongTinLoaiHinhHoc = "Học tại fasttrackse nhé !!!";
	public LoaiHinhHocOffLine() {
		super();
	}
	public LoaiHinhHocOffLine(String thongTinLoaiHinhHoc) {
		this.thongTinLoaiHinhHoc = thongTinLoaiHinhHoc;
	}
	public String getThongTinLoaiHinhHoc() {
		return thongTinLoaiHinhHoc;
	}
	public void setThongTinLoaiHinhHoc(String thongTinLoaiHinhHoc) {
		this.thongTinLoaiHinhHoc = thongTinLoaiHinhHoc;
	}
}
