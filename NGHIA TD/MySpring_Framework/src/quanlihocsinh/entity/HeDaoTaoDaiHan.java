package quanlihocsinh.entity;

import java.util.List;

import quanlihocsinh.monhoc.MonHoc;

public class HeDaoTaoDaiHan implements HeDaoTao {
	List<MonHoc> dsMonHoc;
	
	public HeDaoTaoDaiHan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HeDaoTaoDaiHan(List<MonHoc> dsMonHoc) {
		super();
		this.dsMonHoc = dsMonHoc;
	}

	@Override
	public String getMaHeDaoTao() {
		// TODO Auto-generated method stub
		return "Mã 0010101";
	}

	@Override
	public String getThongTinHeDaoTao() {
		// TODO Auto-generated method stub
		return "Hệ đào tạo Dài Hạn";
	}


	public List<MonHoc> getDsMonHoc() {
		return dsMonHoc;
	}

	public void setDsMonHoc(List<MonHoc> dsMonHoc) {
		this.dsMonHoc = dsMonHoc;
	}

	

	
	


	
}
