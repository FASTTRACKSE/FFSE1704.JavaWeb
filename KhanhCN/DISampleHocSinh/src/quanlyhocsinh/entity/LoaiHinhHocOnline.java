package quanlyhocsinh.entity;

public class LoaiHinhHocOnline implements TheLoaiHinhHoc {
	String theLoai = "Online";

	public LoaiHinhHocOnline() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoaiHinhHocOnline(String theLoai) {
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
