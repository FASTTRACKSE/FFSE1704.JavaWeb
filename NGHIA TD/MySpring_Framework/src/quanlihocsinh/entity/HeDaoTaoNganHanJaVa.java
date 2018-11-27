package quanlihocsinh.entity;

import java.util.List;

import quanlihocsinh.monhoc.MonHoc;

public class HeDaoTaoNganHanJaVa implements HeDaoTao{
	List<MonHoc> dsMonHoc;
	@Override
	public String getMaHeDaoTao() {
		// TODO Auto-generated method stub
		return "ffse1704";
	}

	@Override
	public String getThongTinHeDaoTao() {
		// TODO Auto-generated method stub
		return "Đào tạo ngắn hạn JAVA";
	}

	public List<MonHoc> getDsMonHoc() {
		return dsMonHoc;
	}

	public void setDsMonHoc(List<MonHoc> dsMonHoc) {
		this.dsMonHoc = dsMonHoc;
	}




}
