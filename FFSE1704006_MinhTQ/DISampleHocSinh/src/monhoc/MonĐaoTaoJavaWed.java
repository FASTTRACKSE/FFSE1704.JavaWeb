package monhoc;

import giangvien.GiangVien;

public class MonĐaoTaoJavaWed implements MonHoc {
	GiangVien giangVien;

	public MonĐaoTaoJavaWed(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
	}

	public MonĐaoTaoJavaWed() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getThongTinMonHoc() {
		// TODO Auto-generated method stub
		return "Môn đào tạo lập trình java WED ";
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
