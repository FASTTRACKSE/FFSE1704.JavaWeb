package quanlihocsinh.entity;

import java.util.List;

import quanlihocsinh.monhoc.MonHoc;

public class HeDaoTaoDaiHan implements HeDaoTao {
	List<MonHoc> dsMonHoc;
	
	public HeDaoTaoDaiHan() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMaHeDaoTao() {
		// TODO Auto-generated method stub
		return "ê3";
	}

	@Override
	public String getThongTinHeDaoTao() {
		// TODO Auto-generated method stub
		return "Dai hạn";
	}


	public List<MonHoc> getDsMonHoc() {
		return dsMonHoc;
	}

	public void setDsMonHoc(List<MonHoc> dsMonHoc) {
		this.dsMonHoc = dsMonHoc;
	}

	

	
	


	
}
