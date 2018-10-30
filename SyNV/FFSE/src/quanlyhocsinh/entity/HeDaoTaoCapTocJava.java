package quanlyhocsinh.entity;

public class HeDaoTaoCapTocJava implements HeDaoTao {
	String maHeDaoTao = "FFSECTJ";
	String thongTinHeDaoTao = "Đào tạo cấp tốc Java 6 tháng";

	public HeDaoTaoCapTocJava() {
		super();
	}
	
	public HeDaoTaoCapTocJava(String maHeDaoTao, String thongTinHeDaoTao) {
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
