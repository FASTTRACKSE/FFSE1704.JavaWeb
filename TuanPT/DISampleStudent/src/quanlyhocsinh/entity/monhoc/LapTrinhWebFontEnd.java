package quanlyhocsinh.entity.monhoc;

import quanlyhocsinh.entity.giangvien.GiangVien;

public class LapTrinhWebFontEnd implements MonHoc {
	GiangVien giangVien;
	
	public GiangVien getGiangVien() {
		return giangVien;
	}

	public void setGiangVien(GiangVien giangVien) {
		this.giangVien = giangVien;
	}
	
	public LapTrinhWebFontEnd() {
		super();
	}

	public LapTrinhWebFontEnd(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
	}
	
	@Override
	public String getThongTinMonHoc() {
		// TODO Auto-generated method stub
		return "Lập Trình Web Frontend";
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
