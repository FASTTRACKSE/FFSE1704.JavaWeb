package quanlihocsinh.monhoc;

import giangvien.GiangVien;

public class TinHocVanPhong implements MonHoc {
	GiangVien giangVien;
	public TinHocVanPhong(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
	}
	
	@Override
	public String gettenMonHoc() {
		// TODO Auto-generated method stub
		return "Tin Học Văn Phòng";
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
