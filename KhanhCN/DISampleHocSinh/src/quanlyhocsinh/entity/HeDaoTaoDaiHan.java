package quanlyhocsinh.entity;

public class HeDaoTaoDaiHan implements HeDaoTao {
	String maHeDaoTao = "FFSE1704";
	String thongTinDaoTao = "Đào tạo dài hạn 16 tháng full các môn lập trình. ";

	public HeDaoTaoDaiHan(String maHeDaoTao, String thongTinDaoTao ) {
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

	public HeDaoTaoDaiHan() {
		super();
		// TODO Auto-generated constructor stub
	}

}
