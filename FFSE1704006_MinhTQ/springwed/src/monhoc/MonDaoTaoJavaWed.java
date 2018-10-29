package monhoc;

import giangvien.GiangVien;

public class MonDaoTaoJavaWed implements MonHoc {
	GiangVien giangVien;

	public MonDaoTaoJavaWed(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
	}

	public MonDaoTaoJavaWed() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getThongTinMonHoc() {
		// TODO Auto-generated method stub
		return "Môn đòa tạo lập trình java WED ";
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
