package quanlyhocsinh.monhoc;

import quanlyhocsinh.giangvien.GiangVien;

public class QuyTrinhDuAn implements MonHoc {

	GiangVien giangVien;

	public QuyTrinhDuAn(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
	}

	@Override
	public String getTenMonHoc() {
		// TODO Auto-generated method stub
		return "Quy trình dự án";
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

	public QuyTrinhDuAn() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
