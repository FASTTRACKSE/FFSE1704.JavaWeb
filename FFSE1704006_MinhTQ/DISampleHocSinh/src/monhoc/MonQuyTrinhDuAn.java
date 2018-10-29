package monhoc;

import giangvien.GiangVien;

public class MonQuyTrinhDuAn implements MonHoc {
	public MonQuyTrinhDuAn() {
		super();
		// TODO Auto-generated constructor stub
	}

	GiangVien giangvien;

	public MonQuyTrinhDuAn(GiangVien giangvien) {
		super();
		this.giangvien = giangvien;
	}

	@Override
	public String getThongTinMonHoc() {
		// TODO Auto-generated method stub
		return "Môn quy trình dự án";
	}

	@Override
	public String getTenGiangVien() {
		// TODO Auto-generated method stub
		return giangvien.getTenGiangVien();
	}

	@Override
	public String getEmailGiangVien() {
		// TODO Auto-generated method stub
		return giangvien.getEmailGiangVien();
	}

}
