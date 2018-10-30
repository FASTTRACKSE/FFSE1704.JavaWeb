package monhoc;

import giangvien.GiangVien;

public class MonTinHocVanHoc implements MonHoc {
	GiangVien giangvien;

	public MonTinHocVanHoc(GiangVien giangvien) {
		super();
		this.giangvien = giangvien;
	}

	@Override
	public String getThongTinMonHoc() {
		// TODO Auto-generated method stub
		return "Môn đào tạo tin học văn phòng ";
	}

	public MonTinHocVanHoc() {
		super();
		// TODO Auto-generated constructor stub
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
