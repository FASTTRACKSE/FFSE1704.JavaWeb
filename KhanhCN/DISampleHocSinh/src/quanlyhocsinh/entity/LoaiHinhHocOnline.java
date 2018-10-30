package quanlyhocsinh.entity;

public class LoaiHinhHocOnline implements TheLoaiHinhHoc {
	String theLoai = "Online";
	String thoiGian = "24/24";
	String diaChi = "facebook.com";

	public LoaiHinhHocOnline() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}

	public String getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	

}
