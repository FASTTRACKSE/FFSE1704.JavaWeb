package fasttrackse.hedaotao;

import fasttrackse.entity.HeDaoTao;

public class HeDaoTaoCapTocJava implements HeDaoTao {
	String maHeDaoTao = "FFSENHJ";
	String thongTinHeDaoTao = "Đào tào ngắn hạn Java trong 6 tháng";

	public HeDaoTaoCapTocJava() {
		super();
	}
	
	public HeDaoTaoCapTocJava(String maHeDaoTao, String thongTinHeDaoTao) {
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
