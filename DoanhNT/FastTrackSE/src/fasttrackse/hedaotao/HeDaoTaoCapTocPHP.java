package fasttrackse.hedaotao;

import fasttrackse.entity.HeDaoTao;

public class HeDaoTaoCapTocPHP implements HeDaoTao {
	String maHeDaoTao = "FFSENHP";
	String thongTinHeDaoTao = "Đào tào ngắn hạn PHP trong 6 tháng";

	public HeDaoTaoCapTocPHP() {
		super();
	}
	
	public HeDaoTaoCapTocPHP(String maHeDaoTao, String thongTinHeDaoTao) {
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
