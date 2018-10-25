package ffse1704.jsf.entity;

import ffse1704.jsf.entity.monhoc.MonHoc;
import ffse1704.jsf.giangvien.GiangVien;

public class MonLapTrinhJavaCoBan implements MonHoc {
	private String maMonHoc = "LP #4";
	private String tenMonHoc = "Lập Trình Java Cơ Bản";
	GiangVien giangVien;

	public MonLapTrinhJavaCoBan() {
		super();
	}

	public MonLapTrinhJavaCoBan(GiangVien giangVien) {
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
