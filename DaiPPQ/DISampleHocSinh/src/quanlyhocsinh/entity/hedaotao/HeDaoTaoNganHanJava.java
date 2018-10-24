package quanlyhocsinh.entity.hedaotao;

public class HeDaoTaoNganHanJava implements HeDaoTao {
	String maHeDaoTao = "FFSE-NHJ";
	String thongTinHeDaoTao = "Đào tạo dài hạn ngắn hạn Java 6 tháng";
	
	public HeDaoTaoNganHanJava() {
		super();
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
