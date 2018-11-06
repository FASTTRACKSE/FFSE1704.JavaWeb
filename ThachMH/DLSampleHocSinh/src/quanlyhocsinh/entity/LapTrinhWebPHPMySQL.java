package quanlyhocsinh.entity;

public class LapTrinhWebPHPMySQL implements MonHoc {
	GiangVien giangVien;

	public LapTrinhWebPHPMySQL(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
	}
	 public LapTrinhWebPHPMySQL() {
		// TODO Auto-generated constructor stub
		 super();
	}

	@Override
	public String getThongTonMonHoc() {
		// TODO Auto-generated method stub
		return "Lập Trình Wed PHP và My SQL";
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
