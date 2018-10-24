package entity;

public class HeDaoTaoNganHanPHP implements HeDaoTao {
	String MaHeDaoTao = "FFSENHP";
	String thongtinHeDaoTao = "Đào tạo dài hạn ngắn hạn PHP & MySQL 6 tháng";
	
	public HeDaoTaoNganHanPHP() {
		super();
	}
	
	public HeDaoTaoNganHanPHP(String MaHeDaoTao, String thongtinHeDaoTao) {
		super();
		this.MaHeDaoTao = MaHeDaoTao;
		this.thongtinHeDaoTao = thongtinHeDaoTao;
	}

	@Override
	public String getMaHeDaoTao() {
		return MaHeDaoTao;
	}
	
	public void setMaHeDaoTao(String MaHeDaoTao) {
		this.MaHeDaoTao = MaHeDaoTao;
	}

	@Override
	public String getthongtinHeDaoTao() {
		return thongtinHeDaoTao;
	}
	
	public void setthongtinHeDaoTao(String thongtinHeDaoTao) {
		this.thongtinHeDaoTao = thongtinHeDaoTao;
	}

}
