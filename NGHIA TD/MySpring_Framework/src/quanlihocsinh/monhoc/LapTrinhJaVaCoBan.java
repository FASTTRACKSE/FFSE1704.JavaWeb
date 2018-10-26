package quanlihocsinh.monhoc;

import giangvien.GiangVien;

public class LapTrinhJaVaCoBan implements MonHoc {
	GiangVien giangVien;
	public LapTrinhJaVaCoBan(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
	}
	
	@Override
	public String gettenMonHoc() {
		// TODO Auto-generated method stub
		return "Lập trình java cơ bản";
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
