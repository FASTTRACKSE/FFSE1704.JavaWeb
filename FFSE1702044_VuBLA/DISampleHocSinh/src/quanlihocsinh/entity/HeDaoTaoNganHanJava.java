package quanlihocsinh.entity;

public class HeDaoTaoNganHanJava implements HeDaoTao {
	String maHeDaoTao = "FFSENHJV";
	String thongTinHeDaoTao = "Đào tạo ngắn hạn 6 tháng, Lập trình Java";

	public HeDaoTaoNganHanJava() {
		super();
	}
	
	public HeDaoTaoNganHanJava(String maHeDaoTao, String thongTinHeDaoTao) {
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
