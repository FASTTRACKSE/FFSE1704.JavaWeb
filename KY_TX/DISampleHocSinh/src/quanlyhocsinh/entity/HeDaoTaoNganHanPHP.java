package quanlyhocsinh.entity;

public class HeDaoTaoNganHanPHP implements HeDaoTao {
	String maHeDaoTao = "FFSENHP";
	String thongTinHeDaoTao = "Đào tạo ngắn hạn PHP & MySQL 6 tháng";
	public HeDaoTaoNganHanPHP() {
		super();
	}
	public HeDaoTaoNganHanPHP(String maHeDaoTao, String thongTinHeDaoTao) {
		this.maHeDaoTao = maHeDaoTao;
		this.thongTinHeDaoTao = thongTinHeDaoTao;
	}
	public String getMaHeDaoTao() {
		return maHeDaoTao;
	}
	public void setMaHeDaoTao(String maHeDaoTao) {
		this.maHeDaoTao = maHeDaoTao;
	}
	public String getThongTinHeDaoTao() {
		return thongTinHeDaoTao;
	}
	public void setThongTinHeDaoTao(String thongTinHeDaoTao) {
		this.thongTinHeDaoTao = thongTinHeDaoTao;
	}
}
