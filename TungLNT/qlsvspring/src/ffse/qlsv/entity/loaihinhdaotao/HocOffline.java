package ffse.qlsv.entity.loaihinhdaotao;

public class HocOffline implements CheDoHoc{

	@Override
	public String getCheDoHoc() {
		return "Offline";
	}

	@Override
	public String getThoiGianHoc() {
		return "sáng từ 8h00, chiều từ 13h30, tối từ 18h30";
	}

	@Override
	public String getDiaChiHoc() {
		return "Toà nhà FPT, KCN An Đồn";
	}

}
