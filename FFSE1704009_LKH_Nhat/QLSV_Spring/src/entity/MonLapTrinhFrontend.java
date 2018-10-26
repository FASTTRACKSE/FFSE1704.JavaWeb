package entity;

import ffse1704.spring.entity.monhoc.MonHoc;

public class MonLapTrinhFrontend implements MonHoc {
	private String maMonHoc;
	private String tenMonHoc;
	GiangVien giangVien;

	public MonLapTrinhFrontend() {
		super();
	}

	public MonLapTrinhFrontend(GiangVien giangVien) {
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
	
	public GiangVien getGiangVien() {
		return giangVien;
	}

	public void setGiangVien(GiangVien giangVien) {
		this.giangVien = giangVien;
	}
}
