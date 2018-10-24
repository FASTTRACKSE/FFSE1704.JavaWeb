package quanlihocsinh.entity;

public class QuyTrinhDuAn{
	String giangVien = "";
	String tenMonHoc = "Quy Trình Dự Án";

	public String getGiangVien() {
		return giangVien;
	}

	public void setGiangVien(String giangVien) {
		this.giangVien = giangVien;
	}

	public String getTenMonHoc() {
		return tenMonHoc;
	}

	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}

	public QuyTrinhDuAn(String giangVien, String tenMonHoc) {
		super();
		this.giangVien = giangVien;
		this.tenMonHoc = tenMonHoc;
	}

	public QuyTrinhDuAn() {
		super();
		// TODO Auto-generated constructor stub
	}
}
