package quanlyhocsinh.entity;

import hedaotao.HeDaoTao;

public class HeDaoTaoNganHanJava implements HeDaoTao {
	String maHeDaoTao = "FFSEDTNHJV";
	String thongTinHeDaoTao = "Đào tạo java ngắn hạn 6 tháng,full môn java lập trình không che";
	

	public HeDaoTaoNganHanJava() {
		super();
		// TODO Auto-generated constructor stub
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
