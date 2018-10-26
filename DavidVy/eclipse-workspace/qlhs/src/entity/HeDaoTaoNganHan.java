package entity;

public class HeDaoTaoNganHan implements HeDaoTao {
	
	String MaHeDaoTao = "FFSEDH";
	String thongtinHeDaoTao = "đào tạo dài hạn ngắn hạn java 6 tháng";
	
	public HeDaoTaoNganHan() {
		super();
	}
	
	public HeDaoTaoNganHan(String MaHeDaoTao, String thongtinHeDaoTao) {
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
