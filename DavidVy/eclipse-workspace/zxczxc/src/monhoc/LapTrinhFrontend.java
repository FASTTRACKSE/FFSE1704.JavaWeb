package monhoc;

import entity.GiangVien;

public class LapTrinhFrontend implements MonHoc {
	
	private String maMonHoc;
	private String tenMonHoc;
	GiangVien giangvien;
	
	public LapTrinhFrontend () {
		super();
	}
	
	public LapTrinhFrontend(GiangVien giangvien) {
		super();
		this.giangvien = giangvien;
	}

	@Override
	public String getMaMonHoc() {
		return maMonHoc;
	}
	
	public void setMaMonHoc(String maMonHoc) {
		this.maMonHoc = maMonHoc;
	}

	@Override
	public String getTenMonHoc() {
		return "lap trinh Frontend";
	}
	
	

	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}

	@Override
	public String getEmailGiangVien() {
		return giangvien.getEmailGiangVien();
	}
	
	public GiangVien getGiangVien() {
		return giangvien;
	}

	public void setGiangVien(GiangVien giangVien) {
		this.giangvien = giangVien;
	}

	@Override
	public String getTenGiangVien() {
		// TODO Auto-generated method stub
		return giangvien.getTenGiangVien();
	}

	public LapTrinhFrontend(String maMonHoc, String tenMonHoc, GiangVien giangvien) {
		super();
		this.maMonHoc = maMonHoc;
		this.tenMonHoc = tenMonHoc;
		this.giangvien = giangvien;
	}

}
