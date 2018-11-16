package monhoc;

import giangvien.GiangVien;

public class MonLapTrinhCanBan implements MonHoc {

	GiangVien giangVien;
	
	public MonLapTrinhCanBan(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
	}

	public MonLapTrinhCanBan() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getThongTinMonHoc() {
		// TODO Auto-generated method stub
		return "Lập trình cơ bản";
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
