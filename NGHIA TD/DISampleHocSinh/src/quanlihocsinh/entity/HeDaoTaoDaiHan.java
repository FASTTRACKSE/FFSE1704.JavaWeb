package quanlihocsinh.entity;

import java.util.List;

import quanlihocsinh.monhoc.MonHoc;

public class HeDaoTaoDaiHan implements HeDaoTao {
	List<MonHoc> dsMonHoc;
	
	public HeDaoTaoDaiHan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<MonHoc> getDsMonHoc() {
		return dsMonHoc;
	}

	public void setDsMonHoc(List<MonHoc> dsMonHoc) {
		this.dsMonHoc = dsMonHoc;
	}
	@Override
	public String getMaHeDaoTao() {
		// TODO Auto-generated method stub
		return "ffse";
	}
	@Override
	public String getThongTinHeDaoTao() {
		// TODO Auto-generated method stub
		return "Đào tạo dài hạn";
	}
	public HeDaoTaoDaiHan(List<MonHoc> dsMonHoc) {
		super();
		this.dsMonHoc = dsMonHoc;
	}


	
}
