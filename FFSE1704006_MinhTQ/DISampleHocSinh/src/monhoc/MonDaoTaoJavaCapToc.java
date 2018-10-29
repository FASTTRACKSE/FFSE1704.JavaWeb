package monhoc;

import giangvien.GiangVien;

public class MonDaoTaoJavaCapToc implements MonHoc {

	public MonDaoTaoJavaCapToc(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
	}

	GiangVien giangVien;

	

	public MonDaoTaoJavaCapToc() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getThongTinMonHoc() {
		// TODO Auto-generated method stub
		return "Môn đào tạo lập trình java WED cấp Tốc";
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
