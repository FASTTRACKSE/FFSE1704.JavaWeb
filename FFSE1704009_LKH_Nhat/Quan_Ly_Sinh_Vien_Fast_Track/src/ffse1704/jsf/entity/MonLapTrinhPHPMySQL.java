package ffse1704.jsf.entity;

import ffse1704.jsf.entity.monhoc.MonHoc;
import ffse1704.jsf.entity.GiangVien;

public class MonLapTrinhPHPMySQL implements MonHoc {
	private String maMonHoc = "LP #3";
	private String tenMonHoc = "Lập trình Web PHP và MySQL";
	GiangVien giangVien;

	public MonLapTrinhPHPMySQL() {
		super();
	}

	public MonLapTrinhPHPMySQL(GiangVien giangVien) {
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
