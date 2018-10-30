package quanlyhocsinh.monhoc;

import quanlyhocsinh.giangvien.GiangVien;

public class TinHocVanPhong implements MonHoc {

	GiangVien giangVien;

	public TinHocVanPhong(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
	}

	@Override
	public String getTenMonHoc() {
		// TODO Auto-generated method stub
		return "Tin học văn phòng";
	}

	@Override
	public String getTenGiangVien() {
		// TODO Auto-generated method stub
		return giangVien.getTenGiangVien();
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return giangVien.getEmail();
	}

}
