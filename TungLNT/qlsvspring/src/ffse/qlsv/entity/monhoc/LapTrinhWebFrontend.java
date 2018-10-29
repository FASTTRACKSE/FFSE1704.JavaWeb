package ffse.qlsv.entity.monhoc;

import ffse.qlsv.entity.giangvien.GiangVien;

public class LapTrinhWebFrontend implements MonHoc{
	String tenMonHoc = "Lập trình Web frontend";
	GiangVien giangVien;
	
	public LapTrinhWebFrontend() {
		super();
	}
	public LapTrinhWebFrontend(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
	}
	public String getTenMonHoc() {
		return tenMonHoc;
	}
	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
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
		return  giangVien.getEmailGiangVien();
	}
}
