package entity;

import java.util.List;

import monhoc.MonHoc;

public class HeDaoTaoNganHanPHP implements HeDaoTao {
	
	List<MonHoc> danhSachMonHoc;
	
	public List<MonHoc> getDsMonHoc() {
		return danhSachMonHoc;
	}
	
	public void setDsMonHoc(List<MonHoc> danhSachMonHoc) {
		this.danhSachMonHoc = danhSachMonHoc;
	}
	
	public List<MonHoc> getDanhSachMonHoc() {
		// TODO Auto-generated method stub
		return danhSachMonHoc;
	}
	
	

	
	public HeDaoTaoNganHanPHP() {
		super();
	}
	


	@Override
	public String getMaHeDaoTao() {
		return "FFSENHP";
	}
	


	@Override
	public String getthongtinHeDaoTao() {
		return "Đào tạo dài hạn ngắn hạn PHP & MySQL 6 tháng";
	}


}
