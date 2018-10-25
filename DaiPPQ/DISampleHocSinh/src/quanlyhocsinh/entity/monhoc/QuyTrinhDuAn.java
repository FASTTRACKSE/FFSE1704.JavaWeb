package quanlyhocsinh.entity.monhoc;

import quanlyhocsinh.entity.giangvien.*;

public class QuyTrinhDuAn implements MonHoc {
	GiangVien giangVien;
	
	public QuyTrinhDuAn(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
	}

	@Override
	public String getThongTinMonHoc() {
		// TODO Auto-generated method stub
		return "Quy Trình Dự Án";
	}

	@Override
	public String getThongTinGiangVien() {
		// TODO Auto-generated method stub
		return giangVien.getThongTinGiangVien();
	}

}
