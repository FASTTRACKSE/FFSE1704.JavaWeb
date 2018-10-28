package quanlyhocsinh.entity.monhoc;

import quanlyhocsinh.entity.giangvien.GiangVien;

public class LapTrinhCoBan implements MonHoc {

	public LapTrinhCoBan() {
		super();
		// TODO Auto-generated constructor stub
	}

	String tenMonHoc = "Lập Trình Cơ Bản";
	GiangVien giangVien;

	public LapTrinhCoBan(GiangVien giangVien) {
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
	public String getTenMonHoc() {
		// TODO Auto-generated method stub
		return "Lap Trinh Co Ban";
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
