package quanlihocsinh.entity;

public class HeDaoTaoLienKetCD implements HeDaoTao{
	String maHeDaoTao="MAD1103";
	String thongTinHeDaoTao="Đào tạo dài hạn + Thương cha nhớ nội";
	public HeDaoTaoLienKetCD(String maHeDaoTao, String thongTinHeDaoTao) {
		super();
		this.maHeDaoTao = maHeDaoTao;
		this.thongTinHeDaoTao = thongTinHeDaoTao;
	}
	public HeDaoTaoLienKetCD() {
		super();
		// TODO Auto-generated constructor stub
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
