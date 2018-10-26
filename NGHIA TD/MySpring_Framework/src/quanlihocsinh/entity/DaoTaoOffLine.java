package quanlihocsinh.entity;

public class DaoTaoOffLine implements LoaiDaoTao{

	 String MaLoaiDaoTao="MuHH-hahaha";
	 String thongTinLoaiDaoTao="Đào tạo offline:\r\n" + 
	 		"o	Thời gian: sáng từ 8h00, chiều từ 13h30, tối từ 18h30\r\n" + 
	 		"o	Địa chỉ: Toà nhà FPT, KCN An Đồn";
	public DaoTaoOffLine() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DaoTaoOffLine(String maLoaiDaoTao, String thongTinLoaiDaoTao) {
		super();
		MaLoaiDaoTao = maLoaiDaoTao;
		this.thongTinLoaiDaoTao = thongTinLoaiDaoTao;
	}
	public String getMaLoaiDaoTao() {
		return MaLoaiDaoTao;
	}
	public void setMaLoaiDaoTao(String maLoaiDaoTao) {
		MaLoaiDaoTao = maLoaiDaoTao;
	}
	public String getThongTinLoaiDaoTao() {
		return thongTinLoaiDaoTao;
	}
	public void setThongTinLoaiDaoTao(String thongTinLoaiDaoTao) {
		this.thongTinLoaiDaoTao = thongTinLoaiDaoTao;
	}

}
