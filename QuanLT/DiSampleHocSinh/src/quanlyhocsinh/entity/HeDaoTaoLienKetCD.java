package quanlyhocsinh.entity;

public class HeDaoTaoLienKetCD implements HeDaoTao {
	String maHeDaoTao = "FFSECDCN";
	String thongTinHeDaoTao = "Chương trình Đào tạo liên kết CĐ CNTT";

	public HeDaoTaoLienKetCD() {
		super();
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
