package entity;

public class HeDaoTaoLienKetCD implements HeDaoTao {
	String MaHeDaoTao = "FFSECDCN";
	String thongtinHeDaoTao = "đào tao dài hạn + cao đẳng 2 năm trời thương nhớ";
	
	public HeDaoTaoLienKetCD() {
		super();
	}
	
	public HeDaoTaoLienKetCD(String MaHeDaoTao , String thontinHeDaoTao) {
		super();
		this.MaHeDaoTao = MaHeDaoTao;
		this.thongtinHeDaoTao = thontinHeDaoTao;
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
