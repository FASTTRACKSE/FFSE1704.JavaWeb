package entity;

public class HeDaoTaoDaiHan implements HeDaoTao {
	
	String MaHeDaoTao = "FFSEDH";
	String thongtinHeDaoTao = "đào tạo dài han 16 tháng , full các môn lập trình";
	
	public HeDaoTaoDaiHan() {
		super();
	}
	
	public HeDaoTaoDaiHan(String MaHeDaoTao, String thongtinHeDaoTao) {
		super();
		this.MaHeDaoTao = MaHeDaoTao;
		this.thongtinHeDaoTao = thongtinHeDaoTao;
	}
	
	@Override
	public String getMaHeDaoTao() {
		return MaHeDaoTao;
	}
	
	 public void setMaHeDaoTao(String maHeDaoTao) {
		this.MaHeDaoTao = maHeDaoTao;
	}

	@Override
	public String getthongtinHeDaoTao() {
		return thongtinHeDaoTao;
	}
	
	public void setthongtinHeDaoTao(String thongtinHeDaoTao) {
		this.thongtinHeDaoTao = thongtinHeDaoTao;
	}

}
