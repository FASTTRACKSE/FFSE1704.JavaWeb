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
		return "Đào tạo online \n"
				+ "		* Thời gian: 24/24 \n"
				+ "		* Địa chỉ: trang web LMS.FASTTRACK.EDU.VN";
	}

}
