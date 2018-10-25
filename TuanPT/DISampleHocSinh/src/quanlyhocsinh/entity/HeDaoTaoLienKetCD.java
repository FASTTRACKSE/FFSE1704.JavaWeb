package quanlyhocsinh.entity;

public class HeDaoTaoLienKetCD implements HeDaoTao{
	
	String maHeDaoTao = "FFSECDCN";
	String thongTinHeDaoTao = "Dao tao dai han + cao dang 2 nam troi thuong nho";
	
	public HeDaoTaoLienKetCD() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HeDaoTaoLienKetCD(String maHeDaoTao, String thongTinHeDaoTao) {
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
