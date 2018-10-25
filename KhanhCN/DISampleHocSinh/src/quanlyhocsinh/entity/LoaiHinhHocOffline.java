package quanlyhocsinh.entity;

public class LoaiHinhHocOffline implements TheLoaiHinhHoc {
	String theLoai = "Offline";

	public LoaiHinhHocOffline() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoaiHinhHocOffline(String theLoai) {
		super();
		this.theLoai = theLoai;
	}

	public String getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}

}
