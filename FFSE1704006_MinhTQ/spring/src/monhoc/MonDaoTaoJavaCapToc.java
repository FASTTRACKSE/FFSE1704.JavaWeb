package monhoc;

import giangvien.GiangVien;

public class MonDaoTaoJavaCapToc implements MonHoc {
	String thongTinMonHoc;
	GiangVien giangVien;

	public MonDaoTaoJavaCapToc(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
	}

	public MonDaoTaoJavaCapToc() {
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
