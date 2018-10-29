package quanlyhocsinh.entity.MonHoc;

import quanlyhocsinh.entity.GiangVien.GiangVien;

public class LapTrinhWebFrontend implements MonHoc {

	public LapTrinhWebFrontend() {
		super();
		// TODO Auto-generated constructor stub
	}

	String tenMonHoc = "Lập Trình Java Frontend";
	GiangVien giangVien;

	public LapTrinhWebFrontend(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
	}

	public String gettenMonHoc() {
		return tenMonHoc;
	}

	public void settenMonHoc(String tenMonHoc) {
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
		return giangVien.getEmailGiangVien();
	}

	@Override
	public String getTenMonHoc() {
		// TODO Auto-generated method stub
		return "Lập Trình Java Frontend";
	}

}
