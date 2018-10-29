package quanlyhocsinh.entity.hedaotao;

import java.util.List;

import quanlyhocsinh.entity.monhoc.MonHoc;

public class HeDaoTaoHavardFastTrack implements HeDaoTao {

	@Override
	public String getMaHeDaoTao() {
		return "FSEHAVARD";
	}

	@Override
	public String getThongTinHeDaoTao() {
		return "Học Harvard tại Đà Nẵng, 25K USD/Tuần";
	}

	@Override
	public List<MonHoc> getDanhSachMonHoc() {
		// TODO Auto-generated method stub
		return null;
	}

}