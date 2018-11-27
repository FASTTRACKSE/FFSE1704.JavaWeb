package monhoc;

import entity.GiangVien;

public class LapTrinhCoBan implements MonHoc{
	public GiangVien getGiangvien() {
		return giangVien;
	}

	public void setGiangvien(GiangVien giangvien) {
		this.giangVien = giangvien;
	}

	private String maMonHoc;
	private String tenMonHoc;
	GiangVien giangVien;
	
	public LapTrinhCoBan() {
		super();
	}
	
	public LapTrinhCoBan(GiangVien giangvien) {
		super();
		this.giangVien = giangvien;
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
		return "Lap Trinh Co ban";
	}
	
	public LapTrinhCoBan(String maMonHoc, String tenMonHoc, GiangVien giangvien) {
		super();
		this.maMonHoc = maMonHoc;
		this.tenMonHoc = tenMonHoc;
		this.giangVien = giangvien;
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
