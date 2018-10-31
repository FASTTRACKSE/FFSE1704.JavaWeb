package monhoc;

import giangvien.GiangVien;

public class MonLapTrinhWebPHPMySQL implements MonHoc {

	String thongTinMonHoc;
	GiangVien giangVien;

	public MonLapTrinhWebPHPMySQL() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MonLapTrinhWebPHPMySQL(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
	}

	public GiangVien getGiangVien() {
		return giangVien;
	}

	public void setGiangVien(GiangVien giangVien) {
		this.giangVien = giangVien;
	}

	public void setThongTinMonHoc(String thongTinMonHoc) {
		this.thongTinMonHoc = thongTinMonHoc;
	}

	public String getThongTinMonHoc() {
		
		return thongTinMonHoc;
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
