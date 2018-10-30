package quanlyhocsinh.monhoc;

import quanlyhocsinh.giangvien.GiangVien;

public class QuyTrinhDuAn implements MonHoc {

	GiangVien giangVien;
	String tenMonHoc;

	public QuyTrinhDuAn() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuyTrinhDuAn(GiangVien giangVien, String tenMonHoc) {
		super();
		this.giangVien = giangVien;
		this.tenMonHoc = tenMonHoc;
	}

	public GiangVien getGiangVien() {
		return giangVien;
	}

	public void setGiangVien(GiangVien giangVien) {
		this.giangVien = giangVien;
	}

	public String getTenMonHoc() {
		return tenMonHoc;
	}

	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}

	@Override
	public String getTenGiangVien() {
		// TODO Auto-generated method stub
		return giangVien.getTenGiangVien();
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return giangVien.getEmail();
	}

}
