package quanlyhocsinh.entity.loaihinhdaotao;

public class DaoTaoOffline implements LoaiHinhDaoTao {

	@Override
	public String getMaLoaiHinhDaoTao() {
		// TODO Auto-generated method stub
		return "FFSE-DT-Offline";
	}

	@Override
	public String getThongTinLoaiHinhDaoTao() {
		// TODO Auto-generated method stub
		return "Đào tạo offline \n"
				+ "		* Thời gian: sáng từ 8h00, chiều từ 13h30, tối từ 18h30 \n"
				+ "		* Địa chỉ: Toà nhà FPT, KCN An Đồn";
	}

}
