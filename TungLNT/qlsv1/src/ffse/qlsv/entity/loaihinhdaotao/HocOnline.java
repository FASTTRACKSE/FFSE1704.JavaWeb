package ffse.qlsv.entity.loaihinhdaotao;

public class HocOnline implements CheDoHoc{

	@Override
	public String getCheDoHoc() {
		return "Online";
	}

	@Override
	public String getThoiGianHoc() {
		return "Thời gian: 24/24";
	}

	@Override
	public String getDiaChiHoc() {
		return "trang web LMS.FASTTRACK.EDU.VN";
	}

}
