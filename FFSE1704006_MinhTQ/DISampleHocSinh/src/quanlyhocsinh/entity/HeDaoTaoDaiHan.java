package quanlyhocsinh.entity;

import hedaotao.HeDaoTao;

public class HeDaoTaoDaiHan implements HeDaoTao {
	String maHeDaoTao = "FFSEDTDH";
	String thongTinHeDaoTao = "Đào tạo dài hạn 16 tháng ,full các môn lập trình không che ";
	

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

	

	public HeDaoTaoDaiHan(String maHeDaoTao, String thongTinHeDaoTao) {
		super();
		this.maHeDaoTao = maHeDaoTao;
		this.thongTinHeDaoTao = thongTinHeDaoTao;
		
	}

	public HeDaoTaoDaiHan() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
