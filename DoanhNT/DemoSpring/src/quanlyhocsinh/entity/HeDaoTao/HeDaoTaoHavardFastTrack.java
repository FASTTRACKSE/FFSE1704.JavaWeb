package quanlyhocsinh.entity.HeDaoTao;

import java.util.List;

import quanlyhocsinh.entity.MonHoc.MonHoc;

public class HeDaoTaoHavardFastTrack implements HeDaoTao {

	@Override
	public String getMaHeDaoTao() {
		return "FSEHAVARD";
	}

	@Override
	public String getThongTinHeDaoTao() {
		return "Học Havard tại Đà Nẵng, 14KUSD/tuần";
	}

	@Override
	public List<MonHoc> getDanhSachMonHoc() {
		// TODO Auto-generated method stub
		return null;
	}

}