package quanlyhocsinh.entity;

public class HeDaoTaoNganHanJava implements HeDaoTao{
	String maHeDaoTao = "FFSENHJ";
	String thongTinHeDaoTao = "Dao tao java ngan han 6 thang";
	
	public HeDaoTaoNganHanJava() {
		super();
		// TODO Auto-generated constructor stub
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
