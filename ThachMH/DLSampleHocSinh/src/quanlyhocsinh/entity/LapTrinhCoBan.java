package quanlyhocsinh.entity;

public class LapTrinhCoBan implements MonHoc {

	GiangVien giangVien;
	
	public LapTrinhCoBan(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
	}
	
	public LapTrinhCoBan() {
		super();
	}
	
	@Override
	public String getThongTonMonHoc() {
		// TODO Auto-generated method stub
		return "Lập Trình Cơ Bản";
	}

	@Override
	public String getTenGiangVien() {
		// TODO Auto-generated method stub
		return giangVien.getTenGiangVien();
	}

	@Override
	public String getEmailGV() {
		// TODO Auto-generated method stub
		return giangVien.getEmailGV();
	}
	

	
}
