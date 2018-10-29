package monhoc;

import entity.GiangVien;

public class LapTrinhPhpMySql implements MonHoc {
	
	private String maMonHoc;
	private String tenMonHoc;
	GiangVien giangVien;
	
	public LapTrinhPhpMySql() {
		super();
	}
	
	public LapTrinhPhpMySql(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
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
