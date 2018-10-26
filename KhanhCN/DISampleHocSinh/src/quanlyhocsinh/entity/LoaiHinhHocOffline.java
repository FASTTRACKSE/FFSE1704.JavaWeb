package quanlyhocsinh.entity;

public class LoaiHinhHocOffline implements TheLoaiHinhHoc {
	String theLoai = "Offline";
	String thoiGian = "27/7";
	String diaChi = "Toà nhà FPT, KCN An Đồn";


	public LoaiHinhHocOffline() {
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
