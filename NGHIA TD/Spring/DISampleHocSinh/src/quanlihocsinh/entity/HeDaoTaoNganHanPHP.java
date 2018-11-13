package quanlihocsinh.entity;

import java.util.List;

import quanlihocsinh.monhoc.MonHoc;

public class HeDaoTaoNganHanPHP implements HeDaoTao{
	List<MonHoc> dsMonHoc;
	@Override
	public String getMaHeDaoTao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getThongTinHeDaoTao() {
		// TODO Auto-generated method stub
		return null;
	}


	public List<MonHoc> getDsMonHoc() {
		return dsMonHoc;
	}

	public void setDsMonHoc(List<MonHoc> dsMonHoc) {
		this.dsMonHoc = dsMonHoc;
	}
	
}
