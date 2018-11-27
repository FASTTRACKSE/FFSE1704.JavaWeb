package quanlyhocsinh.entity;

public class LapTrinhJavaWed implements MonHoc {
	GiangVien giangVien;

	public LapTrinhJavaWed(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
	}
	public LapTrinhJavaWed() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public String getThongTonMonHoc() {
		// TODO Auto-generated method stub
		return "Lập Trình Java Wed";
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
