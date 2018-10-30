package ffse1704.jsf.entity;

import ffse1704.jsf.entity.monhoc.MonHoc;
import ffse1704.jsf.entity.GiangVien;

public class MonLapTrinhCoBan implements MonHoc {
	private String maMonHoc = "LP #1";
	private String tenMonHoc = "Lập trình cơ bản";
	GiangVien giangVien;

	public MonLapTrinhCoBan() {
		super();
	}

	public MonLapTrinhCoBan(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
	}

	public String getMaMonHoc() {
		return maMonHoc;
	}

	public void setMaMonHoc(String maMonHoc) {
		this.maMonHoc = maMonHoc;
	}

	public String getTenMonHoc() {
		return tenMonHoc;
	}

	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
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
