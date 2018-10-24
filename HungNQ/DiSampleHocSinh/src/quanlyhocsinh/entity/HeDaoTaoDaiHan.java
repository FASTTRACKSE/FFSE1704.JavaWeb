package quanlyhocsinh.entity;

public class HeDaoTaoDaiHan implements HeDaoTao {
	String maHeDaoTao = "FFSEDH";
	String thongTinHeDaoTao = "Đào tạo dài hạn 16 tháng full các môn lập trình";
	String thoiGianHoc = "16 tháng, sáng 8h30, chiều 13h30";
	String thongTinMonHoc = "Tin học văn phòng,Lập trình cơ bản,Lập trình Web frontend,Lập trình Web PHP & MySQL,Lập trình Java Cơ bản,Lập trình Java Web,Quy trình dự án";

	public HeDaoTaoDaiHan(String maHeDaoTao, String thongTinHeDaoTao, String thoiGianHoc, String thongTinMonHoc) {
		super();
		this.maHeDaoTao = maHeDaoTao;
		this.thongTinHeDaoTao = thongTinHeDaoTao;
		this.thoiGianHoc = thoiGianHoc;
		this.thongTinMonHoc = thongTinMonHoc;
	}

	public HeDaoTaoDaiHan() {
		super();
		// TODO Auto-generated constructor stub
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
