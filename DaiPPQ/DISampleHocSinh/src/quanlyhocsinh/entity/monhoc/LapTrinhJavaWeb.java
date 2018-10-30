package quanlyhocsinh.entity.monhoc;

import quanlyhocsinh.entity.giangvien.*;

public class LapTrinhJavaWeb implements MonHoc {
	GiangVien giangVien;

	public LapTrinhJavaWeb(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
	}
	
	@Override
	public String getThongTinMonHoc() {
		// TODO Auto-generated method stub
		return "Lập Trình Java Web";
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
}
