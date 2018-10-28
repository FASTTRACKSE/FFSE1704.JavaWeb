package quanlyhocsinh.monhoc;

import quanlyhocsinh.giangvien.GiangVien;

public class WebPHP implements MonHoc {

	GiangVien giangVien;

	public WebPHP(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
	}

	@Override
	public String getTenMonHoc() {
		// TODO Auto-generated method stub
		return "Lập trình Web PHP & MySQL";
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

	public WebPHP() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
