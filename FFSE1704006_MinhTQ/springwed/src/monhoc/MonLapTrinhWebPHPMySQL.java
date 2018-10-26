package monhoc;

import giangvien.GiangVien;

public class MonLapTrinhWebPHPMySQL implements MonHoc {
	GiangVien giangVien;

	public MonLapTrinhWebPHPMySQL(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
	}

	@Override
	public String getThongTinMonHoc() {
		// TODO Auto-generated method stub
		return "Lập trình PHP & MySQL";
	}

	@Override
	public String getTenGiangVien() {
		// TODO Auto-generated method stub
		return giangVien.getTenGiangVien();
	}

	@Override
	public String getEmailGiangVien() {
		// TODO Auto-generated method stub
		return giangVien.getEmailGiangVien();
	}

}
