package quanlymonhoc.entity;

import quanlygiangvien.entity.GiangVien;

public class QuyTrinhDuAn implements MonHoc {
	String tenMonHoc;
	String thongTinMonHoc;
	GiangVien giangVien;

	public QuyTrinhDuAn() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuyTrinhDuAn(String tenMonHoc, String thongTinMonHoc, GiangVien giangVien) {
		super();
		this.tenMonHoc = tenMonHoc;
		this.thongTinMonHoc = thongTinMonHoc;
		this.giangVien = giangVien;
	}

	public String getTenMonHoc() {
		return tenMonHoc;
	}

	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}

	public String getThongTinMonHoc() {
		return thongTinMonHoc;
	}

	public void setThongTinMonHoc(String thongTinMonHoc) {
		this.thongTinMonHoc = thongTinMonHoc;
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
		return giangVien.getEmail();
	}

}
