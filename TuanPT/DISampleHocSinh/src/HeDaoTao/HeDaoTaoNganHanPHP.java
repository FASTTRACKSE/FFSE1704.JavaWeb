package HeDaoTao;

public class HeDaoTaoNganHanPHP implements HeDaoTao{

	String maHeDaoTao ="FFSENHP";
	String thongTinHeDaoTao = "Thông tin thời gian học: 6 tháng, tối từ 18h30 – 21h30";
	
	public HeDaoTaoNganHanPHP() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HeDaoTaoNganHanPHP(String maHeDaoTao, String thongTinHeDaoTao) {
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
