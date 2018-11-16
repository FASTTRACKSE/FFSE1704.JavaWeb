package quanlyhocsinh.entity;

public class HeDaoTaoNganHanPHP implements HeDaoTao {
	String maHeDaoTao = "FFSENH";
	String thongTinHeDaoTao = "Đào tạo ngắn hạn 16 tháng full các môn lập trình";
	String thoiGianHoc = "6 tháng, tối từ 18h30 – 21h30";
	String thongTinMonHoc = "Lập trình Java Cơ bản,Lập trình Java Web";
	
	public HeDaoTaoNganHanPHP() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HeDaoTaoNganHanPHP(String maHeDaoTao, String thongTinHeDaoTao) {
		super();
		this.maHeDaoTao = maHeDaoTao;
		this.thongTinHeDaoTao = thongTinHeDaoTao;
		this.thoiGianHoc = thoiGianHoc;
		this.thongTinMonHoc = thongTinMonHoc;
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
	public String getThoiGianHoc() {
		return thoiGianHoc;
	}
	public void setThoiGianHoc(String thoiGianHoc) {
		this.thoiGianHoc = thoiGianHoc;
	}
	public String getThongTinMonHoc() {
		return thongTinMonHoc;
	}
	public void setThongTinMonHoc(String thongTinMonHoc) {
		this.thongTinMonHoc = thongTinMonHoc;
	}
	
	
}
