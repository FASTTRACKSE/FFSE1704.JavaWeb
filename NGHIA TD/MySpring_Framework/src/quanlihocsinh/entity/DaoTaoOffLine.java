package quanlihocsinh.entity;

public class DaoTaoOffLine implements LoaiDaoTao{

	 String MaLoaiDaoTao="MuHH-hahaha";
	 String thongTinLoaiDaoTao="Đào Tạo offline:\r\n" + 
	 		"o	Thá»�i gian: sÃ¡ng tá»« 8h00, chiá»�u tá»« 13h30, tá»‘i tá»« 18h30\r\n" + 
	 		"o	Ä�á»‹a chá»‰: ToÃ  nhÃ  FPT, KCN An Ä�á»“n";
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
