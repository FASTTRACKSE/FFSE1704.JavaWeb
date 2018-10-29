package quanlyhocsinh.entity;

import java.util.List;

import monhoc.MonHoc;

public class HeDaoTaoNganHanPHP implements HeDaoTao {
	String maHeDaoTao ;
	String thongTinHeDaoTao ;
	List<MonHoc> danhSachMonHoc;

	public HeDaoTaoNganHanPHP() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HeDaoTaoNganHanPHP(String maHeDaoTao, String thongTinHeDaoTao, List<MonHoc> danhSachMonHoc) {
		super();
		this.maHeDaoTao = maHeDaoTao;
		this.thongTinHeDaoTao = thongTinHeDaoTao;
		this.danhSachMonHoc = danhSachMonHoc;
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
