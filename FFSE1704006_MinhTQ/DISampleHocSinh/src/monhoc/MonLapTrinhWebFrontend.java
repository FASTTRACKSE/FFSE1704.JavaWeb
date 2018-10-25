package monhoc;

import giangvien.GiangVien;

public class MonLapTrinhWebFrontend implements MonHoc {
	GiangVien giangVien;

	public MonLapTrinhWebFrontend(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
	}

	@Override
	public String getThongTinMonHoc() {
		// TODO Auto-generated method stub
		return "Môn lập trình Wed Frontend";
	}

	@Override
	public String getTenGiangVien() {
		// TODO Auto-generated method stub
		return giangVien.getTenGiangVien();
	}

	@Override
	public String getEmailGiangVien() {
		// TODO Auto-generated method stub
		return giangVien.getTenGiangVien();
	}

}
