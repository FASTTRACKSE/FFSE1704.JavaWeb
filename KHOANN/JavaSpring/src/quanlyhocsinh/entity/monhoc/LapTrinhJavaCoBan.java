package quanlyhocsinh.entity.monhoc;

import quanlyhocsinh.entity.giangvien.GiangVien;

public class LapTrinhJavaCoBan implements MonHoc {

	public LapTrinhJavaCoBan() {
		super();
		// TODO Auto-generated constructor stub
	}

	String tenMonHoc = "Lập Trình Java Cơ Bản";
	GiangVien giangVien;

	public LapTrinhJavaCoBan(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
	}

	public String gettenMonHoc() {
		return tenMonHoc;
	}

	public void settenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}

	public GiangVien getGiangVien() {
		return giangVien;
	}

	public void setGiangVien(GiangVien giangVien) {
		this.giangVien = giangVien;
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

	@Override
	public String getTenMonHoc() {
		// TODO Auto-generated method stub
		return "Lap Trinh Java Co Ban";
	}
}
