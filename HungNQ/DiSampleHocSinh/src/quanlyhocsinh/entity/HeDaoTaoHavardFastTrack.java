package quanlyhocsinh.entity;

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
	public String getThoiGianHoc() {
		return "Overtime";
	}
	
	@Override
	public String getThongTinMonHoc() {
		return "Over môn";
	}

}