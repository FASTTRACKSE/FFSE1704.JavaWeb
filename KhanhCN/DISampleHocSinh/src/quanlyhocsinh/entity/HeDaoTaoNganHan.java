package quanlyhocsinh.entity;

public class HeDaoTaoNganHan implements HeDaoTao {

	String maHeDaoTao = "FFSENHJ";
	String thongTinDaoTao = " Đào tạo 6 tháng java.....!!";

	public HeDaoTaoNganHan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HeDaoTaoNganHan(String maHeDaoTao, String thongTinDaoTao) {
		super();
		this.maHeDaoTao = maHeDaoTao;
		this.thongTinDaoTao = thongTinDaoTao;
	}

	public String getMaHeDaoTao() {
		return maHeDaoTao;
	}

	public void setMaHeDaoTao(String maHeDaoTao) {
		this.maHeDaoTao = maHeDaoTao;
	}

	public String getThongTinDaoTao() {
		return thongTinDaoTao;
	}

	public void setThongTinDaoTao(String thongTinDaoTao) {
		this.thongTinDaoTao = thongTinDaoTao;
	}

}
