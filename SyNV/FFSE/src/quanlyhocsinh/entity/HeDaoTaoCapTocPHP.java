package quanlyhocsinh.entity;

public class HeDaoTaoCapTocPHP implements HeDaoTao {
	String maHeDaoTao = "FFSECTP";
	String thongTinHeDaoTao = "Đào tạo cấp tốc PHP 6 tháng";

	public HeDaoTaoCapTocPHP() {
		super();
	}
	
	public HeDaoTaoCapTocPHP(String maHeDaoTao, String thongTinHeDaoTao) {
		super();
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
