package quanlyhocsinh.entity.HeDaoTao;

import java.util.List;

import quanlyhocsinh.entity.MonHoc.MonHoc;

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
	public String getThongTinHeDaoTao() {
		return "16 tháng, sáng 8h30, chiều 13h30";
	}

	
}