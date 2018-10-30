package quanlyhocsinh.entity;

public class LapTrinhJavaCoBan implements MonHoc  {
	
	GiangVien giangVien;
	
	public LapTrinhJavaCoBan(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
	}
	
	public LapTrinhJavaCoBan() {
		super();
	}

	@Override
	public String getThongTonMonHoc() {
		// TODO Auto-generated method stub
		return "LapTrinhJavaCoBan";
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
