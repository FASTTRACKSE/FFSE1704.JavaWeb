package quanlihocsinh.monhoc;

import giangvien.GiangVien;

public class LapTrinhPHPMySQL implements MonHoc {
	GiangVien giangVien;
	public LapTrinhPHPMySQL(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
	}
	
	@Override
	public String gettenMonHoc() {
		// TODO Auto-generated method stub
		return "Lâp trình PHP & My SQL";
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
