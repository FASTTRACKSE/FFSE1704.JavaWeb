package entity;

import java.util.List;

import monhoc.MonHoc;

public class HeDaoTaoNganHan implements HeDaoTao {
	
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
	
	public HeDaoTaoNganHan() {
		super();
	}
	
	

	@Override
	public String getMaHeDaoTao() {
		return "FFSEDH";
	}
	
	@Override
	public String getthongtinHeDaoTao() {
		return "6 tháng";
	}

}
