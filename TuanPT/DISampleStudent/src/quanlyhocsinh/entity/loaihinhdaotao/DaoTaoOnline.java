package quanlyhocsinh.entity.loaihinhdaotao;

public class DaoTaoOnline implements LoaiHinhDaoTao {

	@Override
	public String getMaLoaiHinhDaoTao() {
		// TODO Auto-generated method stub
		return "FFSE-DT-Online";
	}

	@Override
	public String getThongTinLoaiHinhDaoTao() {
		// TODO Auto-generated method stub
		return "Đào tạo online";
	}

	@Override
	public String getThoiGianDaoTao() {
		// TODO Auto-generated method stub
		return "Thời gian: 24/24";
	}
	
	@Override
	public String getDiaDiemDaoTao() {
		// TODO Auto-generated method stub
		return "Địa chỉ: trang web LMS.FASTTRACK.EDU.VN";
	}
}