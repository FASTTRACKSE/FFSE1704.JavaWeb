package quanlihocsinh.monhoc;

import giangvien.GiangVien;

public class LapTrinhWebFrontEnd implements MonHoc {
	GiangVien giangVien;
	public LapTrinhWebFrontEnd(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
	}
	
	@Override
	public String gettenMonHoc() {
		// TODO Auto-generated method stub
		return "Lập trình front-end";
	}
	@Override
	public String getGiangVien() {
		// TODO Auto-generated method stub
		return giangVien.getTenGiangVien();
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
