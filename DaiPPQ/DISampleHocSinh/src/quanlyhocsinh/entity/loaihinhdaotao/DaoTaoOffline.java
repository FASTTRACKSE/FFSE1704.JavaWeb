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
		return "Đào tạo offline";
	}
	
	@Override
	public String getThoiGianDaoTao() {
		// TODO Auto-generated method stub
		return "sáng từ 8h00, chiều từ 13h30, tối từ 18h30";
	}
	
	@Override
	public String getDiaDiemDaoTao() {
		// TODO Auto-generated method stub
		return "Toà nhà FPT, KCN An Đồn";
	}
}
