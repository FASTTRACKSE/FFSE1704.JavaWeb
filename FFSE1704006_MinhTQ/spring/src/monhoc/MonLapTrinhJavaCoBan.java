package monhoc;

import giangvien.GiangVien;

public class MonLapTrinhJavaCoBan implements MonHoc {
	String thongTinMonHoc;
	GiangVien giangVien;

	public MonLapTrinhJavaCoBan(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
	}

	public MonLapTrinhJavaCoBan() {
		super();
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
		return giangVien.getTenGiangVien();
	}

	@Override
	public String getEmailGiangVien() {
		return giangVien.getEmailGiangVien();
	}

}
