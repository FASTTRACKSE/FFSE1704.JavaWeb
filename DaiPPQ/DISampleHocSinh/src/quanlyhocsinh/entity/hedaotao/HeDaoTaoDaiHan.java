package quanlyhocsinh.entity.hedaotao;

public class HeDaoTaoDaiHan implements HeDaoTao {
	String maHeDaoTao = "FFSE-DH";
	String thongTinHeDaoTao = "Hệ đào tạo dài hạn 16 tháng";
	
	public HeDaoTaoDaiHan() {
		super();
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
