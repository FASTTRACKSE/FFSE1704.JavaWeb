package quanlyhocsinh.entity.monhoc;

import quanlyhocsinh.entity.giangvien.*;

public class LapTrinhWebPHPMySQL implements MonHoc {
	GiangVien giangVien;
	
	public LapTrinhWebPHPMySQL(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
	}
	
	@Override
	public String getThongTinMonHoc() {
		// TODO Auto-generated method stub
		return "Lập Trình Web PHP&MySQL";
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
