package quanlyhedaotao.entity;

import java.util.List;

import quanlymonhoc.entity.MonHoc;

public class HeDaoTaoNganHanPHP implements HeDaoTao {
	String maHeDaoTao = "DTNHPHP";

	public HeDaoTaoNganHanPHP(String maHeDaoTao, String thongTinHeDaoTao, List<MonHoc> danhSachMonHoc) {
		super();
		this.maHeDaoTao = maHeDaoTao;
		this.thongTinHeDaoTao = thongTinHeDaoTao;
		this.danhSachMonHoc = danhSachMonHoc;
	}

	String thongTinHeDaoTao = "6 tháng";
	List<MonHoc> danhSachMonHoc;

	public HeDaoTaoNganHanPHP() {
		super();
	}

	public void setMaHeDaoTao(String maHeDaoTao) {
		this.maHeDaoTao = maHeDaoTao;
	}

	public void setThongTinHeDaoTao(String thongTinHeDaoTao) {
		this.thongTinHeDaoTao = thongTinHeDaoTao;
	}

	public void setDanhSachMonHoc(List<MonHoc> danhSachMonHoc) {
		this.danhSachMonHoc = danhSachMonHoc;
	}

	public String getMaHeDaoTao() {
		return maHeDaoTao;
	}

	public String getThongTinHeDaoTao() {
		return thongTinHeDaoTao;
	}

	public List<MonHoc> getDanhSachMonHoc() {
		return danhSachMonHoc;
	}
}
