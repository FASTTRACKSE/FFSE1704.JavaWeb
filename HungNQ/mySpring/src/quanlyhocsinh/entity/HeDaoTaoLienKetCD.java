package quanlyhocsinh.entity;

public class HeDaoTaoLienKetCD implements HeDaoTao {
	String maHeDaoTao = "FFSECDCN";
	String thongTinHeDaoTao = "Đào tạo dài hạng + cao đăng 2 năm trời";
	String thoiGianHoc = "16 tháng, sáng 8h30, chiều 13h30";
	String thongTinMonHoc = "Dự án cao đẳng";

	public HeDaoTaoLienKetCD() {
		super();
	}
	
	public HeDaoTaoLienKetCD(String maHeDaoTao, String thongTinHeDaoTao) {
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