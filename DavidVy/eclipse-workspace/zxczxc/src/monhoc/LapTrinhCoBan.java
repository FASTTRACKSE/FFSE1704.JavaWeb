package monhoc;

import entity.GiangVien;

public class LapTrinhCoBan implements MonHoc{
	private String maMonHoc;
	private String tenMonHoc;
	GiangVien giangvien;
	
	public LapTrinhCoBan() {
		super();
	}
	
	public LapTrinhCoBan(GiangVien giangvien) {
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
		return "Lap Trinh Co ban";
	}
	
	public LapTrinhCoBan(String maMonHoc, String tenMonHoc, GiangVien giangvien) {
		super();
		this.maMonHoc = maMonHoc;
		this.tenMonHoc = tenMonHoc;
		this.giangvien = giangvien;
	}

	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}
	
	@Override
	public String getTenGiangVien() {
		return giangvien.getTenGiangVien();
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

}
