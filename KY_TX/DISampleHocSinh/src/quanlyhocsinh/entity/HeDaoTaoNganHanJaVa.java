package quanlyhocsinh.entity;

public class HeDaoTaoNganHanJaVa implements HeDaoTao {
	String maHeDaoTao = "FFSENHJ";
	String thongTinHeDaoTao = "Đào tạo ngắn hạn java 6 tháng";
	public HeDaoTaoNganHanJaVa() {
		super();
	}
	public HeDaoTaoNganHanJaVa(String maHeDaoTao, String thongTinHeDaoTao) {
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
