package quanlyhocsinh.entity;

public class HeDaoTaoDaiHan implements HeDaoTao {

	String maHeDaoTao = "FFSEDH";
	String thongTinHeDaoTao ="16 thang";
	
	
	public HeDaoTaoDaiHan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HeDaoTaoDaiHan(String maHeDaoTao, String thongTinHeDaoTao) {
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
