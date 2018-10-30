package quanlihocsinh.entity;

import java.util.List;

import quanlihocsinh.monhoc.MonHoc;

public class HeDaoTaoHavardFastTrack implements HeDaoTao {
	List<MonHoc> dsMonHoc;
	@Override
	public String getMaHeDaoTao() {
		// TODO Auto-generated method stub
		return "FASTTRACKNGHIA";
	}

	@Override
	public String getThongTinHeDaoTao() {
		// TODO Auto-generated method stub
		return "Fasttrack´";
	}



	public void setDsMonHoc(List<MonHoc> dsMonHoc) {
		this.dsMonHoc = dsMonHoc;
	}

	@Override
	public List<MonHoc> getDsMonHoc() {
		// TODO Auto-generated method stub
		return dsMonHoc;
	}

	

}
