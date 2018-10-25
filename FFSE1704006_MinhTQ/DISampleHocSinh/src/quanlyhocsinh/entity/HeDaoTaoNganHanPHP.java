package quanlyhocsinh.entity;

import hedaotao.HeDaoTao;

public class HeDaoTaoNganHanPHP implements HeDaoTao {
	String maHeDaoTao = "FFSEDTDTNHPHP";
	String thongTinHeDaoTao = "Đào tạo Php ngắn hạn 6 tháng ,full môn lập trình php không che ";
	

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
