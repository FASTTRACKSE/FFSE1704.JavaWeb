package quanlyhocsinh.entity;

import java.util.List;

public class HeDaoTaoNganHanJava implements HeDaoTao {
	String maHeDaoTao = "FFSENHJ";
	String thongTinHeDaoTao = "Đào tạo dài hạn ngắn hạn Java 6 tháng";
	List<MonHoc> danhSachMonHoc;

	public HeDaoTaoNganHanJava() {
		super();
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

	public List<MonHoc> getDanhSachMonHoc() {
		return danhSachMonHoc;
	}

	public void setDanhSachMonHoc(List<MonHoc> danhSachMonHoc) {
		this.danhSachMonHoc = danhSachMonHoc;
	}

}
