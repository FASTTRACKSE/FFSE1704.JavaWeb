package monhoc;

import giangvien.GiangVien;

public class MonTinHocVanPhong implements MonHoc {
	
	String thongTinMonHoc;
	GiangVien giangVien;
	public MonTinHocVanPhong() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MonTinHocVanPhong(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
	}

	public GiangVien getGiangVien() {
		return giangVien;
	}

	public void setGiangVien(GiangVien giangVien) {
		this.giangVien = giangVien;
	}

	public void setThongTinMonHoc(String thongTinMonHoc) {
		this.thongTinMonHoc = thongTinMonHoc;
	}

	public String getThongTinMonHoc() {
		// TODO Auto-generated method stub
		return thongTinMonHoc;
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
