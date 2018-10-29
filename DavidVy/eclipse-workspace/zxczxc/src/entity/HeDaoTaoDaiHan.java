package entity;

import java.util.List;

import monhoc.MonHoc;

public class HeDaoTaoDaiHan implements HeDaoTao {
	
	List<MonHoc> danhSachMonHoc;

	public List<MonHoc> getDsMonHoc() {
		return danhSachMonHoc;
	}

	public void setDsMonHoc(List<MonHoc> danhSachMonHoc) {
		this.danhSachMonHoc = danhSachMonHoc;
	}
	
	@Override
	public List<MonHoc> getDanhSachMonHoc() {
		// TODO Auto-generated method stub
		return danhSachMonHoc;
	}

	@Override
	public String getMaHeDaoTao() {
		return "FFSEDH";
	}

	@Override
	public String getthongtinHeDaoTao() {
		return "full 16 tháng";
	}

	
	
	



}
